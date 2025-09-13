package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UsuarioDTO;
import com.dto.UsuarioWSDTO;
import com.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioWSDTO usuarioWS) {
		UsuarioDTO usuario = new UsuarioDTO();
		try {
			getUsuarioService().cadastrarUsuario(usuarioWS);
		} catch (Exception e) {
			e.printStackTrace();
			usuario.setMensagem("Ocorreu um erro ao cadastrar o usuário " + usuario.getLogin());
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/atualizarUsuario")
	public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		try {
			getUsuarioService().atualizarUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			usuarioDTO.setMensagem("Ocorreu um erro ao atualizar o usuário " + usuario.getLogin());
		}
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable("id") Long chave) {
		try {
			getUsuarioService().excluirUsuarioPorChave(chave);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{login}")
	public ResponseEntity<UsuarioDTO> pesquisarUsuarioPorLogin(@PathVariable String login) {
		UsuarioDTO usuario = new UsuarioDTO();
		try {
			getUsuarioService().pesquisarUsuarioPorLogin(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(usuario);
	}
	
	
	private UsuarioService getUsuarioService() {
		if (usuarioService == null) {
			usuarioService = new UsuarioService();
		}
		return usuarioService;
	}
}
