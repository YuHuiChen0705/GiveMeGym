package com.givemegym.courseshowoff.service;
import com.givemegym.courseshowoff.vo.CourseShowOffVo;


import java.util.List;
import java.util.Optional;
public interface CourseShowOffService {
boolean isDup(Integer COURSESCHEDULE_ID);
	
	/*新增或修改問題*/
    CourseShowOffVo saveOrUpdate(CourseShowOffVo courseshowoffvo);
	
	 /*刪除 根據ID刪除單一問題*/
	void deleteById(Integer CourseScheduleId);
	
	 /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<CourseShowOffVo> findById(Integer CourseShowOffId);

    /*查詢所有問題*/
    List<CourseShowOffVo> findAll();
//  VO型別
    /*根據問題類別(四種類別)查問題*/
    List<CourseShowOffVo> findByCourseShowOffId(Integer CourseShowOffId);

}
