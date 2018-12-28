package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class BookType implements Serializable {
    private String tname;
    private String tvalue;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTvalue() {
        return tvalue;
    }

    public void setTvalue(String tvalue) {
        this.tvalue = tvalue;
    }

    public BookType(String tname, String tvalue) {
        this.tname = tname;
        this.tvalue = tvalue;
    }

    public BookType() {
    }


}
