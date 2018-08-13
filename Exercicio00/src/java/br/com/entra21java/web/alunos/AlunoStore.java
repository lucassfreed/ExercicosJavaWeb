package br.com.entra21java.web.alunos;

import br.com.entra21java.bean.AlunoBean;
import br.com.entra21java.dao.AlunoDAO;
import br.com.entra21java.util.Util;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Rodrigo
 */
@WebServlet("/alunos/store")
public class AlunoStore extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String nome = req.getParameter("nome");
        float nota1 = Float.parseFloat(req.getParameter("nota_1"));
        float nota2 = Float.parseFloat(req.getParameter("nota_2"));
        float nota3 = Float.parseFloat(req.getParameter("nota_3"));
        float media = (nota1 + nota2 + nota3)/3;
        byte frequencia = Byte.parseByte(req.getParameter("frequencia"));
        
        AlunoBean aluno = new AlunoBean();
        aluno.setNome(nome);
        aluno.setNota1(nota1);
        aluno.setNota2(nota2);
        aluno.setNota3(nota3);
        aluno.setMedia(media);
        aluno.setFrequencia(frequencia);
        int codigo = new AlunoDAO().armazenar(aluno);
        
        if (codigo > 0)
            resp.sendRedirect("/Exercicio00/alunos");
    }
}
