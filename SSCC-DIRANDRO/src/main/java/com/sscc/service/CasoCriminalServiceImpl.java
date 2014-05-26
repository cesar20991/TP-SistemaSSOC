package com.sscc.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sscc.form.CasoCriminalBean;
import com.sscc.model.CasoCriminal;
import com.sscc.model.Perfil;
import com.sscc.model.Usuario;
import com.sscc.util.DateUtil;

@Service
public class CasoCriminalServiceImpl implements CasoCriminalService{
	
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("deprecation")
	@Transactional
	public Integer crearCasoCriminal(CasoCriminal caso, Integer idUsuario) {
		//seteo el primer estado del caso
		caso.setEstado("Activo");
		//seteo la fecha de creacion
		DateUtil d = new DateUtil();
		caso.setFecCreacion(d.hoyTimestamp());
		//seteo el idUsuario como clave foranea
		Usuario u = new Usuario();
		u.setIdUsuario(idUsuario);
		caso.setUsuario(u);
		
		//grabar en la BD
		em.persist(caso);
		
		caso.setCodigo("N°"+caso.getIdCasoCriminal()+"-"+d.hoy().getMonth()+"-"+d.hoy().getYear()+"-DIRANDRO-PNP-UI");
		
		return caso.getIdCasoCriminal();
	}

	public CasoCriminalBean getCasoCriminalBean(Integer idCaso) {
		CasoCriminalBean cb = new CasoCriminalBean();
		CasoCriminal c = em.find(CasoCriminal.class, idCaso);
		Usuario u = c.getUsuario();
		Perfil p = u.getPerfil();
		
		cb.setApeMaterno(p.getApeMaterno());
		cb.setApePaterno(p.getApePaterno());
		cb.setAsunto(c.getAsunto());
		cb.setCodigo(c.getCodigo());
		cb.setCorreoElectronico(u.getContrasena());
		cb.setDescripcion(c.getDescripcion());
		cb.setEstado(c.getEstado());
		cb.setFecCreacion(c.getFecCreacion());
		cb.setIdCasoCriminal(c.getIdCasoCriminal());
		cb.setPrimerNombre(p.getPrimerNombre());
		cb.setReferencia(c.getReferencia());
		cb.setSegundoNombre(p.getSegundoNombre());
		cb.setTipoFiscal(p.getTipoFiscal());
		cb.setIdPerfil(p.getIdPerfil());
		
		return cb;
	}

}
