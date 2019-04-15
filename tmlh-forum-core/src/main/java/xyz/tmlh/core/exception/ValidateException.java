package xyz.tmlh.core.exception;
import java.util.List;

import org.springframework.validation.ObjectError;

/**
 * <p>
 *      校验异常   
 * </p>
 *
 * @author TianXin
 * @since 2019年4月15日下午6:30:38
 */
public class ValidateException extends RuntimeException {

	private static final long serialVersionUID = 7207451175263593487L;
	
	private List<ObjectError> errors;
	
	public ValidateException(List<ObjectError> errors) {
		this.errors = errors;
	}

    public List<ObjectError> getErrors() {
		return errors;
	}

	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}

}
