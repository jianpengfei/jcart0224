package io.jpf.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.jpf.jcartadministrationback.po.Administrator;

import java.util.List;

public interface AdministratorService {

    Administrator getById(Integer administratorId);

    Administrator getByUsername(String username);

    void update(Administrator administrator);

    Integer create(Administrator administrator);

    void delete(Integer administratorId);

    void batchDelete(List<Integer> administratorIds);

    Page<Administrator> getList(Integer pageNum);

    //custom
    Administrator getByEmail(String email);

}
