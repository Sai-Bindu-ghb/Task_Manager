package com.taskmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.entity.ActivityLog;

public interface ActivityLogRepo  extends JpaRepository<ActivityLog, Long>  {

}
