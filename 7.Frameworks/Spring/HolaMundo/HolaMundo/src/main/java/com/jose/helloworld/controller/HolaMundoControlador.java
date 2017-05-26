package com.jose.helloworld.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOCliente;
import modelos.Cliente;

@Controller
@SessionAttributes("usuario") //Creara la sesion con el usuario "usuario"
public class HolaMundoControlador {
	
	@Autowired
	DAOCliente daoCliente;

	@RequestMapping("/hola") //Es como accceder al metodo en el buscador
	public ModelAndView muestraMensaje(
			HttpSession sesion,
			@RequestParam(value="nombre", required=false, defaultValue="Mundo")String nombre){
			
		ModelAndView mv = new ModelAndView("holamundo");
		Cliente c = daoCliente.read(1);
		
		mv.addObject("mensaje","Bienvenido al MVC de Spring");
		mv.addObject("nombre",nombre);
		
		//Añadimos el usuario a la sesion
		sesion.setAttribute("usuario", nombre);
		
		List<Cliente> lista = daoCliente.listar();
		mv.addObject("lista",lista);
		
		return mv;
	}
}
