package com.atli.ws.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.atli.ws.shared.GenericResponse;


@RestController
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/api/0.0.1/auth")
	AuthResponse handleAuthentication(@RequestBody Credentials credentials){
		return authService.authenticate(credentials);
	}
	
	@PostMapping("/api/0.0.1/logout")
	GenericResponse handleLogout(@RequestHeader(name = "Authorization") String authorization){
		String token = authorization.substring(7); //Bearer'ı çıkardık
		authService.clearToken(token);
		return new GenericResponse("Logout Success");
		
	}

}
