package com.user.postwise.controllers;

import com.user.postwise.models.post.Ipost;
import com.user.postwise.models.post.Post;
import com.user.postwise.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class PostController {
    public static HashMap<Long, Post> db=new HashMap<>();
//    Post p= Post.getPostBuilder()
//            .setId(1L)
//            .setTitle("1st post made")
//            .setDescription("Description must be maintained")
//            .build();
//    db.put(p.getId(),p);
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") Long id) {
       return postService.getPostById(id);
    }
    @GetMapping("/posts")
    public List<Ipost> getAllPost(){
        return postService.getAllPosts();
    }
    @PostMapping
    public Post createPost(@RequestBody Post post) {

        return postService.createPost(post);
    }
    @PutMapping
    public Post updatePost(@RequestBody Post post) {
    // complete update
        return postService.updatePost(post);
    }
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        return postService.deletePost(id);
    }


}
