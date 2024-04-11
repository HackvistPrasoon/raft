package dev.project.raftbackend.Service;

import dev.project.raftbackend.model.Userdetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;


@Service
public class CookieService {

    private static UserService userService;
    @Autowired
    public CookieService(UserService userService) {
        this.userService = userService;
    }
    private static final String SECRET_KEY = "expensetrackerapikeyiniim12gjdfghgfvghjhbjnbnjnnkmjnkmfgbn";

    public String getCookieValue(HttpServletRequest request, String cookieName) {
        // Get the cookie from the request
        Cookie cookie = WebUtils.getCookie(request, cookieName);

        if (cookie == null) {
            throw new SecurityException("Token not found from cookies");
        }

        // Get the value from the cookie
        if(!isTokenExpired(cookie.getValue())) {
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String[] chunks = cookie.getValue().split("\\.");
            String payload = new String((decoder.decode(chunks[1])));
            JSONParser parser = new JSONParser();
            try {
                JSONObject json = (JSONObject) parser.parse(payload);
                return (String) json.get("email");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return "Failed";
    }

    public static boolean isTokenExpired(String token) {
        try {
            System.out.println(SECRET_KEY);
            // Parse the token
            SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            System.out.println(key);
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            System.out.println(claimsJws);
            // Get the expiration time from the token
            Date expiration = claimsJws.getBody().getExpiration();
            System.out.println(expiration);

            // Compare with the current time
            Instant now = Instant.now();
            Date current = Date.from(now);
            return expiration.before(current); // Token is expired if expiration time is before current time
        } catch (Exception e) {
            return true;
        }

    }
    public static ResponseEntity<Userdetails> getUserByEmail(String emailid) {
        System.out.println("This email ID has reached Entity Function "+emailid);
        Userdetails userDetails = userService.findUserByEmail(emailid);
        if (userDetails != null) {
            return ResponseEntity.ok().body(userDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
