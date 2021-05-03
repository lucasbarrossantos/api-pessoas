package br.com.desafio.apipessoas;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@EnableAuthorizationServer
@EnableResourceServer
@SpringBootApplication
public class ApiPessoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPessoasApplication.class, args);
    }

}
