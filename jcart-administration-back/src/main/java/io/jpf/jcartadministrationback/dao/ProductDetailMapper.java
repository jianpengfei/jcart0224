package io.jpf.jcartadministrationback.dao;

import io.jpf.jcartadministrationback.po.ProductDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//    注解可以确保DAO或者repositories提供异常转译，
//     这个注解修饰的DAO或者repositories类会被ComponetScan发现并配置，
//     同时也不需要为它们提供XML配置项
@Repository
public interface ProductDetailMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKeyWithBLOBs(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);

    //    custom

    int batchDelete(@Param("productIds") List<Integer> productIds);
}