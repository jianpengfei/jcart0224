package io.jpf.jcartstoreback.service;

import com.github.pagehelper.Page;
import io.jpf.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.jpf.jcartstoreback.po.Order;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                     Integer customerId);

    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);

}
