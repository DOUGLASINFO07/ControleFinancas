package bancoConexaoDAO;

import classes.BoletoRelatorio;
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
public class BoletoRelatorioDAO {

    //CLASSE DE CONEXÃO.
    private final Connection conn;

    //CONTRUTOR
    public BoletoRelatorioDAO() {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<BoletoRelatorio> listaBoletoRelatorio(
            String filtroPesquisa,
            String filtroEmpresa,
            String dataAtual,
            String dataInicial,
            String dataFinal
    ) {
        Utilitario util = new Utilitario();

        List<BoletoRelatorio> boletoLista = new ArrayList<>();

        String sqlListar = "";

        if ("Empresa".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "ORDER BY empresaBoleto";
        }
        if ("Período".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "ORDER BY empresaBoleto";
        }
        if ("Data".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "ORDER BY empresaBoleto";
        }
        if ("Vencidos".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND valorPagoBoleto is null "
                    + "ORDER BY empresaBoleto";
        }
        if ("Pagos".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "ORDER BY empresaBoleto";
        }
        if ("Vencidos por Data".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "AND valorPagoBoleto is null "
                    + "ORDER BY empresaBoleto";
        }
        if ("Vencidos por Período".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "AND valorPagoBoleto is null "
                    + "ORDER BY empresaBoleto";
        }
        if ("Vencidos por Empresa".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "AND valorPagoBoleto is null "
                    + "ORDER BY empresaBoleto";
        }
        if ("Pagos por Data".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "AND vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "ORDER BY empresaBoleto";
        }
        if ("Pagos por Período".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "AND vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "ORDER BY empresaBoleto";
        }
        if ("Pagos por Empresa".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "ORDER BY empresaBoleto";
        }
        if ("Empresas por Data".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "ORDER BY empresaBoleto";
        }
        if ("Empresas por Período".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "ORDER BY empresaBoleto";
        }
        if ("Todos".equals(filtroPesquisa)) {
            sqlListar = "SELECT * "
                    + "FROM boleto "
                    + "ORDER BY empresaBoleto";
        }

        try {

            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BoletoRelatorio bR = new BoletoRelatorio();
                bR.setEmpresa(rs.getString("empresaBoleto"));
                bR.setProduto(rs.getString("produtoBoleto"));
                bR.setValorBoleto(util.converterCifraoAmericanoBrasil(Double.parseDouble(rs.getString("valorBoleto"))));
                bR.setVencimento(util.converterDataAmericanoBrasil(rs.getString("vencimentoBoleto")));
                bR.setParcela(rs.getString("parcelaBoleto"));
                bR.setFormaPagto(rs.getString("formaPagamentoBoleto"));

                String data = rs.getString("dataPagamentoBoleto");
                if (data == null) {
                    bR.setDataPagto("");
                } else {
                    bR.setDataPagto(util.converterDataAmericanoBrasil(data));
                }

//                bR.setDataPagto(rs.getString("dataPagamentoBoleto"));
                String valor = rs.getString("valorPagoBoleto");
                if (valor == null) {
                    bR.setValorPagto("");
                } else {
                    bR.setValorPagto("" + util.converterCifraoAmericanoBrasil(Double.parseDouble(valor)));
                }

//                bR.setValorPagto(rs.getString("valorPagoBoleto"));
                bR.setLocalPagto(rs.getString("localPagamentoBoleto"));
                bR.setPagador(rs.getString("pagadorBoleto"));
                boletoLista.add(bR);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(BoletoRelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return boletoLista;
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
            Logger.getLogger(BoletoRelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
    }//FIM DO MÉTODO.

    public String somarBoletosPagarBoletoRelatorio(
            String filtroPesquisa,
            String filtroEmpresa,
            String dataAtual,
            String dataInicial,
            String dataFinal
    ) {

        String soma = null;
        String sqlListar = "";

        if (filtroPesquisa == "Empresa") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "AND valorPagoBoleto is Null "
                    + "ORDER BY empresaBoleto";
        }

        if (filtroPesquisa == "Período") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "AND valorPagoBoleto is Null "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Data") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "AND valorPagoBoleto is Null "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Vencidos") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND valorPagoBoleto is Null "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Pagos") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto is Null "
                    + "AND valorPagoBoleto != 'NULL' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Vencidos por Data") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "AND valorPagoBoleto is Null "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Vencidos por Período") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "AND valorPagoBoleto is Null "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Vencidos por Empresa") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "AND valorPagoBoleto is Null "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Pagos por Data") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "AND valorPagoBoleto is null "
                    + "AND vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Pagos por Período") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "AND valorPagoBoleto is null "
                    + "AND vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Pagos por Empresa") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "AND valorPagoBoleto is null "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Empresas por Data") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "AND valorPagoBoleto is Null "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Empresas por Período") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "AND valorPagoBoleto is Null "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Todos") {
            sqlListar = "SELECT SUM(valorBoleto) as soma "
                    + "FROM boleto "
                    + "ORDER BY empresaBoleto";
        }

        try {
            Utilitario util = new Utilitario();

            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                 if (rs.getString("soma") == null) {
                    soma = "0";
                } else {
                    soma = rs.getString("soma");
                }
//            soma = rs.getString("teste");
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(BoletoRelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
        return soma;
    }//FIM DO MÉTODO.

    public String somarBoletosPagosBoletoRelatorio(
            String filtroPesquisa,
            String filtroEmpresa,
            String dataAtual,
            String dataInicial,
            String dataFinal
    ) {

        String soma = null;
        String sqlListar = "";

        if (filtroPesquisa == "Empresa") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "AND valorPagoBoleto != 'NULL' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Período") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Data") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Vencidos") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND valorPagoBoleto is NULL "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Pagos") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Vencidos por Data") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND vencimentoBoleto LIKE '" + dataInicial + "' "
                     + "AND valorPagoBoleto is NULL "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Vencidos por Período") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                     + "AND valorPagoBoleto is NULL "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Vencidos por Empresa") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto < '" + dataAtual + "' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                     + "AND valorPagoBoleto is NULL "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Pagos por Data") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "AND vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Pagos por Período") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "AND vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Pagos por Empresa") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE valorPagoBoleto != 'NULL' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Empresas por Data") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto LIKE '" + dataInicial + "' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Empresas por Período") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "WHERE vencimentoBoleto >= '" + dataInicial + "' "
                    + "AND vencimentoBoleto <= '" + dataFinal + "' "
                    + "AND empresaBoleto LIKE '" + filtroEmpresa + "' "
                    + "ORDER BY empresaBoleto";
        }
        if (filtroPesquisa == "Todos") {
            sqlListar = "SELECT SUM(valorPagoBoleto) as soma "
                    + "FROM boleto "
                    + "ORDER BY empresaBoleto";
        }

        try {
            Utilitario util = new Utilitario();

            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("soma") == null) {
                    soma = "0";
                } else {
                    soma = rs.getString("soma");
                }
//            soma = rs.getString("teste");
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(BoletoRelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
        }
        return soma;
    }//FIM DO MÉTODO.
}
