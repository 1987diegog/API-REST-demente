package com.demente.apirest.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.demente.apirest.mapper.TeamDtoToEntity;
import com.demente.apirest.persistence.entity.Team;
import com.demente.apirest.persistence.entity.TeamStatus;
import com.demente.apirest.persistence.repository.TeamRepository;
import com.demente.apirest.service.dto.TeamInDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository repository;
    private final TeamDtoToEntity mapper;

    public Team createTeam(TeamInDTO teamInDTO) {
        Team team = mapper.map(teamInDTO);
        team.setCreatedAt(LocalDateTime.now());
        team.setStatus(TeamStatus.DISABLE);
        return repository.save(team);
    }

    public List<Team> findAll() {
        return repository.findAll();
    }

    public List<Team> findAllByStatus(TeamStatus status) {
        return repository.findAllByStatus(status);
    }

    @Transactional
    public void updateTeamStatus(Long id, TeamStatus status) {
        repository.updateStatus(id, status.name());
    }
}
