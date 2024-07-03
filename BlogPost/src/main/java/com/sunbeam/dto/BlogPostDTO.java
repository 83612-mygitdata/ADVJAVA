package com.sunbeam.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlogPostDTO extends BaseDTO {
	private Long category_id;
	private String content;
	private String description;
	private String title;

}
