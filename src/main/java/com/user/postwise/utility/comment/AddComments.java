package com.user.postwise.utility.comment;

import com.user.postwise.utility.post.Ipost;
import com.user.postwise.utility.post.Post;

public abstract class AddComments implements Ipost {
    protected Post post;
    public AddComments(Post post) {
        this.post = post;
    }

    public abstract Post addComment(AddComments comment);
    public abstract String getCommentary();

}
