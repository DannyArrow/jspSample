package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate_Email {
    public  static  final Pattern Valid_Email_Address_Regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailstr){
        Matcher matcher = Valid_Email_Address_Regex.matcher(emailstr);

        return (matcher.find() && (emailstr.length() > 3));
    }
}
