package io.jpf.jcartstoreback.service;

import com.github.pagehelper.Page;
import io.jpf.jcartstoreback.dto.out.ProductListOutDTO;
import io.jpf.jcartstoreback.dto.out.ProductShowOutDTO;
import io.jpf.jcartstoreback.po.Product;

public interface ProductService {

    Product getById(Integer productId);

    ProductShowOutDTO getShowById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);
}
