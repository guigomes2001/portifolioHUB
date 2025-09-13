package com.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.UsuarioDTO;

//Talves eu use o repositório JPA no futuro mas no momento vou usar JDBC
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDTO, Long>{
	Optional<UsuarioDTO> capturarUsuario(String usuario);
	Optional<UsuarioDTO> captuarUsuarioPorChave(Long chave);
}
