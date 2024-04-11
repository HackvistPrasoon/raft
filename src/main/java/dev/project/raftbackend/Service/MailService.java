package dev.project.raftbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
@Service
public class MailService {

        @Autowired
        private JavaMailSender mailSender;

        @Value("${spring.mail.username}")
        private String fromMail;

        public void sendMail(String mail, String subject, String message) {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(fromMail);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);
            simpleMailMessage.setTo(mail);

            mailSender.send(simpleMailMessage);
        }

    }


