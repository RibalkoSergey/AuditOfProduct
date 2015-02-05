package com.aop.service;

import com.aop.entity.ServerData;
import com.aop.util.DataViewBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by alexanderli on 2/5/15.
 */
@Service
public class HomeService {
    private List<DataViewBean> SERVER_DATA_LIST = new ArrayList<>();

    public List<DataViewBean> getDataViewBeans() {
        return SERVER_DATA_LIST;
    }

    public String checkProduct(String code) {
        for (DataViewBean bean : SERVER_DATA_LIST) {
            if (bean.getProductCode().equals(code))
                return bean.getProductName();
        }

        return null;
    }

    public Boolean updateServerData(String phoneNumber, String code, Integer count) {
        if (SERVER_DATA_LIST.contains(new DataViewBean(code))) {
            SERVER_DATA_LIST.stream().filter(bean -> bean.getProductCode().equals(code)).forEach(bean -> {
                bean.setPhoneNumber(phoneNumber);
                bean.setRealizedCount(count);
                bean.setRest(bean.getRest() - count);
            });
            return true;
        } else {
            SERVER_DATA_LIST.add(new DataViewBean(phoneNumber, code, count));
            return false;
        }
    }

    public void initData() {
        Random rand = new Random();
        for (int i = 0; i <= 50; i++) {
            int code = rand.nextInt();
            SERVER_DATA_LIST.add(new DataViewBean("-----", null, Integer.toString(code), "name-" + code, 50 + i));
        }
    }
}
