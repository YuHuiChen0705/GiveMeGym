package com.givemegym.course.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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


}