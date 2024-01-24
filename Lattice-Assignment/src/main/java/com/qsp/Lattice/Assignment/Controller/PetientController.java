package com.qsp.Lattice.Assignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Lattice.Assignment.Service.PetientService;
import com.qsp.Lattice.Assignment.Utility.ResponseStructure;
import com.qsp.Lattice.Assignment.dto.DoctorsDto;
import com.qsp.Lattice.Assignment.dto.PatientsDto;

@RestController
public class PetientController {
	@Autowired
	private PetientService service;
	
	@PostMapping("/add-patient")
	public ResponseEntity<ResponseStructure<PatientsDto>> addPetient(@RequestBody PatientsDto patient)
	{
		return service.addPatient(patient);
	}
	@GetMapping("/suggested/{id}")
	public ResponseEntity<ResponseStructure<List<DoctorsDto>>> suggested( @PathVariable int id)
	{
		return service.Suggesting(id);
	}
	
	@DeleteMapping("/delete-petient/{id}")
	public ResponseEntity<ResponseStructure<PatientsDto>> deletePetient(@PathVariable int id){
		return service.deletePetient(id);
	}
	


}
