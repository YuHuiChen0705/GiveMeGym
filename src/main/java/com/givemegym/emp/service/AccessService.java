package com.givemegym.emp.service;

import java.util.List;
import java.util.Optional;

import com.givemegym.emp.vo.Access;

public interface AccessService {
	
	/*根據Id檢查是否重複*/
	boolean isDup(Integer accessId);

    /*新增或修改問題*/
    Access saveOrUpdate(Access access);

    /*刪除 根據ID刪除單一問題*/
    void deleteById(Integer access);

    /*查詢 根據ID查單一問題 Optional避免空值例外*/
    Optional<Access> findById(Integer access);

    /*查詢所有問題*/
    List<Access> findAll();

    /*根據問題類別(四種類別)查問題 比如透過部門找員工*/
    List<Access> findByAccessId(Integer accessId);

}
