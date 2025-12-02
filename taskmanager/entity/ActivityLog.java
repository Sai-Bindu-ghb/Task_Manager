package com.taskmanager.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	 private Long id;
	 
	 @ManyToOne
	 @JoinColumn(name = "task_id")
	 
	 private Task task;

	 @ManyToOne
	 @JoinColumn(name = "user_id")
	 private User user;

	 
	 private String action; // CREATED / UPDATED / DELETED / STATUS_CHANGED
	 private LocalDateTime timestamp;
	 
	 public ActivityLog() {}

	    // Parameterized constructor
	    public ActivityLog(Long id, Task task, User user, String action, LocalDateTime timestamp) {
	        this.id = id;
	        this.task = task;
	        this.user = user;
	        this.action = action;
	        this.timestamp = timestamp;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Task getTask() {
			return task;
		}

		public void setTask(Task task) {
			this.task = task;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

}
