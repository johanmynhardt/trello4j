
package org.trello4j.model;

import java.util.HashMap;
import java.util.Map;

public class CheckItem extends TrelloObject {

    private String state;
    private String idChecklist;
    private String name;
    private Object nameData;
    private Integer pos;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIdChecklist() {
        return idChecklist;
    }

    public void setIdChecklist(String idChecklist) {
        this.idChecklist = idChecklist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNameData() {
        return nameData;
    }

    public void setNameData(Object nameData) {
        this.nameData = nameData;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
