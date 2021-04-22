package com.emergentes.controladores;

import com.emergentes.modelo.Libros;
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
@WebServlet(name = "Main_libros", urlPatterns = {"/Main_libros"})
public class Main_libros extends HttpServlet {

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
        
        ArrayList<Libros> lista = new ArrayList<Libros>();
        try{
            Class.forName(driver);
            
            conn = (Connection) DriverManager.getConnection(url,usuario,password);
            
            sql="select * from libros";
            ps = (PreparedStatement) conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next()){
                Libros l = new Libros();
                l.setId(rs.getInt("id"));
                
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setIsbn(rs.getInt("isbn"));
                lista.add(l);
                System.out.println(l.getAutor());

            }
            request.setAttribute("libros", lista);
            request.getRequestDispatcher("/vistas/libros.jsp").forward(request, response);
        }catch(ClassNotFoundException e){
            System.out.println("Error en Driver"+e.getMessage());
        }catch(SQLException e){
            System.out.println("Error al conectar"+e.getMessage());
        }
        
    }

}
