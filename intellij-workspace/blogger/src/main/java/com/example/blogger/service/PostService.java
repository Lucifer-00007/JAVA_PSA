package com.example.blogger.service;

import com.example.blogger.payload.PostDto;

import java.util.List;

public interface PostService {

    public PostDto createPost(PostDto postDto);

    void deletePost(long id);

//    List<PostDto> getAllPosts();

    List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortOrder);

    PostDto updatePost(long postId, PostDto postDto);
}
