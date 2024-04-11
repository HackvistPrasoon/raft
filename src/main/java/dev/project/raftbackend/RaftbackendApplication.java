package dev.project.raftbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class RaftbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaftbackendApplication.class, args);
	}


	}
	


