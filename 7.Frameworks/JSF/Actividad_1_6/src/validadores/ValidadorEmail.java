package validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validadorEmail")
public class ValidadorEmail implements Validator{
	private final static String PATRON_EMAIL= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    private final static Pattern EMAIL_COMPILED_PATTERN = Pattern.compile(PATRON_EMAIL);
     
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object o) throws ValidatorException {

	    
	     if (o == null || "".equals((String)o)) {
	            FacesMessage msg = new FacesMessage("No email value!", "Email Validation Error");
	            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	            throw new ValidatorException(msg);
	        }
	         
	        // The email matcher
	        Matcher matcher = EMAIL_COMPILED_PATTERN.matcher((String)o);
	         
	        if (!matcher.matches()) {   // Email doesn't match
	            FacesMessage msg = new FacesMessage("Invalid email value!", "Email Validation Error");
	            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	            throw new ValidatorException(msg);
	        }
	         
	    
	}

	
	
}
