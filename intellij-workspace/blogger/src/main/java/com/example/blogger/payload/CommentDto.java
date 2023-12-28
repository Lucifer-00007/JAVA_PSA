package com.example.blogger.payload;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor

@Data
public class CommentDto {

    private long id;
    private String body;
    private String email;
    private String name;

}
