package com.givemegym.courseorder.dao;

import com.givemegym.courseorder.vo.CourseOrder;
import com.givemegym.member_B.vo.Member;
import com.givemegym.period.vo.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseOrderDao extends JpaRepository<CourseOrder, Integer> {

    // 查看報名該時段的訂單數量
    List<CourseOrder> findCourseOrderByPeriod(Period Period);

    // 根據報名時段更新訂單狀態為'已取消'
    @Modifying
    @Query("UPDATE CourseOrder p SET p.courseOrderState = '已取消' WHERE p.period = :period")
    void updateCourseOrderStateToOffByPeriod(Period period);

    // 根據報名時段更新訂單狀態為'已成立'
    @Modifying
    @Query("UPDATE CourseOrder p SET p.courseOrderState = '已成立' WHERE p.period = :period")
    void updateCourseOrderStateToOnByPeriod(Period period);

    @Query("SELECT co FROM CourseOrder co WHERE co.member.memberId = :memberId")
    List<CourseOrder> findByMemberId(@Param("memberId") Integer memberId);

    List<CourseOrder> findByCourseOrderStateAndMember(String CourseOrderState, Member member);

    Set<CourseOrder> findByCourseOrderStateAndPeriod(String courseOrderState,Period period);


}
