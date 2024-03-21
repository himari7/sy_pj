package com.ll.maybeMap.domain.post.PostPage.postservice;

import com.ll.maybeMap.domain.post.PostPage.entity.Answer;
import com.ll.maybeMap.domain.post.PostPage.entity.Post;
import com.ll.maybeMap.domain.post.PostPage.postrepository.AnswerRepository;
import com.ll.maybeMap.domain.post.PostPage.postrepository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service

public class AnswerService {
    private final AnswerRepository answerRepository;
    private final PostRepository postRepository;

    public void createAnswer(Long posted, String content) {
        Post post = postRepository.findById(posted)
                .orElseThrow(() -> new IllegalArgumentException("해당 체험을 찾을 수 없습니다."));

        Answer answer = new Answer();
        answer.setContent(content);
        answer.setPost(post);
        answer.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }
}