package com.example.blogger.service;

import com.example.blogger.payload.PostDto;

public interface PostService {

    public PostDto createPost(PostDto postDto);

    void deletePost(long id);
}
