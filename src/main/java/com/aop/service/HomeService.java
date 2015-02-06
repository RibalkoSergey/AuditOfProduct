package com.aop.service;

import com.aop.util.DataViewBean;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexanderli on 2/5/15.
 */
@Service
public class HomeService {
    private List<DataViewBean> SERVER_DATA_LIST = new ArrayList<DataViewBean>();

    private Boolean isInit = false;

    public List<DataViewBean> getDataViewBeans() {
        return SERVER_DATA_LIST;
    }

    public String checkProduct(String code) throws JSONException {
        if (code == null) return "";
        JSONObject result = new JSONObject();
        JSONObject productName = new JSONObject();
        for (DataViewBean bean : SERVER_DATA_LIST) {
            if (bean.getProductCode().equals(code)) {
                result.put("result", productName.put("name", bean.getProductName()));
                return result.toString();
            }
        }

        result.put("error", productName.put("name", "Undefined Product"));
        return result.toString();
    }

    public Boolean updateServerData(String phoneNumber, String code, Integer count) {
        if (SERVER_DATA_LIST.contains(new DataViewBean(code))) {
            for (DataViewBean bean : SERVER_DATA_LIST) {
                if (bean.getProductCode().equals(code)) {
                    bean.setPhoneNumber(phoneNumber);
                    bean.setRealizedCount(count);
                    bean.setRest(bean.getGeneralCount() - count);
                }
            }
            return Boolean.TRUE;
        } else {
            SERVER_DATA_LIST.add(new DataViewBean(phoneNumber, code, count));
            return Boolean.FALSE;
        }
    }

    public void initData() {
        if (isInit) return;

        String codeTruscav = "4820124820157";
        SERVER_DATA_LIST.add(new DataViewBean("-----", 0, codeTruscav, "Truscavetska Water", 1456750));
        codeTruscav = "9785388000033";
        SERVER_DATA_LIST.add(new DataViewBean("-----", 0, codeTruscav, "Thinking in Java", 132234));

        isInit = true;
    }

    public void createProduct(String productCode, String productName, String productAmount) {
        if (productAmount == null || productName == null || productCode == null) return;

        SERVER_DATA_LIST.add(new DataViewBean("-----", 0, productCode, productName, Integer.parseInt(productAmount)));
    }
}
