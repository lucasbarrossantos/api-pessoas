package br.com.desafio.apipessoas.v1.core.servicies;

import br.com.desafio.apipessoas.v1.adapter.entities.UserEntity;
import br.com.desafio.apipessoas.v1.adapter.http.exceptions.NegocioException;
import br.com.desafio.apipessoas.v1.adapter.mapper.UserMapper;
import br.com.desafio.apipessoas.v1.adapter.repositories.UserEntityRepository;
import br.com.desafio.apipessoas.v1.core.mock.MockBuilder;
import br.com.desafio.apipessoas.v1.core.model.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private UserMapper mapper;

    @Mock
    private UserEntityRepository userEntityRepository;

    private final MockBuilder mock = MockBuilder.getInstance();

    @DisplayName("Deve salvar um usuário com sucesso")
    @Test
    void mustSuccessOnSaveUser() {
        UserEntity entity = mock.userEntity();

        Mockito.when(mapper.toModel(Mockito.any(UserEntity.class))).thenReturn(mock.userModel());
        Mockito.when(mapper.toEntity(Mockito.any(UserModel.class))).thenReturn(mock.userEntity());

        Mockito.when(userEntityRepository.existsByEmail(Mockito.anyString())).thenReturn(false);
        Mockito.doReturn(entity).when(userEntityRepository).save(Mockito.any(UserEntity.class));

        UserModel userSaved = pessoaService.saveUser(mock.userModel());

        assertNotNull(userSaved);
        assertEquals(entity.getEmail(), userSaved.getEmail());
        Mockito.verify(userEntityRepository, Mockito.atLeastOnce()).existsByEmail(entity.getEmail());
    }

    @DisplayName("Deve lançar exception NegocioException.class ao tentar salvar usuário com e-mail existente")
    @Test
    void shouldThrowExceptionNegocioException() {
        Throwable exception = assertThrows(NegocioException.class, () -> {
            Mockito.when(userEntityRepository.existsByEmail(Mockito.anyString())).thenReturn(true);
            pessoaService.saveUser(mock.userModel());
        });

        assertEquals(exception.getMessage(), "O e-mail "+ mock.userModel().getEmail() +" já está cadastrado na base");
    }

}
