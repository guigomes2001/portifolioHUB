package com.UsuariosAPIApplication;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dao.DAOGenerica;

@SpringBootApplication
@ComponentScan(basePackages = "com.controller, com.dao, com.dto, com.repository, com.service, com.util")
public class UsuariosApiApplication {

	public UsuariosApiApplication(DataSource dataSource) {
        DAOGenerica.setDataSource(dataSource);
    }
	
    public static void main(String[] args) {
        SpringApplication.run(UsuariosApiApplication.class, args);
    }
}