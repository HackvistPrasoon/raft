
package dev.project.raftbackend.Controller;

import dev.project.raftbackend.Service.MailService;
import dev.project.raftbackend.Repo.UserdetailsRepo;
import dev.project.raftbackend.model.Userdetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Date;

@RestController
public class UserdetailsController {

    @Autowired
    UserdetailsRepo repo;
    @Autowired
    private MailService mailService;
    @CrossOrigin(origins = "*")
    @PostMapping("/createuser")
    public String createUser(@RequestBody Userdetails userdetails) {
        System.out.println(userdetails);
        long timestamp = System.currentTimeMillis();
        String secretkey = "expensetrackerapikeyiniim12gjdfghgfvghjhbjnbnjnnkmjnkmfgbn";
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, secretkey.getBytes())
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + 86400000))
                .claim("email", userdetails.getEmailid())
                .compact();
        SecretKey key = Keys.hmacShaKeyFor(secretkey.getBytes());
        System.out.println(key);

        try {
            String clickableLink = "http://localhost:8080/login/" + token;

            mailService.sendMail(userdetails.getEmailid(), "Your Verification Link", clickableLink);
            System.out.println("Mail Sent Successfully!");

        }
        catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
            return "Error";
        }
        return "Login link has been sent your email account successfully";

    }


}