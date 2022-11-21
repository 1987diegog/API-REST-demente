package com.demente.apirest.persistence.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.demente.apirest.persistence.entity.Team;
import com.demente.apirest.persistence.entity.TeamStatus;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findAllByStatus(TeamStatus status);

    @Modifying
    @Query(value = "UPDATE TEAM SET STATUS=:status WHERE ID=:id", nativeQuery = true)
    void updateStatus(@Param("id") Long id, @Param("status") String status);
}
