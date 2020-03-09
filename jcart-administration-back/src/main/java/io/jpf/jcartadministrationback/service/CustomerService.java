package io.jpf.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.jpf.jcartadministrationback.dto.in.CustomerSearchInDTO;
import io.jpf.jcartadministrationback.dto.in.CustomerSetStatusInDTO;
import io.jpf.jcartadministrationback.po.Customer;

public interface CustomerService {

    Page<Customer> search(CustomerSearchInDTO customerSearchInDTO, Integer pageNum);

    Customer getById(Integer customerId);

    void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);
}
