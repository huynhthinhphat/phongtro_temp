package com.example.PHONGTROSPRING.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BlogPosts")
public class BlogPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

	@ManyToOne
	@JoinColumn(nullable = false, name = "userId", referencedColumnName = "userId")
	private User user;

	@Column(nullable = false, length = 255, columnDefinition = "varchar(255)")
	private String title;

	@Column(nullable = false, columnDefinition = "varchar(255)")
	private String message;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setContent(String message) {
		this.message = message;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt() {
		this.createdAt = LocalDateTime.now();
	}
}
