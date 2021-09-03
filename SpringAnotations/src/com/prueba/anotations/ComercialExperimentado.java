package com.prueba.anotations;


// si no se puede resolver estos dos import debajo (javax.annotation...)  agregar el 
// jar javax.annotation-api-1.3.2.jar" , en las versiones de java 9 o superior no trae este paquete incorporado 

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.interfaces.CreacionInformesFinancieros;
import com.interfaces.IEmpleados;

//utilizamos una anotation y le definimos un id "comercialExperimenbtado"

@Component("comercialExperimentado")
//podemos prescindir de darle un id al component y spring tomaria como id el nombre de la clase pero con la primera
//letra en minuscula 
//@Scope("prototype")
public class ComercialExperimentado implements IEmpleados {

	// inyeccion de dependencias
	private CreacionInformesFinancieros informeNuevo;

	// si no ponemos el autowired para inyectar la dependencia y solo tenemos un
	// constructor , todo seguira funcionando
	// pero como recomendacion ponerlo SIEMPRE , asi cuando se escala la app y se
	// crean nuevo constructores
	// no se nos ROMPE!
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
		// utilizamos el metodo getInforme de la interface (que fue inyectado)
		return informeNuevo.getInformeFinanciero();
	}

	//Para usar las anotaciones  @PreDestroy y @PostConstruct SI o SI  debemos utilizar 
	//el scope SINGLETON , esto se debe a que spring no controla el ciclo de vida por
	//completo del beans si trabajamos con scope de tipo PROTOTYPE
	
	//ejecucion de codigo despues de la creacion de nuestro bean en el contenedor 
	@PostConstruct
	public void ejecutaDespuesCreacion() {
		System.out.println("Ejecutando tareas magicas tras la creacion del bean ");
	}

	//ejecucion de codigo despues del apagado del contenedor de Spring 
	@PreDestroy
	public void ejecutaAntesCreacion() {
		System.out.println("Ejecutando tareas cosmicas tras destruir el bean ");
	}

}
