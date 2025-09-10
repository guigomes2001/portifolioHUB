package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.PessoaDTO;
import com.dto.UsuarioDTO;
import com.service.UsuarioService;
import com.util.NullUtil;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioDTO> cadastrarUsuario(@PathVariable UsuarioDTO usuario) {
		UsuarioDTO usuarioWS = new UsuarioDTO();
		
		if(!NullUtil.isNullOrEmpty(usuario.getUsuario())) {
			usuarioWS.setUsuario(usuario.getUsuario());
		}
		if(!NullUtil.isNullOrEmpty(usuario.getSenha())) {
			usuarioWS.setSenha(usuario.getSenha());
		}
		
		try {
			getUsuarioService().cadastrarUsuario(usuarioWS);
		} catch (Exception e) {
			e.printStackTrace();
			usuarioWS.setMensagem("Ocorreu um erro ao cadastrar o usuário " + usuario.getUsuario());
		}
		return ResponseEntity.ok(usuarioWS);
	}
	
	@GetMapping()
	public UsuarioDTO pesquisarUsuario(@PathVariable PessoaDTO pessoa) {
		UsuarioDTO usuario = new UsuarioDTO();
		
		if(!NullUtil.isNullOrEmpty(pessoa.getNome())) {
			usuario.getPessoa().setNome(pessoa.getNome());
		}
		if(!NullUtil.isNullOrEmpty(pessoa.getDataNascimento())) {
			usuario.getPessoa().setDataNascimento(pessoa.getDataNascimento());
		}
		if(!NullUtil.isNullOrEmpty(pessoa.getCpf())) {
			usuario.getPessoa().setCpf(pessoa.getCpf());
		}
		return null;
	}
	
	public UsuarioService getUsuarioService() {
		if (usuarioService == null) {
			usuarioService = new UsuarioService();
		}
		return usuarioService;
	}
}
