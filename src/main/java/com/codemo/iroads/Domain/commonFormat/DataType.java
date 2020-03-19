package com.codemo.iroads.Domain.commonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataType {
    private String type;
    private String subtype;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
}