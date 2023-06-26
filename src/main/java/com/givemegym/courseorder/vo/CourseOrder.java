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
@Table(name = "proclassorder",schema = "no7")
public class CourseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROCLASSORDER_ID")
    private Integer courseOrderId;

    @Column(name = "PROCLASS_ID")
    private Date courseOrderDate;

    @Column(name = "MEMBER_ID")
    private String courseOrderState;

    @Column(name = "PROCLASS_ATTEND")
    private Integer courseOrderTotalPrice;

    @ManyToOne()
    @JoinColumn(name ="PROCLASS_TIME")
    private Period period;

//    @ManyToOne()
//    @JoinColumn(name = "MEMBER_ID")
//    private MemberVO memberVO;

}
