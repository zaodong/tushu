package com.rx.tushu.model;

public class Bookinfo {
    private Integer BID;
    private String BTitle;
    private String BAuthor;
    private Integer BPrice;
    private Integer BCategoryID;
    private String BPublisher;
    private String BPhoto;
    private Categoryinfo categoryinfo;

    public Integer getBID() {
        return BID;
    }

    public void setBID(Integer BID) {
        this.BID = BID;
    }

    public String getBTitle() {
        return BTitle;
    }

    public void setBTitle(String BTitle) {
        this.BTitle = BTitle;
    }

    public String getBAuthor() {
        return BAuthor;
    }

    public void setBAuthor(String BAuthor) {
        this.BAuthor = BAuthor;
    }

    public Integer getBPrice() {
        return BPrice;
    }

    public void setBPrice(Integer BPrice) {
        this.BPrice = BPrice;
    }

    public Integer getBCategoryID() {
        return BCategoryID;
    }

    public void setBCategoryID(Integer BCategoryID) {
        this.BCategoryID = BCategoryID;
    }

    public String getBPublisher() {
        return BPublisher;
    }

    public void setBPublisher(String BPublisher) {
        this.BPublisher = BPublisher;
    }

    public String getBPhoto() {
        return BPhoto;
    }

    public void setBPhoto(String BPhoto) {
        this.BPhoto = BPhoto;
    }

    public Categoryinfo getCategoryinfo() {
        return categoryinfo;
    }

    public void setCategoryinfo(Categoryinfo categoryinfo) {
        this.categoryinfo = categoryinfo;
    }
}
