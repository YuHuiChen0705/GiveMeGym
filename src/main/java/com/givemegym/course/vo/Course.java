package com.givemegym.course.vo;

import com.givemegym.period.vo.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "course", schema = "no7")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID", nullable = false)
    private Integer courseId;

    @Size(max = 20)
    @NotNull
    @Column(name = "COURSE_CATEGORY", nullable = false, length = 20)
    private String courseCategory;

    @Size(max = 20)
    @NotNull
    @Column(name = "COURSE_NAME", nullable = false, length = 20)
    private String courseName;

    @Size(max = 200)
    @NotNull
    @Column(name = "COURSE_INTRODUCTION", nullable = false, length = 200)
    private String courseIntroduction;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "course")
//    @OrderBy("periodId asc")
//    private Set<Period> courses = new HashSet<Period>();


    //註1:【現在是設定成 cascade="all" lazy="false" inverse="true"之意】
    //註2:【mappedBy="多方的關聯屬性名"：用在雙向關聯中，把關係的控制權反轉】【deptVO是EmpVO的屬性】
    //註3:【原預設為@OneToMany(fetch=FetchType.LAZY, mappedBy="deptVO")之意】--> 【是指原為  lazy="true"  inverse="true"之意】
    //FetchType.EAGER : Defines that data must be eagerly fetched
    //FetchType.LAZY  : Defines that data can be lazily fetched
}