package io.jpf.jcartstoreback.service;

import io.jpf.jcartstoreback.dto.in.OrderCheckoutInDTO;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                     Integer customerId);


}
