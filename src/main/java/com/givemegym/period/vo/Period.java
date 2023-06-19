package com.givemegym.period.vo;

import com.givemegym.course.vo.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "period", schema = "no7")
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERIOD_ID")
    private Integer periodId;

    @NotNull()
    @Column(name = "PEOPLE_UPPER")
    private Integer peopleUpper;

    @Column(name = "PEOPLE_LOWER")
    private Integer peopleLower;

    @Column(name = "COURSE_PRICE")
    private Integer coursePrice;

    @Column(name = "COURSE_STATE", insertable = false)
    private String courseState;

    @Column(name = "COURSE_NUMBER")
    private Integer courseNumber;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @Column(name = "COURSE_ORDER_BE")
    private Date courseOrderBe;

    @Column(name = "COURSE_ORDER_EN")
    private Date courseOrderEn;


}
