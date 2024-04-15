package dev.project.raftbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class TabMapping {
	@Id
	private String emailId;
	private String tab1;
	private String tab2;
	private String tab3;
	private String tab4;
	private String tab5;
	private String tab6;
}
