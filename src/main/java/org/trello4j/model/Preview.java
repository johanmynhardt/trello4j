
package org.trello4j.model;

import java.util.HashMap;
import java.util.Map;

public class Preview extends TrelloObject {

    private Integer bytes;
    private String url;
    private Integer height;
    private Integer width;
    private String id;
    private Boolean scaled;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getBytes() {
        return bytes;
    }

    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Boolean getScaled() {
        return scaled;
    }

    public void setScaled(Boolean scaled) {
        this.scaled = scaled;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
