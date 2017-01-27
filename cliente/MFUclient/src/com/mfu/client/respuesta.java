package com.mfu.client;

public class respuesta {
	private String accion, actor, hora ,banco;
	Boolean respuesta;

	public respuesta(String banco ,String accion, String actor, String hora, String respuesta) {
		// TODO Auto-generated constructor stub
		this.setBanco(banco);
		this.setAccion(accion);
		this.setActor(actor);
		this.setHora(hora);
		this.setRespuesta(respuesta);
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Boolean getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = Boolean.valueOf(respuesta);
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	

}
