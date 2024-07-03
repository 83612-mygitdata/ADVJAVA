package com.sunbeam.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="Categories")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Category extends BaseEntity{
	
	@Column(name = "catName", length=25, nullable=false)
	private String catName;
	private String description;

}
