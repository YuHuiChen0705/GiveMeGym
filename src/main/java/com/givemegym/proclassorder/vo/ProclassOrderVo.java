package com.givemegym.proclassorder.vo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "PROCLASSORDER", schema = "no7")
public class ProclassOrderVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROCLASSORDER_ID")
    private Integer proClassOrderId;

    @JoinColumn(name = "PROCLASS_ID", referencedColumnName = "PROCLASS_ID")
    private Integer proClassId;

    @Column(name ="MEMBER_ID")
    private Integer memberId;
	    
	    @Column(name = "PROCLASS_ATTEND")
	    private Date proClassAttend;
	    
	    @Column(name = "PROCLASS_TIME")
	    private Date proClassTime;
	    
	    @Column(name = "PROCLASS_DATE")
	    private Date proClassDate;
	    
	    @Column(name = "COACH_ID")
	    private Date coachId;
	    
	    @Column(name = "PROCLASSORDER_STATE")
	    private Date proClassOrderState;
	    
	    @Column(name = "PROCLASSORDER_DATE")
	    private Date proClassOrderDate;

}
