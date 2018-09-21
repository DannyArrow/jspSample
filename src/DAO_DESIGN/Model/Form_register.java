package DAO_DESIGN.Model;

import org.hibernate.validator.constraints.Range;
import validation.Address;
import validation.EmailConstrain;
import validation.Password;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Address.Addressannotaion(
        @Address(
          city = "cities",
          address = "street",
          zipcode = "zip",
          message = "incorrect address"
        )
)
@Password.passlist(
        @Password(
            password = "password",
            verifypassword = "confirmpassword"
        )
)
public class Form_register {

    @NotNull(message="is required")
    @Size(min=1, message="is required")
   private String firstName;

    @NotNull(message="is required")
    @Size(min=1, message="is required")
   private String lastname;

    @NotNull(message="is required")
    @EmailConstrain
   private String email;

    @Pattern(regexp="^[0-9]{8,11}", message="only 8 to 11 digits")
    private String phone;

   @NotNull
   @Size(min =6, message = "password must have at least 6 characters")

  @Pattern(regexp = "^([a-zA-Z+]+[0-9+]+[&@!#+]+)$", flags = Pattern.Flag.UNICODE_CASE, message = "password needs least 1 letter, 1 number and 1 special character")
   private String password;
    @NotNull
    @Size(min =6, max = 30,
            message = "password must be between 6 to 30 characters")

   private String confirmpassword;

   private String street;
   private String streetdetails;
   private String cities;
   private String State;

   @Pattern(regexp="^[0-9]{5}", message="only 5 chars/digits")
   private String zip;

   private String type_of_building;

   public Form_register(){

   }
    public Form_register(String firstName, String lastname, String email, String phone, String password, String confirmpassword, String street, String streetdetails, String cities, String state, String zip, String type_of_building) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.street = street;
        this.streetdetails = streetdetails;
        this.cities = cities;
        this.State = state;
        this.zip = zip;
        this.type_of_building = type_of_building;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetdetails() {
        return streetdetails;
    }

    public void setStreetdetails(String streetdetails) {
        this.streetdetails = streetdetails;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getType_of_building() {
        return type_of_building;
    }

    public void setType_of_building(String type_of_building) {
        this.type_of_building = type_of_building;
    }
}
