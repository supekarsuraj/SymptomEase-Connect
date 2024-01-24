package com.qsp.Lattice.Assignment.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.Lattice.Assignment.Exception.DoctorNotFound;
import com.qsp.Lattice.Assignment.Exception.PetientNotFound;
import com.qsp.Lattice.Assignment.Utility.ResponseStructure;
import com.qsp.Lattice.Assignment.dao.DoctorDao;
import com.qsp.Lattice.Assignment.dao.PetientDao;
import com.qsp.Lattice.Assignment.dto.DoctorsDto;
import com.qsp.Lattice.Assignment.dto.PatientsDto;

@Service
public class PetientService {

    @Autowired
    private PetientDao dao;

    @Autowired
    private DoctorDao ddao;

    public ResponseEntity<ResponseStructure<PatientsDto>> addPatient(PatientsDto patient) {//here i write code for add patient
		    	PatientsDto  savee=patient;
		    	String city=patient.getCity().toLowerCase();//because user can store any type location 
		    	savee.setCity(city);
		    	savee.setSymptom(patient.getSymptom().toLowerCase());//because user can store any type ex tissue injuries,Tissue Injuries,TISSUEINJURIES
		        ResponseStructure<PatientsDto> structure = new ResponseStructure<>();
		        structure.setMessage("User Sign Up Successful");
		        structure.setStatus(HttpStatus.OK.value());
		        structure.setData(dao.savePatient(savee));
		        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
    

    public ResponseEntity<ResponseStructure<List<DoctorsDto>>> Suggesting(int id) {
        ResponseStructure<List<DoctorsDto>> structure = new ResponseStructure<>();
        Optional<PatientsDto> patientOptional = dao.findById(id);

        if (patientOptional.isEmpty()) {
        	 structure.setMessage("Id Not Present Please Correct Id");
		     structure.setStatus(HttpStatus.BAD_REQUEST.value());
		     structure.setData(null);
		     return new ResponseEntity<ResponseStructure<List<DoctorsDto>>>(structure, HttpStatus.FOUND);
//           throw new PetientNotFound("Patient Not Found. Please input the correct id");
        }

        PatientsDto patient = patientOptional.get();
        List<String> symptoms = List.of("arthritis", "back pain", "tissue injuries");
        List<String> cities = List.of("delhi", "noida", "faridabad");

        if (!cities.contains(patient.getCity())) {
            structure.setMessage("We are still waiting to expand to your location");
            structure.setStatus(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
        }

        List<DoctorsDto> doctorsList = Collections.emptyList();
        String speciality = "";

        if (List.of("dysmenorrhea").contains(patient.getSymptom())) {
            speciality = "gynecology speciality";
        } else if (symptoms.contains(patient.getSymptom())) {
            speciality = "orthopedic specialist";
        } else if (List.of("skininfection", "skinburn").contains(patient.getSymptom())) {
            speciality = "dermatology speciality";
        } else if (List.of("ear pain", "eye pain").contains(patient.getSymptom())) {
            speciality = "entspeciality";
        }

        doctorsList = ddao.findBySpecialityAndCity(speciality, patient.getCity());

        if (doctorsList.isEmpty()) {
            structure.setMessage("There isn’t any doctor present at your location for your symptom");
            structure.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            structure.setMessage("Doctors for your Symptom");
            structure.setStatus(HttpStatus.OK.value());
        }

        structure.setData(doctorsList);
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

	
	
	
	 public ResponseEntity<ResponseStructure<PatientsDto>> deletePetient(int id){
	    	ResponseStructure<PatientsDto> structure = new ResponseStructure<>();//PatientsDto List
		    Optional<PatientsDto> patientOptional = dao.findById(id);
		
		    		if (patientOptional.isEmpty()) {
		    			 structure.setMessage("Id Not Present Please Correct Id");
		    		     structure.setStatus(HttpStatus.BAD_REQUEST.value());
		    		     structure.setData(null);
		    		        return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);

//		    		     return new ResponseEntity<ResponseStructure<DoctorsDto>>(structure, HttpStatus.FOUND);
		//		check the doctor 
//		    				throw new PetientNotFound("Doctor Not Found. Please input correct id");//if we input wrong id
		    			} else {
		    				PatientsDto d = patientOptional.get();
		    				dao.deleteAccount(d);

							 structure.setMessage("User Delete Successful");
						     structure.setStatus(HttpStatus.FOUND.value());
						     structure.setData(d);
						     
						     return new ResponseEntity<ResponseStructure<PatientsDto>>(structure, HttpStatus.FOUND);
						//	return dao.deleteAccount(id);
		    	}
		    		
	    } 
	
	
	
			}
			    
			    
			
  




