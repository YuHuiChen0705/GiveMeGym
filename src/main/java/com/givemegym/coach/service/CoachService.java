package com.givemegym.coach.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.coach.vo.Coach;

public interface CoachService {

	/* 根據Id檢查是否重複 */
	boolean isDup(Integer coachId);

	/* 新增或修改問題 */

	Coach saveOrUpdate(Coach coach);

	/* 刪除 根據ID刪除單一問題 */

	void deleteById(Integer coachId);

	/* 查詢 根據ID查單一問題 Optional避免空值例外 */
	Optional<Coach> findById(Integer coachId);

	/* 查詢所有問題 */
	List<Coach> findAll();

	/* 根據問題類別(四種類別)查問題 */

	List<Coach> findByCoachId(Integer coachId);

}
