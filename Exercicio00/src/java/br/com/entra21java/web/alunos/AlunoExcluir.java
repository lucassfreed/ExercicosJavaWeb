package br.com.entra21java.web.alunos;

import br.com.entra21java.dao.AlunoDAO;
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
@WebServlet("/alunos/excluir")
public class AlunoExcluir extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean apagou = new AlunoDAO().apagar(id);
        if (apagou) {
            resp.getWriter().println("Aluno apagado com sucesso!");
        } else {
            resp.getWriter().println("Não foi possível apagar este aluno...");
        }
    }
}
