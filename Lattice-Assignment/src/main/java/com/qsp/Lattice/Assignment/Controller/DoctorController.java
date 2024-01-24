package com.qsp.Lattice.Assignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Lattice.Assignment.Service.DoctorService;
import com.qsp.Lattice.Assignment.dto.DoctorsDto;
import com.qsp.Lattice.Assignment.Utility.ResponseStructure; 
@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	
	@PostMapping("/add-doctor")
	public ResponseEntity<ResponseStructure<DoctorsDto>> addDoctor(@RequestBody DoctorsDto doctor)
	{
		return service.addDoctor(doctor);
	}
	@DeleteMapping("/delete-doctor/{id}")
	public ResponseEntity<ResponseStructure<DoctorsDto>> deleteDoctor(@PathVariable int id){
		return service.deleteDoctor(id);
	}
	

}
