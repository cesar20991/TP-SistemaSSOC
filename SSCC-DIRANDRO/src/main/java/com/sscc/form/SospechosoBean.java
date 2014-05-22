package com.sscc.form;

import java.sql.Date;
import java.sql.Timestamp;

public class SospechosoBean {

	private Integer idSospechoso;
	
	private String codigoUnicoDeIdentificacion;
	private String primerApellido;
	private String segundoApellido;
	private String preNombres;
	private String alias;
	private String sexo;//F = femenino, M = masculino
	private Date fechaDeNacimiento;
	private String departamentoDeNacimiento;
	private String provinciaDeNacimiento;
	private String distritoDeNacimiento;
	private String gradoDeInstruccion;
	private String estadoCivil;//comboBox: Soltero, Casado, Divorciado, Viudo
	private Double estatura;
	private Date fechaDeInscripcion;
	private String nombrePadre;
	private String nombreMadre;
	private Date fechaDeEmision;
	private String restriccion;
	private String domicilio;
	private String departamentoDeDomicilio;
	private String provinciaDeDomicilio;
	private String distritoDeDomicilio;
	private Integer multasElectorales;
	private String estado;
	private Timestamp fecCreacionSospechoso;
	
	public Integer getIdSospechoso() {
		return idSospechoso;
	}
	public void setIdSospechoso(Integer idSospechoso) {
		this.idSospechoso = idSospechoso;
	}
	public String getCodigoUnicoDeIdentificacion() {
		return codigoUnicoDeIdentificacion;
	}
	public void setCodigoUnicoDeIdentificacion(String codigoUnicoDeIdentificacion) {
		this.codigoUnicoDeIdentificacion = codigoUnicoDeIdentificacion;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getPreNombres() {
		return preNombres;
	}
	public void setPreNombres(String preNombres) {
		this.preNombres = preNombres;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getDepartamentoDeNacimiento() {
		return departamentoDeNacimiento;
	}
	public void setDepartamentoDeNacimiento(String departamentoDeNacimiento) {
		this.departamentoDeNacimiento = departamentoDeNacimiento;
	}
	public String getProvinciaDeNacimiento() {
		return provinciaDeNacimiento;
	}
	public void setProvinciaDeNacimiento(String provinciaDeNacimiento) {
		this.provinciaDeNacimiento = provinciaDeNacimiento;
	}
	public String getDistritoDeNacimiento() {
		return distritoDeNacimiento;
	}
	public void setDistritoDeNacimiento(String distritoDeNacimiento) {
		this.distritoDeNacimiento = distritoDeNacimiento;
	}
	public String getGradoDeInstruccion() {
		return gradoDeInstruccion;
	}
	public void setGradoDeInstruccion(String gradoDeInstruccion) {
		this.gradoDeInstruccion = gradoDeInstruccion;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Double getEstatura() {
		return estatura;
	}
	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}
	public Date getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}
	public void setFechaDeInscripcion(Date fechaDeInscripcion) {
		this.fechaDeInscripcion = fechaDeInscripcion;
	}
	public String getNombrePadre() {
		return nombrePadre;
	}
	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}
	public String getNombreMadre() {
		return nombreMadre;
	}
	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}
	public Date getFechaDeEmision() {
		return fechaDeEmision;
	}
	public void setFechaDeEmision(Date fechaDeEmision) {
		this.fechaDeEmision = fechaDeEmision;
	}
	public String getRestriccion() {
		return restriccion;
	}
	public void setRestriccion(String restriccion) {
		this.restriccion = restriccion;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getDepartamentoDeDomicilio() {
		return departamentoDeDomicilio;
	}
	public void setDepartamentoDeDomicilio(String departamentoDeDomicilio) {
		this.departamentoDeDomicilio = departamentoDeDomicilio;
	}
	public String getProvinciaDeDomicilio() {
		return provinciaDeDomicilio;
	}
	public void setProvinciaDeDomicilio(String provinciaDeDomicilio) {
		this.provinciaDeDomicilio = provinciaDeDomicilio;
	}
	public String getDistritoDeDomicilio() {
		return distritoDeDomicilio;
	}
	public void setDistritoDeDomicilio(String distritoDeDomicilio) {
		this.distritoDeDomicilio = distritoDeDomicilio;
	}
	public Integer getMultasElectorales() {
		return multasElectorales;
	}
	public void setMultasElectorales(Integer multasElectorales) {
		this.multasElectorales = multasElectorales;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Timestamp getFecCreacionSospechoso() {
		return fecCreacionSospechoso;
	}
	public void setFecCreacionSospechoso(Timestamp fecCreacionSospechoso) {
		this.fecCreacionSospechoso = fecCreacionSospechoso;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
}