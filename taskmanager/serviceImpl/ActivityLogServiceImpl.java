package com.taskmanager.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.entity.ActivityLog;
import com.taskmanager.repo.ActivityLogRepo;
import com.taskmanager.service.ActivityLogService;

@Service
public class ActivityLogServiceImpl implements ActivityLogService  {
	
	   @Autowired
	 private ActivityLogRepo activityLogRepository;

	@Override
	public ActivityLog saveLog(ActivityLog log) {
		return activityLogRepository.save(log);
	}

}
