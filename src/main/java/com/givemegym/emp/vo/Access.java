package com.givemegym.emp.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "access", schema = "no7")
public class Access {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCESS_ID")
	private int accessId;
	
	@Column(name = "ACCESS_NAME")
    private String accessName;
	
	@ManyToOne
    @JoinColumn(name = "ACCESS_ID")
    private Access access;


}
