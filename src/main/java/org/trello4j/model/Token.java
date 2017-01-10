package org.trello4j.model;

import java.util.Date;

/**
 * The Class Token.
 */
public class Token extends TrelloObject {

    String idMember;

    Date dateCreated;

    Date dateExpires;

    java.util.List<Permission> permissions;

    public String getIdMember() {
        return idMember;
    }

    public void setIdMember(String idMember) {
        this.idMember = idMember;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateExpires() {
        return dateExpires;
    }

    public void setDateExpires(Date dateExpires) {
        this.dateExpires = dateExpires;
    }

    public class Permission {

        public String getIdModel() {
            return idModel;
        }

        public void setIdModel(String idModel) {
            this.idModel = idModel;
        }

        public String getModelType() {
            return modelType;
        }

        public void setModelType(String modelType) {
            this.modelType = modelType;
        }

        public boolean isRead() {
            return read;
        }

        public void setRead(boolean read) {
            this.read = read;
        }

        public boolean isWrite() {
            return write;
        }

        public void setWrite(boolean write) {
            this.write = write;
        }

        String idModel;

        String modelType;

        boolean read;

        boolean write;
    }
}
