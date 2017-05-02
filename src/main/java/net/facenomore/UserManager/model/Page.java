package net.facenomore.UserManager.model;

import java.util.List;

public class Page {
    private int totalUsersNumber;
    private List<User> data;

    public Page(int count, List<User> users) {
        this.totalUsersNumber = count;
        this.data = users;
    }

    public int getTotalUsersNumber() {
        return totalUsersNumber;
    }

    public void setTotalUsersNumber(int totalUsersNumber) {
        this.totalUsersNumber = totalUsersNumber;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
