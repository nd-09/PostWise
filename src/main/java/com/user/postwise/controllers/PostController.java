package com.user.postwise.controllers;

import com.user.postwise.dtos.Postdto;
import com.user.postwise.models.post.Ipost;
import com.user.postwise.models.post.Post;
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
    public Post getPostById(@PathVariable("id") Long id) {
       return postService.getPostById(id);
    }
    @GetMapping()
    public List<Ipost> getAllPost(){
        return postService.getAllPosts();
    }
    @PostMapping
    public Post createPost(@RequestBody Postdto post) {

        return postService.createPost(post);
    }
    @PutMapping
    public Post updatePost(@RequestBody Postdto post) {
    // complete update
        return postService.updatePost(post);
    }
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        return postService.deletePost(id);
    }


}
