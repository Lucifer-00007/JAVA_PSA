package com.example.blogger.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name="comments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String body;
    private String email;
    private String name;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
