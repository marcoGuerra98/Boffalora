package com.boffa.project.repository;

import com.boffa.project.entity.SquadraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadraRepository extends JpaRepository<SquadraEntity, Integer> {
     SquadraEntity findByName(String name);

     String findNameByName(String name);
}
