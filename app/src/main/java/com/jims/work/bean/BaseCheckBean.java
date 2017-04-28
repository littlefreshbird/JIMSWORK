package com.jims.work.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hdy on 2017/2/23.
 */

public class BaseCheckBean implements Serializable {

    private String message;

    private String respcode;

    private List<CheckResult> data;

    private String errorcode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRespcode() {
        return respcode;
    }

    public void setRespcode(String respcode) {
        this.respcode = respcode;
    }

    public List<CheckResult> getData() {
        return data;
    }

    public void setData(List<CheckResult> data) {
        this.data = data;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }


}

