package dev.project.raftbackend.model;

import java.time.LocalDateTime;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "riverslist")
public class Riverslist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String states;
    private String river;
    private String river_section;
    private String outfitter;
    private String level;
    private LocalDate date;

    private LocalDateTime createdAt;
};
