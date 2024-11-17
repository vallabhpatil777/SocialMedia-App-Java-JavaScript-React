package com.vallabh.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
	
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@OneToMany(mappedBy = "chat")
	private List<Message> messages = new ArrayList<>();
	
	private String chatName;
	
	private String chatImage;
	
	@ManyToMany
	private List<User> user = new ArrayList<>();
	
	private LocalDateTime timestamp;

}
