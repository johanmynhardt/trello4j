
package org.trello4j.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attachment extends TrelloObject {

    private Integer bytes;
    private String date;
    private String edgeColor;
    private String idMember;
    private Boolean isUpload;
    private Object mimeType;
    private String name;
    private List<Preview> previews = null;
    private String url;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getBytes() {
        return bytes;
    }

    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEdgeColor() {
        return edgeColor;
    }

    public void setEdgeColor(String edgeColor) {
        this.edgeColor = edgeColor;
    }

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public Boolean getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(Boolean isUpload) {
        this.isUpload = isUpload;
    }

    public Object getMimeType() {
        return mimeType;
    }

    public void setMimeType(Object mimeType) {
        this.mimeType = mimeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Preview> getPreviews() {
        return previews;
    }

    public void setPreviews(List<Preview> previews) {
        this.previews = previews;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
