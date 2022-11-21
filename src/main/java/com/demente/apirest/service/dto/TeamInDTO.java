package com.demente.apirest.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class TeamInDTO {
    private String name;
    private String league;
    private String colours;
}
