package io.jpf.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import io.jpf.jcartadministrationback.dto.out.OrderListOutDTO;
import io.jpf.jcartadministrationback.po.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //    custom
    Page<OrderListOutDTO> search();

}