package com.securitydemo.inmemorysecurity.services;

import java.util.List;

import com.securitydemo.inmemorysecurity.entities.Post;
// import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
  // private final PostRepo postRepo;

  Post post1 = new Post(1L, "Spring Security",
      "Spring Security is a powerful and highly customizable authentication and access-control framework.", "John Doe");
  Post post2 = new Post(2L, "JWT",
      "JSON Web Token (JWT) is an open standard that defines a compact and self-contained way for securely transmitting information between parties as a JSON object.",
      "John Doe");
  Post post3 = new Post(3L, "OAuth 2.0",
      "OAuth 2.0 is the industry-standard protocol for authorization. OAuth 2.0 focuses on client developer simplicity while providing specific authorization flows for web applications, desktop applications, mobile phones, and living room devices.",
      "John Doe");

  public List<Post> getAllPosts() {
    return List.of(post1, post2, post3);
  }

  public Post getPostById(Long id) {
    List<Post> all = getAllPosts();
    for (Post post : all) {
      if (post.getId().equals(id)) {
        return post;
      }
    }
    return null;
  }
}
