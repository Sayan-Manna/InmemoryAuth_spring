package com.securitydemo.inmemorysecurity.entities;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
//import lombok.Data;

// @Entity
// @Data
public class Post {
  // @Id
  private Long id;
  private String title;
  private String content;
  private String author;

  public Post(Long id, String title, String content, String author) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public Post() {
  }

  // getter and setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
