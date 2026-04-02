package com.boffa.project.repository;

import com.boffa.project.entity.PlayerEntity;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@NullMarked
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {

    List<PlayerEntity> findAll();

    Optional<PlayerEntity> findById(Integer id);

    Optional<PlayerEntity> findByUserName(String userName);
}
