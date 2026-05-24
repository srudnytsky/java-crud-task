package com.example.dto;

public class ProjectPrice {
    private long projectId;
    private long price;

    public ProjectPrice(long projectId, long price) {
        this.projectId = projectId;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProjectPrice{" +
                "projectId=" + projectId +
                ", price=" + price +
                '}';
    }
}
