package br.com.desafio.apipessoas.v1.core.servicies;

import br.com.desafio.apipessoas.v1.adapter.entities.UserEntity;
import br.com.desafio.apipessoas.v1.adapter.http.exceptions.NegocioException;
import br.com.desafio.apipessoas.v1.adapter.http.exceptions.PessoaNaoEncontradaException;
import br.com.desafio.apipessoas.v1.adapter.mapper.UserMapper;
import br.com.desafio.apipessoas.v1.adapter.repositories.UserEntityRepository;
import br.com.desafio.apipessoas.v1.core.model.UserModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PessoaService implements UserDetailsService {

    private final UserMapper mapper;
    private final UserEntityRepository userEntityRepository;

    @Transactional
    public UserModel saveUser(UserModel model) {
        validateExistedEmail(model);

        return mapper.toModel(userEntityRepository.save(mapper.toEntity(model)));
    }

    public void validateExistedEmail(UserModel model) {
        boolean existsEmail = userEntityRepository.existsByEmail(model.getEmail());

        if (existsEmail)
            throw new NegocioException(String.format("O e-mail %s já está cadastrado na base", model.getEmail()));
    }

    public List<UserModel> getAllUsers() {
        return mapper.toModels(userEntityRepository.findAll());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> user = userEntityRepository.findByEmail(email);

        if (user.isPresent()) {
            return user.get();
        } else
            throw new PessoaNaoEncontradaException("User not found!");
    }

    public UserModel getById(UUID id) {
        return userEntityRepository.findById(id)
                .map(mapper::toModel)
                .orElseThrow(() -> new PessoaNaoEncontradaException("Nenhum registro encontrado com o parâmetro informado!"));
    }
}
