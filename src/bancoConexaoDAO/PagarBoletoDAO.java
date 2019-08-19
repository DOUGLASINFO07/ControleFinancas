package bancoConexaoDAO;

import classes.Boleto;
import classes.PagarBoleto;
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
public class PagarBoletoDAO {

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
    public PagarBoletoDAO() {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.

    //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
    public boolean atualizar(PagarBoleto pB) {
        String sqlAtualizar = "UPDATE Boleto "
                + "SET dataPagamentoBoleto = ?, "
                + "valorPagoBoleto = ?, "
                + "localPagamentoBoleto = ?, "
                + "pagadorBoleto = ? "
                + "WHERE empresaBoleto = ? "
                + "AND vencimentoBoleto = ? ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizar)) {
                stmt.setString(1, pB.getDataPagamentoBoleto());
                stmt.setString(2, pB.getValorPagoBoleto());
                stmt.setString(3, pB.getLocalPagamentoBoleto());
                stmt.setString(4, pB.getPagadorBoleto());
                stmt.setString(5, pB.getNomeEmpresaBoleto());
                stmt.setString(6, pB.getDataVencimentoBoleto());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PagarBoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PagarBoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.
    
        //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
    public void buscarFotoUsuario(
            String nomeUsuario
    ) {
        String sqlAtualizar = "SELECT * FROM Usuario "
                + "WHERE nomeUsuario = '" + nomeUsuario + "' ";
        try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizar)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                caminhoFoto = (rs.getString("fotoUsuario"));
                stmt.execute();
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PagarBoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<PagarBoleto> listaPagarBoleto() {
        Utilitario util = new  Utilitario();
                
        List<PagarBoleto> pagarBoletoLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM Boleto "
                + "WHERE valorPagoBoleto IS NULL "
                + "ORDER BY empresaBoleto";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PagarBoleto pB = new PagarBoleto();
                pB.setNomeEmpresaBoleto(rs.getString("empresaBoleto"));
                pB.setProdutoBoleto(rs.getString("produtoBoleto"));
                pB.setValorBoleto(util.converterCifraoAmericanoBrasil(rs.getDouble("valorBoleto")));
                pB.setParcelaBoleto(rs.getString("parcelaBoleto"));
                pB.setDataVencimentoBoleto(util.converterDataAmericanoBrasil(rs.getString("vencimentoBoleto")));
                pB.setFormaPagamentoBoleto(rs.getString("formaPagamentoBoleto"));
                pagarBoletoLista.add(pB);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PagarBoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return pagarBoletoLista;
    }//FIM DO MÉTODO.

    public void listaUsuario(ComboBox usuario) {

        ObservableList<String> listaUsuario = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM Usuario ORDER BY nomeUsuario";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                Boleto s = new Boleto();
                listaUsuario.add(rs.getString("nomeUsuario"));
            }
            usuario.setItems(listaUsuario);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PagarBoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }//FIM DO MÉTODO.

}
