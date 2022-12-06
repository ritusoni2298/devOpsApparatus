package com.brudite.devops.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "candidates")
@Getter
@Setter
public class Candidate extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false)
    String college;

    @Column(nullable = false)
    private String year;

    @Column(name = "stage_status_code")
    private Integer stageStatusCode;

    @Column
    private Boolean taskCompleted;

    public Candidate(String username, String name, String college, String year, Integer stageStatusCode) {
        this.username = username;
        this.name = name;
        this.college = college;
        this.year = year;
        this.stageStatusCode = stageStatusCode;
    }
}
