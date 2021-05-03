package br.com.desafio.apipessoas.v1.adapter;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;

public interface RepositoryFilterPort <E, T> {

    List<E> filter(Specification<E> var1) throws EntityNotFoundException;

    Page<Collection<T>> filterWithPagination(Specification<E> var1, Page<?> var2) throws EntityNotFoundException;

}
