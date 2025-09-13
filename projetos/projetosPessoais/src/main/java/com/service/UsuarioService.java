package com.service; 

import org.springframework.stereotype.Service;

import com.dao.UsuarioDAO;
import com.dto.UsuarioDTO;
import com.dto.UsuarioWSDTO;
import com.util.NullUtil;

@Service
public class UsuarioService {
	
	private UsuarioWSDTO usuarioWS;
	private UsuarioDTO usuario;
	private UsuarioDAO usuarioDAO; 
	
	public void cadastrarUsuario(UsuarioWSDTO usuarioWS) {
		setUsuarioWS(usuarioWS);
		cadastrarUsuario();
	}
	
	private void cadastrarUsuario() {
		UsuarioDTO usuario = definirUsuario(getUsuarioWS());
		getUsuarioDAO().cadastrarUsuario(usuario);
	}
	
	public void atualizarUsuario(UsuarioDTO usuario) {
		setUsuario(usuario);
		atualizarUsuario();
	}
	
	private void atualizarUsuario() {
		UsuarioDTO usuarioCapturado = getUsuarioDAO().capturarUsuarioPorChave(getUsuarioWS().getChave());
		if(!NullUtil.isNullOrEmpty(usuarioCapturado)) {
			getUsuarioDAO().atualizarUsuario(getUsuario());
		}
	}

	public void excluirUsuarioPorChave(Long chave) {
		try {
			getUsuarioDAO().excluirUsuarioPorChave(chave);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UsuarioDTO pesquisarUsuarioPorLogin(String login) {
		UsuarioDTO usuarioCapturado = new UsuarioDTO();
		try {
			usuarioCapturado = getUsuarioDAO().capturarUsuarioPorLogin(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarioCapturado;
	}
	
	private UsuarioDTO definirUsuario(UsuarioWSDTO usuarioWS) {
		UsuarioDTO usuario = new UsuarioDTO();
		if(!NullUtil.isNullOrEmpty(usuarioWS.getLogin())) {
			usuario.setLogin(usuarioWS.getLogin());
		}
		if(!NullUtil.isNullOrEmpty(usuarioWS.getSenha())) {
			usuario.setSenha(usuarioWS.getSenha());
		}
		if(!NullUtil.isNullOrEmpty(usuarioWS.getPessoa().getNome())) {
			usuario.getPessoa().setNome(usuarioWS.getPessoa().getNome());
		}
		if(!NullUtil.isNullOrEmpty(usuarioWS.getPessoa().getCpf())) {
			usuario.getPessoa().setNome(usuarioWS.getPessoa().getCpf());
		}
		if(!NullUtil.isNullOrEmpty(usuarioWS.getPessoa().getDataNascimento())) {
			usuario.getPessoa().setNome(usuarioWS.getPessoa().getDataNascimento());
		}
		return usuario;
	}

	private UsuarioWSDTO getUsuarioWS() {
		if (usuarioWS == null) {
			usuarioWS = new UsuarioWSDTO();
		}
		return usuarioWS;
	}
	
	private void setUsuarioWS(UsuarioWSDTO usuarioWS) {
		this.usuarioWS = usuarioWS;
	}
	
	private UsuarioDTO getUsuario() {
		if (usuario == null) {
			usuario = new UsuarioDTO();
		}
		return usuario;
	}
	
	private void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	private UsuarioDAO getUsuarioDAO() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAO();
		}
		return usuarioDAO;
	}
}
