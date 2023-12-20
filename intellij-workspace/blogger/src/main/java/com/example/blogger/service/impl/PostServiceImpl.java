package com.example.blogger.service.impl;

import com.example.blogger.entity.Post;
import com.example.blogger.exception.ResourceNotFound;
import com.example.blogger.payload.PostDto;
import com.example.blogger.repository.PostRepository;
import com.example.blogger.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

//    @Override
//    public List<PostDto> getAllPosts() {
//        List<Post> posts = postRepo.findAll();
//        List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
//        return dtos;
//    }

    @Override
    public List<PostDto> getAllPost(int pageNo, int pageSize, String sortBy, String sortOrder) {
        Sort sort = (sortOrder.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        //Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy), sort);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> pagePosts = postRepo.findAll(pageable);
        List<Post> postContent = pagePosts.getContent();
        List<PostDto> dtos = postContent.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public PostDto updatePost(long postId, PostDto postDto) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFound("Post Not Found With id: " + postId)
        );

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        //post.setId(postDto.getId());

        Post savedPost = postRepo.save(post);
        PostDto dto = mapToDto(savedPost);
        return dto;
    }

    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        return dto;
    }
}
