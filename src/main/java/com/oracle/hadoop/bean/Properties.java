package com.oracle.hadoop.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sambaShareServer",
        "sambaShareName",
        "sambaShareDirectories"
})
public class Properties {

    @JsonProperty("sambaShareServer")
    private String sambaShareServer;
    @JsonProperty("sambaShareName")
    private String sambaShareName;
    @JsonProperty("sambaShareDirectories")
    private List<String> sambaShareDirectories = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sambaShareServer")
    public String getSambaShareServer() {
        return sambaShareServer;
    }

    @JsonProperty("sambaShareServer")
    public void setSambaShareServer(String sambaShareServer) {
        this.sambaShareServer = sambaShareServer;
    }

    @JsonProperty("sambaShareName")
    public String getSambaShareName() {
        return sambaShareName;
    }

    @JsonProperty("sambaShareName")
    public void setSambaShareName(String sambaShareName) {
        this.sambaShareName = sambaShareName;
    }

    @JsonProperty("sambaShareDirectories")
    public List<String> getSambaShareDirectories() {
        return sambaShareDirectories;
    }

    @JsonProperty("sambaShareDirectories")
    public void setSambaShareDirectories(List<String> sambaShareDirectories) {
        this.sambaShareDirectories = sambaShareDirectories;
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