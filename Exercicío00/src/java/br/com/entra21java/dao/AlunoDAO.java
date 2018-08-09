package br.com.entra21java.dao;

import br.com.entra21java.bean.AlunoBean;
import br.com.entra21java.database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lucas Rodrigo
 */
public class AlunoDAO {

    public int armazenar(AlunoBean aluno) {
        Connection conexao = Conexao.getConnection();
        if (conexao != null) {
            String sql = "INSERT INTO alunos(id, nome, codigo_matricula, nota1, nota2, nota3, media, frequencia)";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1, aluno.getId());
                ps.setString(2, aluno.getCodigoMatricula());
                ps.setFloat(3, aluno.getNota1());
                ps.setFloat(4, aluno.getNota2());
                ps.setFloat(5, aluno.getNota3());
                ps.setFloat(6, aluno.getMedia());
                ps.setByte(7, aluno.getFrequencia());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.closeConnection();
            }
        }
        return 0;
    }
    
    public boolean apagar(int id) {
        Connection conexao = Conexao.getConnection();
        String sql = "";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection();
        }
        return false;
    }
    
    

}
