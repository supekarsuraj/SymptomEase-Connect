package com.qsp.Lattice.Assignment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.qsp.Lattice.Assignment.dto.DoctorsDto;
import com.qsp.Lattice.Assignment.ripository.DoctorRipo;

@Repository
public class DoctorDao {
	
	@Autowired
	 private DoctorRipo ripo;
	
	
	public DoctorsDto findByPhone(long phone)
	{
		return ripo.findDoctorsDtoByPhone(phone);
	}
	public DoctorsDto saveDoctor(DoctorsDto doctor)
	{
		return ripo.save(doctor);
	}
	public List<DoctorsDto> findBySpecialityAndCity(String speciality,String city)
	{
		return ripo.findByDoctorsDtoSpecialityAndCity(speciality,city);
	}
	public Optional<DoctorsDto> findById(int id) {
		return ripo.findById(id);
	}
	public  void deleteAccount(DoctorsDto d)
	{
		ripo.delete(d);
	}
	

}
