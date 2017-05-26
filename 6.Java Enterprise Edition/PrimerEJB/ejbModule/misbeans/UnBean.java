package misbeans;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class UnBean
 */
@Stateless
public class UnBean implements UnBeanRemote, UnBeanLocal {

    /**
     * Default constructor. 
     */
    public UnBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String decirHola(){
    	return "Hola";
    }

}
