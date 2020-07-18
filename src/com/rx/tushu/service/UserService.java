package com.rx.tushu.service;

import com.rx.tushu.model.Admininfo;

public interface UserService {
    Admininfo selectOne(String aLoginID, String aLoginPSW);
}
