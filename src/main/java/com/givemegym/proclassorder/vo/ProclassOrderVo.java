package com.givemegym.proclassorder.vo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.givemegym.proclass.vo.Proclass;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private Proclass proClass;
	//private Integer proClassId;
    

    @Column(name ="MEMBER_ID")
	private Integer memberId;

	@Column(name = "PROCLASS_ATTEND")
	private Boolean proClassAttend;

	@Column(name = "PROCLASS_TIME")
	private Integer proClassTime;

	@Column(name = "PROCLASS_DATE")
	private Date proClassDate;

	@JoinColumn(name = "COACH_ID")
	private Integer coachId;

	@Column(name = "PROCLASSORDER_STATE")
	private Integer proClassOrderState;

	@Column(name = "PROCLASSORDER_DATE")
	private Date proClassOrderDate;
	
//
//	public String getProClassTime() {
//	    if (proClassTime==0) {
//        return "早上";
//	    } else if (proClassTime==1) {
//	        return "中午";
//	    } else if (proClassTime==2) {
//	        return "晚上";
//    } else {
//	        return "未知";
//	    }
//	}
	 public String getProClassName() {
	        if (proClass != null) {
	            return proClass.getProclassName();
	        } else {
	            return "未知";
	        }
	    }
}
