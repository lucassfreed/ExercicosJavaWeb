package br.com.entra21java.web.alunos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Rodrigo
 */
@WebServlet("/alunos/cadastro")
public class AlunoCadastro extends HttpServlet {
    
    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alunos - Cadastro</title>");
        out.println("<link rel='stylesheet' type='text/css' href='/Exercicio00/bootstrap/css/bootstrap.css'>");
        out.println("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.2.0/css/all.css' integrity='sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ' crossorigin='anonymous'>");
        out.println("<script src='/Exercicio00/alunos-cadastro.js'></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div clas='container-fluid'>");
        out.println("");
        out.println("<div class='row'>");
        out.println("<div class='col-md-12'>");
        out.println("<h3 class='text-center'>Cadastro</h3>");
        out.println("</div>");
        out.println("</div>");
        out.println("<form action='/Exercicio00/alunos/store' method='post' onsubmit='validarDados()'>");
        out.println("<div id='div-campo-nome' class='form-group'>");
        out.println("<label for='campo-nome'>Nome: <span class='text-danger' font-weight-bold>*</span></label>");
        out.println("<input class='form-control' type='text' class='form-control' id='campo-nome' name='nome' required='required' onfocusout='validarNome()'>");
        out.println("</div>");
        out.println("<div id='div-campo-nota1' class='form-group'>");
        out.println("<label for='campo-nota1'>Nota 1: <span class='text-danger' font-weight-bold>*</span></label>");
        out.println("<input class='form-control' type='text' class='form-control' id='campo-nota1' name='nota_1' required='required' onfocusout='validarNota1()'>");
        out.println("</div>");
        out.println("<div id='div-campo-nota2' class='form-group'>");
        out.println("<label for='campo-nota2'>Nota 2: <span class='text-danger' font-weight-bold>*</span></label>");
        out.println("<input class='form-control' type='text' class='form-control' id='campo-nota2' name='nota_2' required='required' onfocusout='validarNota2()'>");
        out.println("</div>");
        out.println("<div id='div-campo-nota3' class='form-group'>");
        out.println("<label for='campo-nota3'>Nota 3: <span class='text-danger' font-weight-bold>*</span></label>");
        out.println("<input class='form-control' type='text' class='form-control' id='campo-nota3' name='nota_3' required='required' onfocusout='validarNota3()'>");
        out.println("</div>");
        out.println("<div id='div-campo-frequencia' class='form-group'>");
        out.println("<label for='campo-frequencia'>Frequência: </label>");
        out.println("<input class='form-control' type='text' class='form-control' id='campo-frequencia' name='frequencia' onfocusout='validarFrequencia()'>");
        out.println("</div>");
        out.println("<input class='btn btn-success' type='submit' value='Cadastrar' required='required'>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }
}
