package com.givemegym.news.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "News",schema="no7")
public class NewsVo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer newsId;
	private byte[] newsImg;
	private Date newsTime;

@Id
@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
@Column(name ="News_ID")
	public Integer getNewsId() {
	return this.newsId;
}
    public void setNewsId(Integer newsId){
    this.newsId = newsId;
}


//照片
@Column(name ="NEWS_IMG")
	public byte[] getNewsImg(){
	return newsImg;
}
    public void setNewsImg(byte[] newsImg) {

	this.newsImg = newsImg;

	}







@Column(name ="NEWS_TIME")
	public Date getNewsTime(){
	return this.newsTime;
}
public void setNewsTime(Date newsTime){
	this.newsTime = newsTime;
}


}



	