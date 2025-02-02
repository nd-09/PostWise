package com.user.postwise.controllers;

import com.user.postwise.dtos.RequestCommentdto;
import com.user.postwise.dtos.ResponseCommentdto;
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
        public List<RequestCommentdto> getAllCommentByPostId(@PathVariable("postId") Long PostId) {
        //gets post id and returns a list of comments on a post
        return commentService.getCommentsByPostId(PostId);
    }
    @PostMapping
    public ResponseCommentdto createComment(@RequestBody RequestCommentdto comment) {
        // adds a comment to a post
        return commentService.createComment(comment);
    }
    @PutMapping("/{id}")
    public ResponseCommentdto updateComment(@PathVariable("id") Long id) {
        // gets a comment by id and updates it
        return commentService.updateComment(id);
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable("id") Long commentId) {
        // deletes comment by id
        return commentService.deleteComment(commentId);
    }
}
