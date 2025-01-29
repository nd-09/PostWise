package com.user.postwise.services;

import com.user.postwise.dtos.RequestPostdto;
import com.user.postwise.dtos.ResponsePostdto;
import com.user.postwise.utility.post.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.user.postwise.controllers.PostController.db;

@Service
public class PostService {

    public ResponsePostdto getPostById(Long postId) {
        if(db.containsKey(postId)){
            Post post = db.get(postId);
            ResponsePostdto response = new ResponsePostdto();
            response.setTitle(post.getTitle());
            response.setDescription(post.getDescription());
            response.setComments(post.getComments());
            response.setResponse("Post found with successfully");
            return response;
        }else{
         throw new NullPointerException("Post with id " + postId + " not found");
        }
    }

    public List<RequestPostdto> getAllPosts() {
        List<RequestPostdto> posts = new ArrayList<>();
        for (Long key : db.keySet()) {
            Post post = db.get(key);
            RequestPostdto postDto = new RequestPostdto();
            postDto.setTitle(post.getTitle());
            postDto.setDescription(post.getDescription());
            postDto.setComments(post.getComments());

            posts.add(postDto);
        }
        return posts;
    }

    public ResponsePostdto createPost(RequestPostdto post) {
        Post p1= Post.getPostBuilder().setTitle(post.getTitle())
                .setId(post.getId())
                .setDescription(post.getDescription())
                .build();
        db.put(p1.getId(),p1);
        ResponsePostdto response = new ResponsePostdto();
        response.setTitle(post.getTitle());
        response.setDescription(post.getDescription());
        response.setResponse("Post created successfully");
        return response;
    }

    public ResponsePostdto updatePost(RequestPostdto post) {
        //complete update
        Post p1= Post.getPostBuilder()
                .setId(post.getId())
                .setTitle(post.getTitle())
                .setDescription(post.getDescription())
                .build();
        db.put(post.getId(),p1);
        ResponsePostdto response = new ResponsePostdto();
        response.setTitle(post.getTitle());
        response.setDescription(post.getDescription());
        response.setResponse("Post updated successfully");

        return response;
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
