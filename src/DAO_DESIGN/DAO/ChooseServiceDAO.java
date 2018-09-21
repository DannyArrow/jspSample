package DAO_DESIGN.DAO;

import DAO_DESIGN.Model.*;
import DAO_DESIGN.interfaces.ChooseserviceDAOI;
import DAO_DESIGN.testdatabase.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.jdbc.Statement;

public class ChooseServiceDAO extends OracleConnection implements ChooseserviceDAOI {
    @Override
    public int insert_order(Order_table table) throws SQLException {
       int key = 0;
//3
//6
        String insert_neworder = String.format("insert into order_table(dateorder,amount_of_bags,amount_of_dryitem,washfold_total,drycleaning_total,total_pounds,laundrycarepackage_id,drycleaning,pickup_status,dropoff_status,cancelorder,driver_on_its_way,pickup_time,pickupdate,dropoff_time,dropoffdate,personless_pickup,personless_dropoff,pickupnotes,dropoffnotes,customerid,pickup_Driver,dropoff_drivers,payment_id)values (?,null,null,null,null,null,?,?,true,false,false,false,?,?,?,?,?,?,?,?, ?,null,null,?)");  //4


        PreparedStatement preparedStatement = getConnection().prepareStatement(insert_neworder, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setDate(1,table.getDateorder());
        preparedStatement.setInt(2,table.getLaundrycarepackage_id());
        preparedStatement.setBoolean(3,table.isDrycleaning());
        preparedStatement.setString(4,table.getPickup_time());
        preparedStatement.setString(5,table.getPickupdate());
        preparedStatement.setString(6,table.getDropoff_time());
        preparedStatement.setString(7,table.getDropoffdate());
        preparedStatement.setBoolean(8,table.isPersonless_pickup());
        preparedStatement.setBoolean(9,table.isPersonless_dropoff());
        preparedStatement.setString(10,table.getPickupnotes());
        preparedStatement.setString(11,table.getDropoffnotes());
        preparedStatement.setInt(12,table.getCustomerid());
        preparedStatement.setInt(13,table.getPayment_id());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            key = resultSet.getInt(1);
        }

         return key;
    }

    @Override
    public int insertpayment(Payment payment) throws SQLException {
        int key =0 ;
        String insert_payment = String.format("insert into payment(billingname,credit_card_number,expire_date,payment_type)\nvalues(?,?,?,?)");
        PreparedStatement preparedStatement = getConnection().prepareStatement(insert_payment, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,payment.getBillingname());
        preparedStatement.setLong(2,payment.getCredit_card_number());
        preparedStatement.setString(3,payment.getExpire_date());
        preparedStatement.setString(4,payment.getPaymenttype());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
          key = resultSet.getInt(1);
        }

        return key;
    }

    @Override
    public int insertinto_customwashdetails(CustomWashDetails customWashDetails) throws SQLException {

        int key = 0;
      String insert_customwashdetails = String.format("insert into customwashdetails(orderid,whitetemperature,colortemprature,colorheat,whiteheat,soapID,softnerID)\nvalues(?,?,?,?,?,?,?)");

        PreparedStatement preparedStatement = getConnection().prepareStatement(insert_customwashdetails);
        preparedStatement.setInt(1,customWashDetails.getOrder_ID());
        preparedStatement.setString(2,customWashDetails.getWhitetemperature());
        preparedStatement.setString(3,customWashDetails.getColortemperature());
        preparedStatement.setString(4,customWashDetails.getColorheat());
        preparedStatement.setString(5,customWashDetails.getWhiteheat());
        preparedStatement.setInt(6,customWashDetails.getSoapID());
        preparedStatement.setInt(7,customWashDetails.getSoftnerID());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()){
            key = resultSet.getInt(1);
        }

        return key;
    }

    public List<Payment> userpayments(int CustomerID) throws SQLException {
        String sql = String.format("select payment.payment_id,payment.billingname, payment.credit_card_number, payment.expire_date,payment.payment_type from Customer \njoin order_table on order_table.customerid = Customer.CustomerID\njoin payment on payment.payment_id = order_table.payment_id where Customer.CustomerID = ?");
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setInt(1,CustomerID);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Payment> listpayment = new ArrayList<>();
        while (resultSet.next()){
            Payment payment = new Payment();
            payment.setPaymentID(resultSet.getInt(1));
            payment.setBillingname(resultSet.getString(2));
            payment.setCredit_card_number(resultSet.getLong(3));
            payment.setExpire_date(resultSet.getString(4));
            payment.setPaymenttype(resultSet.getString(5));
            listpayment.add(payment);
        }

        return listpayment;


    }

    public List<Soap> soapList() throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("select * from soap");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Soap> soapArrayList = new ArrayList<>();
        while (resultSet.next()){
            soapArrayList.add(new Soap(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3)));
        }

        return soapArrayList;

    }

    public List<Softner> softnerList() throws SQLException{
        PreparedStatement preparedStatement = getConnection().prepareStatement("select * from softner");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Softner> softnerArrayList = new ArrayList<>();
        while (resultSet.next()){
            softnerArrayList.add(new Softner(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3)));
        }
        return softnerArrayList;
    }

}
