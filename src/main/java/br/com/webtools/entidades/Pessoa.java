package br.com.webtools.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Pessoa implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	// VALIDAÇÃO COM BIN VALIDATOR de tamanho
	//@Size (min=3, max = 50, message = "O campo Nome deve ter entre 4 e 50 letras ")
	//@NotEmpty(message = "Nome deve ser informado") // se sobre nome for vazio
	private String nome;
	
	// VALIDAÇÃO COM BIN VALIDATOR
	//@NotEmpty(message = "Sobrenome deve ser informado") // se sobre nome for vazio
	//@NotNull (message = "Sobrenome deve ser informado") // Se sobre nome for null
	private String sobreNome;
	
	// VALIDAÇÃO COM BIN VALIDATOR
	//@DecimalMin(value = "10", message = "Idade deve ser maior que 10")
	//@DecimalMax(value = "50", message = "Idade deve ser menor que 50")
	private Integer idade;
	
	//@Temporal(TemporalType.DATE)
	private Date dataNascimento = new Date(); // FOI INTACIADA PARA RECEBER O VALOR DA DATA ATUAL
	
	private String sexo;
	
	private Integer telefone; 
	
	private String[] frameworks;
	
	private Boolean ativo;
	
	private String login;
	
	private String senha;
	
	private String perfiluser;
	
	private String estadoCivil;
	
	private Integer[] linguagens;
	
	public Pessoa() {
		
	}
	
	
	public Integer[] getLinguagens() {
		return linguagens;
	}


	public void setLinguagens(Integer[] linguagens) {
		this.linguagens = linguagens;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public String getPerfiluser() {
		return perfiluser;
	}


	public void setPerfiluser(String perfiluser) {
		this.perfiluser = perfiluser;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
		
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	

	public String[] getFrameworks() {
		return frameworks;
	}

	public void setFrameworks(String[] frameworks) {
		this.frameworks = frameworks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
