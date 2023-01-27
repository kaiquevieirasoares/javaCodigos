package negocio;

import dao.GameDAO;
import dominio.Game;
import java.sql.SQLException;
import java.util.List;

public class GameNegocio {

    private GameDAO gameDAO = new GameDAO();

    public List<Game> listarJogos() throws SQLException {
        return gameDAO.listarJogos();
    }
    
    public void inserirGame(Game game) throws SQLException, Exception {
        if (game.getCodigo() > 0) {
            gameDAO.inserirGame(game);

        } else {
            throw new Exception("O código tem que ser positivo");
        }
    }

    public void alterarPorCodigo(Game game) throws SQLException, Exception {
        if (game.getCodigo() > 0) {
            gameDAO.alterarPorCodigo(game);
        } else {
            throw new Exception("O código tem que ser positivo");
        }

    }

    public void excluirPorCodigo(int codigo) throws SQLException, Exception {
        if (codigo > 0) {
            gameDAO.excluirPorCodigo(codigo);

        } else {
            throw new Exception("O código tem que ser positivo");
        }

    }
}
