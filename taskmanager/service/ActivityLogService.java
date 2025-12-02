package com.taskmanager.service;

import java.util.List;

import com.taskmanager.entity.ActivityLog;

public interface ActivityLogService {
	
	  ActivityLog addLog(ActivityLog log);
	    List<ActivityLog> getAllLogs();
	    List<ActivityLog> getLogsByTaskId(Long taskId);

}
