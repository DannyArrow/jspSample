package DAO_DESIGN.DAO;

import DAO_DESIGN.testdatabase.OracleConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao extends OracleConnection {

    public List<String> querycity() throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("select * from citytown");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> ls = new ArrayList<>();
        while (resultSet.next()){
            ls.add(resultSet.getString(2));
        }
        return ls;
    }

    public int getcitytownkey(String citytown) throws SQLException {
        String sql = "select * from citytown where citytown.name = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1,citytown);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);

    }
}
