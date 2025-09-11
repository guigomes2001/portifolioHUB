package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@DeleteMapping("/excluirUsuario/{chave}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Long chave) {
		try {
			getUsuarioService().excluirUsuarioPorChave(chave);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}
	
	private UsuarioService getUsuarioService() {
		if (usuarioService == null) {
			usuarioService = new UsuarioService();
		}
		return usuarioService;
	}
}
