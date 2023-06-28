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
	@Id
    private int accessId;
    private String accessName;

    public int getAccessId() {
        return this.accessId;
    }

    public void setAccessId(int accessId) {
        this.accessId = accessId;
    }

    public String getAccessName() {
        return this.accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }
}
