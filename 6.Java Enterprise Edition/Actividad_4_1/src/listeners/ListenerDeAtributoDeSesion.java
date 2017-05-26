package listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ListenerDeAtributoDeSesion implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("Atributo añadido");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("Atributo eliminado");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("Atributo reemplazado");
	}

	
}
