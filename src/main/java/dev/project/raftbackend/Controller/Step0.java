package dev.project.raftbackend.Controller;

import dev.project.raftbackend.Service.UserService;
import dev.project.raftbackend.bean.ResponseData;
import dev.project.raftbackend.Repo.TabMappingRepo;
import dev.project.raftbackend.Repo.UserdetailsRepo;
import dev.project.raftbackend.Service.CookieService;
import dev.project.raftbackend.model.TabMapping;
import dev.project.raftbackend.model.Userdetails;

import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import jakarta.servlet.http.Cookie;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Base64;

import static dev.project.raftbackend.Service.CookieService.isTokenExpired;
import static dev.project.raftbackend.Service.CookieService.getUserByEmail;

@RestController
public class Step0 {
	// @Autowired
	private Userdetails userDetails;
	private UserService userService;
	@Autowired
	private CookieService cookieservice;
	
	@Autowired
    TabMappingRepo mappingRepo;
	
	@Autowired
	UserdetailsRepo userdetailsRepo;

	@CrossOrigin(origins = "*")
	@GetMapping("/login/{token}")
	public Object firstserve(@PathVariable("token") String token, HttpServletResponse response) throws IOException {
		String[] chunks = token.split("\\.");
		if (isTokenExpired(token)) {
			ErrorResponse errorResponse = new ErrorResponse("Token has either Expired or does not exist",
					HttpStatus.BAD_REQUEST);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

		Base64.Decoder decoder = Base64.getUrlDecoder();

		String payload = new String((decoder.decode(chunks[1])));
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(payload);
			String email = (String) json.get("email");
			System.out.println(email);
			System.out.println(getUserByEmail(email));
			Cookie cookie = new Cookie("token", token);

			// Set the cookie's properties
			cookie.setHttpOnly(true);
			cookie.setSecure(false); // Set this to true if you're using HTTPS
			cookie.setMaxAge(24 * 60 * 60);
			response.addCookie(cookie);
			// String redirectUrl =
			// "https://raftapp.azurewebsites.net/step-1.html?token="+token;
			
			ResponseData responseData = new ResponseData();
			
			//String mini_url = "http://localhost:8080/";
			String mini_url = "https://raftapp.azurewebsites.net/";
			
			String redirectUrl = null;
			
			 TabMapping tabs = mappingRepo.findByEmailId(email);
			 
			 System.out.println(tabs);
			 
//			 if(tabs.getTab5() != null && tabs.getTab5().equalsIgnoreCase("true")) {
			 if (tabs != null && tabs.getTab5() != null && tabs.getTab5().equalsIgnoreCase("true")) {

				// String redirectUrl =
					// "https://raftapp.azurewebsites.net/preview-page?token="+token;
				 redirectUrl = mini_url+"preview-page.html?token=" + token;
					response.sendRedirect(redirectUrl);
			 } else
//				 if (tabs.getTab4() != null && tabs.getTab4().equalsIgnoreCase("true")) {
				 if (tabs != null && tabs.getTab4() != null && tabs.getTab4().equalsIgnoreCase("true")) {

				// String redirectUrl =
					// "https://raftapp.azurewebsites.net/step-5.html?token="+token;
				  redirectUrl =  mini_url+"step-5.html?token=" + token;
					response.sendRedirect(redirectUrl);
			 } else
//				 if (tabs.getTab3() != null && tabs.getTab3().equalsIgnoreCase("true")) {
				 if (tabs != null && tabs.getTab3() != null && tabs.getTab3().equalsIgnoreCase("true")) {

				// String redirectUrl =
					// "https://raftapp.azurewebsites.net/step-4.html?token="+token;
				  redirectUrl =  mini_url+"step-4.html?token=" + token;
					response.sendRedirect(redirectUrl);
			 } else 
//				 if (tabs.getTab2() != null && tabs.getTab2().equalsIgnoreCase("true")) {
				 if (tabs != null && tabs.getTab2() != null && tabs.getTab2().equalsIgnoreCase("true")) {

				// String redirectUrl =
					// "https://raftapp.azurewebsites.net/step-3.html?token="+token;
				  redirectUrl =  mini_url+"step-3.html?token=" + token;
					response.sendRedirect(redirectUrl);
			 } else 
//				 if (tabs.getTab1() != null && tabs.getTab1().equalsIgnoreCase("true")) {
				 if (tabs != null && tabs.getTab1() != null && tabs.getTab1().equalsIgnoreCase("true")) {

				// String redirectUrl =
					// "https://raftapp.azurewebsites.net/step-2.html?token="+token;
				  redirectUrl =  mini_url+"step-2.html?token=" + token;
					response.sendRedirect(redirectUrl);
			 } else {
				// String redirectUrl =
					// "https://raftapp.azurewebsites.net/step-1.html?token="+token;
				  redirectUrl =  mini_url+"step-1.html?token=" + token;
					response.sendRedirect(redirectUrl);
			 }
			
			
			// return response;

			return ResponseEntity.ok().body(redirectUrl);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}

}

class ErrorResponse {
	private final String message;
	private final HttpStatus status;

	public ErrorResponse(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}
}