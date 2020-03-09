package io.jpf.jcartstoreback.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.jpf.jcartstoreback.constant.ClientExceptionConstant;
import io.jpf.jcartstoreback.dto.in.*;
import io.jpf.jcartstoreback.dto.out.CustomerGetProfileOutDTO;
import io.jpf.jcartstoreback.dto.out.CustomerLoginOutDTO;
import io.jpf.jcartstoreback.exception.ClientException;
import io.jpf.jcartstoreback.po.Customer;
import io.jpf.jcartstoreback.service.CustomerService;
import io.jpf.jcartstoreback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.util.HashMap;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private SecureRandom secureRandom;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private HashMap<String, String> emailPwdResetCodeMap = new HashMap();

    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterInDTO customerRegisterInDTO){
        Integer customerId = customerService.register(customerRegisterInDTO);
        return customerId;
    }

    @GetMapping("/login")
    public CustomerLoginOutDTO login(CustomerLoginInDTO customerLoginInDTO) throws ClientException {
        //获取客户名
        Customer customer = customerService.getByUsername(customerLoginInDTO.getUsername());

        //判断  要么错误  要么不存在
        if (customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRMSG);
        }
        //获取加密密码
        String encPwdDB = customer.getEncryptedPassword();

        //BCrypt 加密算法  hash算法  == MD5
        //自带salt盐的算法 使用相同的密码 密文不一样 加密级别高
        BCrypt.Result result = BCrypt.verifyer().verify(customerLoginInDTO.getPassword().toCharArray(), encPwdDB);

        //登录机制  1有状态  session  2无状态  token 令牌 通行证
        //jwt  json web token
        if (result.verified) {
            CustomerLoginOutDTO customerLoginOutDTO = jwtUtil.issueToken(customer);
            return customerLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }
    }

    @GetMapping("/getProfile")
    public CustomerGetProfileOutDTO getProfile(@RequestAttribute Integer customerId){
        Customer customer = customerService.getById(customerId);
        CustomerGetProfileOutDTO customerGetProfileOutDTO = new CustomerGetProfileOutDTO();
        customerGetProfileOutDTO.setUsername(customer.getUsername());
        customerGetProfileOutDTO.setRealName(customer.getRealName());
        customerGetProfileOutDTO.setMobile(customer.getMobile());
        customerGetProfileOutDTO.setMobileVerified(customer.getMobileVerified());
        customerGetProfileOutDTO.setEmail(customer.getEmail());
        customerGetProfileOutDTO.setEmailVerified(customer.getEmailVerified());

        return customerGetProfileOutDTO;
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody CustomerUpdateProfileInDTO customerUpdateProfileInDTO,
                              @RequestAttribute Integer customerId){
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setRealName(customerUpdateProfileInDTO.getRealName());
        customer.setMobile(customerUpdateProfileInDTO.getMobile());
        customer.setEmail(customerUpdateProfileInDTO.getEmail());
        customerService.update(customer);
    }

    @PostMapping("/changePwd")
    public void changePwd(@RequestBody CustomerChangePwdInDTO customerChangePwdInDTO,
                          @RequestAttribute Integer customerId) throws ClientException {
        Customer customer = customerService.getById(customerId);
        String encPwdDB = customer.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(customerChangePwdInDTO.getOriginPwd().toCharArray(), encPwdDB);

        if (result.verified) {
            String newPwd = customerChangePwdInDTO.getNewPwd();
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, newPwd.toCharArray());
            customer.setEncryptedPassword(bcryptHashString);
            customerService.update(customer);
        }else {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }

    }

    @GetMapping("/getPwdRestCode")
    public void getPwdRestCode(@RequestParam String email) throws ClientException {

        Customer customer = customerService.getByEmail(email);
        if (customer == null) {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRMSG);
        }
        //先拿到一个随机数
        byte[] bytes = secureRandom.generateSeed(3);
        //并转换成16进制字符串
        String hex = DatatypeConverter.printHexBinary(bytes);
        //发送简单邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(email);
        message.setSubject("jcart商店端客户重置密码");
        message.setText(hex);
        mailSender.send(message);

        //todo send messasge to MQ
        //存入map集合
        emailPwdResetCodeMap.put(email, hex);

    }



    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody CustomerResetPwdInDTO customerResetPwdInDTO) throws ClientException {

        //判断邮箱是否为空  抛异常
        String email = customerResetPwdInDTO.getEmail();
        if (email == null) {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_EMAIL_NONE_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_EMAIL_NONE_ERRMSG);
        }

        //判根据邮箱获取重置码是否为空  抛异常
        String innerResetCode = emailPwdResetCodeMap.get(email);
        if (innerResetCode == null) {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_INNER_RESETCODE_NONE_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_INNER_RESETCODE_NONE_ERRMSG);
        }

        //判外面得重置码是否为空 抛异常
        String outerResetCode = customerResetPwdInDTO.getResetCode();
        if (outerResetCode == null) {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_OUTER_RESETCODE_NONE_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_OUTER_RESETCODE_NONE_ERRMSG);
        }

        //innerResetCode outerResetCode进行比较 不相等抛异常
        if (!outerResetCode.equalsIgnoreCase(innerResetCode)){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PWDRESET_RESETCODE_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PWDRESET_RESETCODE_INVALID_ERRMSG);
        }

        //判断根据email从数据库获取客户是否为空  抛异常
        Customer customer = customerService.getByEmail(email);
        if (customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_EMAIL_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_EMAIL_NOT_EXIST_ERRMSG);
        }

        //判断新密码是否为空  抛异常
        String newPwd = customerResetPwdInDTO.getNewPwd();
        if (newPwd == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_NEWPWD_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_NEWPWD_NOT_EXIST_ERRMSG);
        }

        String bcryptHashString = BCrypt.withDefaults().hashToString(12, newPwd.toCharArray());
        customer.setEncryptedPassword(bcryptHashString);
        customerService.update(customer);

        //删除用过的重置码  维护代码安全  (每使用一次  就进行删除)
        emailPwdResetCodeMap.remove(email);

    }
}
