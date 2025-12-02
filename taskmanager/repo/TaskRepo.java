package com.taskmanager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.entity.Task;

public interface TaskRepo  extends JpaRepository<Task, Long> {
	
	List<Task> findByAssignedToId(Long userId);  
    List<Task> findByCreatedById(Long managerId);

}
