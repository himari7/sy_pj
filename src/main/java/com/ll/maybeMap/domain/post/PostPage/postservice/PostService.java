package com.ll.maybeMap.domain.post.PostPage.postservice;

import com.ll.maybeMap.domain.post.PostPage.Dto.PostDto;
import com.ll.maybeMap.domain.post.PostPage.entity.Post;
import com.ll.maybeMap.domain.post.PostPage.postrepository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //@Transactional
    public Post createPost(PostDto postDto) {
        Post post = Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .author(postDto.getAuthor())
                .build();
        return postRepository.save(post);
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id=" + id));
    }
    public List<Post> getAllPosts() {
//        return postRepository.findAll().stream().map(post ->
//                PostDto.builder()
//                        .title(post.getTitle())
//                        .content(post.getContent())
//                        .author(post.getAuthor())
//                        .build()
//        ).collect(Collectors.toList());
        return postRepository.findAll();
    }


}

