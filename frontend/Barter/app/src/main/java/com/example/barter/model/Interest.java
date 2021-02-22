package com.example.barter.model;

public class Interest {
    private int id;
    private String interested_uid;
    private int pid;
    private String offering_pid;

    public Interest(int id, String interested_uid, int pid, String offering_pid) {
        this.id = id;
        this.interested_uid = interested_uid;
        this.pid = pid;
        this.offering_pid = offering_pid;
    }

    public int getId() {
        return id;
    }

    public String getInterested_uid() {
        return interested_uid;
    }

    public int getPid() {
        return pid;
    }

    public String getOffering_pid() {
        return offering_pid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInterested_uid(String interested_uid) {
        this.interested_uid = interested_uid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setOffering_pid(String offering_pid) {
        this.offering_pid = offering_pid;
    }
}
