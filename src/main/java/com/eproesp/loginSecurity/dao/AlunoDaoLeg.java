package com.eproesp.loginSecurity.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.eproesp.loginSecurity.connection.ConnectionFactory;
import com.eproesp.loginSecurity.entity.Aluno;
public class AlunoDaoLeg {
	private Connection conexao;

    public AlunoDaoLeg() {
        conexao = new ConnectionFactory().getSQLConnection();
    }

    public void save(Aluno aluno) {
    	java.sql.Date dataSql =  new java.sql.Date(aluno.getDataN().getTime());
        try {
            // creating a preparedStatement
            String sql = "insert into alunos (nome_aluno, esporte_aluno, idade_aluno, datan)"
                    + " values (?,?,?,?);";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            // fill the values
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEsporte());
            stmt.setInt(3, aluno.getIdade());
            stmt.setDate(4, dataSql);
            // execute
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
