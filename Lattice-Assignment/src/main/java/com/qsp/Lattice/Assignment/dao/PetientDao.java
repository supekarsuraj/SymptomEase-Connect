package com.qsp.Lattice.Assignment.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Lattice.Assignment.dto.DoctorsDto;
import com.qsp.Lattice.Assignment.dto.PatientsDto;
import com.qsp.Lattice.Assignment.ripository.DoctorRipo;
import com.qsp.Lattice.Assignment.ripository.PetientRipository;

@Repository
public class PetientDao {
	@Autowired
	 private PetientRipository ripo;
	
	
	public PatientsDto findByPhone(long phone)
	{
		return ripo.findPatientsDtoByPhone(phone);
	}
	public PatientsDto saveDoctor(PatientsDto petient)
	{
		return ripo.save(petient);
	}
	
	public PatientsDto savePatient(PatientsDto petient)
	{
		return ripo.save(petient);
	}
	public Optional<PatientsDto> findById(int id)
	{
		return ripo.findById(id);
	}
	
	public  void deleteAccount(PatientsDto p)
	{
		ripo.delete(p);
	}
	
	

}
