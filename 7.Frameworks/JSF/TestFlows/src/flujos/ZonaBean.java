package flujos;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named("zonaBean")
@FlowScoped("zona")
public class ZonaBean implements Serializable{
	public static final long serialVersionIUD=1L;
	
	public String getAccionTerminar(){
		
		return "/zona-return.xhtml";
	}
}
