package io.jpf.jcartadministrationback.controller;

import io.jpf.jcartadministrationback.dto.in.AdministratorLogInDTO;
import io.jpf.jcartadministrationback.dto.in.AdministratorRestPwdInDTO;
import io.jpf.jcartadministrationback.dto.in.AdministratorUpdateProfileInDTO;
import io.jpf.jcartadministrationback.dto.out.AdministratorGetProfileOutDTO;
import io.jpf.jcartadministrationback.dto.out.AdministratorListOutDTO;
import io.jpf.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/login")
    public String login(AdministratorLogInDTO AdministratorLoginDTO){

        return null;
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(@RequestParam(required = false) Integer administratorId){
        return null;
    }

    @PostMapping("/updateProdfile")
    public void updateProdfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

    }

    @GetMapping("/getPwdRestCode")
    public String getPwdRestCode(@RequestParam String email){
        return null;
    }

    @PostMapping("/restPwd")
    public void restPwd(@RequestBody AdministratorRestPwdInDTO administratorRestPwdInDTO){

    }

    @GetMapping("/getList")
    public PageOutDTO<AdministratorListOutDTO> getList(@RequestBody Integer pageNum){
        return null;
    }

}
