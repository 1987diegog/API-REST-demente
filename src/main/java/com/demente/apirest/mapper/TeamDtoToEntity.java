package com.demente.apirest.mapper;

import org.mapstruct.Mapper;
import com.demente.apirest.persistence.entity.Team;
import com.demente.apirest.service.dto.TeamInDTO;

@Mapper(componentModel = "spring")
public interface TeamDtoToEntity {
    Team map(TeamInDTO teamInDTO);
}
