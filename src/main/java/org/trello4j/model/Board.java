
package org.trello4j.model;

import java.util.HashMap;
import java.util.Map;

import org.trello4j.gson.CopyOfPermissionTypeDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Board extends TrelloObject {

    @JsonDeserialize(using = CopyOfPermissionTypeDeserializer.class)
    public enum PERMISSION_TYPE {
        PUBLIC, ORGANIZATION, MEMBERS
    }

    private String name;
    private String desc;
    private Object descData;
    private Boolean closed;
    private String idOrganization;
    private Boolean pinned;
    private String url;
    private Prefs prefs;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getDescData() {
        return descData;
    }

    public void setDescData(Object descData) {
        this.descData = descData;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Prefs getPrefs() {
        return prefs;
    }

    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
