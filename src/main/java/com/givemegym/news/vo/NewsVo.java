package com.givemegym.news.vo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "News",schema="no7")
public class NewsVo {

@Id
@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
@Column(name ="News_ID")
	private int NewsId;
@Column(name ="NEWS_IMG")
	private String NewsImg;
@Column(name ="NEWS_UPDATETIME")
	private String NewsUpdateTime;

public static NewsVo save(NewsVo NewsVo) {
	// TODO Auto-generated method stub
	return null;
}
}

	