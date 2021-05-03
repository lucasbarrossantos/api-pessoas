package br.com.desafio.apipessoas.v1.adapter.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_phone")
public class PhoneEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column( columnDefinition = "uuid", updatable = false )
    private UUID id;

    @NotNull
    private Long number;

    @NotNull
    private Long ddd;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;

}
