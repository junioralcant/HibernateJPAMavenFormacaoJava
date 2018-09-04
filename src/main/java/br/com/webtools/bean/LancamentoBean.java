package br.com.webtools.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.webtools.dao.DaoGeneric;
import br.com.webtools.entidades.Lancamento;
import br.com.webtools.entidades.Pessoa;
import br.com.webtools.repository.IDaoLancamentoImpl;
import br.com.webtools.repository.IDaoLancamentos;

@ViewScoped
@ManagedBean(name = "lancamentoBean")
public class LancamentoBean {
	private Lancamento lancamento = new Lancamento();
	private DaoGeneric<Lancamento> dao = new DaoGeneric<Lancamento>();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private IDaoLancamentos daoLancamento = new IDaoLancamentoImpl();
	
	public String salvarMerge() {
		
		 // RECUPERA O USUARIO 
		 FacesContext context = FacesContext.getCurrentInstance();
		 ExternalContext externalContext = context.getExternalContext();
		 Pessoa pessoaUser = (Pessoa) externalContext.getSessionMap().get("usuarioLogado");
		 
		 lancamento.setUsuario(pessoaUser);
		 lancamento = dao.merge(lancamento);
		 
		 carregarLancamento();
		
		return "";
	}
	
	@PostConstruct // O METODO SERA CHAMADO AUTOMATICAMENTE APOS LOGAR NO SISTEMA 
	public void carregarLancamento() {// SERA CARREGADO OS LANCAMENTOS SÓ DO USUARIO LOGADO
		
		// RECUPERA O USUARIO 
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Pessoa pessoaUser = (Pessoa) externalContext.getSessionMap().get("usuarioLogado");
		
		lancamentos = daoLancamento.consultar(pessoaUser.getId());
	}
	
	
	
	public String deletePorId() {
		dao.deletePorId(lancamento);
		lancamento = new Lancamento();
		carregarLancamento();
		
		return"";
	}
	
	public String novo() {
		lancamento = new Lancamento();
		
		return"";
	}
	
	public Lancamento getLancamento() {
		return lancamento;
	}
	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	public DaoGeneric<Lancamento> getDao() {
		return dao;
	}
	public void setDao(DaoGeneric<Lancamento> dao) {
		this.dao = dao;
	}
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	
}
