package com.taskmanager.entity;

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
@Table(name = "tasks")
public class Task {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String title;
    
    
    @Column(columnDefinition = "TEXT")
    private String description;

    private String status; // PENDING, IN_PROGRESS, COMPLETED
    
    @ManyToOne
    @JoinColumn(name = "created_by")
    
    private User createdBy;
    
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User assignedTo;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public Task() {}
    
    public Task(Long id, String title, String description, String status, User createdBy,
            User assignedTo, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.status = status;
    this.createdBy = createdBy;
    this.assignedTo = assignedTo;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
