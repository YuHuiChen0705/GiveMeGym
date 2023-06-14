package com.givemegym.faqs.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "faqs")
public class Faq {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID", nullable = false)
    private Integer faqId;

    @Size(max = 20)
    @NotNull()
    @Column(name = "QUESTION_CATEGORY", nullable = false, length = 20)
    private String faqCategory;


    @Size(max = 500)
    @NotNull()
    @Column(name = "QUESTION_DESCRIPTION", nullable = false, length = 500)
    private String faqQ;

    @Size(max = 500)
    @NotNull()
    @Column(name = "ANSWER_DESCRIPTION", nullable = false, length = 500)
    private String faqA;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "FAQS_UPDATETIME")
    private Date faqUpdateTime;


}