package com.givemegym.access.vo;

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
@Table(name = "ACCESS")
public class Access {

	@Override
	public String toString() {
		return "Access [accessId=" + accessId + ", accessName=" + accessName + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accessId;
	public int getAccessId() {
		return this.accessId;
	}

	public void setAccessId(int accessId) {
		this.accessId = accessId;
	}

	private String accessName;
	
	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}
}
