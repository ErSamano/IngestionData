package com.oracle.hadoop.bean;

import java.util.HashMap;
import java.util.Map;

public class IngestionInputEvents {

    private String name;
    private Properties properties;
    private Metadata metadata;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Properties getProperties() {
        return properties;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Metadata getMetadata() {
        return metadata;
    }
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
