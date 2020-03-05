package io.jpf.jcartadministrationback.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.jpf.jcartadministrationback.dao.OrderDetailMapper;
import io.jpf.jcartadministrationback.dao.OrderMapper;
import io.jpf.jcartadministrationback.dto.out.OrderListOutDTO;
import io.jpf.jcartadministrationback.dto.out.OrderShowOutDTO;
import io.jpf.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public Page<OrderListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<OrderListOutDTO> page = orderMapper.search();
        return page;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        return null;
    }
}
