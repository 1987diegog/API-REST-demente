package com.demente.apirest.controller;

import java.net.http.HttpResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.demente.apirest.persistence.entity.Team;
import com.demente.apirest.persistence.entity.TeamStatus;
import com.demente.apirest.service.TeamService;
import com.demente.apirest.service.dto.TeamInDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("v1/teams")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public Team createTeam(@RequestBody TeamInDTO teamInDTO) {
        return teamService.createTeam(teamInDTO);
    }

    @GetMapping
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Team> findAllByStatus(@PathVariable("status") TeamStatus status) {
        return teamService.findAllByStatus(status);
    }

    @PatchMapping("/update/{id}/{status}")
    public ResponseEntity<Void> updateStatus(@PathVariable("id") Long id, @PathVariable("status") TeamStatus status) {
        teamService.updateTeamStatus(id, status);
        return ResponseEntity.noContent().build();
    }
}
