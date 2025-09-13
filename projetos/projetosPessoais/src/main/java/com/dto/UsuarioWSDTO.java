package com.dto;

public class UsuarioWSDTO {
	
	private Long chave;
	private String login;
	private String senha;
	private PessoaDTO pessoa;
	private String mensagem;
	
	public UsuarioWSDTO() {
		
	}
	
	public UsuarioWSDTO(Long chave, String login, String senha) {
		this.chave = chave;
		this.login = login;
		this.senha = senha;
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

