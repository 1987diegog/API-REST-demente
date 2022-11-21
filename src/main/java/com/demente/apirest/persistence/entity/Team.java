package com.demente.apirest.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String league;
    private String colours;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private TeamStatus status;
}
