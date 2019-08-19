package bancoConexaoDAO;

import classes.Empresa;
import classes.Salario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import util.Utilitario;

/**
 * @author douglas borges egidio
 */
public class SalarioDAO {

    //CLASSE DE CONEXÃO.
    private final Connection conn;

    private String caminhoFoto;

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    //CONTRUTOR
    public SalarioDAO() {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.

    //MÉTODO PARA INSERIR DADOS NO BANCO DE DADOS.
    public boolean Inserir(Salario s) {

        String sqlAdicionar = "INSERT INTO Salario VALUES (null, ?,?,?,?)";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlAdicionar)) {
                stmt.setString(1, s.getNomeEmpresa());
                stmt.setString(2, s.getSalario());
                stmt.setString(3, s.getDataRecebimento());
                stmt.setString(4, s.getTipoPagamento());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SalarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
    public boolean atualizar(Salario e) {
        String sqlAtualizar = "UPDATE Salario "
                + "SET valorSalario = ?, "
                + "tipoPagamentoSalario = ? "
                + "WHERE empresaSalario = ? "
                + "AND dataRecebimentoSalario = ? ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizar)) {
                stmt.setString(1, e.getSalario());
                stmt.setString(2, e.getTipoPagamento());
                stmt.setString(3, e.getNomeEmpresa());
                stmt.setString(4, e.getDataRecebimento());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SalarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA APAGAR DADOS DO BANCO DE DADOS.
    public boolean apagar(Salario e) {
        String sqlApagar = "DELETE FROM Salario "
                + "WHERE empresaSalario = ? AND dataRecebimentoSalario = ?";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlApagar)) {
                stmt.setString(1, e.getNomeEmpresa());
                stmt.setString(2, e.getDataRecebimento());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SalarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
    public void buscarFoto(
            String nomeEmpresa
    ) {
        String sqlAtualizar = "SELECT * FROM Empresa "
                + "WHERE nomeEmpresa = '" + nomeEmpresa + "' ";
        try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizar)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                caminhoFoto = (rs.getString("fotoEmpresa"));
                stmt.execute();
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<Salario> listaSalario() {
        Utilitario util = new  Utilitario();
                
        List<Salario> SalarioLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM Salario ORDER BY empresaSalario";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Salario s = new Salario();
                s.setNomeEmpresa(rs.getString("empresaSalario"));
                s.setSalario(util.converterCifraoAmericanoBrasil(rs.getDouble("valorSalario")));
                s.setDataRecebimento(util.converterDataAmericanoBrasil(rs.getString("dataRecebimentoSalario")));
                s.setTipoPagamento(rs.getString("tipoPagamentoSalario"));
                SalarioLista.add(s);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return SalarioLista;
    }//FIM DO MÉTODO.

    public void listaEmpresa(ComboBox empresa) {

        ObservableList<String> listaEmpresa = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM Empresa ORDER BY nomeEmpresa";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                Salario s = new Salario();
                listaEmpresa.add(rs.getString("nomeEmpresa"));
            }
            empresa.setItems(listaEmpresa);
//            rs.close();
//            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }//FIM DO MÉTODO.

}
