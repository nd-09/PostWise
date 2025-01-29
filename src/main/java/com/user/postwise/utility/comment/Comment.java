package com.user.postwise.utility.comment;

import com.user.postwise.utility.post.Post;
import lombok.Getter;

import java.util.Random;


public class Comment extends AddComments {
    @Getter
    private Long id;
    private Long postId;
    private String commentary;
    private Random r=new Random();
    public Comment(Post post){
        super(post);
        this.postId = post.getId();
        this.id= r.nextLong();
    }

    public String getCommentary() {
        return this.commentary;
    }
    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }


    @Override
    public Post addComment(AddComments comment) {
        return post.addComment(comment);  // Use Post's addComment to update the post with the comment.
    }
    public Long getPostId(){
        return this.postId;
    }
    public Long getId(){
        return this.id;
    }

}
