package com.service; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.PessoaDTO;
import com.dto.UsuarioDTO;
import com.respository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private PessoaDTO pessoa;
	@Autowired
	private UsuarioDTO usuario;
	private UsuarioRepository usuarioRepository;
	
	public void cadastrarUsuario(UsuarioDTO usuarioWS) {
		getUsuarioRepository().save(usuarioWS);
		if(true) {
			usuarioWS.setMensagem("Usuário cadastrado com sucesso");
		}
	}
	
	private PessoaDTO getPessoa() {
		if (pessoa == null) {
			pessoa = new PessoaDTO();
		}
		return pessoa;
	}
	
	private UsuarioDTO getUsuario() {
		if (usuario == null) {
			usuario = new UsuarioDTO();
		}
		return usuario;
	}
	
	private UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}
}
