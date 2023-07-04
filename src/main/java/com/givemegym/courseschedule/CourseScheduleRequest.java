package com.givemegym.courseschedule;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CourseScheduleRequest {

    private List<CourseScheduleItem> courseSchedule;


}

