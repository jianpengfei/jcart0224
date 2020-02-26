package io.jpf.jcartstoreback.controller;

import io.jpf.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.jpf.jcartstoreback.dto.out.OrderListOutDTO;
import io.jpf.jcartstoreback.dto.out.OrderShowOutDTO;
import io.jpf.jcartstoreback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/checkout")
    public Integer checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }
}
