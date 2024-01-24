package com.qsp.Lattice.Assignment.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Lattice.Assignment.Exception.PetientNotFound;
import com.qsp.Lattice.Assignment.Utility.ResponseStructure; // Corrected import statement
import com.qsp.Lattice.Assignment.dao.DoctorDao;
import com.qsp.Lattice.Assignment.dto.DoctorsDto;
import com.qsp.Lattice.Assignment.dto.PatientsDto;

@Service
public class DoctorService {
    @Autowired
    private DoctorDao dao;

    public ResponseEntity<ResponseStructure<DoctorsDto>> addDoctor(DoctorsDto doctor) {
//    	if(doctor.getEmail().length()<=20||doctor.getName().length()<3||)
//    	{
//    		
//    	}
    	DoctorsDto  savee=doctor;
    	String specility=doctor.getSpeciality();
    	savee.setSpeciality(specility.toLowerCase());
            ResponseStructure<DoctorsDto> structure = new ResponseStructure<DoctorsDto>();
            structure.setMessage("User Save Successful");
            structure.setStatus(HttpStatus.ACCEPTED.value());
            structure.setData(dao.saveDoctor(savee));
            return new ResponseEntity<ResponseStructure<DoctorsDto>>(structure, HttpStatus.OK);
        } 
    
    public ResponseEntity<ResponseStructure<DoctorsDto>> deleteDoctor(int id){
    	ResponseStructure<DoctorsDto> structure = new ResponseStructure<>();//Doctors List
	    Optional<DoctorsDto> patientOptional = dao.findById(id);
	
	    		if (patientOptional.isEmpty()) {
	    			
	//		check the doctor 
	    			 structure.setMessage("Id  Present Please Correct Id");
	    		     structure.setStatus(HttpStatus.BAD_REQUEST.value());
	    		     structure.setData(null);
	    		        return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);

	    			
	    			} else {
	    				DoctorsDto d = patientOptional.get();
	    				dao.deleteAccount(d);

						 structure.setMessage("User Delete Successful");
					     structure.setStatus(HttpStatus.FOUND.value());
					     structure.setData(d);
					     return new ResponseEntity<ResponseStructure<DoctorsDto>>(structure, HttpStatus.FOUND);
	    	}
	    		
    } 
    
    
  
    
    
    }
    






