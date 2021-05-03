package br.com.desafio.apipessoas.v1.adapter;

import br.com.desafio.apipessoas.v1.adapter.http.exceptions.NegocioException;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

public interface RepositoryPort <T, I, E> extends RepositoryFilterPort<E, T> {

    T persist(T var1) throws NegocioException;

    void remove(T var1) throws EntityNotFoundException;

    T find(I var1) throws EntityNotFoundException;

    <M> Collection<T> query(M var1) throws EntityNotFoundException;

}
