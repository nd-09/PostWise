package com.user.postwise.services;

import com.user.postwise.models.post.Ipost;
import com.user.postwise.models.post.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.user.postwise.controllers.PostController.db;

@Service
public class PostService {

    public Post getPostById(Long postId) {
        if(db.containsKey(postId)){
            return db.get(postId);
        }else{
         throw new NullPointerException("Post with id " + postId + " not found");
        }
    }

    public List<Ipost> getAllPosts() {
        List<Ipost> posts = new ArrayList<>();
        for (Long key : db.keySet()) {
            posts.add(getPostById(key));
        }
        return posts;
    }

    public Post createPost(Post post) {
        Post p1= Post.getPostBuilder().setTitle(post.getTitle())
                .setId(post.getId())
                .setDescription(post.getDescription())
                .build();
        db.put(p1.getId(),p1);
        return p1;
    }

    public Post updatePost(Post post) {
        //complete update
        Post p1= Post.getPostBuilder()
                .setId(post.getId())
                .setTitle(post.getTitle())
                .setDescription(post.getDescription())
                .build();
        db.put(post.getId(),p1);
        return p1;
    }

    public String deletePost(Long id) {
        if(db.containsKey(id)){
            db.remove(id);
        }else{
            return "Post not found";
        }
        return "Post deleted Successfully";
    }
}
