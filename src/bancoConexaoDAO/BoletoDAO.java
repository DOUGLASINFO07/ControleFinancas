package bancoConexaoDAO;

import classes.Boleto;
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
    public class BoletoDAO {
        
        ///teste 

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
    public BoletoDAO() {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.

    //MÉTODO PARA INSERIR DADOS NO BANCO DE DADOS.
    public boolean Inserir(Boleto b) {

        String sqlAdicionar = "INSERT INTO Boleto VALUES (null,?,?,?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlAdicionar)) {
                stmt.setString(1, b.getNomeEmpresaBoleto());
                stmt.setString(2, b.getProdutoBoleto());
                stmt.setString(3, b.getValorBoleto());
                stmt.setString(4, b.getDataVencimentoBoleto());
                stmt.setString(5, b.getParcelaBoleto());
                stmt.setString(6, b.getFormaPagamentoBoleto());
                stmt.setString(7, null);
                stmt.setString(8, null);
                stmt.setString(9, null);
                stmt.setString(10, null);
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
    public boolean atualizar(Boleto b) {
        String sqlAtualizar = "UPDATE Boleto "
                + "SET produtoBoleto = ?, "
                + "valorBoleto = ?, "
                + "parcelaBoleto = ?, "
                + "formaPagamentoBoleto = ? "
                + "WHERE empresaBoleto = ? "
                + "AND vencimentoBoleto = ? ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizar)) {
                stmt.setString(1, b.getProdutoBoleto());
                stmt.setString(2, b.getValorBoleto());
                stmt.setString(3, b.getParcelaBoleto());
                stmt.setString(4, b.getFormaPagamentoBoleto());
                stmt.setString(5, b.getNomeEmpresaBoleto());
                stmt.setString(6, b.getDataVencimentoBoleto());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA APAGAR DADOS DO BANCO DE DADOS.
    public boolean apagar(Boleto b) {
        String sqlApagar = "DELETE FROM Boleto "
                + "WHERE empresaBoleto = ? AND vencimentoBoleto = ?";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlApagar)) {
                stmt.setString(1, b.getNomeEmpresaBoleto());
                stmt.setString(2, b.getDataVencimentoBoleto());
                stmt.execute();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<Boleto> listaBoleto() {
        Utilitario util = new  Utilitario();
                
        List<Boleto> BoletoLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM Boleto ORDER BY empresaBoleto";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Boleto b = new Boleto();
                b.setNomeEmpresaBoleto(rs.getString("empresaBoleto"));
                b.setProdutoBoleto(rs.getString("produtoBoleto"));
                b.setValorBoleto(util.converterCifraoAmericanoBrasil(rs.getDouble("valorBoleto")));
                b.setParcelaBoleto(rs.getString("parcelaBoleto"));
                b.setDataVencimentoBoleto(util.converterDataAmericanoBrasil(rs.getString("vencimentoBoleto")));
                b.setFormaPagamentoBoleto(rs.getString("formaPagamentoBoleto"));
                BoletoLista.add(b);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return BoletoLista;
    }//FIM DO MÉTODO.

    public void listaEmpresa(ComboBox empresa) {

        ObservableList<String> listaEmpresa = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM Empresa ORDER BY nomeEmpresa";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                Boleto s = new Boleto();
                listaEmpresa.add(rs.getString("nomeEmpresa"));
            }
            empresa.setItems(listaEmpresa);
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }//FIM DO MÉTODO.
    
    public void listaProdutoEmpresa(ComboBox produtoEmpresa) {

        ObservableList<String> listaProdutoEmpresa = FXCollections.observableArrayList();
        String sqlListar = "SELECT * FROM Empresa ORDER BY produtoEmpresa";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//                Boleto s = new Boleto();
                listaProdutoEmpresa.add(rs.getString("produtoEmpresa"));
            }
            produtoEmpresa.setItems(listaProdutoEmpresa);
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(BoletoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }//FIM DO MÉTODO.

}
