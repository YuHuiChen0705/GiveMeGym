package com.givemegym.coach_B.vo;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
@Entity
@Table(name = "coach", schema = "no7")
public class Coach implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COACH_ID")
    private Integer coachId;

    @Column(name = "COACH_NAME")
    private String coachName;

    @Column(name = "COACH_DETAIL")
    private String coachDetail;

    @Column(name = "COACH_PIC")
    private String coachPic;

    @Column(name = "COACH_GENDER")
    private String coachGender;

}

