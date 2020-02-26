package io.jpf.jcartadministrationback.service;

import io.jpf.jcartadministrationback.dto.in.ProductCreateInDTO;

public interface ProductService {

    Integer create(ProductCreateInDTO productCreateInDTO);
}
