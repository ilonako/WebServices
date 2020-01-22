package models;

import java.util.List;

public class UserModel {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserData> data;

    public UserModel(int page, int per_page, int total, int total_pages, List<UserData> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }
}
