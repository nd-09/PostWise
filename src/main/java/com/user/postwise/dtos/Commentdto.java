package com.user.postwise.dtos;

public class Commentdto {
    private Long id;
    private Long postId;
    private String commentary;

//    public void setId(Long id) {
//        this.id = id;
//    }
    public Long getId() {
        return this.id;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }
    public Long getPostId() {
        return this.postId;
    }
    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
    public String getCommentary() {
        return this.commentary;
    }

}
