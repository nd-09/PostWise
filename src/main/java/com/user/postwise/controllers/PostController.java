package com.user.postwise.controllers;

import com.user.postwise.dtos.RequestPostdto;
import com.user.postwise.dtos.ResponsePostdto;
import com.user.postwise.utility.post.Post;
import com.user.postwise.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    public static HashMap<Long, Post> db=new HashMap<>();
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/{id}")
    public ResponsePostdto getPostById(@PathVariable("id") Long id) {
       return postService.getPostById(id);
    }
    @GetMapping()
    public List<RequestPostdto> getAllPost(){
        return postService.getAllPosts();
    }
    @PostMapping
    public ResponsePostdto createPost(@RequestBody RequestPostdto post) {

        return postService.createPost(post);
    }
    @PutMapping
    public ResponsePostdto updatePost(@RequestBody RequestPostdto post) {
    // complete update
        return postService.updatePost(post);
    }
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        return postService.deletePost(id);
    }


}
