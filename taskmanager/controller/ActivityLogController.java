package com.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.entity.ActivityLog;
import com.taskmanager.service.ActivityLogService;

@RestController
@RequestMapping("/api/activity")
@CrossOrigin(origins = "*")
public class ActivityLogController {

	 @Autowired
	    private ActivityLogService activityLogService;

	   
	    @GetMapping("/all")
	    public List<ActivityLog> getAllLogs() {
	        return activityLogService.getAllLogs();
	    }

	   
	    @GetMapping("/task/{taskId}")
	    public List<ActivityLog> getLogsByTask(@PathVariable Long taskId) {
	        return activityLogService.getLogsByTaskId(taskId);
	    }

	   
	    @PostMapping("/add")
	    public ActivityLog addLog(@RequestBody ActivityLog log) {
	        return activityLogService.addLog(log);
	    }
}
