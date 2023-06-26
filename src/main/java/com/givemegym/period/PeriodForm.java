package com.givemegym.period;

import com.givemegym.courseschedule.vo.CourseSchedule;
import com.givemegym.period.vo.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class PeriodForm {

    private Period period;

    private List<CourseSchedule> courseSchedules;

    public PeriodForm() {
        this.courseSchedules = new ArrayList<>(); // 添加这行代码进行初始化
    }

    public void addCourseSchedule(CourseSchedule courseSchedule) {
        this.courseSchedules.add(courseSchedule);
    }

}
