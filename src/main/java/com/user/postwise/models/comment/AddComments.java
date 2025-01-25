package com.user.postwise.models.comment;

import com.user.postwise.models.post.Ipost;
import com.user.postwise.models.post.Post;

public abstract class AddComments implements Ipost {
    protected Post post;
    public AddComments(Post post) {
        this.post = post;
    }

    public abstract Post addComment(AddComments comment);
    public abstract String getCommentary();

}
