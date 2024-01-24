package com.qsp.Lattice.Assignment.ripository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.qsp.Lattice.Assignment.Utility.ResponseStructure;
import com.qsp.Lattice.Assignment.dto.DoctorsDto;

public interface DoctorRipo extends JpaRepository<DoctorsDto, Integer> {
	  DoctorsDto findDoctorsDtoByPhone(long phone);
	  List<DoctorsDto> findDoctorsDtoByspeciality(String speciality);
	 	  
	  
	  @Query("SELECT e FROM DoctorsDto e WHERE e.speciality = :speciality AND e.city = :city")
	  List<DoctorsDto> findByDoctorsDtoSpecialityAndCity(@Param("speciality") String speciality, @Param("city") String city);


//		List<Tasks>   getTasksByTaskName(@Param("speciality") String taskName);
	  

}

