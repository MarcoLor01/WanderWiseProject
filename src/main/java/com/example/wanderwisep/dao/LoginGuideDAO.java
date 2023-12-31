package com.example.wanderwisep.dao;

import com.example.wanderwisep.dao.db_connection.DBConnection;
import com.example.wanderwisep.exception.UserNotFoundException;
import com.example.wanderwisep.model.TouristGuide;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
public class LoginGuideDAO {

    public TouristGuide findGuide(String email, String password) throws UserNotFoundException, SQLException {
        PreparedStatement stmt = null;
        Connection conn = null;
        TouristGuide touristGuide;
        String sql = "SELECT * FROM touristguide WHERE email = ? AND password = ?";

        try {
            conn = DBConnection.getConnection();

            stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (!rs.first()) {
                throw new UserNotFoundException("User not found");
            }
            rs.first();
            String name = rs.getString("nome");
            String surname = rs.getString("cognome");
            String lingueparlateString = rs.getString("lingueparlate");
            List<String> lingueParlate = Arrays.asList(lingueparlateString.split(","));
            touristGuide = new TouristGuide(name, surname, email, lingueParlate);
            rs.close();
        } finally {
            if (stmt != null)
                stmt.close();

            if (conn != null)
                conn.close();
        }
        return touristGuide;
    }

}
