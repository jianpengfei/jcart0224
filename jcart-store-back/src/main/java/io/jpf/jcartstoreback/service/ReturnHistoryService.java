package io.jpf.jcartstoreback.service;

import io.jpf.jcartstoreback.po.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {

    List<ReturnHistory> getByReturnId(Integer returnId);

}
