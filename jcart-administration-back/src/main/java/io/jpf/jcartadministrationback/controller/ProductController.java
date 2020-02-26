package io.jpf.jcartadministrationback.controller;

import io.jpf.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.jpf.jcartadministrationback.dto.in.ProductSearchInDTO;
import io.jpf.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.jpf.jcartadministrationback.dto.out.PageOutDTO;
import io.jpf.jcartadministrationback.dto.out.ProductListOutDTO;
import io.jpf.jcartadministrationback.dto.out.ProductShowOutDTO;
import io.jpf.jcartadministrationback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam  Integer pageNum){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }
    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        return null;
    }

}
