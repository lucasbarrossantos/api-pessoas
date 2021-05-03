package br.com.desafio.apipessoas.v1.adapter.mapper;

import br.com.desafio.apipessoas.v1.adapter.entities.UserEntity;
import br.com.desafio.apipessoas.v1.core.model.UserModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserModel toModel(UserEntity entity);

    UserEntity toEntity(UserModel model);

    List<UserModel> toModels(List<UserEntity> entityList);

    List<UserEntity> toEntities(List<UserModel> models);

}
