package com.givemegym.skill.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.skill.vo.Skill;

public interface SkillService {

	/* 根據Id檢查是否重複 */
	boolean isDup(Integer skillId);

	/* 新增或修改問題 */

	Skill saveOrUpdate(Skill skill);

	/* 刪除 根據ID刪除單一問題 */

	void deleteById(Integer skill);

	/* 查詢 根據ID查單一問題 Optional避免空值例外 */
	Optional<Skill> findById(Integer skill);

	/* 查詢所有問題 */
	List<Skill> findAll();

	/* 根據問題類別(四種類別)查問題 */

	List<Skill> findBySkillId(Integer skillId);

}
