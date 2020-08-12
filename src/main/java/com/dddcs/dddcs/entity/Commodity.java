package com.dddcs.dddcs.entity;

import java.math.BigDecimal;


public class Commodity {
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 商品名
     */

    private String name;

    /**
     * 商品详情
     */
    private String details;

    /**
     * 商品图片地址
     */
    private String imageUrl;

    /**
     * 商品图片地址
     */
    private Integer type;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 商品库存
     */
    private Integer pcs;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPcs() {
        return pcs;
    }

    public void setPcs(Integer pcs) {
        this.pcs = pcs;
    }
}
