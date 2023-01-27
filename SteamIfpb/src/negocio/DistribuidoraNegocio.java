package negocio;

import dao.DistribuidoraDAO;
import dominio.Distribuidora;
import java.sql.SQLException;
import java.util.List;

public class DistribuidoraNegocio {

    private DistribuidoraDAO distribuidoraDAO = new DistribuidoraDAO();

    public List<Distribuidora> listarTodos() throws SQLException {
        return distribuidoraDAO.listarTodos();
    }

    public void inserirDistribuidora(Distribuidora distribuidora) throws SQLException, Exception {
        if (distribuidora.getCodigo() > 0) {
            distribuidoraDAO.inserirDistribuidora(distribuidora);

        } else {
            throw new Exception("O código tem que ser positivo");
        }
    }

    public void alterarPorCodigo(Distribuidora distribuidora) throws SQLException, Exception {
        if (distribuidora.getCodigo() > 0) {
            distribuidoraDAO.alterarPorCodigo(distribuidora);
        } else {
            throw new Exception("o codigo tem que ser positivo");
        }

    }

    public void excluirPorCodigo(int codigo) throws SQLException, Exception {
        if (codigo > 0) {
            distribuidoraDAO.excluirPorCodigo(codigo);

        } else {
            throw new Exception("O codigo tem que ser positivo");
        }

    }

}
