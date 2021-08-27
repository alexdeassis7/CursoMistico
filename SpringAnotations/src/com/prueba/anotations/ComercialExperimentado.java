package com.prueba.anotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.interfaces.CreacionInformesFinancieros;
import com.interfaces.IEmpleados;

//utilizamos una anotation y le definimos un id "comercialExperimenbtado"

@Component("comercialExperimentado")
//podemos prescindir de darle un id al component y spring tomaria como id el nombre de la clase pero con la primera
//letra en minuscula 
@Scope("prototype")
public class ComercialExperimentado implements IEmpleados {

	// inyeccion de dependencias
	private CreacionInformesFinancieros informeNuevo;

	//si no ponemos el autowired para inyectar la dependencia y solo tenemos un constructor , todo seguira funcionando 
	//pero como recomendacion ponerlo SIEMPRE , asi cuando se escala la app y se crean nuevo constructores 
	//no se nos ROMPE!
	@Autowired
	public ComercialExperimentado(CreacionInformesFinancieros informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	@Override
	public String getTareas() {
		return "Soy un vendedor y me encargo de vender mucho , para que agustin labure!";
	}

	@Override
	public String getInforme() {
		//utilizamos el metodo getInforme de la interface  (que fue inyectado)
		return informeNuevo.getInformeFinanciero();
	}

}
