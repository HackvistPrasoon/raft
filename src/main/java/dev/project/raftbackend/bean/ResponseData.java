package dev.project.raftbackend.bean;

import lombok.Data;

@Data
public class ResponseData {
	
	 private String status;
	 private String token;
	 private String url;
	 private UserDetailsPreview udp;

}
