package br.com.desafio.apipessoas.v1.adapter.repositories;

import br.com.desafio.apipessoas.v1.adapter.entities.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhoneEntityRepository extends JpaRepository<PhoneEntity, UUID> {

}
