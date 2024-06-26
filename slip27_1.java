/*
Write a Java Program to display the details of College (CID, CName, address, Year) 
database table on JTable.
 */
package com.mycompany.javaslip;


import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;

class CollegeTable {
    private JFrame frame;
    private JTable table;
    
    CollegeTable() throws SQLException {
        frame = new JFrame("Project Table");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 150);
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        
        String[] colNames = {"cid", "cname", "address", "year"};
        String[][] data = retriveData(conn);
        
        table = new JTable(data, colNames);
        JScrollPane scrPane = new JScrollPane(table);
        
        frame.getContentPane().add(scrPane, BorderLayout.CENTER);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private String[][] retriveData(Connection conn) throws SQLException {
        String sql = "select * from college";

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();

        int noCol = rsmd.getColumnCount();
        rs.last();
        int noRow = rs.getRow();
        rs.beforeFirst();

        String[][] data = new String[noRow][noCol];

        int rowCnt = 0;
        while (rs.next()) {
            for (int i = 1; i <= noCol; i++)
                data[rowCnt][i - 1] = rs.getString(i); 
            rowCnt++;
        }
        return data;
    }

}

public class slip27_1
{
    public static void main(String[] args) throws SQLException {
        new CollegeTable();
    }
}
