package com.dto;

public class PessoaDTO {
	
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	
	private UsuarioDTO usuario;
	
	public PessoaDTO() {
		
	}
	
	public PessoaDTO(String nome, String cpf, String dataNascimento, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public UsuarioDTO getUsuario() {
		return usuario;
	}
}
