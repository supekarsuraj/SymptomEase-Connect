package com.qsp.Lattice.Assignment.ripository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Lattice.Assignment.dto.DoctorsDto;
import com.qsp.Lattice.Assignment.dto.PatientsDto;

public interface PetientRipository extends JpaRepository<PatientsDto,Integer>{
	PatientsDto findPatientsDtoByPhone(long phone);
	


}
