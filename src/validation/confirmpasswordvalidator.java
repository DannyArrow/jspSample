package validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class confirmpasswordvalidator implements ConstraintValidator<Password, Object> {

   private String password;
   private String confirmpassword;

   public void initialize(Password constraint) {
      this.password = constraint.password();
      this.confirmpassword = constraint.verifypassword();
   }

   public boolean isValid(Object value, ConstraintValidatorContext context) {
      String pass1 = (String) new BeanWrapperImpl(value)
              .getPropertyValue(password);
      String pass2 = (String) new BeanWrapperImpl(value)
              .getPropertyValue(confirmpassword);

      return pass1.equals(pass2);

   }
}
