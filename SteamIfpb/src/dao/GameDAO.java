package dao;

import dominio.Game;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {

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

    public List<Game> listarJogos() throws SQLException {
        List<Game> game = new ArrayList<>();
        Connection conexao = conectar();
        String sql = "SELECT * FROM game";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String nome = rs.getString("nome");
            double preco = rs.getDouble("preco");
            String genero = rs.getString("genero");
            int codigo = rs.getInt("codigo");
            int codigoDistribuidora = rs.getInt("codigo_distribuidora");
            Game jogo = new Game(nome, preco, genero, codigo, codigoDistribuidora);
            game.add(jogo);
        }
        desconectar(conexao);
        return game;
    }

    public void inserirGame(Game game) throws SQLException {
        Connection conexao = conectar();
        String sql = "INSERT INTO game VALUES(?,?,?,?,?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, game.getNome());
        ps.setDouble(2, game.getPreco());
        ps.setString(3, game.getGenero());
        ps.setInt(4, game.getCodigo());
        ps.setInt(5, game.getCodigoDistribuidora());
        ps.executeUpdate();
        desconectar(conexao);

    }

    public void alterarPorCodigo(Game game) throws SQLException {
        Connection conexao = conectar();
        String sql = "UPDATE game SET nome = ?, preco = ?, genero = ?, codigo_distribuidora = ? WHERE codigo = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, game.getNome());
        ps.setDouble(2, game.getPreco());
        ps.setString(3, game.getGenero());
        ps.setInt(4, game.getCodigoDistribuidora());
        ps.setInt(5, game.getCodigo());
        ps.executeUpdate();
        desconectar(conexao);

    }

    public void excluirPorCodigo(int codigo) throws SQLException {
        Connection conexao = conectar();
        String sql = "DELETE FROM game WHERE codigo = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.executeUpdate();
        desconectar(conexao);
    }
}
