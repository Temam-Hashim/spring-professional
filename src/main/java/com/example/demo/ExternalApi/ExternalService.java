package com.example.demo.ExternalApi;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "PostApi",url="https://jsonplaceholder.typicode.com/")
public interface ExternalService {

    @GetMapping("posts")
    List<Posts> getPosts();
    @GetMapping("posts/{postId}")
    Posts getPost(@PathVariable("postId") Integer postId);

    @GetMapping("users/{userId}/posts")
    List<Posts> getUserPost(@PathVariable("userId") Integer userId);

    @GetMapping("posts/{postId}/comments")
    List<Posts> getPostComment(@PathVariable("postId") Integer postId);

    @PostMapping("posts")
    default Posts createPost(@Valid @RequestBody Posts posts){
        return posts;

    }

    @DeleteMapping("posts/{postId}")
    Posts deletePost(@PathVariable("postId") Integer postId);
}
