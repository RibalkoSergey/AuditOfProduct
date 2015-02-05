package com.aop.util;

/**
 * Created by alexanderli on 2/5/15.
 */
public class DataViewBean {
    private String phoneNumber;
    private Integer realizedCount;
    private String productCode;
    private String productName;
    private Integer generalCount;
    private Integer rest;

    public DataViewBean(String phoneNumber, Integer realizedCount, String productCode, String productName, Integer generalCount) {
        this.phoneNumber = phoneNumber;
        this.realizedCount = realizedCount;
        this.productCode = productCode;
        this.productName = productName;
        this.generalCount = generalCount;
    }

    public DataViewBean(String phoneNumber, String productCode, Integer realizedCount) {
        this.phoneNumber = phoneNumber;
        this.productCode = productCode;
        this.realizedCount = realizedCount;
    }

    public DataViewBean(String code) {
        this.productCode = code;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRealizedCount() {
        return realizedCount;
    }

    public void setRealizedCount(Integer realizedCount) {
        this.realizedCount = realizedCount;
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

    @Override
    public boolean equals(Object obj) {
        DataViewBean bean = (DataViewBean) obj;
        if (this.productCode.equals(bean.getProductCode()))
            return true;

        return false;
    }
}
