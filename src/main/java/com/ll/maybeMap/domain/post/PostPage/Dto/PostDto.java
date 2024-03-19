package com.ll.maybeMap.domain.post.PostPage.Dto;

import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PostDto {
    //private Long id;
    private String title;
    private String content;
    private String author;


}