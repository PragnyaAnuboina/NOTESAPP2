package com.cs17b004.notesapp;

import org.json.JSONException;
import org.json.JSONObject;

public class note {
    private static final String JSON_TITLE = "Title";
    private static final String JSON_DESCRIPTION = "Description";
    private static final String JSON_FAVORITE = "Favorite" ;
    private static final String JSON_TODO = "Todo";
    private static final String JSON_DONE = "Done";
    private static final String JSON_BUDGET="Budget";
    // End added in chapter 7

    String title;
    String description;
    boolean favorite;
    boolean todo;
    boolean done;
    boolean budget;

    public note(JSONObject jo) throws JSONException {
        title =  jo.getString(JSON_TITLE);
        description = jo.getString(JSON_DESCRIPTION);
        favorite = jo.getBoolean(JSON_FAVORITE);
        todo = jo.getBoolean(JSON_TODO);
        done = jo.getBoolean(JSON_DONE);
        budget=jo.getBoolean(JSON_BUDGET);
    }


    public note (){

    }

    public JSONObject convertToJSON() throws JSONException{
        JSONObject jo = new JSONObject();

        jo.put(JSON_TITLE, title);
        jo.put(JSON_DESCRIPTION, description);
        jo.put(JSON_FAVORITE, favorite);
        jo.put(JSON_TODO, todo);
        jo.put(JSON_DONE, done);
        jo.put(JSON_BUDGET,budget);

        return jo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isTodo() {
        return todo;
    }

    public void setTodo(boolean todo) {
        this.todo = todo;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isBudget() {
        return budget;
    }

    public void setBudget(boolean budget) {
        this.budget = budget;
    }
}
