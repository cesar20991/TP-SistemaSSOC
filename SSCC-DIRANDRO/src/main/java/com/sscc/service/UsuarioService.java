package com.sscc.service;

import javax.servlet.http.HttpSession;

import com.sscc.model.Usuario;

public interface UsuarioService {
	
	Boolean login(Usuario usuario, HttpSession session);

}
