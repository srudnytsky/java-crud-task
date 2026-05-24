package com.example.dto;

public class LongestProject {
    private long id;
    private int monthCount;

    public LongestProject(long id, int monthCount) {
        this.id = id;
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", monthCount=" + monthCount +
                '}';
    }
}
