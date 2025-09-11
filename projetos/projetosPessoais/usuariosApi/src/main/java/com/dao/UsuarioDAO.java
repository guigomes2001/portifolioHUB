package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.UsuarioDTO;

public class UsuarioDAO extends DAOGenerica {
	
	final static String SQL_CADASTRAR_USUARIO =  new StringBuilder()
			.append("INSERT INTO API_USUARIOS ")
			.append("  VALUES (?,?,sysdate) ").toString();
	
	final static String SQL_CAPTURAR_USUARIO_POR_LOGIN = new StringBuilder()
			.append(" SELECT * FROM API_USUARIOS ")
			.append(" WHERE LOGIN = ? ")
			.append("   AND DATA_EXCLUSAO IS NULL ").toString();
	
	final static String SQL_EXCLUIR_USUARIO_POR_CHAVE = new StringBuilder()
			.append(" UPDATE API_USUARIOS ")
			.append(" SET DATA_EXCLUSAO = SYSDATE ")
			.append(" WHERE CHAVE = ? ").toString();
	
	public int cadastrarUsuario(UsuarioDTO usuario) {
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			pstmt = getConexao().prepareStatement(SQL_CADASTRAR_USUARIO);
			pstmt.setString(1, usuario.getLogin());
			pstmt.setString(2, usuario.getSenha());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fechaConexao(pstmt);
		}
		return i;
	}

	public UsuarioDTO capturarUsuarioPorLogin(String login) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UsuarioDTO usuario = new UsuarioDTO();
		try {
			pstmt = getConexao().prepareStatement(SQL_CAPTURAR_USUARIO_POR_LOGIN);
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				usuario = preencherUsuario(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fechaConexao(pstmt);
		}
		return usuario;
	}

	private UsuarioDTO preencherUsuario(ResultSet rs) throws SQLException {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setChave(rs.getLong("CHAVE"));
		usuario.setLogin(rs.getString("LOGIN_USUARIO"));
		usuario.setTipoDeUsuario(rs.getString("TIPO_USUARIO"));
		return usuario;
	}

	public int excluirUsuarioPorChave(Long chave) {
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			pstmt = getConexao().prepareStatement(SQL_EXCLUIR_USUARIO_POR_CHAVE);
			pstmt.setLong(1, chave);
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fechaConexao(pstmt);
		}
		return i;
	}
}
