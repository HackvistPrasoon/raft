package dev.project.raftbackend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "userdetails")
public class Userdetails {

    @Getter
    @Setter
    @Id
    private String emailid;



    private String first_name;
    private String last_name;
    private Long river_id;
    private Integer outside_my_bubble;
    private String omb_first_name;
    private String omb_last_name;
    private String omb_emailid;
    private Long ethnic_id;
    private Long gender_id;
    private Long employment_id;
    private Long education_id;
    private Long age_id;
    private String conservative;
    private String maga;
    private String libertarian;
    private String moderate;
    private String liberal;
    private String progressive;
    private String socialist;
    private String democrat;
    private String republican;
    private String liberatarian_political_party;
    private String green;
    private String independent;
    private String none;
    private String text_box1;
    private String text_box2;
    private String resedential_detail;

    private LocalDateTime createdAt;


};
