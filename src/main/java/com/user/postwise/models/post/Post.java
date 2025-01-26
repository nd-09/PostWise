package com.user.postwise.models.post;

import com.user.postwise.models.comment.AddComments;
import com.user.postwise.models.comment.Comment;

import java.util.ArrayList;
import java.util.List;

//@Getter

public class Post implements Ipost{
    private Long id;
    private String title;
    private String description;
    private List<Comment> comments = new ArrayList<>();

   private Post(PostBuilder post) {
       this.id=post.id;
       this.title=post.title;
       this.description=post.description;
       this.comments=post.comments;
   }

   public Long getId() {
       return this.id;
   }
   public String getTitle() {
       return this.title;
   }
   public String getDescription() {
       return this.description;
   }
   public List<Comment> getComments() {
       return this.comments;
   }
   public static PostBuilder getPostBuilder() {
       return new PostBuilder();
   }

    @Override
    public Post addComment(AddComments comment) {
        if(comment.getCommentary()!=null){
            Comment c=new Comment(this,comment.getCommentary());
            comments.add(c);
        }else{
            throw new RuntimeException("Comment is null");
        }
        return this;
    }

    public static class PostBuilder {
       private Long id;
       private String title;
       private String description;
       private List<Comment> comments = new ArrayList<>();

       public PostBuilder setId(Long id) {
           this.id = id;
           return this;
       }
       public PostBuilder setTitle(String title) {
           this.title = title;
           return this;
       }
       public PostBuilder setDescription(String description) {
           this.description = description;
           return this;
       }
//        public PostBuilder setComments(List<Comment> comments) {
//            this.comments = comments;
//            return this;
//        }
       public Post build(){
           if(!this.title.isEmpty() && !this.description.isEmpty()) {
               return new Post(this);
           }else {
            throw new RuntimeException("Title and description cannot be empty");
           }
       }
    }
}
