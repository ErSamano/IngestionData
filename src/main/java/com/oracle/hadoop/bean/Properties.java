package com.oracle.hadoop.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Properties {

    private String sambaShareServer;
    private String sambaShareName;
    private List<String> sambaShareDirectories = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getSambaShareServer() {
        return sambaShareServer;
    }
    public void setSambaShareServer(String sambaShareServer) {
        this.sambaShareServer = sambaShareServer;
    }

    public String getSambaShareName() {
        return sambaShareName;
    }
    public void setSambaShareName(String sambaShareName) {
        this.sambaShareName = sambaShareName;
    }

    public List<String> getSambaShareDirectories() {
        return sambaShareDirectories;
    }
    public void setSambaShareDirectories(List<String> sambaShareDirectories) {
        this.sambaShareDirectories = sambaShareDirectories;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}