package com.sscc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sscc.form.BienBean;
import com.sscc.form.CasoCriminalBean;
import com.sscc.form.InmuebleBean;
import com.sscc.form.MuebleBean;
import com.sscc.form.SospechosoBean;
import com.sscc.form.VehiculoBean;
import com.sscc.model.Sospechoso;
import com.sscc.service.BienService;
import com.sscc.service.MuebleService;
import com.sscc.service.SospechosoService;

@Controller
public class BienController {

	@Autowired
	BienService bienServ;
	
	@Autowired
	SospechosoService sosServ;
	
	@RequestMapping("toBuscarInmueble")
	public String toBuscarInmueble() {
		return "principal/buscarInmueble";
	}
	
	@RequestMapping("toBuscarVehiculo")
	public String toBuscarVehiculo() {
		return "principal/buscarVehiculo";
	}
	
	@RequestMapping("toBuscarMueble")
	public String toBuscarMueble() {
		return "principal/buscarMueble";
	}
	
	@RequestMapping("popUpAsignarBien-{idSospechoso}")
	public String toBuscarBien(@PathVariable("idSospechoso")Integer idSospechoso, Model model ) {
		List<SospechosoBean> sospechosoList = new ArrayList<SospechosoBean>();
		SospechosoBean s = new SospechosoBean();
		s.setIdSospechoso(idSospechoso);
		sospechosoList.add(s);
		model.addAttribute("sospechosoList", sospechosoList);
		return "principal/popUpAsignarBien";
	}
	
	@RequestMapping(value = "getBienesPorSospechoso-{idSospechoso}", method = RequestMethod.POST)
	@ResponseBody
	public List<BienBean> getBienesPorSospechoso(@PathVariable("idSospechoso") Integer idSospechoso){
		System.out.println("IdSospechoso = "+idSospechoso);	
		return bienServ.getBienesPorSopechoso(idSospechoso);
	}

	
	/*@RequestMapping(value ="asignarBienToSospechoso-{idBien}-{idSospechoso}",method= RequestMethod.POST)
	@ResponseBody
	public List<BienBean> toBuscarBien(@PathVariable("idBien")Integer idBien,@PathVariable("idSospechoso")Integer idSospechoso) {
		if(bienServ.asignarBienToSospechoso(idBien, idSospechoso)){
			return bienServ.getBienesPorSopechoso(idSospechoso);
		}
		return null;
	}
	*/
	@RequestMapping(value = "desAsignarBienToSospechoso-{idSospechoso}-{idBien}", method = RequestMethod.POST)
	@ResponseBody
	public List<BienBean> desAsignarBienToSospechoso(@PathVariable("idSospechoso") Integer idSospechoso,@PathVariable("idBien") Integer idBien){
		if(bienServ.desAsignarBienToSospechoso(idSospechoso, idBien)){
			return bienServ.getBienesPorSopechoso(idSospechoso);
		}else{
			return null;
		}
	}
	
	// Metodos para el Inmueble
	@RequestMapping("toRegistrarInmueble")
	public String toRegistrarInmueble() {
		return "principal/registrarBienInmueble";
	}
	@RequestMapping(value = "registrarInmueble", method = RequestMethod.POST)
	public String registrarInmueble(@ModelAttribute InmuebleBean inmuebleBean, HttpServletRequest req, HttpSession session, Model model){

		Integer idUsuario = (Integer)session.getAttribute("idUsuario");
		Integer id = bienServ.registrarBienInmueble(inmuebleBean, idUsuario);
		
		return "redirect:toInmueble-"+id;
	}
	
	@RequestMapping("toInmueble-{idInmueble}")
	public String toInmueble(@PathVariable("idInmueble")Integer idInmueble, Model model ){
		List<InmuebleBean> i = new ArrayList<InmuebleBean>();
		InmuebleBean ib = new InmuebleBean();
		//ib.setIdInmueble(idInmueble);
		ib = getInmueble(idInmueble);
		i.add(ib);		
		model.addAttribute("inmuebleList", i);
		return "principal/inmueblePrincipal";
	}
	
	@RequestMapping(value= "getInmueble-{idInmueble}", method=RequestMethod.POST)
	@ResponseBody
	public InmuebleBean getInmueble(@PathVariable("idInmueble")Integer idInmueble){
		InmuebleBean inmuebleBean = new InmuebleBean();
		inmuebleBean = bienServ.getInmuebleBean(idInmueble);
		System.out.println(inmuebleBean!=null?"Existe inmueble":"No esta devolviendo el inmueble");
		return inmuebleBean;
	}
	
