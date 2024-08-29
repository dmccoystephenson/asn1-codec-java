package com.test.asn1codecjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
public class Asn1CodecJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Asn1CodecJavaApplication.class, args);
	}

	// expose endpoint that receives string, passes it through codec and returns the result
	@RequestMapping("/decode")
	public String decode(@RequestParam(required = true) String encodedHex) {
		var toReturn = "";
		try {
			Asn1CodecWrapper Asn1CodecWrapperInstance = new Asn1CodecWrapper();
			var decoded = Asn1CodecWrapperInstance.decode(encodedHex);
			toReturn = decoded;
		} catch (Exception e) {
			toReturn = "Error: " + e.getMessage();
		}
		return toReturn;
	}

}
