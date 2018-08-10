package br.com.entra21java.dao;

import br.com.entra21java.bean.AlunoBean;
import br.com.entra21java.database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Rodrigo
 */
public class AlunoDAO {

    public int armazenar(AlunoBean aluno) {
        Connection conexao = Conexao.getConnection();
        if (conexao != null) {
            String sql = "INSERT INTO alunos(id, nome, codigo_matricula, nota1, nota2, nota3, media, frequencia)"
                    + "VALUES(?,?,?,?,?,?,?,?)";
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
        if (conexao != null) {
            String sql = "DELETE FROM alunos WHERE id = ?";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.closeConnection();
            }
        }
        return false;
    }

    public boolean isContainsAluno(String nomeAluno) {
        List<AlunoBean> alunos = obterAlunos();
        boolean is = false;
        for (int i = 0; i < alunos.size(); i++) {
            if (!is) {
                if (alunos.get(i).getNome().equalsIgnoreCase(nomeAluno)) {
                    is = true;
                } else {
                    is = false;
                }
            }
        }
        return false;
    }

    public List<AlunoBean> obterAlunos() {
        List<AlunoBean> alunos = new ArrayList<>();
        Connection conexao = Conexao.getConnection();
        if (conexao != null) {
            String sql = "SELECT id, nome, codigo_matricula, nota_1, nota_2,"
                    + "nota_3, media, frequencia FROM alunos;";
            try {
                Statement st = conexao.createStatement();
                st.execute(sql);
                ResultSet rs = st.getResultSet();
                while (rs.next()) {
                    AlunoBean aluno = new AlunoBean();
                    aluno.setId(rs.getInt("id"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCodigoMatricula(rs.getString("codigo_matricula"));
                    aluno.setNota1(rs.getFloat("nota_1"));
                    aluno.setNota2(rs.getFloat("nota_2"));
                    aluno.setNota3(rs.getFloat("nota_3"));
                    aluno.setMedia(rs.getFloat("media"));
                    aluno.setFrequencia(rs.getByte("frequencia"));
                    alunos.add(aluno);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.closeConnection();
            }
        }
        return alunos;
    }

    public AlunoBean obterAlunoPorID(int id) {
        Connection conexao = Conexao.getConnection();
        if (conexao != null) {
            String sql = "SELECT id, nome, codigo_matricula, nota_1, nota_2, nota_3, media, frequencia FROM alunos WHERE id = ?;";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    AlunoBean aluno = new AlunoBean();
                    aluno.setId(rs.getInt("id"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCodigoMatricula(rs.getString("codigo_matricula"));
                    aluno.setNota1(rs.getFloat("nota_1"));
                    aluno.setNota2(rs.getFloat("nota_2"));
                    aluno.setNota3(rs.getFloat("nota_3"));
                    aluno.setMedia(rs.getFloat("media"));
                    aluno.setFrequencia(rs.getByte("frequencia"));
                    return aluno;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.closeConnection();
            }
        }
        return null;
    }
}
