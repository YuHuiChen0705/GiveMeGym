package com.givemegym.period.vo;

import com.givemegym.course.vo.Course;
import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.courseschedule.vo.CourseSchedule;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@ToString
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

    @NotNull(message = "請設定人數上限")
    @Min(value = 1, message = "人數上限必須大於等於1")
    @Column(name = "PEOPLE_UPPER")
    private Integer peopleUpper;


    @NotNull(message = "請設定人數下限")
    @Min(value = 1, message = "人數下限必須大於等於1")
    @Column(name = "PEOPLE_LOWER")
    private Integer peopleLower;

    @NotNull(message = "請輸入費用")
    @Min(value = 1, message = "費用0元!!!老闆會生氣")
    @Column(name = "COURSE_PRICE")
    private Integer coursePrice;

    @Column(name = "COURSE_STATE", insertable = false)
    private String courseState;

    @Min(value = 1, message = "0堂!!!會員會生氣")
    @NotNull(message = "請輸入堂數")
    @Column(name = "COURSE_NUMBER")
    private Integer courseNumber;

    @NotNull(message = "請輸入團課 ")
    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @NotNull(message = "請輸入報名開始日期")
    @Future(message = "別活在過去")
    @Column(name = "COURSE_ORDER_BE")
    private Date courseOrderBe;

    @NotNull(message = "請輸入報名截止日期")
    @Future(message = "別活在過去")
    @Column(name = "COURSE_ORDER_EN")
    private Date courseOrderEn;


    // 關聯多方(上課時段)
    // mappedBy = " " 為映射對象
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "period")
    @OrderBy("courseScheduleId asc")
    private Set<CourseSchedule> schedules = new HashSet<CourseSchedule>();

    // 關聯多方(團課訂單)
    // mappedBy = " " 為映射對象
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "period")
    @OrderBy("courseOrderId asc")
    private Set<CourseOrder> orders = new HashSet<CourseOrder>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Period period = (Period) o;
        return getPeriodId() != null && Objects.equals(getPeriodId(), period.getPeriodId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
