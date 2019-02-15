package com.oracle.hadoop.bean;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Metadata {

    private String dataFunctionType;
    private String dataClasificationType;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dataFunctionType")
    public String getDataFunctionType() {
        return dataFunctionType;
    }

    @JsonProperty("dataFunctionType")
    public void setDataFunctionType(String dataFunctionType) {
        this.dataFunctionType = dataFunctionType;
    }

    @JsonProperty("dataClasificationType")
    public String getDataClasificationType() {
        return dataClasificationType;
    }

    @JsonProperty("dataClasificationType")
    public void setDataClasificationType(String dataClasificationType) {
        this.dataClasificationType = dataClasificationType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}