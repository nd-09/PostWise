package com.user.postwise.controllers;

import com.user.postwise.dtos.Commentdto;
import com.user.postwise.dtos.Postdto;
import com.user.postwise.models.comment.Comment;
import com.user.postwise.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{postId}")
        public List<Comment> getAllCommentByPostId(@PathVariable("postId") Long PostId) {
        //gets post id and returns a list of comments on a post
        return commentService.getCommentsByPostId(PostId);
    }
    @PostMapping
    public Comment createComment(@RequestBody Commentdto comment) {
        // adds a comment to a post
        return commentService.createComment(comment);
    }
    @PutMapping
    public Commentdto updateComment(@RequestBody Commentdto comment) {
        // gets a comment by id and updates it
        return commentService.updateComment(comment);
    }

    @DeleteMapping
    public String deleteComment(@RequestBody Commentdto comment) {
        // deletes comment by id
        return commentService.deleteComment(comment);
    }
}
