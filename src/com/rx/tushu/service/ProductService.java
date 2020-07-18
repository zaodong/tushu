package com.rx.tushu.service;

import com.rx.tushu.model.Bookinfo;
import com.rx.tushu.model.Categoryinfo;

import java.util.List;

public interface ProductService {

    List<Bookinfo> selectProductAll();

    void addProduct(String bTitle, String bAuthor, int bPrice, Integer bCategoryID, String bPublisher, String bPhoto);

    void deleteProduct(Integer integer);

    Bookinfo selectProductOne(Integer bid);

    void updateProduct(Integer bid, String bTitle, String bAuthor, Integer bPrice, Integer bCategoryID, String bPublisher, String url);
}
