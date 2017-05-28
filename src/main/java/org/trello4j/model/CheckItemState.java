
package org.trello4j.model;

import java.util.HashMap;
import java.util.Map;

public class CheckItemState {

    private String idCheckItem;
    private String state;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIdCheckItem() {
        return idCheckItem;
    }

    public void setIdCheckItem(String idCheckItem) {
        this.idCheckItem = idCheckItem;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
