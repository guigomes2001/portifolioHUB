package com.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.UsuarioDTO;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDTO, Long>{
	
}
