package com.user.postwise.services;

import com.user.postwise.dtos.RequestCommentdto;
import com.user.postwise.dtos.RequestPostdto;
import com.user.postwise.dtos.ResponseCommentdto;
import com.user.postwise.dtos.ResponsePostdto;
import com.user.postwise.models.Comment;
import com.user.postwise.models.Post;
import com.user.postwise.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public ResponsePostdto getPostById(Long postId) {
        Optional<Post> p= postRepository.findById(postId);// is it mapped with the models
         // under the hood by Jpa Repository??
        List<ResponseCommentdto> comments = new ArrayList<>();
        if(p.isPresent()){
            ResponsePostdto response = new ResponsePostdto();
            response.setTitle(p.get().getTitle());
            response.setDescription(p.get().getDescription());
//            response.setComments(p.get().getComments());
            for(Comment comment : p.get().getComments()){
                ResponseCommentdto dto = new ResponseCommentdto();
                dto.setComment(comment.getCommentary());
                comments.add(dto);
            }
            response.setComments(comments);
            response.setResponse("Post found with successfully");
            return response;
        }else{
         throw new NullPointerException("Post with id " + postId + " not found");
        }
    }

    public List<RequestPostdto> getAllPosts() {
        List<RequestPostdto> posts = new ArrayList<>();
        postRepository.findAll().forEach(post -> {
            RequestPostdto dto= new RequestPostdto();
            dto.setTitle(post.getTitle());
//            dto.setComments(post.getComments());
            dto.setDescription(post.getDescription());
            posts.add(dto);
        });
        return posts;
    }

    public ResponsePostdto createPost(RequestPostdto post) {
        Post p=new Post();
        p.setTitle(post.getTitle());
        p.setDescription(post.getDescription());
        p.setComments(post.getComments());
        postRepository.save(p);
        ResponsePostdto response = new ResponsePostdto();
        response.setTitle(p.getTitle());
        response.setDescription(p.getDescription());
        response.setResponse("Post created successfully");
        return response;
    }

    public ResponsePostdto updatePost(RequestPostdto post) {
        //complete update
        Post p=new Post();
        p.setTitle(post.getTitle());
        p.setDescription(post.getDescription());
        p.setComments(post.getComments());
        postRepository.save(p);
        ResponsePostdto response = new ResponsePostdto();
        response.setTitle(p.getTitle());
        response.setDescription(p.getDescription());
        response.setResponse("Post updated successfully");

        return response;
    }

    public String deletePost(Long id) {
        if(postRepository.existsById(id)){
            postRepository.deleteById(id);
        }else{
            return "Post not found";
        }
        return "Post deleted Successfully";
    }
}
