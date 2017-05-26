package com.pajaro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOPajaro;
import modelos.Pajaro;
import modelos.Pajaro.SO;

@Controller
public class PajarosController {

	@Autowired
	DAOPajaro daop;
	
	@RequestMapping(value = {"/", "/index"})
	public ModelAndView index(HttpSession sesion){
		List<Pajaro> lista;
		lista = daop.listar();
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("lista", lista);
		return mv;
	}
	
	@RequestMapping(value = {"formModif"})
	public ModelAndView formModificar(HttpSession sesion, 
			@RequestParam(value = "id") int id){
		System.out.println(id);
		ModelAndView mv = new ModelAndView("formularioModificar");
		mv.addObject("id", id);
		return mv;
	}
	
	@RequestMapping(value={"modificar"})
	public ModelAndView modificar(HttpSession sesion,HttpServletResponse rs,
			@RequestParam(value = "id")String idS,
			@RequestParam(value = "especie")String especie,
			@RequestParam(value = "familia")String familia,
			@RequestParam(value = "superorden")String superorden){
		
		int id = Integer.parseInt(idS);
		
		SO so;
		if(superorden.equals("PALEOGNATA")){
			so = SO.PALEOGNATA;
		}else if(superorden.equals("IMPENNES")){
			so = SO.IMPENNES;
		}else{so = SO.NEOGNATA;}
		
		Pajaro p = new Pajaro(id, especie, familia, so);
		
		daop.update(p);
		
		try {
			rs.sendRedirect("/Ornitologia/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = {"formInsertar"})
	public ModelAndView formInsertar(HttpSession sesion){
		ModelAndView mv = new ModelAndView("formularioInsertar");
		return mv;
	}
	
	@RequestMapping(value = {"insertar"})
	public ModelAndView insertar(HttpSession sesion, HttpServletResponse rs,
			@RequestParam("especie")String especie,
			@RequestParam("familia")String familia,
			@RequestParam("superorden")String superorden){
		
		SO so;
		if(superorden.equals("PALEOGNATA")){
			so = SO.PALEOGNATA;
		}else if(superorden.equals("IMPENNES")){
			so = SO.IMPENNES;
		}else{so = SO.NEOGNATA;}
		
		Pajaro p = new Pajaro(especie, familia, so);
		
		daop.create(p);
		
		try {
			rs.sendRedirect("/Ornitologia/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value ={"borrar"})
	public ModelAndView borrar(HttpSession sesion, HttpServletResponse rs,
			@RequestParam("id")String idS){
		int id = Integer.parseInt(idS);
		daop.delete(id);
		try {
			rs.sendRedirect("/Ornitologia/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

