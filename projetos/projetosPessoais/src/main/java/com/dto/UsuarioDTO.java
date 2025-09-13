package com.dto;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsuarioDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chave;
	private String login;
	private String senha;
	private String tipoDeUsuario;
	private PessoaDTO pessoa;
	private String mensagem;
	private Date dataExclusao;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Long chave, String login, String senha, String tipoDeUsuario, Date dataExclusao) {
		this.chave = chave;
		this.login = login;
		this.senha = senha;
		this.tipoDeUsuario = tipoDeUsuario;
		this.dataExclusao = dataExclusao;
	}
	
	public Long getChave() {
		return chave;
	}
	
	public void setChave(Long chave) {
		this.chave = chave;
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
	
	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}
	
	public void setTipoDeUsuario(String tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}
	
	public Date getDataExclusao() {
		return dataExclusao;
	}
	
	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}
	
	public PessoaDTO getPessoa() {
		if (pessoa == null) {
			pessoa = new PessoaDTO();
		}
		return pessoa;
	}
	
	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
