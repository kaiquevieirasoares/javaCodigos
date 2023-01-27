package dao;

import dominio.Distribuidora;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class DistribuidoraDAO {

    private String url = "jdbc:mysql://localhost:3306/steamifpb";
    private String usuario = "root";
    private String senha = "";

    public Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public void desconectar(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Distribuidora> listarTodos() throws SQLException {
        List<Distribuidora> distribuidora = new ArrayList<>();
        Connection conexao = conectar();
        String sql = "SELECT * FROM distribuidora";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String nome = rs.getString("nome");
            int codigo = rs.getInt("codigo");
            String site = rs.getString("site");
            Distribuidora distri = new Distribuidora(nome, codigo, site);
            distribuidora.add(distri);
        }
        desconectar(conexao);
        return distribuidora;
    }

    public void inserirDistribuidora(Distribuidora distribuidora) throws SQLException {
        Connection conexao = conectar();
        String sql = "INSERT INTO distribuidora VALUES(?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, distribuidora.getNome());
        ps.setInt(2, distribuidora.getCodigo());
        ps.setString(3, distribuidora.getSite());
        ps.executeUpdate();
        desconectar(conexao);

    }

    public void alterarPorCodigo(Distribuidora distribuidora) throws SQLException {
        Connection conexao = conectar();
        String sql = "UPDATE distribuidora SET nome = ?, site = ? WHERE codigo = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, distribuidora.getNome());
        ps.setString(2, distribuidora.getSite());
        ps.setInt(3, distribuidora.getCodigo());
        ps.executeUpdate();
        desconectar(conexao);

    }

    public void excluirPorCodigo(int codigo) throws SQLException {
        Connection conexao = conectar();
        String sql = "DELETE FROM distribuidora WHERE codigo = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.executeUpdate();
        desconectar(conexao);
    }

}
