package com.givemegym.news.vo;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NEWS_ID")
    Integer newsId;

    @Column(name = "NEWS_IMG")
    byte[] newsImg;

    @Column(name = "NEWS_TIME")
    Timestamp newsTime;
}

	