package com.rx.tushu.service.Impl;

import com.rx.tushu.dao.CategoryDao;
import com.rx.tushu.dao.UserDao;
import com.rx.tushu.model.Admininfo;
import com.rx.tushu.model.Categoryinfo;
import com.rx.tushu.service.CategoryService;
import com.rx.tushu.service.UserService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao=new CategoryDao();
    @Override
    public boolean addCategory(String cName) {
        boolean b = categoryDao.addCategory(cName);
        return b;
    }

    @Override
    public List<Categoryinfo> selectCategoryAll() {
        return categoryDao.selectCategoryAll();
    }

    @Override
    public void deleteCategory(Integer integer) {
        categoryDao.deleteCategory(integer);
    }
}
