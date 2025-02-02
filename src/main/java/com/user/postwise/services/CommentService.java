package com.user.postwise.services;

import com.user.postwise.dtos.RequestCommentdto;
import com.user.postwise.dtos.ResponseCommentdto;
import com.user.postwise.models.Comment;
import com.user.postwise.models.Post;
import com.user.postwise.repositories.CommentRepository;
import com.user.postwise.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<RequestCommentdto> getCommentsByPostId(Long postId){
        Optional<Post> p= postRepository.findById(postId);
        List<RequestCommentdto>response=new ArrayList<>();
        if(p.isPresent()) {
            for (Comment c : p.get().getComments()) {
                RequestCommentdto r = new RequestCommentdto();
                r.setCommentary(c.getCommentary());
                response.add(r);
            }
        }else{
            throw new NullPointerException("Cannot get comments as Post with " +postId+" not found");
        }
        return response;
    }

    public ResponseCommentdto createComment(RequestCommentdto commentary){
        Optional<Post> p= postRepository.findById(commentary.getPostId());
        if(p.isPresent()) {
            Comment comment = new Comment();
            comment.setPostId(p.get());
            comment.setCommentary(commentary.getCommentary());
            commentRepository.save(comment);
        }else{
            throw new NullPointerException("Cannot create a comment with " +commentary.getPostId()+" not found");
        }
        ResponseCommentdto response=new ResponseCommentdto();
        response.setComment(commentary.getCommentary());
        response.setResponse("Comment added successfully");
        return response;
    }

    public ResponseCommentdto updateComment(Long commentId){
        Optional<Comment> c = commentRepository.findById(commentId);
        ResponseCommentdto response=new ResponseCommentdto();
        if(c.isPresent()) {
            Comment p = c.get();
            commentRepository.save(p);
            response.setComment(p.getCommentary());
            response.setResponse("Comment updated successfully");
        }else{
            throw new NullPointerException("Cannot update a comment with " +commentId+" not found");
        }
        return response;
    }
    public String deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
        return "Comment deleted successfully";
    }
}
