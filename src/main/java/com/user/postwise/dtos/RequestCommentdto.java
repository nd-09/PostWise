package com.user.postwise.dtos;

public class RequestCommentdto {
    private Long id;
    private Long postId;
    private String commentary;

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
