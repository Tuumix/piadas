/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import bd.dal.DALUsuario;
import bd.entidades.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(
    location="/", 
    fileSizeThreshold=1024*1024,    // 1MB *      
    maxFileSize=1024*1024*100,      // 100MB **
    maxRequestSize=1024*1024*10*10  // 100MB ***
)

@WebServlet(name = "cadastra_usu", urlPatterns = {"/cadastra_usu"})
public class cadastra_usu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            Usuario usu;
            String nome, email, senha;
            DALUsuario dalusu = new DALUsuario();
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            senha = request.getParameter("senha");
            usu = new Usuario(nome, email, senha, null, false);
            
            if (dalusu.salvar(usu)) {
                try
                {
                    // recebe a foto
                Part foto = request.getPart("foto");
                // cria um vetor para armazenar a foto
                byte[] imagem=new byte[(int)foto.getSize()];
                // carrega o vetor com os bytes da foto
                foto.getInputStream().read(imagem);
                // cria um arquivo com o mesmo nome da foto e grava o vetor como seu conteúdo
                FileOutputStream arquivo = new FileOutputStream(new File(getServletContext().getRealPath("/") + "/"+ "fotos_usuario/" + dalusu.getCod(email)+".jpg"));
                arquivo.write(imagem);
                arquivo.close();
                session.setAttribute("usuario", usu);
                response.sendRedirect("index.jsp");
                }
                catch(Exception e){
                    out.print(e.getMessage());}
            }
            else
                response.sendRedirect("./");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
