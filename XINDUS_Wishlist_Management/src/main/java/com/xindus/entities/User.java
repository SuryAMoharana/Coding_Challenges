package com.xindus.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String customId;
	
	@Column(nullable = false, unique=true)
	private String email;
	
	@Transient
	private String transientId;
	
	@Column(nullable = false)
	private String password;
	
	@PrePersist
    protected void onCreate() {
        if (this.id == null) {
            // Logic to generate custom ID with prefix "X-"
            this.customId = "X-" + this.id;
        }
    }

}
