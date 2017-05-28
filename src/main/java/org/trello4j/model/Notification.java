package org.trello4j.model;

/**
 *
 * @author joel
 *
 */
public class Notification extends Action {

    private boolean unread;

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }
}
