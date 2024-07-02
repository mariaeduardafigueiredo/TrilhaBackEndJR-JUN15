package com.pxp.SQLite.trilhaBackEndJR_JUN15.dto;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;

import br.com.napoleao.projeto.entity.PerfilEntity;


@Getter
@Setter
@NoArgsConstructor
public class PerfilDTO {

	private Long id;
	private String descricao;
	
	public PerfilDTO(HttpEntity perfil) {
		BeanUtils.copyProperties(perfil, this);
	}
}