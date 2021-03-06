package com.sscc.service;

import java.util.List;

import com.sscc.form.BienBean;
import com.sscc.form.InmuebleBean;
import com.sscc.form.MuebleBean;
import com.sscc.form.SospechosoBean;
import com.sscc.form.VehiculoBean;
import com.sscc.model.Bien;
import com.sscc.model.Inmueble;
import com.sscc.model.Vehiculo;

public interface BienService {

	Integer registrarBienVehicular(VehiculoBean vehiculoBean, Integer idUsuario);
	VehiculoBean getVehiculoBean(Integer idVehiculo);
	VehiculoBean editVehiculoBean(VehiculoBean vb);
	
	
	Integer registrarBienInmueble(InmuebleBean inmuebleBean, Integer idUsuario);
	InmuebleBean getInmuebleBean(Integer idInmueble);
	InmuebleBean editInmuebleBean(InmuebleBean inmuebleBean);
	
	//List<BienBean> getBienesBean();
	
	//boolean asignarBienToSospechoso(Integer idBien , Integer idSospechoso);
	Boolean asignarInmueble(Integer idSospechoso, Integer idBien);
	Boolean reAsignarInmueble(Integer idSospechoso, Integer idBien, String estado);
	
	Boolean getPartidaRegistral (String partidaRegistral);
	//Vehicular:
	Boolean getPlaca (String placa);
	
	List<BienBean> getBienesPorSopechoso(Integer idSospechoso);
	
	Boolean desAsignarBienToSospechoso(Integer idSospechoso, Integer idBien);
	
	List<InmuebleBean> getInmueblesBuscar();
	
	List<InmuebleBean> getInmueblesBuscarPorSospechoso(Integer idSospechoso);
	
	List<VehiculoBean> getVehiculosBuscar();
	
	List<VehiculoBean> getVehiculosBuscarPorSospechoso(Integer idSospechoso);
	
	List<MuebleBean> getBienesMuebles(Integer idSospechoso);
	
	List<MuebleBean> getMueblesBuscar();
	
	List<InmuebleBean> getBienesInmueble();
	
	List<VehiculoBean> getBienesVehiculos();
}