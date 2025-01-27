package com.user.postwise.services;

import com.user.postwise.dtos.Commentdto;
import com.user.postwise.models.comment.Comment;
import com.user.postwise.models.post.Post;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

import static com.user.postwise.controllers.PostController.db;

@Service
public class CommentService {

    public List<Comment> getCommentsByPostId(Long postId){
        Post p=db.get(postId);
        return p.getComments();
    }

    public Comment createComment(Commentdto commentary){
        Post p=db.get(commentary.getPostId());
        Comment c= new Comment(p);
        c.setCommentary(commentary.getCommentary());
        p.addComment(c);
        return c;
    }

    public Commentdto updateComment( Commentdto comment){
        Post p =db.get(comment.getPostId());
       //got the post by post id and add update the comment to it
       List<Comment> ls=p.getComments();
       // here since we are using a map as our in-memory db we are not maintaining a separate map for comments
        // ,so we need to iterate over comments list to the comment
        // else we would be querying the comments table directly using comment id present in comment;
       for(Comment c:ls) {
           if (Objects.equals(comment.getId(), c.getId())) {
               c.setCommentary(comment.getCommentary());
               break;
           }
       }
        return comment;
    }
    public String deleteComment(Commentdto Comment){
        // here since we are using a map as our in-memory db we are not maintaining a separate map for comments
        // else we would be querying the comments table directly using comment id;
        Post p=db.get(Comment.getPostId());
        List<Comment> ls=p.getComments();
        for(Comment c:ls) {
            if (Objects.equals(Comment.getId(), c.getId())) {
                ls.remove(c);
                return "Comment deleted successfully";
            }
        }
        return "Comment not found";
    }
}
