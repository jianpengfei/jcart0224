package io.jpf.jcartadministrationback.dao;

import io.jpf.jcartadministrationback.po.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}