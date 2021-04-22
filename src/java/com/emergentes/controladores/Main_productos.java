
package com.emergentes.controladores;

import com.emergentes.modelo.Productos;
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

@WebServlet(name = "Main_productos", urlPatterns = {"/Main_productos"})
public class Main_productos extends HttpServlet {


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
        
        ArrayList<Productos> lista = new ArrayList<Productos>();
        try{
            Class.forName(driver);
            
            conn = (Connection) DriverManager.getConnection(url,usuario,password);
            
            sql="select * from productos";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next()){
                Productos p = new Productos();
                p.setId(rs.getInt("id"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getFloat("precio"));
                p.setTipo(rs.getString("tipo"));
                lista.add(p);
                
            }
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/vistas/productos.jsp").forward(request, response);
        }catch(ClassNotFoundException e){
            System.out.println("Error en Driver"+e.getMessage());
        }catch(SQLException e){
            System.out.println("Error al conectar"+e.getMessage());
        }
        
    }
        
    

}
