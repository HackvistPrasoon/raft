package dev.project.raftbackend.Controller;


import dev.project.raftbackend.Service.UserService;
import dev.project.raftbackend.Service.CookieService;
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


import java.util.Base64;

import static dev.project.raftbackend.Service.CookieService.isTokenExpired;
import static dev.project.raftbackend.Service.CookieService.getUserByEmail;


@RestController
public class Step0 {
    //@Autowired
    private Userdetails userDetails;
    private UserService userService;
    @Autowired
    private CookieService cookieservice;


    @CrossOrigin(origins = "*")
    @GetMapping("/login/{token}")
    public Object firstserve(@PathVariable("token") String token, HttpServletResponse response){
        String[] chunks = token.split("\\.");
        if(isTokenExpired(token)){
            ErrorResponse errorResponse = new ErrorResponse("Token has either Expired or does not exist", HttpStatus.BAD_REQUEST);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String payload = new String((decoder.decode(chunks[1])));
        JSONParser parser = new JSONParser();
        try{
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
            return cookie;


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