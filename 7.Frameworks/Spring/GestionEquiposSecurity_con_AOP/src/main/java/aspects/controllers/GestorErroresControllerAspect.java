package aspects.controllers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import dao.EstadoDAO;

@ControllerAdvice
public class GestorErroresControllerAspect {

	
	@Autowired
	EstadoDAO estadoDAO;
	
	public GestorErroresControllerAspect(){
		System.out.println("GestorErroresController iniciandose");
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView gestionaErroresControladores(Exception e){
		System.out.println("Advice gestion errores controladores read ejecutandose");
		ModelAndView mv=new ModelAndView("dbdown");
		
		if(estadoDAO.getEstado()==EstadoDAO.Estado.DOWN){
			return mv;
		}
		else{
			return new ModelAndView("problemaindeterminado");
		}
		
		
	}
}
