package br.com.desafio.apipessoas.v1.adapter.mapper;

import br.com.desafio.apipessoas.v1.adapter.entities.PhoneEntity;
import br.com.desafio.apipessoas.v1.core.model.PhoneModel;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    PhoneModel toModel(PhoneEntity entity);
    PhoneEntity toEntity(PhoneModel model);

    List<PhoneModel> toModels(List<PhoneEntity> entityList);
    List<PhoneEntity> toEntities(List<PhoneModel> models);
    
}
