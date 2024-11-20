package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Clientes;
import servicios.ClientesServiceImplement;
import servicios.ClientesServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/cliente.xls", "/clientehtml"})
public class ClienteXls extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClientesServices servicios = new ClientesServiceImplement();
        List<Clientes> clientes = servicios.listar();

        String servletPath = req.getServletPath();
        boolean xls = servletPath.equals("/cliente.xls");
        if (xls) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-disposition", "attachment; filename=clientes.xls");
        } else {
            resp.setContentType("text/html;charset=UTF-8");
        }

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Lista de Clientes</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Listado de Clientes</h1>");
        out.println("<p><a href=\"" + req.getContextPath() + "/cliente.xls" + "\">Descargar xls</a></p>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID CLIENTE</th>");
        out.println("<th>NOMBRE</th>");
        out.println("<th>APELLIDO</th>");
        out.println("<th>EMAIL</th>");
        out.println("</tr>");
        clientes.forEach(c -> {
            out.println("<tr>");
            out.println("<td>" + c.getIdCliente() + "</td>");
            out.println("<td>" + c.getNombre() + "</td>");
            out.println("<td>" + c.getApellido() + "</td>");
            out.println("<td>" + c.getEmail() + "</td>");
            out.println("</tr>");
        });
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
