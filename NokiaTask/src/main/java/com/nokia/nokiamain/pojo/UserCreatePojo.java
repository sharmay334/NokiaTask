package com.nokia.nokiamain.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserCreatePojo {

	@NotNull(message = "Id cannot be missing or empty")
	private Long id;
	@NotNull(message = "Name cannot be missing or empty")
	@Size(min = 3,max=150 ,message = "Name must be between 3 to 150 character")
	@Pattern(regexp="[\\w ]*",message = "Name must be alphanumeric")
	private String name;
	@NotNull(message = "Phone cannot be missing or empty")
	@Size(min = 9,max=12 ,message = "Phone must be between 9 to 12 character")
	@Pattern(regexp = "[\\d]*",message = "Please provide valid phone number")
	private String phone;
	@NotNull(message = "Email cannot be missing or empty")
	@Email(message="Enter a valid email address")
	private String email;
	private String address;
	@NotNull(message = "Country cannot be missing or empty")
	@Size(max=56 ,message = "Country max length should be 56 character")
	private String country;
	@NotNull(message = "Department cannot be missing or empty")
	@Size(max=50 ,message = "Department max length should be 50 character")
	private String department;
	
}
