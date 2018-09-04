package br.com.webtools.repository;

import br.com.webtools.entidades.Pessoa;

public interface IDaoPessoa {
	Pessoa consultarUsuario(String login, String senha);
}
