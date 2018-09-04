package br.com.webtools.repository;

import java.util.List;

import br.com.webtools.entidades.Lancamento;

public interface IDaoLancamentos {
	List<Lancamento> consultar(long codUser);
}
