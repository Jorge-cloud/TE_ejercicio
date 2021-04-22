
package com.emergentes.controladores;

import com.emergentes.modelo.Ciudades;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "Main_ciudades", urlPatterns = {"/Main_ciudades"})
public class Main_ciudades extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bd_ejercicio";
        String usuario = "root";
        String password = "";
        
        Connection conn = null;
        String sql ="";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Ciudades> lista = new ArrayList<Ciudades>();
        try{
            Class.forName(driver);
            
            conn = (Connection) DriverManager.getConnection(url,usuario,password);
            
            sql="select * from ciudades";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next()){
                Ciudades c = new Ciudades();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setCapital(rs.getString("capital"));
                c.setHabitantes(rs.getInt("habitantes"));
                lista.add(c);
                System.out.println(c.getId());
            }
            request.setAttribute("lista_ciudades", lista);
            request.getRequestDispatcher("/vistas/ciudades.jsp").forward(request, response);
        }catch(ClassNotFoundException e){
            System.out.println("Error en Driver"+e.getMessage());
        }catch(SQLException e){
            System.out.println("Error al conectar"+e.getMessage());
        }
        
    }
        
    

}
