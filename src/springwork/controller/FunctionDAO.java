package springwork.controller;

import DAO_DESIGN.DAO.CityDao;
import DAO_DESIGN.DAO.UserDAO;
import DAO_DESIGN.Model.Customer;
import DAO_DESIGN.Model.Form_register;
import Hashing.HashingPassword;

import java.sql.SQLException;

public class FunctionDAO {

    public static Customer add_customerToDatabase(Form_register form) throws SQLException {
        Customer customer = new Customer();
        customer.setFirstName(form.getFirstName());
        customer.setLastname(form.getLastname());

        customer.setEmail(form.getEmail());

        customer.setPassword(HashingPassword.hash(form.getPassword()));

        customer.setPhone(Long.parseLong(form.getPhone()));
        customer.setStreet(form.getStreet());


        customer.setCity(new CityDao().getcitytownkey(form.getCities()));

        customer.setState(form.getState());

        customer.setZip(Integer.parseInt(form.getZip()));

        customer.setType_of_building(form.getType_of_building());
        Customer userDAO = new UserDAO().register_customer(customer);
        return userDAO;
    }

}
