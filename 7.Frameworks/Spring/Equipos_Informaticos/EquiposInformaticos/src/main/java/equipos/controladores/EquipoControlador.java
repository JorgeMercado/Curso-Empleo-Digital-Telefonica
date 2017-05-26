package equipos.controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DAOEquipo;
import dao.DAOUsuario;
import modelos.Equipo;
import modelos.Equipo.Tipo;
import modelos.Usuario;

@Controller
public class EquipoControlador {
	
	@Autowired
	DAOEquipo daoEquipo;
	
	@Autowired
	DAOUsuario daoUsuario;
	
	@RequestMapping("/login")
	public ModelAndView acceso(@RequestParam(value="nombre")String nombre,@RequestParam(value="password")String password, HttpSession sesion){
		ModelAndView mv = null;
		Usuario u = new Usuario(nombre);
		
		boolean ok = daoUsuario.login(u, password);		
		if(ok){
			sesion.setAttribute("usuario", u);
			mv = new ModelAndView("loginTrue");
		}else{
			sesion.setAttribute("usuario", null);
			mv = new ModelAndView("loginFalse");
		}
		return mv;
	}
	
	@RequestMapping("/listado")
	public ModelAndView session(HttpServletResponse response, HttpSession sesion){
		ModelAndView mv = null;

		Usuario usuario = (Usuario)sesion.getAttribute("usuario");
		if(usuario!=null){
			List<Equipo> lista = daoEquipo.listar();
			mv = new ModelAndView("listaCompleta");
			mv.addObject("lista", lista);
		}else{
			try {
				response.sendRedirect("formulariologin.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mv;
	}
	
	@RequestMapping("/addNew")
	public ModelAndView nuevo(HttpSession sesion, HttpServletResponse response,
			@RequestParam(value="tipo")Tipo tipo,
			@RequestParam(value="modelo")String modelo,
			@RequestParam(value = "ubicacion")String ubicacion,
			@RequestParam(value = "fecha")String fecha){
		ModelAndView mv = null;
			
			Usuario usuario = (Usuario)sesion.getAttribute("usuario");
			
		if(usuario == null){
			try {
				response.sendRedirect("formulariologin.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}				
		}else{
				SimpleDateFormat formatter = new SimpleDateFormat("y-M-d");
				Date date = null;
		        try {
		            date = formatter.parse(fecha);
		        } catch (ParseException e) {
		            e.printStackTrace();
		        }
			Equipo e = new Equipo(tipo, modelo, ubicacion, date);
				
			boolean ok = daoEquipo.create(e);
			if(ok){
				try {
					response.sendRedirect("listado");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else{
				mv = new ModelAndView("errorCrear");
			}
		}
		return mv;
	}
	
	
	@RequestMapping("borrar")
	public ModelAndView delete(HttpSession sesion,HttpServletResponse response,
			@RequestParam(value="idS")String idS){
		Usuario usuario = (Usuario)sesion.getAttribute("usuario");
		ModelAndView mv = null;

		if(usuario == null){
			try {
				response.sendRedirect("formulariologin.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			int id = Integer.parseInt(idS);
			boolean ok = daoEquipo.delete(id);
			if(ok){
				try {
					response.sendRedirect("listado");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				mv = new ModelAndView("errorBorrar");
			}
		}
		return mv;
	}
	
	@RequestMapping("check")
	public ModelAndView check(HttpSession sesion, HttpServletResponse response,
			@RequestParam(value="idS")String idS){
		
		ModelAndView mv = null;
		Usuario usuario = (Usuario)sesion.getAttribute("usuario");
		if(usuario == null){
			try {
				response.sendRedirect("formulariologin.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			mv = new ModelAndView("formularioUpdate");
			int id = Integer.parseInt(idS);
			Equipo e = daoEquipo.read(id);
			mv.addObject("tipos", Tipo.values());
			mv.addObject("equipo", e);
		}
		
		return mv;
	}
	
	@RequestMapping("update")
	public ModelAndView modificar(HttpSession sesion, HttpServletResponse response,
			@RequestParam(value="idS")String idS,
			@RequestParam(value="tipo")Tipo tipo,
			@RequestParam(value="modelo")String modelo,
			@RequestParam(value = "ubicacion")String ubicacion,
			@RequestParam(value = "fecha")String fecha){
		ModelAndView mv = null;
		int id = Integer.parseInt(idS);
		Usuario usuario = (Usuario)sesion.getAttribute("usuario");
		if(usuario == null){
			try {
				response.sendRedirect("formulariologin.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}				
		}else{
				SimpleDateFormat formatter = new SimpleDateFormat("y-M-d");
				Date date = null;
		        try {
		            date = formatter.parse(fecha);
		        } catch (ParseException e) {
		            e.printStackTrace();
		        }
			Equipo e = new Equipo(id, tipo, modelo, ubicacion, date);
				
			boolean ok = daoEquipo.update(e);
			if(ok){
				try {
					response.sendRedirect("listado");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else{
				mv = new ModelAndView("errorCrear");
			}
		}
		
		return mv;
	}
	
}
