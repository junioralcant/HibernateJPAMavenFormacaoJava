package br.com.webtools.bean;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.webtools.dao.DaoGeneric;
import br.com.webtools.entidades.Pessoa;
import br.com.webtools.repository.IDaoPessoa;
import br.com.webtools.repository.IDaoPessoaImpl;



@ViewScoped
@ManagedBean(name = "pessoaBean") 
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> dao = new DaoGeneric<>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	private IDaoPessoa idaopessoa = new IDaoPessoaImpl();
	
		
	public String salvar () {
		dao.salvar(pessoa);
		pessoa = new Pessoa();
		carregarPessoas();
		mostraMsg("Cadastrodo com sucesso!");
		return ""; // FICA NA MESMA PAGINA
	}
	
	

	public String salvarMerge() {
		pessoa = dao.merge(pessoa);
		carregarPessoas();
		mostraMsg("Cadastrodo com sucesso!");
		return "";
	}
	
	public String novo() {
		pessoa = new Pessoa();
		return "";
	}
	
	public String delete() {
		dao.delete(pessoa);
		return "";
	}
	
	public String deletePorId() {
		dao.deletePorId(pessoa);
		pessoa = new Pessoa();
		carregarPessoas();
		mostraMsg("Removido com sucesso!");
		return "";
	}
	
	private void mostraMsg(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(null, message);
				
	}
	
	@PostConstruct // FAZ COM QUE O METODO SEJA CHAMADO AUTOMATICAMENTE
	public void carregarPessoas() { // RETORNARA UMA LISTA DE PESSOAS
		pessoas = dao.getListEntity(Pessoa.class);
	}
	
	public String logar () { //VALIDAÇÃO DE USUARIO
		
		 Pessoa pessoaUser = idaopessoa.consultarUsuario(pessoa.getLogin(), pessoa.getSenha());
		 
		 if(pessoaUser != null) { // ENCONTROU USUARIO
			 // ADICIONANDO USUARIO NA SESSÃO usuarioLogado 
			 FacesContext context = FacesContext.getCurrentInstance();
			 ExternalContext externalContext = context.getExternalContext();
			 externalContext.getSessionMap().put("usuarioLogado", pessoaUser);
			 
			 return "primeiraPagina.jsf";
		 }
		
		return "index.jsf";
	}
	
	public boolean permiteAcesso(String acesso) {
		// ADICIONANDO USUARIO NA SESSÃO usuarioLogado RECEBE O ACESSO E RETORNA O TIPO DE PERFIL DO USER 
		// BLOQUEIA ALGUMAS PARTES DA MINHA TELA DE ACORDO COM O TIPO DE PERFIL DO USUARIO
		 FacesContext context = FacesContext.getCurrentInstance();
		 ExternalContext externalContext = context.getExternalContext();
		 Pessoa pessoaUser = (Pessoa) externalContext.getSessionMap().get("usuarioLogado");
		 
		 return pessoaUser.getPerfiluser().equals(acesso);
	}
			
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	
	
	
}
