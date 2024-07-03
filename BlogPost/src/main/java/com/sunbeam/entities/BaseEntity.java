package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	@Column(name="onCreate")
	private LocalDate onCreate;
	
	@UpdateTimestamp
	@Column(name="onUpdate")
	private LocalDate onUpdate;

}
