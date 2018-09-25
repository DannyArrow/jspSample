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

import javax.jws.WebParam;
import javax.validation.Valid;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("userkey")
public class IndexController 
{
    Customer customer = null;
	private  Order_table order_table = null;
	private CustomWashDetails customWashDetails = new CustomWashDetails();
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
        System.out.println("hi");
        return new ChooseServiceDAO().softnerList();

    }

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    @ModelAttribute("pickupdate")
    public HashMap<Integer,String> datepickup(){
        HashMap<Integer,String> datemap = new HashMap<>();
        for (int i = 1; i < 7; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, i);
            System.out.println(i + ": " + formatter.format(calendar.getTime()));
            datemap.put(i,formatter.format(calendar.getTime()));
            calendar = null;
        }


        return datemap;
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
	    this.order_table = new Order_table();
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

    @RequestMapping(value = "/soapfabric",method = RequestMethod.POST)
    public ModelAndView soapfabric (@RequestParam("soap") String soap, @RequestParam("softnerr") String softner)
    {
      ModelAndView modelAndView = new ModelAndView("customwash");
        System.out.println(soap + " ffdfd" + softner);
        customWashDetails.setSoapID(Integer.parseInt(soap));
        customWashDetails.setSoftnerID(Integer.parseInt(softner));

        return modelAndView;
    }



    @RequestMapping(value = "/customwash",method = RequestMethod.POST)
    public ModelAndView customwash(@RequestParam("color_washtemp") String colortemp, @RequestParam("color_dryer") String color_dryer,
                                   @RequestParam("white_washtemp") String whitetemp, @RequestParam("white_dryer") String white_dryer)
    {
	    customWashDetails.setColortemperature(colortemp);
	    customWashDetails.setColorheat(color_dryer);
	    customWashDetails.setWhiteheat(whitetemp);
	    customWashDetails.setWhiteheat(white_dryer);
	    ModelAndView modelAndView = new ModelAndView("schedulepickup");
	    return modelAndView;

    }


    HashMap<Integer,String> datemap;
  @RequestMapping(value = "/pickuptime", method = RequestMethod.POST)
    public ModelAndView pickup(@RequestParam("date")Integer date,@RequestParam("time") String time){
      System.out.println("date: " +date + " time:" +time);

      ModelAndView modelAttribute = new ModelAndView("scheduledropoff");

       datemap = new HashMap<>();
      for (int i = date; i < (date + 5); i++) {
          Calendar calendar = Calendar.getInstance();
          calendar.add(Calendar.DAY_OF_YEAR, i);
          System.out.println(i + ": " + formatter.format(calendar.getTime()));
          datemap.put(i,formatter.format(calendar.getTime()));
          calendar = null;
      }

      modelAttribute.addObject("dropoff",datemap);

      return modelAttribute;
  }

   @RequestMapping(value = "dropoff", method = RequestMethod.POST)
   public ModelAndView dropoff(@RequestParam("date")Integer date, @RequestParam("time")String time){
        ModelAndView modelAndView = new ModelAndView("personless");
        return modelAndView;
   }

   @RequestMapping(value = "personless", method = RequestMethod.POST)
   public ModelAndView personles(@RequestParam("pickup") String pickup){

      ModelAndView modelandview = new ModelAndView("notes");

       System.out.println(pickup);

     if("false pickup and dropoff".equalsIgnoreCase(pickup)){
         order_table.setPersonless_pickup(false);
         order_table.setPersonless_dropoff(false);
     } else if("true pickup and drop off".equalsIgnoreCase(pickup)){
         order_table.setPersonless_dropoff(true);
         order_table.setPersonless_pickup(true);
     }else if("true pickup".equalsIgnoreCase(pickup)){
         order_table.setPersonless_pickup(true);
         order_table.setPersonless_dropoff(false);
     }else if("false pickup".equalsIgnoreCase(pickup)){
         order_table.setPersonless_pickup(false);
         order_table.setPersonless_pickup(true);
     }

       return modelandview;

   }

    @RequestMapping(value = "instruction", method = RequestMethod.POST)
    public ModelAndView instruction(@RequestParam("pickupnotes") String pickupnotes, @RequestParam("dropoffnotes")String dropoffnotes){
      ModelAndView modelAndView = new ModelAndView("payment");
        System.out.println(pickupnotes);
        order_table.setDropoffnotes(dropoffnotes);
        order_table.setPickupnotes(pickupnotes);
        System.out.println(dropoffnotes);
        return modelAndView;
    }
}