package com.rx.tushu.service.Impl;

import com.rx.tushu.dao.ProductDao;
import com.rx.tushu.dao.UserDao;
import com.rx.tushu.model.Admininfo;
import com.rx.tushu.model.Bookinfo;
import com.rx.tushu.service.ProductService;
import com.rx.tushu.service.UserService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao=new ProductDao();

    @Override
    public List<Bookinfo> selectProductAll() {
        return productDao.selectProductAll();
    }

    @Override
    public void addProduct(String bTitle, String bAuthor, int bPrice, Integer bCategoryID, String bPublisher, String bPhoto) {
         productDao.addProduct(bTitle,bAuthor,bPrice,bCategoryID,bPublisher,bPhoto);
    }

    @Override
    public void deleteProduct(Integer integer) {
        productDao.deleteProduct(integer);
    }

    @Override
    public Bookinfo selectProductOne(Integer bid) {

        return productDao.selectProductOne(bid);
    }

    @Override
    public void updateProduct(Integer bid, String bTitle, String bAuthor, Integer bPrice, Integer bCategoryID, String bPublisher, String url) {
        productDao.updateProduct(bid,bTitle,bAuthor,bPrice,bCategoryID,bPublisher,url);
    }
}
