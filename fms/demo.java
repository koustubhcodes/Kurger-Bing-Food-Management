package fms;

import java.sql.*;

public class demo
{
    public static void main(String[] args) throws Exception
    {
        String query = "select password from login where username = user1";
        Connection c;
        Statement s;
        Class.forName("com.mysql.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jproject","root","doge9@shibuya.com");
        s = c.createStatement();
        ResultSet rs = s.executeQuery(query);
        String i = rs.getString("password");
        rs.next();
        System.out.println(i);
        s.close();
        c.close();
    }
}

