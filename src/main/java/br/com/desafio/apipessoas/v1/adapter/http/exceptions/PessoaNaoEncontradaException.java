package br.com.desafio.apipessoas.v1.adapter.http.exceptions;

public class PessoaNaoEncontradaException extends EntidadeNaoEncontradaException {

    public PessoaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public PessoaNaoEncontradaException(Long pessoaId) {
        this(String.format("Não existe um cadastro de pessoa com código %d", pessoaId));
    }

}
