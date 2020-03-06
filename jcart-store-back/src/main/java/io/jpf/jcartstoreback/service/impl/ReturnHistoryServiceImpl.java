package io.jpf.jcartstoreback.service.impl;

import io.jpf.jcartstoreback.dao.ReturnHistoryMapper;
import io.jpf.jcartstoreback.po.ReturnHistory;
import io.jpf.jcartstoreback.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Override
    public List<ReturnHistory> getByReturnId(Integer returnId) {
        List<ReturnHistory> returnHistories = returnHistoryMapper.selectByReturnId(returnId);
        return returnHistories;
    }
}
