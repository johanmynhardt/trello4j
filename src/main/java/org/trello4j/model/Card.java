package org.trello4j.model;

import java.util.HashMap;
import java.util.Map;

public class Card extends TrelloObject {

    private Badges badges;
    private java.util.List<CheckItemState> checkItemStates = null;
    private Boolean closed;
    private Boolean dueComplete;
    private String dateLastActivity;
    private String desc;
    private Object descData;
    private String due;
    private Object email;
    private String idBoard;
    private java.util.List<String> idChecklists = null;
    private String idList;
    private java.util.List<String> idMembers = null;
    private java.util.List<String> idMembersVoted = null;
    private Integer idShort;
    private String idAttachmentCover;
    private Boolean manualCoverAttachment;
    private java.util.List<Label> labels = null;
    private java.util.List<String> idLabels = null;
    private String name;
    private Integer pos;
    private String shortLink;
    private String shortUrl;
    private Boolean subscribed;
    private String url;
    private java.util.List<Attachment> attachments = null;
    private java.util.List<Member> members = null;
    private Board board;
    private org.trello4j.model.List list;
    private java.util.List<Checklist> checklists = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Badges getBadges() {
        return badges;
    }

    public void setBadges(Badges badges) {
        this.badges = badges;
    }

    public java.util.List<CheckItemState> getCheckItemStates() {
        return checkItemStates;
    }

    public void setCheckItemStates(java.util.List<CheckItemState> checkItemStates) {
        this.checkItemStates = checkItemStates;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getDueComplete() {
        return dueComplete;
    }

    public void setDueComplete(Boolean dueComplete) {
        this.dueComplete = dueComplete;
    }

    public String getDateLastActivity() {
        return dateLastActivity;
    }

    public void setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
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

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public java.util.List<String> getIdChecklists() {
        return idChecklists;
    }

    public void setIdChecklists(java.util.List<String> idChecklists) {
        this.idChecklists = idChecklists;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public java.util.List<String> getIdMembers() {
        return idMembers;
    }

    public void setIdMembers(java.util.List<String> idMembers) {
        this.idMembers = idMembers;
    }

    public java.util.List<String> getIdMembersVoted() {
        return idMembersVoted;
    }

    public void setIdMembersVoted(java.util.List<String> idMembersVoted) {
        this.idMembersVoted = idMembersVoted;
    }

    public Integer getIdShort() {
        return idShort;
    }

    public void setIdShort(Integer idShort) {
        this.idShort = idShort;
    }

    public String getIdAttachmentCover() {
        return idAttachmentCover;
    }

    public void setIdAttachmentCover(String idAttachmentCover) {
        this.idAttachmentCover = idAttachmentCover;
    }

    public Boolean getManualCoverAttachment() {
        return manualCoverAttachment;
    }

    public void setManualCoverAttachment(Boolean manualCoverAttachment) {
        this.manualCoverAttachment = manualCoverAttachment;
    }

    public java.util.List<Label> getLabels() {
        return labels;
    }

    public void setLabels(java.util.List<Label> labels) {
        this.labels = labels;
    }

    public java.util.List<String> getIdLabels() {
        return idLabels;
    }

    public void setIdLabels(java.util.List<String> idLabels) {
        this.idLabels = idLabels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public java.util.List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(java.util.List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public java.util.List<Member> getMembers() {
        return members;
    }

    public void setMembers(java.util.List<Member> members) {
        this.members = members;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public org.trello4j.model.List getList() {
        return list;
    }

    public void setList(org.trello4j.model.List list) {
        this.list = list;
    }

    public java.util.List<Checklist> getChecklists() {
        return checklists;
    }

    public void setChecklists(java.util.List<Checklist> checklists) {
        this.checklists = checklists;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
