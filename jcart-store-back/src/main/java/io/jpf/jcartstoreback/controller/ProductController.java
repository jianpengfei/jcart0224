package io.jpf.jcartstoreback.controller;

import io.jpf.jcartstoreback.dto.in.ProductSearchInDTO;
import io.jpf.jcartstoreback.dto.out.PageOutDTO;
import io.jpf.jcartstoreback.dto.out.ProductListOutDTO;
import io.jpf.jcartstoreback.dto.out.ProductShowOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false, defaultValue = "1") Integer pageNum){

        return null;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        return null;
    }

}
