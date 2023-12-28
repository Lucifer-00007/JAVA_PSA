package com.example.blogger.service.impl;

import com.example.blogger.entity.Comment;
import com.example.blogger.entity.Post;
import com.example.blogger.exception.ResourceNotFound;
import com.example.blogger.payload.CommentDto;
import com.example.blogger.repository.CommentRepository;
import com.example.blogger.repository.PostRepository;
import com.example.blogger.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl  implements CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    @Override

    public CommentDto createComment(long postId, CommentDto commentDto) {
        System.out.println("name: " + commentDto.getName());
        System.out.println("id: " + commentDto.getId());
        System.out.println("body: " + commentDto.getBody());
        System.out.println("email: " + commentDto.getEmail());
        System.out.println("postId: " + postId);
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFound("Post not found with postId: " + postId)
        );

        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        System.out.println("name: " + commentDto.getBody());
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(savedComment.getId());
        dto.setName(savedComment.getName());
        dto.setEmail(savedComment.getEmail());
        dto.setBody(savedComment.getBody());

        return dto;
    }

    @Override
    public void deleteComment(long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFound("Comment not found with id: " + commentId)
        );

        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        List<CommentDto> commentDtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());

        return commentDtos;

    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDto> dtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
        return dtos;
    }

    CommentDto mapToDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());

        return dto;
    }

}