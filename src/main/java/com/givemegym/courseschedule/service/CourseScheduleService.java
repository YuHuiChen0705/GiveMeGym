package com.givemegym.courseschedule.service;
import com.givemegym.courseschedule.vo.*;

import java.util.List;
import java.util.Optional;


public interface CourseScheduleService {
	
	boolean isDup(Integer COURSESCHEDULE_ID);
	
	/*新增、修改*/
	CourseScheduleVo saveOrUpdate(CourseScheduleVo coursescheduleVo);
	
	 /*刪除 根據ID刪除單一問題*/
	void deleteById(Integer CourseScheduleId);
	
		
	 /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<CourseScheduleVo> findById(Integer CourseScheduleId);
    
    
    /*查詢所有問題*/
    List<CourseScheduleVo> findAll();

    
    /*根據問題類別(四種類別)查問題*/
    List<CourseScheduleVo> findByCourseScheduleId(Integer CourseScheduleId);
}