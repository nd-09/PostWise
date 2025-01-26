package com.user.postwise.dtos;

import com.user.postwise.models.comment.Comment;
import java.util.ArrayList;
import java.util.List;

public class Postdto {
    private Long id;
    private String title;
    private String description;
    private List<Comment> comments = new ArrayList<>();

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    public List<Comment> getComments() {
        return this.comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

//inputstr = comp2uter scien1ce world4 rook3s
//
//output :
//
////csmputer wcience worrd rocks
