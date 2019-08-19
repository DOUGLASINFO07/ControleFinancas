package bancoConexaoDAO;

import classes.SalarioRelatorio;
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
 *
 * @author douglas Borges Egidio
 */
public class SalarioRelatorioDAO {

    //CLASSE DE CONEXÃO.
    private final Connection conn;

    //CONTRUTOR
    public SalarioRelatorioDAO() {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<SalarioRelatorio> listaSalarioRelatorio(
            String filtroPesquisa,
            String filtroEmpresaPagadora,
            String dataInicial,
            String dataFinal
    ) {
        Utilitario util = new Utilitario();
        
        List<SalarioRelatorio> salarioLista = new ArrayList<>();

        String sqlListar = "";
        
        System.out.println("" + filtroEmpresaPagadora);

        if (filtroPesquisa == "Empresa Pagadora") {
            sqlListar = "SELECT * "
                    + "FROM salario "
                    + "WHERE empresaSalario LIKE '" + filtroEmpresaPagadora + "' "
                    + "ORDER BY empresaSalario";
        }
        if (filtroPesquisa == "Período") {
            sqlListar = "SELECT * "
                    + "FROM salario "
                    + "WHERE dataRecebimentoSalario >= '" + dataInicial + "' "
                    + "AND dataRecebimentoSalario <= '" + dataFinal + "' "
                    + "ORDER BY empresaSalario";
        }
        if (filtroPesquisa == "Data") {
            sqlListar = "SELECT * "
                    + "FROM salario "
                    + "WHERE dataRecebimentoSalario LIKE '" + dataInicial + "' "
                    + "ORDER BY empresaSalario";
        }
        if (filtroPesquisa == "Empresa e Período") {
            sqlListar = "SELECT * "
                    + "FROM salario "
                    + "WHERE dataRecebimentoSalario >= '" + dataInicial + "' "
                    + "AND dataRecebimentoSalario <= '" + dataFinal + "' "
                    + "AND empresaSalario LIKE '" + filtroEmpresaPagadora + "' "
                    + "ORDER BY empresaSalario";
        }
        if (filtroPesquisa == "Empresa e Data") {
            sqlListar = "SELECT * "
                    + "FROM salario "
                    + "WHERE dataRecebimentoSalario LIKE '" + dataInicial + "' "
                    + "AND empresaSalario LIKE '" + filtroEmpresaPagadora + "' "
                    + "ORDER BY empresaSalario";
        }
        if (filtroPesquisa == "Todos") {
            sqlListar = "SELECT * "
                    + "FROM salario "
                    + "ORDER BY empresaSalario";
        }

        try {
            
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SalarioRelatorio sR = new SalarioRelatorio();
                sR.setEmpresa(rs.getString("empresaSalario"));
                sR.setSalario(util.converterCifraoAmericanoBrasil(Double.parseDouble(rs.getString("valorSalario"))));
                sR.setDataRecebimento(util.converterDataAmericanoBrasil(rs.getString("dataRecebimentoSalario")));
                sR.setTipoPagamento(rs.getString("tipoPagamentoSalario"));
                salarioLista.add(sR);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(SalarioRelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return salarioLista;
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
            Logger.getLogger(SalarioRelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }//FIM DO MÉTODO.
    
     public String somarSalarioRelatorio(
            String filtroPesquisa,
            String filtroEmpresaPagadora,
            String dataInical,
            String dataFinal
    ) {
         
         
         String soma=null;
        String sqlListar = "";

        if (filtroPesquisa == "Empresa Pagadora") {
            sqlListar = "SELECT SUM(valorSalario) as soma "
                    + "FROM salario "
                    + "WHERE empresaSalario LIKE '" + filtroEmpresaPagadora + "' ";
        }
        if (filtroPesquisa == "Período") {
            sqlListar = "SELECT SUM(valorSalario) as soma "
                    + "FROM salario "
                    + "WHERE dataRecebimentoSalario >= '" + dataInical + "' "
                    + "AND dataRecebimentoSalario <= '" + dataFinal + "' ";
        }
        if (filtroPesquisa == "Data") {
            sqlListar = "SELECT SUM(valorSalario) as soma "
                    + "FROM salario "
                    + "WHERE dataRecebimentoSalario LIKE '" + dataInical + "' ";
        }
        if (filtroPesquisa == "Empresa e Período") {
            sqlListar = "SELECT SUM(valorSalario) as soma "
                    + "FROM salario "
                    + "WHERE dataRecebimentoSalario >= '" + dataInical + "' "
                    + "AND dataRecebimentoSalario <= '" + dataFinal + "' "
                    + "AND empresaSalario LIKE '" + filtroEmpresaPagadora + "' ";
        }
        if (filtroPesquisa == "Empresa e Data") {
            sqlListar = "SELECT SUM(valorSalario) as soma "
                    + "FROM salario "
                    + "WHERE dataRecebimentoSalario LIKE '" + dataInical + "' "
                    + "AND empresaSalario LIKE '" + filtroEmpresaPagadora + "' ";
        }
        if (filtroPesquisa == "Todos") {
            sqlListar = "SELECT SUM(valorSalario) as soma "
                    + "FROM salario ";
        }

        try {
            Utilitario util = new Utilitario();
            
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
           
            soma = util.converterCifraoAmericanoBrasil(Double.parseDouble(rs.getString("soma")));
//            soma = rs.getString("teste");
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(SalarioRelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
        return soma;
    }//FIM DO MÉTODO.
}
