package com.example.blogger.service.impl;

import com.example.blogger.entity.Post;
import com.example.blogger.exception.ResourceNotFound;
import com.example.blogger.payload.PostDto;
import com.example.blogger.repository.PostRepository;
import com.example.blogger.service.PostService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post savedPost = postRepo.save(post);

        PostDto dto = new PostDto();
        dto.setId(savedPost.getId());
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());
        dto.setMessage("Post is created!!");

        return  dto;
    }

    @Override
    public void deletePost(long id) {
        //Optional<Post> byId = postRepo.findById(id);
        //if(byId.isPresent()) {
            //postRepo.deleteById(id);
        //}else {
            //throw new ResourceNotFound("Post not found with id: "+id);
        //}

        Post post= postRepo.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Post not found with id: "+id)
        );

        postRepo.deleteById(id);
    }
}
