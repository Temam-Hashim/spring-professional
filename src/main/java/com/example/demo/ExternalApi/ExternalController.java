package com.example.demo.ExternalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/external/posts")
@RestController
public class ExternalController {

    private final ExternalService externalService;

    @Autowired
    public ExternalController(ExternalService externalService) {
        this.externalService = externalService;
    }


    @GetMapping("{postId}")
    Posts getPost(@PathVariable("postId") Integer postId){
        return externalService.getPost(postId);
    }

    @GetMapping()
    List<Posts> getPosts(){
        return externalService.getPosts();
    }

    @GetMapping("{postId}/comments")
    List<Posts> getPostComment(@PathVariable("postId") Integer postId){
        return externalService.getPostComment(postId);
    }

    @PostMapping()
    Posts createPost(Posts posts){
        return externalService.createPost(posts);
    }

    @DeleteMapping("{postId}")
    Posts deletePost(@PathVariable("postId") Integer postId){
        return externalService.deletePost(postId);
    }

    @GetMapping("{userId}/user")
    List<Posts> getUserPost(@PathVariable("userId") Integer userId){
        return externalService.getUserPost(userId);
    }
}
