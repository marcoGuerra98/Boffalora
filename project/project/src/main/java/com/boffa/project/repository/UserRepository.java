package com.boffa.project.repository;

import com.boffa.project.entity.UserEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUserName(String nomeUtente);

    @Override
    @NonNull
    List<UserEntity> findAll();
}
