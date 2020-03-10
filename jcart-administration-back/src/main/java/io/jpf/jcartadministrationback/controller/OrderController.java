package io.jpf.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import io.jpf.jcartadministrationback.dto.in.OrderSearchInDTO;
import io.jpf.jcartadministrationback.dto.out.*;
import io.jpf.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 多条件查询
     *  条件顺序
     *  左右结合  写在左边的会优先处理
     *  where orderId = 1 and  customerName =  like '%aa%' 前者快
     *      主键  >  唯一所有  > 普通索引  > 整形的比较(包括时间类型) ==  字符串的比较  == 字符串like keyword% > 字符串like %keyword%
     * @param orderSearchInDTO
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                              @RequestParam(required = false, defaultValue = "1") Integer pageNum) {
        Page<OrderListOutDTO> page = orderService.search(orderSearchInDTO, pageNum);

        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId) {
        OrderShowOutDTO orderShowOutDTO = orderService.getById(orderId);
        return orderShowOutDTO;
    }

    @GetMapping("/getInvoiceInfo")
    public OrderInvoiceShowOutDTO getInvoiceInfo(@RequestParam Long orderId) {
        return null;
    }

    @GetMapping("/getShipInfo")
    public OrderShipShowOutDTO getShipInfo(@RequestParam Long orderId) {
        return null;
    }
}
