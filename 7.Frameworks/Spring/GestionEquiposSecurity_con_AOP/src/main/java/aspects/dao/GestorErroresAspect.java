package aspects.dao;

import java.util.ArrayList;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Component;

import dao.EstadoDAO;
import modelos.Equipo;
import modelos.User;

@Aspect
public class GestorErroresAspect {
	private final int maxReintentos=10;
	
	@Autowired
	EstadoDAO estadoDAO;
	
	public GestorErroresAspect(){
		System.out.println("GestorErrores iniciandose");
	}
	
	
	@Around("execution(* dao.*.create(..)) or execution(* dao.*.update(..)) or execution(* dao.*.delete(..)) or execution(* dao.DAOUser.recordPassword(..))")
	public Object gestionaReintentosUpdate(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Advice reintentos ejecutandose");
		int numIntentos=0;
		
		estadoDAO.setEstado(EstadoDAO.Estado.OK);
		Exception e;
        do {
        	numIntentos++;
            try {
            	System.out.println("Intento "+numIntentos);
                return pjp.proceed();
            }
            catch(Exception ex) {
                e=ex;
            }
        } while(numIntentos <= this.maxReintentos);
        System.out.println("Fallo");
        estadoDAO.setEstado(EstadoDAO.Estado.DOWN);
        throw e;
        
	}
	
	
	@Around("execution(* dao.*.read(..)) or execution(* dao.*.listar(..)) ")
	public Object gestionaReintentosRead(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Advice reintentos read ejecutandose");
		int numIntentos=0;
		
		estadoDAO.setEstado(EstadoDAO.Estado.OK);
		Exception e;
        do {
        	numIntentos++;
            try {
            	System.out.println("Intento "+numIntentos);
                return pjp.proceed();
            }
            catch(Exception ex) {
                e=ex;
            }
        } while(numIntentos <= this.maxReintentos);
        System.out.println("Fallo");
        estadoDAO.setEstado(EstadoDAO.Estado.DOWN);
        throw e;
        
	}
	
	
	
}