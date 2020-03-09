package io.jpf.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import io.jpf.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.jpf.jcartadministrationback.dto.in.ProductSearchInDTO;
import io.jpf.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.jpf.jcartadministrationback.dto.out.PageOutDTO;
import io.jpf.jcartadministrationback.dto.out.ProductListOutDTO;
import io.jpf.jcartadministrationback.dto.out.ProductShowOutDTO;
import io.jpf.jcartadministrationback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//用于标注控制层组件(如struts中的action)，表示这是个控制器bean,并且是将函数的返回值直 接填入HTTP响应体中,是REST风格的控制器；它是@Controller和@ResponseBody的合集

//@ResponseBody
//表示该方法的返回结果直接写入HTTP response body中
//一般在异步获取数据时使用，在使用@RequestMapping后，返回值通常解析为跳转路径，加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。比如异步获取json数据，加上@responsebody后，会直接返回json数据

//@RequestParam
//用在方法的参数前面

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     *  查询商品列表
     *  模糊 查询 分页
     * @param productSearchInDTO
     * @param pageNum
     * @return
     */
    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false, defaultValue = "1") Integer pageNum){

        Page<ProductListOutDTO> page = productService.search(productSearchInDTO,pageNum);

        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    /**
     *  获取商品的Id
     * @param productId
     * @return
     */
    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestBody Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
    }

    /**
     *  创建商品
     * @param productCreateInDTO
     * @return
     */
    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }

    /**
     *  修改商品
     * @param productUpdateInDTO
     */
    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
        productService.update(productUpdateInDTO);
    }

    /**
     * 商品的单删
     * @param productId
     */
    @PostMapping("/delete")
    public void delete(@RequestBody Integer productId){
        productService.delete(productId);
    }

    /**
     * 商品的批删
     * @param productIds
     */
    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){
        productService.batchDelete(productIds);
    }
}
