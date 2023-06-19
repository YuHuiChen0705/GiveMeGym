package com.givemegym.courseorder.vo;

//import com.givemegym.member.MemberVO;
import com.givemegym.period.vo.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "COURSE_ORDER")
public class CourseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ORDER_ID")
    private Integer courseOrderId;

    @Column(name = "COURSE_ORDER_DATE")
    private Date courseOrderDate;

    @Column(name = "COURSE_ORDER_STATE")
    private String courseOrderState;

    @Column(name = "COURSE_ORDER_TOTAL_PRICE")
    private Integer courseOrderTotalPrice;

    @ManyToOne()
    @JoinColumn(name = "PERIOD_ID")
    private Period period;

//    @ManyToOne()
//    @JoinColumn(name = "MEMBER_ID")
//    private MemberVO memberVO;

}
