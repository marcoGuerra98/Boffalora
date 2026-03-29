package com.boffa.project.repository;

import com.boffa.project.entity.RoleEntity;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NullMarked
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    List<RoleEntity> findAll();

    RoleEntity findByValore(String valore);

    RoleEntity findById(int id);
}
