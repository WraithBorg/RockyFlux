package com.dddcs.dddcs.entity;


/**
 * 商品
 */
public class RF_Goods {

    public Long id;
    private String name;


    /************************************* Constructor *************************************/
    public RF_Goods(Long id, String name) {

        this.id = id;
        this.name = name;

    }

    /************************************ Getter Setter ************************************/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
