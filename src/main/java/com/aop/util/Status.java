package com.aop.util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by alexanderli on 2/6/15.
 */
public class Status {
    public static final Status UPDATED = new Status(1L, "Updated");
    public static final Status ADDED = new Status(2L, "Added");

    private Long id;
    private String name;

    Status() {}

    Status(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public JSONObject toJson() throws JSONException {
        JSONObject result = new JSONObject();
        result.put("id", getId());
        result.put("name", getName());

        return result;
    }
}
