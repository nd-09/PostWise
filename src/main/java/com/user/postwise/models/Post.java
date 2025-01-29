package com.user.postwise.models;

import com.user.postwise.utility.comment.Comment;

import java.util.ArrayList;
import java.util.List;

public class Post extends BaseModel {
    private String title;
    private String description;
    private List<Comment> comments = new ArrayList<>();
}
