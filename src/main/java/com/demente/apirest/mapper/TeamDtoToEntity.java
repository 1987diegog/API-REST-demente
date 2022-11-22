package com.demente.apirest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.demente.apirest.persistence.entity.Team;
import com.demente.apirest.service.dto.TeamInDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamDtoToEntity {
    Team map(TeamInDTO teamInDTO);
}
