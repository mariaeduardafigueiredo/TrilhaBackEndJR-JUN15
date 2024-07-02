package com.pxp.SQLite.trilhaBackEndJR_JUN15.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.pxp.SQLite.trilhaBackEndJR_JUN15.dto.PerfilUsuarioDTO;

import br.com.napoleao.projeto.dto.AcessDTO;
import br.com.napoleao.projeto.dto.AuthenticationDTO;
import br.com.napoleao.projeto.security.jwt.JwtUtils;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticatioManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	public AcessDTO login(AuthenticationDTO authDto) {
		
		try {
		//Cria mecanismo de credencial para o spring
		UsernamePasswordAuthenticationToken userAuth = 
				new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
		
		//Prepara mecanismo para autenticacao
		Authentication authentication = authenticatioManager.authenticate(userAuth);
		
		//Busca usuario logado
		UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();
		
		String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);
		
		AcessDTO accessDto = new AcessDTO(token);
		
		return accessDto;
		
		}catch(BadCredentialsException e) {
			//TODO LOGIN OU SENHA INVALIDO
		}
		return new AcessDTO("Acesso negado");
	}

	public void inserir(PerfilUsuarioDTO usuario) {
		// TODO Auto-generated method stub
		
	}

	public List<PerfilUsuarioDTO> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}