package com.coche.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOCoche;
import modelo.Coche;

@Controller
public class CocheController {
	@Autowired
	DAOCoche daoc;
	
	@RequestMapping(value = {"/", "index"})
	public ModelAndView index(HttpSession sesion){
		List<Coche> lista;
		lista = daoc.listar();
		
		ModelAndView mv = new ModelAndView("listar");
		mv.addObject("lista", lista);
		
		return mv;
	}
	
	@RequestMapping(value={"formEditar"})
	public ModelAndView formModificar (HttpSession sesion, 
			@RequestParam(value="matricula")String matricula){
		ModelAndView mv = new ModelAndView("editar");
		mv.addObject("matricula", matricula);
		return mv;
	}
	
	@RequestMapping(value={"modificar"})
	public ModelAndView modificar(HttpSession sesion, HttpServletResponse rs,
			@RequestParam(value = "matricula")String matricula,
			@RequestParam(value= "modelo")String modelo,
			@RequestParam(value="fechamatriculacion")String fechaStr,
			@RequestParam(value="km")String kmStr,
			@RequestParam(value="precio")String precioStr){
		
		ModelAndView mv = null;
		int km = 0;
		double precio = 0;
		try{
			km = Integer.parseInt(kmStr);
			precio = Double.parseDouble(precioStr);
		}catch(NumberFormatException ne){
			mv = new ModelAndView("errorDatos");
			return mv;
		}
		 
		SimpleDateFormat formatter = new SimpleDateFormat("y-M-d");
		Date date = null;
        try {
            date = formatter.parse(fechaStr);
        } catch (ParseException e) {
			mv = new ModelAndView("errorDatos");
			return mv;
        }

	   
        if(matricula.trim().equals("")||modelo.trim().equals("")){
	    	mv = new ModelAndView("errorDatos");
			return mv;
	    }
	    
	    
	    
		Coche c = new Coche(matricula,modelo,date,km,precio);
		boolean modificar = daoc.update(c);
		System.out.println(modificar);
		
		if(modificar){
			try {
				rs.sendRedirect("/CasoPracticoFinal/");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			mv = new ModelAndView("errorDatos");
			return mv;
		}
		
		return null;
		
	}
	
	@RequestMapping(value = {"formInsertar"})
	public ModelAndView formInsertar(HttpSession sesion){
		ModelAndView mv = new ModelAndView("crear");
		return mv;
	}
	
	@RequestMapping(value= {"crear"})
	public ModelAndView borrar(HttpSession sesion, HttpServletResponse rs,
			@RequestParam("matricula")String matricula,
			@RequestParam("modelo")String modelo,
			@RequestParam("fechamatriculacion")String fechaStr,
			@RequestParam("km")String kmStr,
			@RequestParam("precio")String precioStr){
		
		ModelAndView mv = null;
		int km = 0;
		double precio = 0;
		try{
			km = Integer.parseInt(kmStr);
			precio = Double.parseDouble(precioStr);
		}catch(NumberFormatException ne){
			mv = new ModelAndView("errorDatos");
			return mv;
		}
		 
		SimpleDateFormat formatter = new SimpleDateFormat("y-M-d");
		Date date = null;
        try {
            date = formatter.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        if(matricula.trim().equals("")||modelo.trim().equals("")){
	    	mv = new ModelAndView("errorDatos");
			return mv;
	    }

		Coche c = new Coche(matricula,modelo,date,km,precio);
		boolean crear = daoc.create(c);
		
		if(crear){
			try {
				rs.sendRedirect("/CasoPracticoFinal/");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			mv = new ModelAndView("errorDatos");
			return mv;
		}
		return null;
	}
	
	@RequestMapping(value= {"volver"})
	public ModelAndView volver(HttpSession sesion,HttpServletResponse rs){
		try {
			rs.sendRedirect("/CasoPracticoFinal/");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
