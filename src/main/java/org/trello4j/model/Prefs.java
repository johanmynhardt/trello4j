package org.trello4j.model;

import java.util.HashMap;
import java.util.Map;

import org.trello4j.model.Board.PERMISSION_TYPE;

public class Prefs {

    private String permissionLevel;
    private PERMISSION_TYPE voting;
    private String comments;
    private String invitations;
    private Boolean selfJoin;
    private Boolean cardCovers;
    private String cardAging;
    private Boolean calendarFeedEnabled;
    private String background;
    private Object backgroundImage;
    private Object backgroundImageScaled;
    private Boolean backgroundTile;
    private String backgroundBrightness;
    private String backgroundColor;
    private Boolean canBePublic;
    private Boolean canBeOrg;
    private Boolean canBePrivate;
    private Boolean canInvite;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public PERMISSION_TYPE getVoting() {
        return voting;
    }

    public void setVoting(PERMISSION_TYPE voting) {
        this.voting = voting;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInvitations() {
        return invitations;
    }

    public void setInvitations(String invitations) {
        this.invitations = invitations;
    }

    public Boolean getSelfJoin() {
        return selfJoin;
    }

    public void setSelfJoin(Boolean selfJoin) {
        this.selfJoin = selfJoin;
    }

    public Boolean getCardCovers() {
        return cardCovers;
    }

    public void setCardCovers(Boolean cardCovers) {
        this.cardCovers = cardCovers;
    }

    public String getCardAging() {
        return cardAging;
    }

    public void setCardAging(String cardAging) {
        this.cardAging = cardAging;
    }

    public Boolean getCalendarFeedEnabled() {
        return calendarFeedEnabled;
    }

    public void setCalendarFeedEnabled(Boolean calendarFeedEnabled) {
        this.calendarFeedEnabled = calendarFeedEnabled;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Object getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Object backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Object getBackgroundImageScaled() {
        return backgroundImageScaled;
    }

    public void setBackgroundImageScaled(Object backgroundImageScaled) {
        this.backgroundImageScaled = backgroundImageScaled;
    }

    public Boolean getBackgroundTile() {
        return backgroundTile;
    }

    public void setBackgroundTile(Boolean backgroundTile) {
        this.backgroundTile = backgroundTile;
    }

    public String getBackgroundBrightness() {
        return backgroundBrightness;
    }

    public void setBackgroundBrightness(String backgroundBrightness) {
        this.backgroundBrightness = backgroundBrightness;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Boolean getCanBePublic() {
        return canBePublic;
    }

    public void setCanBePublic(Boolean canBePublic) {
        this.canBePublic = canBePublic;
    }

    public Boolean getCanBeOrg() {
        return canBeOrg;
    }

    public void setCanBeOrg(Boolean canBeOrg) {
        this.canBeOrg = canBeOrg;
    }

    public Boolean getCanBePrivate() {
        return canBePrivate;
    }

    public void setCanBePrivate(Boolean canBePrivate) {
        this.canBePrivate = canBePrivate;
    }

    public Boolean getCanInvite() {
        return canInvite;
    }

    public void setCanInvite(Boolean canInvite) {
        this.canInvite = canInvite;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
