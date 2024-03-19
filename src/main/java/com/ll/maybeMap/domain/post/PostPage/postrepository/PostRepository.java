package com.ll.maybeMap.domain.post.PostPage.postrepository;

import com.ll.maybeMap.domain.post.PostPage.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}