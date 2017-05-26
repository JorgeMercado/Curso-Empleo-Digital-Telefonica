package pajaros.controladores;

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
import modelos.Pajaro.Superorden;

@Controller
public class PajaroControlador {

	@Autowired
	DAOPajaro daoPajaro;
	
	@RequestMapping(value={"/principal","/"})
	public ModelAndView acceso(HttpServletResponse response, HttpSession sesion){
		ModelAndView mv = null;
		
		List<Pajaro> lista = daoPajaro.listar();
		mv = new ModelAndView("listaCompleta");
		mv.addObject("lista",lista);
		
		return mv;
	}
	@RequestMapping("/formNuevo") 
	public ModelAndView formNuevo(HttpServletResponse response, HttpSession sesion){
		ModelAndView mv = new ModelAndView("formularioNuevoPajaro");
		return mv;

	}

	@RequestMapping("/addNew")
	public ModelAndView nuevo(HttpServletResponse response, HttpSession sesion,
			@RequestParam(value="superorden")Superorden superorden,
			@RequestParam(value="familia")String familia,
			@RequestParam(value = "especie")String especie,
			@RequestParam(value = "numero")int numero){
		
		ModelAndView mv = null;
		
		Pajaro pajaro  = new Pajaro(superorden,familia,especie,numero);
		
		boolean ok = daoPajaro.create(pajaro);
		if(ok){
			try {
				response.sendRedirect("principal");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else{
			mv = new ModelAndView("errorCrear");
		}
		
		return mv;
	}
}
