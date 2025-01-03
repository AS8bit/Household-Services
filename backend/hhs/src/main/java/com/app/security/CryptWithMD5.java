package com.app.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CryptWithMD5 {
	   private static MessageDigest md; 
	   // md class provides applications the functionality of amessage digest algorithm, 
	   //Message digests are secure one-way hash functions 
	   //that take arbitrary-sizeddata and output a fixed-length hash value.

	   public static String cryptWithMD5(String pass){
	    try {
	        md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0x02 & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
	    }
	        return null;


	   }
	}