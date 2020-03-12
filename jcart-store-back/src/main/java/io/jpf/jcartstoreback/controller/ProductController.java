package io.jpf.jcartstoreback.controller;

import com.github.pagehelper.Page;
import io.jpf.jcartstoreback.dto.in.ProductSearchInDTO;
import io.jpf.jcartstoreback.dto.out.PageOutDTO;
import io.jpf.jcartstoreback.dto.out.ProductListOutDTO;
import io.jpf.jcartstoreback.dto.out.ProductShowOutDTO;
import io.jpf.jcartstoreback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false, defaultValue = "1") Integer pageNum){

        Page<ProductListOutDTO> page = productService.search(pageNum);
        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){

        ProductShowOutDTO productShowOutDTO = productService.getShowById(productId);
        return productShowOutDTO;
    }

}
