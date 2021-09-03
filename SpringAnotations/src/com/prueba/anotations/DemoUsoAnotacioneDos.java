package com.prueba.anotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.interfaces.IEmpleados;

public class DemoUsoAnotacioneDos {

	public static void main(String[] args) {
		// 1) cargamos el xml de configuracion de Spring
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2) solicitamos un bean al contenedor de Spring
		IEmpleados comercialJose = contexto.getBean("comercialExperimentado", IEmpleados.class);
		IEmpleados comercialPedro = contexto.getBean("comercialExperimentado", IEmpleados.class);

		// comprobamos si los dos objetos apuntan a la misma direccion de memoria
		System.out.println("Direcciones de memoria : ");
		System.out.println(comercialJose + "\n" + comercialPedro);

		if (comercialJose == comercialPedro) {
			System.out.println("Singleton: apuntan al mismo lugar de memoria");
		} else {
			System.out.println("Prototype: apuntan a distintos lugares de memoria , son dos instancias diferentes");
		}

		// 3) Utilizamos el bean
		System.out.println("Utilizamos nuestro bean generado con anotaciones!");
		System.out.println(comercialJose.getTareas());
		System.out.println(comercialJose.getInforme());

		// 4) cerramos el contexto y liberamos los recursos
		contexto.close();

	}

}
