package com.app.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.EmailDTO;
import com.app.dto.EmailResponseDTO;
import com.app.dto.ResultDTO;
import com.app.pojos.Customer;
import com.app.service.EmailService;
import com.app.service.ICustomerServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/forgot")
public class ForgotController {
   Random random=new Random(1000);
	
	@Autowired
	private EmailService emailservice;
	
	@Autowired
	private ICustomerServiceImpl custService;
	
	@PostMapping("/sendotp")
	public ResultDTO Signup(@RequestBody EmailDTO req) {	
		ResultDTO resultdto=null;
		String result="";
		
		System.out.println("EMAIL"+req.getEmail());
		
		Customer validuser=custService.checkEmail(req.getEmail());
		if(validuser!=null) {
			System.out.println("User Exists");
			
			int otp=random.nextInt(999999);
			String subject ="OTP from HouseHoldServices";
			String message="OTP = "+otp+" ";
			String to=req.getEmail();
			boolean flag=this.emailservice.sendEmail(subject, message, to);		
			if(flag) {
				resultdto=new ResultDTO("success",otp);
			}else {
				resultdto=new ResultDTO("failure",otp);
			}
		}else{
			System.out.println("Not a valid user ");
		}
				 
		return resultdto;
	}
	
	
	@PostMapping("/resetPassword")
	public ResponseEntity<?> resetPassword(@RequestBody Customer cust){
		System.out.println(cust.toString());
		System.out.println("inside password reset");
		System.out.println(cust.getEmail());
		System.out.println(cust.getPassword());
		Customer validuser=custService.checkEmail(cust.getEmail());
		System.out.println(validuser);
		Customer persistentUser=custService.restPass(validuser,cust.getPassword());
		if(persistentUser!=null) {
			System.out.println("successfully changed the password");
			return EmailResponseDTO.success("Password changed sucessfully");
		}else {
			return EmailResponseDTO.error("Password Not changed");
		}
		
	}
}
