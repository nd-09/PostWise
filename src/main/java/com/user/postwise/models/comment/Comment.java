package com.user.postwise.models.comment;

import com.user.postwise.models.post.Post;
import lombok.Getter;

import java.util.Random;


public class Comment extends AddComments {
    @Getter
    private Long id;
    private Long postId;
    private String commentary;
    private Random r=new Random();
    public Comment(Post post,String commentary){
        super(post);
        this.postId = post.getId();
        this.id= r.nextLong();
        this.commentary = commentary;
    }

    public String getCommentary() {
        return this.commentary;
    }


    @Override
    public Post addComment(AddComments comment) {
        return post.addComment(comment);  // Use Post's addComment to update the post with the comment.
    }
}
