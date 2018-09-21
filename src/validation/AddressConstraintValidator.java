package validation;


import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_street.Client;
import com.smartystreets.api.us_street.Lookup;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;
import java.util.ArrayList;

public class AddressConstraintValidator
		implements ConstraintValidator<Address, Object> {


	private String city;
	private String zipcode;
	private String address;



	@Override
	public void initialize(Address constraintAnnotation) {
         this.city = constraintAnnotation.city();
         this.zipcode = constraintAnnotation.zipcode();
         this.address = constraintAnnotation.address();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String city_value = (String) new BeanWrapperImpl(value)
				.getPropertyValue(city);
		String zipcode_value = (String) new BeanWrapperImpl(value)
				.getPropertyValue(zipcode);
		String address_value = (String) new BeanWrapperImpl(value)
				.getPropertyValue(address);
		System.out.println(city_value + " " + zipcode_value + " " + address_value);

		Boolean b = new ValidateAddress().Validate_Adress(address_value,city_value,zipcode_value);

		return  b;

		}
	}















