package br.com.webtools.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.webtools.entidades.Lancamento;
import br.com.webtools.entidades.Pessoa;
import br.com.webtools.jpautil.JPAUtil;

public class IDaoLancamentoImpl implements IDaoLancamentos  {

	@Override
	public List<Lancamento> consultar(long codUser) {// METODO PARA CARREGADO OS LANCAMENTOS SÓ DO USUARIO LOGADO
		
		List<Lancamento> lista = null;
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		lista = entityManager.createQuery("from Lancamento where usuario.id = " + codUser).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		return lista;
	}

}
