package com.sunbeam.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="blogPosts")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BlogPost extends BaseEntity {
	
	
	private String content;
	private String description;
	private String title;
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable=false)
	private Category category_id;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user_id;

	
	
	
}
