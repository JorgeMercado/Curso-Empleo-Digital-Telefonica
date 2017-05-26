package jstl;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class DobleNumero implements Tag {
	private double numero;
	private PageContext pageContext;

	public void setNumero(double numero) {
		this.numero = numero;
	}

	public void setParent(Tag t) {
	}

	public void setPageContext(PageContext p) {
		pageContext = p;
	}

	public void release() {
	}

	public Tag getParent() {
		return null;
	}

	public int doStartTag() {
		try {
			JspWriter out = pageContext.getOut();
			out.println("El doble de " + numero + " es " + (2 * numero));
		} catch (Exception e) {
		}

		return Tag.EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}