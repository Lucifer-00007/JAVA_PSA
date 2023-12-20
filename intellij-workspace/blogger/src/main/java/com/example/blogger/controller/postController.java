package com.example.blogger.controller;

import com.example.blogger.payload.PostDto;
import com.example.blogger.service.PostService;
import jakarta.validation.Valid;
import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class postController {
    private PostService postService;

    public postController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post Deleted!!", HttpStatus.OK);
    }


    //http://localhost:8080/api/posts
//    @GetMapping()
//    public ResponseEntity<List<PostDto>> getAllPosts(){
//        //List<PostDto> postDtos = postService.getAllPosts();
//        //return postDtos;
//
//        List<PostDto> postDtos = postService.getAllPosts();
//        return new ResponseEntity<>(postDtos, HttpStatus.OK);
//    }


    //http://localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=title&sortOrder=asc
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPost(
        @RequestParam(name="pageNo", defaultValue = "0", required = false) int pageNo,
        @RequestParam(name="pageSize", defaultValue ="3", required = false) int pageSize,
        @RequestParam(name="sortBy", defaultValue ="id", required = false) String sortBy,
        @RequestParam(name="sortOrder", defaultValue ="asc", required = false) String sortOrder
    ){
        List<PostDto> postDtos = postService.getAllPost(pageNo, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(postDtos, HttpStatus.OK);
    }


    //http://localhost:8080/api/posts?postId=1
    @PutMapping
    public ResponseEntity<PostDto> updatePost(
            @RequestParam("postId") long postId,
            @RequestBody PostDto postDto
    ){
        PostDto dto = postService.updatePost(postId, postDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
