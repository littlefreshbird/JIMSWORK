package com.jims.work.bean;

/**
 * Created by hdy on 2017/4/6.
 */

public class Check_result {
    private String check_name;
    private String check_result;
    private String check_unit;
    private String unusual;
    private String value;


    public Check_result() {
        super();
    }

    public Check_result(String check_name, String check_result, String check_unit, String unusual,
                        String value) {
        super();
        this.check_name = check_name;
        this.check_result = check_result;
        this.check_unit = check_unit;
        this.unusual = unusual;
        this.value = value;

    }

    public String getCheck_name() {
        return check_name;
    }

    public void setCheck_name(String check_name) {
        this.check_name = check_name;
    }

    public String getCheck_result() {
        return check_result;
    }

    public void setCheck_result(String check_result) {
        this.check_result = check_result;
    }

    public String getCheck_unit() {
        return check_unit;
    }

    public void setCheck_unit(String check_unit) {
        this.check_unit = check_unit;
    }

    public String getUnusual() {
        return unusual;
    }

    public void setUnusual(String unusual) {
        this.unusual = unusual;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
