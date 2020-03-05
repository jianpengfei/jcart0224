package io.jpf.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.jpf.jcartadministrationback.dto.out.OrderListOutDTO;
import io.jpf.jcartadministrationback.dto.out.OrderShowOutDTO;
import io.jpf.jcartadministrationback.po.Order;

public interface OrderService {

    Page<OrderListOutDTO> search(Integer pageNum);

    OrderShowOutDTO getById(Long orderId);

    void update(Order order);

}
