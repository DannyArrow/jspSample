package springwork.controller;


import DAO_DESIGN.DAO.ChooseServiceDAO;
import DAO_DESIGN.DAO.CityDao;
import DAO_DESIGN.Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import springwork.model.User;

import javax.validation.Valid;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("userkey")
public class IndexController 
{
	Customer customer;
	Order_table order_table = new Order_table();
	@RequestMapping("/")
	public ModelAndView index() 
	{
		ModelAndView mav = new ModelAndView("welcome");
		return mav;
	}

	// check weather user is within an area and display a jsp page depending on the input of the user zip code
	@RequestMapping(value = "/user_area", method=RequestMethod.POST)
	public ModelAndView user_area(@RequestParam("zipcode") String user_zipcode )
	{
		ModelAndView mav = null;
		ArrayList<String> list = new ArrayList();
		list.add("10601"); list.add("10602"); list.add("10603"); list.add("10604"); list.add("10605"); list.add("10606"); list.add("10607"); list.add("10610");
		if(list.contains(user_zipcode)){
			mav = new ModelAndView("form_register");
			mav.addObject("command",new Form_register());

		}else{
			mav = new ModelAndView("NotinArea");
		}
		return mav;
	}



	@ModelAttribute("citylist")
	public List<String> getNumbersList() throws SQLException {
		List<String> numbersList = new CityDao().querycity();

		return numbersList;
	}
    @ModelAttribute("soaplist")
    public List<Soap> soapList() throws SQLException {
        return new ChooseServiceDAO().soapList();
    }

    @ModelAttribute("softnerlist")
    public List<Softner> softnerList() throws SQLException {
        return new ChooseServiceDAO().softnerList();
    }


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("command") @Valid Form_register form_register, BindingResult theBindingResult) throws SQLException {
         String page = null;

		if (theBindingResult.hasErrors()) {
			page = "form_register";
		} else {

			customer = FunctionDAO.add_customerToDatabase(form_register);

			if (customer != null) {
				page = "pick_service";
			}

		}
		return page;
	}

	@RequestMapping(value = "/service", method = RequestMethod.POST)
	public ModelAndView service(@RequestParam("service")String service)
	{
		if(service.equalsIgnoreCase("drycleaning") || service.equalsIgnoreCase("washfold&drycleaning")){
			order_table.setDrycleaning(true);
		}else {
			order_table.setDrycleaning(false);
		}

		//set the date of when the order was made
		java.util.Date date = new java.util.Date();
		Date sqlDate = new Date(date.getTime());
		order_table.setDateorder(sqlDate);

        ModelAndView modelAndView = new ModelAndView("choosepackage");
        return modelAndView;
    }





    @RequestMapping(value = "/package",method = RequestMethod.POST)
    public ModelAndView laundrypackage(@RequestParam("laundrycarepackage") String pack)
    {
        ModelAndView modelAndView = new ModelAndView("soap&fabric");
        if(pack.equalsIgnoreCase("custompackage")){

            modelAndView.addObject("soap",new Soap());
            modelAndView.addObject("softnerr",new Softner());
            return modelAndView;
        }

        return null;
    }

    @RequestMapping(value = "")




	 /*Very important Function*/
	@ModelAttribute("userkey")
	public User setUpUserForm()
	{
		return new User();
	}
	
	
	@RequestMapping(value = "/userInfo_confirm", method=RequestMethod.POST)
	public ModelAndView userInfo_confirm(@ModelAttribute("userkey")User u ) 
	{	ModelAndView mav = new ModelAndView("UserAccountPage");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/modify", method=RequestMethod.GET)
	public ModelAndView user_info_modify() 
	{
		ModelAndView mav = new ModelAndView("UserAccountModify");
		return mav;
	}
	
	
	
	@RequestMapping(value = "/submit_changes", method=RequestMethod.POST)
	public String user_info_changes(@ModelAttribute User u, @SessionAttribute("userkey") User ukey ) 
	{	
		if (u.getPassword().equals(ukey.getPassword()))
		{
			return "redirect:modify";
		}
		ukey.setPassword(u.getPassword());
		return "UserAccountPage";
	}

	
	
	
	
	
	
	
	
	

}