package br.com.desafio.apipessoas.v1.core.mock;

import br.com.desafio.apipessoas.v1.adapter.entities.PhoneEntity;
import br.com.desafio.apipessoas.v1.adapter.entities.UserEntity;
import br.com.desafio.apipessoas.v1.core.model.PhoneModel;
import br.com.desafio.apipessoas.v1.core.model.UserModel;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

public class MockBuilder {

    private static MockBuilder uniqueInstance;

    private MockBuilder() { }

    public static synchronized MockBuilder getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new MockBuilder();
        }

        return uniqueInstance;
    }

    public UserModel userModel() {
        return UserModel.builder()
                .id(UUID.randomUUID())
                .name("Usuário de teste")
                .password("123456")
                .email("user.email.com.br")
                .phones(new HashSet<>(Collections.singletonList(phoneModel())))
                .created(LocalDateTime.now())
                .modified(LocalDateTime.now())
                .lastLogin(LocalDateTime.now())
                .token("token")
                .build();
    }

    public UserEntity userEntity() {
        return UserEntity.builder()
                .name("Usuário de teste")
                .password("123456")
                .email("user.email.com.br")
                .phones(new HashSet<>(Collections.singletonList(phoneEntity())))
                .build();
    }

    public PhoneEntity phoneEntity() {
        return PhoneEntity.builder()
                .ddd(87L)
                .number(87996421975L)
                .build();
    }

    public PhoneModel phoneModel() {
        return PhoneModel.builder()
                .ddd(87L)
                .number(87996421975L)
                .build();
    }

}
