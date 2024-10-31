package com.securitydemo.inmemorysecurity.controllers;

import java.util.List;

import com.securitydemo.inmemorysecurity.entities.Post;
import com.securitydemo.inmemorysecurity.services.PostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
  private final PostService postService;

  @GetMapping("/posts")
  public List<Post> getAllPosts() {
    return postService.getAllPosts();
  }
  @GetMapping("/posts/{id}")
  public Post getPostById(@PathVariable Long id) {
    return postService.getPostById(id);
  }
  @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')") // both user and admin can access
//  @PreAuthorize("hasRole('USER')") // only user can access, admin can't
//  @PreAuthorize("hasRole('ADMIN') and hasRole('USER')") // the user must have a role of admin and user
  @GetMapping("/user")
  public String user() {
    return "Welcome User";
  }
  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/admin")
  public String admin() {
    return "Welcome Admin";
  }
  @GetMapping("/onlyauth")
    public String onlyAuth() {
        return "Welcome Authenticated User";
    }
}