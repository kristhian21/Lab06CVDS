package edu.eci.cvds.servlet.model;

public class Todo{
    
    private int userID;
    private int id;
    private String title;
    private boolean completed;

    public Todo(){

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getUserID() {
        return userID;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
