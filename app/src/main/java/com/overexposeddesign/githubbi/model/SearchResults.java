package com.overexposeddesign.githubbi.model;

import java.util.ArrayList;

public class SearchResults {
    private String incomplete_results;

    private ArrayList<Repository> items;

    private String total_count;

    public String getIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(String incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public ArrayList<Repository> getItems() {
        return items;
    }

    public void setItems(ArrayList<Repository> items) {
        this.items = items;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    @Override
    public String toString() {
        return "ClassPojo [incomplete_results = " + incomplete_results + ", total_count = " + total_count + "]";
    }
}