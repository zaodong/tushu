package com.rx.tushu.service.Impl;

import com.rx.tushu.dao.UserDao;
import com.rx.tushu.model.Admininfo;
import com.rx.tushu.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDao();
    @Override
    public Admininfo selectOne(String aLoginID, String aLoginPSW) {
        return userDao.selectOne(aLoginID,aLoginPSW);
    }
}
