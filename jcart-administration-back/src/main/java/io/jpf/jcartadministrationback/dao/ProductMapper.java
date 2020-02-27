package io.jpf.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import io.jpf.jcartadministrationback.dto.out.ProductListOutDTO;
import io.jpf.jcartadministrationback.po.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository注解可以确保DAO或者repositories提供异常转译，
//     这个注解修饰的DAO或者repositories类会被ComponetScan发现并配置，
//     同时也不需要为它们提供XML配置项
@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    //    custom

    int batchDelete(@Param("productIds") List<Integer> productIds);

    Page<ProductListOutDTO> search();
}