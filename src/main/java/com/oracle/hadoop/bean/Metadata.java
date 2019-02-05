package com.oracle.hadoop.bean;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dataFunctionType",
        "dataClasificationType"
})
public class Metadata {

    @JsonProperty("dataFunctionType")
    private String dataFunctionType;
    @JsonProperty("dataClasificationType")
    private String dataClasificationType;
    @JsonIgnore
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