package io.jpf.jcartstoreback.service;

import io.jpf.jcartstoreback.dto.in.CustomerRegisterInDTO;
import io.jpf.jcartstoreback.po.Customer;

public interface CustomerService {

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    Customer getByEmail(String email);

    void update(Customer customer);
}
