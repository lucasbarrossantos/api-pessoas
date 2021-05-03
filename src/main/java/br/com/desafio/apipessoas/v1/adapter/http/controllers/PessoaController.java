package br.com.desafio.apipessoas.v1.adapter.http.controllers;

import br.com.desafio.apipessoas.v1.core.model.UserModel;
import br.com.desafio.apipessoas.v1.core.servicies.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/users")
public class PessoaController {

    private final PessoaService pessoaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel model) {
        return ResponseEntity.ok(pessoaService.saveUser(model));
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(pessoaService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(pessoaService.getById(id));
    }

}