	@RequestMapping(value = "editarInmueble", method = RequestMethod.POST)
	@ResponseBody
	public InmuebleBean editarInmueble(@ModelAttribute InmuebleBean inmueble, HttpServletRequest req, HttpSession session, Model model){
		InmuebleBean inmuebleBean = new InmuebleBean();
		inmuebleBean = bienServ.editInmuebleBean(inmueble);
		return inmuebleBean;
	}
	

	// Metodos para el Vehiculo
	@RequestMapping("toRegistrarVehiculo")
	public String toRegistrarVehiculo() {
		return "principal/registrarBienVehicular";
	}
	
	@RequestMapping(value = "registrarVehiculo", method = RequestMethod.POST)
	public String registrarVehiculo(@ModelAttribute VehiculoBean vehiculoBean, HttpServletRequest req, HttpSession session, Model model){
	
		Integer idUsuario = (Integer)session.getAttribute("idUsuario");
		Integer id = bienServ.registrarBienVehicular(vehiculoBean,idUsuario);
		
		return "redirect:toVehiculo-"+id;
	}
	
	@RequestMapping("toVehiculo-{idVehiculo}")
	public String toVehiculo(@PathVariable("idVehiculo")Integer idVehiculo, Model model ){
		List<VehiculoBean> v = new ArrayList<VehiculoBean>();
		VehiculoBean vb = new VehiculoBean();
		//vb.setIdVehiculo(idVehiculo);
		vb = getVehiculo(idVehiculo);
		v.add(vb);		
		model.addAttribute("vehiculoList", v);
		return "principal/vehiculoPrincipal";
	}
	
	@RequestMapping(value= "getVehiculo-{idVehiculo}", method=RequestMethod.POST)
	@ResponseBody
	public VehiculoBean getVehiculo(@PathVariable("idVehiculo")Integer idVehiculo){
		System.out.println("IdVehiculo = "+idVehiculo);
		VehiculoBean vehiculoBean = new VehiculoBean();
		vehiculoBean = bienServ.getVehiculoBean(idVehiculo);
		
		return vehiculoBean;
	}
	
	@RequestMapping(value = "editarVehiculo", method = RequestMethod.POST)
	@ResponseBody
	public VehiculoBean editarVehiculo(@ModelAttribute VehiculoBean vehiculo, HttpServletRequest req, HttpSession session, Model model){
		VehiculoBean vehiculoBean = new VehiculoBean();
		vehiculoBean = bienServ.editVehiculoBean(vehiculo);
		return vehiculoBean;
	}
	
	//Validaciones_Bienes:
	@RequestMapping(value = "getPartidaRegistral-{partidaRegistral}", method = RequestMethod.POST)
	@ResponseBody
	public Boolean getPartidaRegistral(@PathVariable("partidaRegistral") String partidaRegistral){
		if(bienServ.getPartidaRegistral(partidaRegistral)){
			return true;
		}else{
			return false;
		}
	}
	@RequestMapping(value = "getPlaca-{placa}", method = RequestMethod.POST)
	@ResponseBody
	public Boolean getPlaca(@PathVariable("placa") String placa){
		if(bienServ.getPlaca(placa)){
			return true;
		}else{
			return false;
		}
	}
	//buscar
	@RequestMapping(value = "getInmueblesBuscar", method = RequestMethod.POST)
	@ResponseBody
	public List<InmuebleBean> getInmueblesBuscar(){
		List<InmuebleBean> bienes = new ArrayList<InmuebleBean>();
		bienes = bienServ.getInmueblesBuscar();
		return bienes;
	}
	//buscar
	@RequestMapping(value = "getVehiculosBuscar", method = RequestMethod.POST)
	@ResponseBody
	public List<VehiculoBean> getVehiculosBuscar(){
		List<VehiculoBean> bienes = new ArrayList<VehiculoBean>();
		bienes = bienServ.getVehiculosBuscar();
		return bienes;
	}
	
	// BIENES mueble
	@RequestMapping(value = "getBienesMuebles-{idSospechoso}", method = RequestMethod.POST)
	@ResponseBody
	public List<MuebleBean> getBienesMuebles(@PathVariable("idSospechoso") Integer idSospechoso){
		List<MuebleBean> bienes=new ArrayList<MuebleBean>();
		bienes = bienServ.getBienesMuebles(idSospechoso);
		return bienes;
	}
	
