package br.com.entra21java.web.alunos;

import br.com.entra21java.bean.AlunoBean;
import br.com.entra21java.dao.AlunoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Rodrigo
 */
@WebServlet("/alunos")
public class AlunoIndex extends HttpServlet {

    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        out = resp.getWriter();
        List<AlunoBean> alunos = new AlunoDAO().obterAlunos();
        out.println("<!DOCTYPE html>");
        out.println("<link rel='stylesheet' type='text/css' href='bootstrap/css/bootstrap.css'/>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Alunos - Lista</title>");
        out.println("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.2.0/css/all.css' integrity='sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ' crossorigin='anonymous'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container-fluid'>");
        out.println("");
        out.println("<div class='row'>");
        out.println("<div class='col-md-12'>");
        out.println("<h3 class='text-center'>Lista de Alunos</h3>");
        out.println("</div>");
        out.println("</div>");
        out.println("");
        out.println("<div class='row'>");
        out.println("<div class='col-md-2 offset-md-10'>");
        out.println("<a href='/Exercicio00/alunos/cadastro'"
                + " class='btn btn-primary float-right'><i class='fa fa-user-graduate'></i> Novo Aluno</a>");
        out.println("</div>");
        out.println("</div>");
        
        gerarTabela(alunos);
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
    private void gerarTabela(List<AlunoBean> alunos) {
        out.println("<div>");
        out.println("<div>");
        
        out.println("<table class='table table-hover table-dark'");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Código de Matrícula</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Nota 1</th>");
        out.println("<th>Nota 2</th>");
        out.println("<th>Nota 3</th>");
        out.println("<th>Média</th>");
        out.println("<th>Frequência</th>");
        out.println("<th>Ação</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for (AlunoBean aluno : alunos) {
            out.println("<tr>");
            out.println("<td>" + aluno.getCodigoMatricula() + "</td>");
            out.println("<td>" + aluno.getNome() + "</td>");
            out.println("<td>" + aluno.getNota1() + "</td>");
            out.println("<td>" + aluno.getNota2() + "</td>");
            out.println("<td>" + aluno.getNota3() + "</td>");
            out.println("<td>" + aluno.getMedia() + "</td>");
            out.println("<td>" + aluno.getFrequencia() + "%" + "</td>");
            out.println("<td>");
            
            out.println("<a href='/Exercicio00/alunos/editar?id=" + aluno.getId() 
                    + "' class='btn btn-outline-success'><i class='fa fa-edit'></i></a>");
            out.println("<a href='/Exercicio00/alunos/excluir?id=" + aluno.getId()
                    + "' class='btn btn-outline-danger'><i class='fa fa-trash-alt'></i></a>");
            
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("<tfoot>");
        out.println("<tr>");
        out.println("<th>Código de Matrícula</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Nota 1</th>");
        out.println("<th>Nota 2</th>");
        out.println("<th>Nota 3</th>");
        out.println("<th>Média</th>");
        out.println("<th>Frequência</th>");
        out.println("<th>Ação</th>");
        out.println("</tr>");
        out.println("</tfoot>");
        out.println("</table>");
        out.println("</div>");
        out.println("</div>");
    }

}
