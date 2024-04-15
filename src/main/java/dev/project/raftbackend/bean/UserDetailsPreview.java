package dev.project.raftbackend.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDetailsPreview {
		
	private String emailid;
    private String first_name;
    private String last_name;
    private String river_states;
    private String river;
    private String river_section;
    private String river_outfitter;
    private String river_level;
    private LocalDate river_date;
    private String outside_my_bubble;
    private String omb_first_name;
    private String omb_last_name;
    private String omb_emailid;
    private String ethnicType;
    private String gender;
    private String location;
    private String educationType;
    private String ageGroup;
    private String conservative;
    private String maga;
    private String libertarian;
    private String moderate;
    private String liberal;
    private String progressive;
    private String socialist;
    private String apolitical;
    private String democrat;
    private String republican;
    private String liberatarian_political_party;
    private String green;
    private String independent;
    private String other;
    private String text_box1;
    private String text_box2;
    private String resedential_detail;
    private LocalDateTime createdAt;
    private String token;
    private Long radio_feel;
    private Long radio_comfort;
    private Long radio_pov;
    private Long radio_prespective;
}
