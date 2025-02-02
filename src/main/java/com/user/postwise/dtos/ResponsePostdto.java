package com.user.postwise.dtos;

import com.user.postwise.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class ResponsePostdto {
    private String response;
    private String title;
    private String description;
    private List<ResponseCommentdto> comments = new ArrayList<>();

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<ResponseCommentdto> getComments() {
        return this.comments;
    }
    public void setComments(List<ResponseCommentdto> comments) {
        this.comments = comments;
    }
    public String getResponse() {
        return this.response;
    }
    public void setResponse(String response) {
        this.response = response;
    }
}
