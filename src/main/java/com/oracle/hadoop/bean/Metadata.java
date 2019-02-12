package com.oracle.hadoop.bean;

import java.util.HashMap;
import java.util.Map;

public class Metadata {

    private String dataFunctionType;
    private String dataClasificationType;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDataFunctionType() {
        return dataFunctionType;
    }
    public void setDataFunctionType(String dataFunctionType) {
        this.dataFunctionType = dataFunctionType;
    }

    public String getDataClasificationType() {
        return dataClasificationType;
    }
    public void setDataClasificationType(String dataClasificationType) {
        this.dataClasificationType = dataClasificationType;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}