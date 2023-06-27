package com.givemegym.proclassorder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.givemegym.proclassorder.vo.ProclassOrderVo;
@Repository
public interface ProclassOrderDao extends JpaRepository<ProclassOrderVo, Integer> {
	
	@Query("SELECT cd FROM ProclassOrderVo cd  WHERE cd.memberId = :memberId")
	List<ProclassOrderVo> findByMemberId(@Param("memberId") Integer memberId);
	

@Query(value = "INSERT INTO ProclassOrderVo (proclassOrder) VALUES (:proclassOrder)", nativeQuery = true)
   void addProclassOrder(@Param("proclassOrder") ProclassOrderVo proclassOrder);

//	 @Query(value = "DELETE FROM ProclassOrderVo WHERE proClassOrderId = :proClassOrderId", nativeQuery = true)
//	   void cancelProclassOrder(@Param("proClassOrderId") Integer proClassOrderId);


	@Query("SELECT cd FROM ProclassOrderVo cd WHERE cd.coachId = :coachId")
	List<ProclassOrderVo> findByCoachId(@Param("coachId") Integer coachId);
	
//@Query(value = "SELECT * FROM ProclassOrder WHERE coach_Id = :coachId", nativeQuery = true)
//	List<Object[]> findByCoachId(@Param("coachId") Integer coachId);
	
}
