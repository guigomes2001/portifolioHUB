package com.service; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UsuarioDAO;
import com.dto.PessoaDTO;
import com.dto.UsuarioDTO;
import com.dto.UsuarioWSDTO;
import com.respository.UsuarioRepository;
import com.util.NullUtil;

@Service
public class UsuarioService {
	
	private @Autowired UsuarioWSDTO usuarioWS;
	private UsuarioDAO usuarioDAO; 
	
	public void cadastrarUsuario(UsuarioWSDTO usuarioWS) {
		setUsuarioWS(usuarioWS);
		cadastrarUsuario();
	}
	
	private void cadastrarUsuario() {
		UsuarioDTO usuario = definirUsuario(getUsuarioWS());
		int retorno = 0;
		retorno = getUsuarioDAO().cadastrarUsuario(usuario);
		if(retorno > 0) {
			getUsuarioWS().setMensagem("Usuário cadastrado com sucesso");
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
	
	
	public void excluirUsuarioPorChave(Long chave) {
		try {
			getUsuarioDAO().excluirUsuarioPorChave(chave);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public void setUsuarioWS(UsuarioWSDTO usuarioWS) {
		this.usuarioWS = usuarioWS;
	}
	
	private UsuarioDAO getUsuarioDAO() {
		if (usuarioDAO == null) {
			usuarioDAO = new UsuarioDAO();
		}
		return usuarioDAO;
	}
}
