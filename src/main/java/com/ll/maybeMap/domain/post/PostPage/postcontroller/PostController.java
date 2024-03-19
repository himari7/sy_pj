package com.ll.maybeMap.domain.post.PostPage.postcontroller;

import com.ll.maybeMap.domain.post.PostPage.Dto.PostDto;
import com.ll.maybeMap.domain.post.PostPage.entity.Post;
import com.ll.maybeMap.domain.post.PostPage.postservice.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    // 생성자 주입 방식을 사용 (권장)
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시물 작성 페이지
    @GetMapping("/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new PostDto());
        return "domain/post/post";
    }

    // 게시물 저장
    @PostMapping("/create")
    public String createPost(PostDto postDto) {
        Post savedPost = postService.createPost(postDto);
        return "redirect:/posts/" + savedPost.getId();
    }

    // 게시물 상세 페이지
    @GetMapping("/{postId}")
    public String postDetail(@PathVariable(name = "postId") Long postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "domain/post/detail";
    }

    // 모든 게시물 조회
    @GetMapping("/")
    public String list(Model model) {
        List<PostDto> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "domain/post/list"; // 이 부분은 모든 게시글을 나열하는 템플릿 경로입니다.
    }
}