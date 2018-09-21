package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstrain, String> {
   public void initialize(EmailConstrain constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return Validate_Email.validate(obj);
   }
}