	@RequestMapping(value = "getMueblesBuscar", method = RequestMethod.POST)
	@ResponseBody
	public List<MuebleBean> getMueblesBuscar(){
		List<MuebleBean> bienes=new ArrayList<MuebleBean>();
		bienes = bienServ.getMueblesBuscar();
		return bienes;
	}
	// BIENES inmueble
	@RequestMapping(value = "asignarInmuebleToSospechoso-{idSospechoso}-{idBien}", method = RequestMethod.POST)
	@ResponseBody
	public Boolean asignarInmuebleToSospechoso(@PathVariable("idSospechoso") Integer idSospechoso,@PathVariable("idBien") Integer idBien){
		//List<InmuebleBean> bienes=new ArrayList<InmuebleBean>();
		if(bienServ.asignarInmueble(idSospechoso,idBien)){
			return true;
		}else{
			return false;
		}		
	}
	
	@RequestMapping(value = "desasignarInmuebleToSospechoso-{idSospechoso}-{idBien}", method = RequestMethod.POST)
	@ResponseBody
	public Boolean desasignarInmuebleToSospechoso(@PathVariable("idSospechoso") Integer idSospechoso,@PathVariable("idBien") Integer idBien){
		//List<InmuebleBean> bienes=new ArrayList<InmuebleBean>();
		
		if(bienServ.reAsignarInmueble(idSospechoso, idBien, "deshabilitado")){
			return true;
		}else{
			return false;
		}		
	}
	
	@Autowired
	MuebleService muebleServ;
	
	@RequestMapping(value = "desasignarMuebleToSospechoso-{idSospechoso}-{idMueble}", method = RequestMethod.POST)
	@ResponseBody
	public Boolean desasignarMuebleToSospechoso(@PathVariable("idSospechoso") Integer idSospechoso,@PathVariable("idMueble") Integer idBien){
		//List<InmuebleBean> bienes=new ArrayList<InmuebleBean>();
		
		if(muebleServ.reAsignarMuebleTOSospechoso(idSospechoso, idBien, "deshabilitado")){
			return true;
		}else{
			return false;
		}		
	}
	
	@RequestMapping(value = "desasignarCasoToSospechoso-{idSospechoso}-{idCaso}", method = RequestMethod.POST)
	@ResponseBody
	public Boolean desasignarCasoToSospechoso(@PathVariable("idSospechoso") Integer idSospechoso,@PathVariable("idCaso") Integer idCaso){
		if(muebleServ.reAsignarCasoTOSospechoso(idSospechoso, idCaso, "deshabilitado")){
			return true;
		}else{
			return false;
		}		
	}
	
	@RequestMapping(value = "registrarMueble-{idSospechoso}", method = RequestMethod.POST)
	@ResponseBody
	public Boolean registrarMueble(@ModelAttribute MuebleBean muebleBean,@PathVariable("idSospechoso")Integer idSospechoso, HttpServletRequest req, HttpSession session, Model model){
		
		Integer idMueble = muebleServ.registrarMueble(muebleBean, idSospechoso);		
		if(idMueble != 0){
			return true;
		}else{
			return false;
		}
	}
	
	// BIENES vehiculo
	@RequestMapping(value = "asignarVehiculoToSospechoso-{idSospechoso}-{idBien}", method = RequestMethod.POST)
	@ResponseBody
	public Boolean asignarVehiculoToSospechoso(@PathVariable("idSospechoso") Integer idSospechoso,@PathVariable("idBien") Integer idBien){
		//List<VehiculoBean> bienes=new ArrayList<VehiculoBean>();
		if(bienServ.asignarInmueble(idSospechoso,idBien)){
			return true;
		}else{
			return false;
		}
	}
	
	//buscar
	@RequestMapping(value = "getInmueblesPorSospechoso-{idSospechoso}", method = RequestMethod.POST)
	@ResponseBody
	public List<InmuebleBean> getInmueblesPorSospechoso(@PathVariable("idSospechoso") Integer idSospechoso){
		List<InmuebleBean> bienes = new ArrayList<InmuebleBean>();
		bienes = bienServ.getInmueblesBuscarPorSospechoso(idSospechoso);
		return bienes;
	}
	//buscar
	@RequestMapping(value = "getVehiculosPorSospechoso-{idSospechoso}", method = RequestMethod.POST)
	@ResponseBody
	public List<VehiculoBean> getVehiculosPorSospechoso(@PathVariable("idSospechoso") Integer idSospechoso){
		List<VehiculoBean> bienes = new ArrayList<VehiculoBean>();
		bienes = bienServ.getVehiculosBuscarPorSospechoso(idSospechoso);
		return bienes;
	}
	
	//sospechosos bien
	@RequestMapping(value = "sospechososBien-{idBien}", method = RequestMethod.POST)
	@ResponseBody
	public List<SospechosoBean> sospechososBien(@PathVariable("idBien") Integer idBien){
		List<SospechosoBean> sos = new ArrayList<SospechosoBean>();
		sos = sosServ.getSospechososBien(idBien);
		return sos;
	}
	
}
