package com.app.whatslike.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.whatslike.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
