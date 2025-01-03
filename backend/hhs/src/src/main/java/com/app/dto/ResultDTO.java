package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {

	private String status;
	private int otp;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "ResultDTO [status=" + status + ", otp=" + otp + "]";
	}
	
}
