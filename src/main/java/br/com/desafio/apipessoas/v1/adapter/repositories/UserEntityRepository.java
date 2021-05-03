package br.com.desafio.apipessoas.v1.adapter.repositories;

import br.com.desafio.apipessoas.v1.adapter.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);

}
