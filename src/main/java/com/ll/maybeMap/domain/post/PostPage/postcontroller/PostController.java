package com.ll.maybeMap.domain.post.PostPage.postcontroller;

import com.ll.maybeMap.domain.post.PostPage.Dto.PostDto;
import com.ll.maybeMap.domain.post.PostPage.entity.Post;
import com.ll.maybeMap.domain.post.PostPage.postservice.AnswerService;
import com.ll.maybeMap.domain.post.PostPage.postservice.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final AnswerService answerService;

    public PostController(PostService postService, AnswerService answerService) {
        this.postService = postService;
        this.answerService = answerService;
    }

    // 게시물 작성 페이지
    @GetMapping("/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new PostDto());
        return "domain/post/create";
    }

    // 게시물 저장
    @PostMapping("/create")
    public String createPost(PostDto postDto) {
        Post savedPost = postService.createPost(postDto);
        return "redirect:/posts/" + savedPost.getId();
    }

    // 게시물 상세 페이지
    @GetMapping("/{postId}")
    public String postDetail(@PathVariable(name = "postId") Long aId, Model model) {
        Post post = postService.getPost(aId);
        model.addAttribute("post", post);
        return "domain/post/detail";
    }

    // 모든 게시물 조회
    @GetMapping("/")
    public String list(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "domain/post/list"; //
    }

    @PostMapping("/{id}")
    public String createAnswer(Model model, @PathVariable("id") Long postId, @RequestParam(value="content") String content) {
        Post post = postService.getPost(postId);
        this.answerService.createAnswer(post.getId(), content);
        return String.format("redirect:/posts/%s", postId); //
    }


}