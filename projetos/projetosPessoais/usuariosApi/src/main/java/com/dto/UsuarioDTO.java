package com.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UsuarioDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chave;
	private String usuario;
	private String senha;
	private PessoaDTO pessoa;
	private String mensagem;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Long chave, String usuario, String senha) {
		this.chave = chave;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Long getChave() {
		return chave;
	}
	
	public void setChave(Long chave) {
		this.chave = chave;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
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
