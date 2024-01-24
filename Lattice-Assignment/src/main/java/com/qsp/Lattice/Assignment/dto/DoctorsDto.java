package com.qsp.Lattice.Assignment.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Component
@Entity
@Data
public class DoctorsDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Min(value = 6000000000l)//
	@Max(value = 9999999999l)
	private long phone;
	@NotBlank(message = "Name can't be Blank")
	@NotNull(message = "Name Can't be Null")
    @Size(min = 3, message = "Name must have at least {min} characters")

	private String name;
	@NotBlank(message = "Address can't be Blank")
	@NotNull(message = "Address Can't be Null")
	private String city;
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Enter Proper Email")//give email condition
    @Size(max = 20, message = "email character is out of size")


	private String email;
	@NotBlank(message = "Speciality can't be Blank")
	@NotNull(message = "Speciality Can't be Null")
	private String speciality;

}
