
package org.trello4j.model;

import java.util.HashMap;
import java.util.Map;

public class Membership extends TrelloObject {

    private String idMember;
    private String memberType;
    private Boolean unconfirmed;
    private Boolean deactivated;
    private String orgMemberType;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public Boolean getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(Boolean unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    public Boolean getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(Boolean deactivated) {
        this.deactivated = deactivated;
    }

    public String getOrgMemberType() {
        return orgMemberType;
    }

    public void setOrgMemberType(String orgMemberType) {
        this.orgMemberType = orgMemberType;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
