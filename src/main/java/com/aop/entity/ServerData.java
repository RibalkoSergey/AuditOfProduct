package com.aop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by alexanderli on 2/5/15.
 */
@Entity
public class ServerData {
    @Transient
    @Id
    private String productCode;

    @Transient
    private String productName;

    @Transient
    private Integer generalCount;

    @Transient
    private Integer rest;

    public ServerData() {}

    public ServerData(String productCode, String productName, Integer generalCount, Integer rest) {
        this.productCode = productCode;
        this.productName = productName;
        this.generalCount = generalCount;
        this.rest = rest;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getGeneralCount() {
        return generalCount;
    }

    public void setGeneralCount(Integer generalCount) {
        this.generalCount = generalCount;
    }

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
    }
}
