package br.com.desafio.apipessoas.v1.adapter.heroku;

import com.zaxxer.hikari.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Setter
@Getter
@Configuration
@ConfigurationProperties("spring.datasource")
public class DatabaseConfig {

    private String url;
    private String username;
    private String password;

    @Bean
    @Profile("prod")
    public DataSource configDataSourceProdHeroku() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        return new HikariDataSource(config);
    }

}
