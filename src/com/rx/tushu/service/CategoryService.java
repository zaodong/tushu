package com.rx.tushu.service;

import com.rx.tushu.model.Admininfo;
import com.rx.tushu.model.Categoryinfo;

import java.util.List;

public interface CategoryService {
    boolean addCategory(String cName);

    List<Categoryinfo> selectCategoryAll();

    void deleteCategory(Integer integer);
}
