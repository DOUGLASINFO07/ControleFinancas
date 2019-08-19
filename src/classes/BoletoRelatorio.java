//Classe de implemento da Interface BoletoInterface.
package classes;

import bancoConexaoDAO.Conexao;
import bancoConexaoDAO.BoletoRelatorioDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jeanderson.br.util.MaskFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Utilitario;

/**
 *
 * @author douglas borges egidio
 * @since 25/09/2018
 */
public class BoletoRelatorio extends Application {

    Connection conn;

    Utilitario util = new Utilitario(conn);

    //VARIÁVEIS DA CLASSE.
    private String empresa;
    private String produto;
    private String valorBoleto;
    private String vencimento;
    private String parcela;
    private String formaPagto;
    private String dataPagto;
    private String valorPagto;
    private String localPagto;
    private String pagador;
    private ComboBox filtroPesquisaCB;
    private ComboBox empresaPagadoraCB;
    private DatePicker dataInicalDP;
    private DatePicker dataFinalDP;
    private String filtroPesquisa;
    private String empresaPagadora;
    private String dataAtual;
    private String dataInicial;
    private String dataFinal;
    //FIM DAS VARIÁVEIS.

    public BoletoRelatorio(
            int posicao,
            String filtroPesquisa
    ) {
        this.filtroPesquisa = filtroPesquisa;
    }

    public BoletoRelatorio(
            String filtroPesquisa,
            String empresaPagadora,
            String dataAtual,
            String dataInicial,
            String dataFinal
    ) {
        this.filtroPesquisa = filtroPesquisa;
        this.empresaPagadora = empresaPagadora;
        this.dataAtual = dataAtual;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;

    }

    //CONSTRUTOR VAZIO 
    public BoletoRelatorio() {

    }//FIM DO CONSTRUTOR VAZIO.

    public String getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(String dataAtual) {
        this.dataAtual = dataAtual;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(String valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public String getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(String formaPagto) {
        this.formaPagto = formaPagto;
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public String getValorPagto() {
        return valorPagto;
    }

    public void setValorPagto(String valorPagto) {
        this.valorPagto = valorPagto;
    }

    public String getLocalPagto() {
        return localPagto;
    }

    public void setLocalPagto(String localPagto) {
        this.localPagto = localPagto;
    }

    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public ComboBox<BoletoRelatorio> getFiltroPesquisaCB() {
        return filtroPesquisaCB;
    }

    public void setFiltroPesquisaCB(ComboBox<BoletoRelatorio> filtroPesquisaCB) {
        this.filtroPesquisaCB = filtroPesquisaCB;
    }

    public ComboBox<BoletoRelatorio> getEmpresaPagadoraCB() {
        return empresaPagadoraCB;
    }

    public void setEmpresaPagadoraCB(ComboBox<BoletoRelatorio> empresaPagadoraCB) {
        this.empresaPagadoraCB = empresaPagadoraCB;
    }

    public DatePicker getDataInicalDP() {
        return dataInicalDP;
    }

    public void setDataInicalDP(DatePicker dataInicalDP) {
        this.dataInicalDP = dataInicalDP;
    }

    public DatePicker getDataFinalDP() {
        return dataFinalDP;
    }

    public void setDataFinalDP(DatePicker dataFinalDP) {
        this.dataFinalDP = dataFinalDP;
    }

    public String getFiltroPesquisa() {
        return filtroPesquisa;
    }

    public void setFiltroPesquisa(String filtroPesquisa) {
        this.filtroPesquisa = filtroPesquisa;
    }

    public String getEmpresaPagadora() {
        return empresaPagadora;
    }

    public void setEmpresaPagadora(String empresaPagadora) {
        this.empresaPagadora = empresaPagadora;
    }

    public String getDataInical() {
        return dataInicial;
    }

    public void setDataInical(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
        return getFiltroPesquisa();
    }
    //FIM DOS MÉTODOS GETTER E SETTER.

    //FORMATAR CAMPO TELEFONE.
    public void formatarTelefone(TextField telefone) {
        MaskFormatter formatter = new MaskFormatter(telefone);
        formatter.setMask(MaskFormatter.TEL_9DIG);
    }//FIM DO MÉTODO FORMATAR TELEFONE.

    public void limitarQantidadeCaractere(TextField textField, int limite) {
        Utilitario.limitarQuantidadeCaracteres(textField, limite);
    }

    //MÉTODO FECHAR USUARIO.
    public void fecharBoletoRelatorio() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        Menu menu = new Menu();
        try {
            menu.start(new Stage());
            fecharBoletoRelatorio();
        } catch (Exception ex) {
            Logger.getLogger(BoletoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //CONJUNTO DE MÉTODOS PARA ABRIR A TELA CADASTRO DE USUÁRIO.
    private static Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/FXMLBoletoRelatorio.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/consultarVenda.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Relatório de Boleto");
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn empresa,
            TableColumn produto,
            TableColumn valorBoleto,
            TableColumn vencimento,
            TableColumn parcela,
            TableColumn formaPagto,
            TableColumn dataPagto,
            TableColumn valorPagto,
            TableColumn localPagto,
            TableColumn pagador,
            TableView tabelaBoletoRelatorio
    ) {
        empresa.setCellValueFactory(new PropertyValueFactory("empresa"));
        produto.setCellValueFactory(new PropertyValueFactory("produto"));
        valorBoleto.setCellValueFactory(new PropertyValueFactory("valorBoleto"));
        vencimento.setCellValueFactory(new PropertyValueFactory("vencimento"));
        parcela.setCellValueFactory(new PropertyValueFactory("parcela"));
        formaPagto.setCellValueFactory(new PropertyValueFactory("formaPagto"));
        dataPagto.setCellValueFactory(new PropertyValueFactory("dataPagto"));
        valorPagto.setCellValueFactory(new PropertyValueFactory("valorPagto"));
        localPagto.setCellValueFactory(new PropertyValueFactory("localPagto"));
        pagador.setCellValueFactory(new PropertyValueFactory("pagador"));
        tabelaBoletoRelatorio.setItems(atualizaTabela());
    }

    public ObservableList<BoletoRelatorio> atualizaTabela() {
        BoletoRelatorioDAO dao = new BoletoRelatorioDAO();
        return FXCollections.observableArrayList(dao.listaBoletoRelatorio(
                filtroPesquisa,
                empresaPagadora,
                dataAtual,
                dataInicial,
                dataFinal
        ));
    }

    public String somaBoletosPagar() {
        BoletoRelatorioDAO dao = new BoletoRelatorioDAO();
        return dao.somarBoletosPagarBoletoRelatorio(
                filtroPesquisa,
                empresaPagadora,
                dataAtual,
                dataInicial,
                dataFinal
        );
    }
    
    public String somaBoletosPago() {
        BoletoRelatorioDAO dao = new BoletoRelatorioDAO();
        return dao.somarBoletosPagosBoletoRelatorio(
                filtroPesquisa,
                empresaPagadora,
                dataAtual,
                dataInicial,
                dataFinal
        );

    }

    public void preencherComboBoxFiltroPesquisa(ComboBox filtroPesquisaCB) {

        List<BoletoRelatorio> filtroPesquisa = new ArrayList<>();

        ObservableList<BoletoRelatorio> observableListBoletoRelatorio;

        BoletoRelatorio filtroPesquisa1 = new BoletoRelatorio(1, "Selecione um filtro");
        BoletoRelatorio filtroPesquisa2 = new BoletoRelatorio(2, "Empresa");
        BoletoRelatorio filtroPesquisa3 = new BoletoRelatorio(3, "Data");
        BoletoRelatorio filtroPesquisa4 = new BoletoRelatorio(4, "Período");
        BoletoRelatorio filtroPesquisa5 = new BoletoRelatorio(5, "Vencidos");
        BoletoRelatorio filtroPesquisa6 = new BoletoRelatorio(6, "Pagos");
        BoletoRelatorio filtroPesquisa7 = new BoletoRelatorio(7, "Vencidos por Data");
        BoletoRelatorio filtroPesquisa8 = new BoletoRelatorio(8, "Vencidos por Período");
        BoletoRelatorio filtroPesquisa9 = new BoletoRelatorio(9, "Vencidos por Empresa");
        BoletoRelatorio filtroPesquisa10 = new BoletoRelatorio(10, "Pagos por Data");
        BoletoRelatorio filtroPesquisa11 = new BoletoRelatorio(11, "Pagos por Período");
        BoletoRelatorio filtroPesquisa12 = new BoletoRelatorio(12, "Pagos por Empresa");
        BoletoRelatorio filtroPesquisa13 = new BoletoRelatorio(13, "Empresas por Data");
        BoletoRelatorio filtroPesquisa14 = new BoletoRelatorio(14, "Empresas por Período");
        BoletoRelatorio filtroPesquisa15 = new BoletoRelatorio(15, "Todos");

        filtroPesquisa.add(filtroPesquisa1);
        filtroPesquisa.add(filtroPesquisa2);
        filtroPesquisa.add(filtroPesquisa3);
        filtroPesquisa.add(filtroPesquisa4);
        filtroPesquisa.add(filtroPesquisa5);
        filtroPesquisa.add(filtroPesquisa6);
        filtroPesquisa.add(filtroPesquisa7);
        filtroPesquisa.add(filtroPesquisa8);
        filtroPesquisa.add(filtroPesquisa9);
        filtroPesquisa.add(filtroPesquisa10);
        filtroPesquisa.add(filtroPesquisa11);
        filtroPesquisa.add(filtroPesquisa12);
        filtroPesquisa.add(filtroPesquisa13);
        filtroPesquisa.add(filtroPesquisa14);
        filtroPesquisa.add(filtroPesquisa15);

        observableListBoletoRelatorio = FXCollections.observableArrayList(filtroPesquisa);

        filtroPesquisaCB.setItems(observableListBoletoRelatorio);

    }

    private void Relatorios(
            String relatorio,
            String empresa,
            String dataAtual,
            String dataInicial,
            String dataFinal
    ) {
        Conexao conn = new Conexao();

        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("empresa", empresa);
        filtro.put("dataAtual", dataAtual);
        filtro.put("dataInicial", dataInicial);
        filtro.put("dataFinal", dataFinal);

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn.abrirConexao());
        } catch (JRException ex) {
            System.out.println("ERRO AO GERAR RELATORIO\n" + ex);
            Logger.getLogger(BoletoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
    }

    public void imprimir(
            String filtro,
            String Empresa,
            String dataAtual,
            String dataInicial,
            String dataFinal
    ) {

        String relatorio = null;

        switch (filtro) {
            case "Todos":
                relatorio = "../src/relatorio/BoletoRelatorioListarTodos.jasper";
                break;
            case "Empresa":
                relatorio = "../src/relatorio/BoletoRelatorioListarEmpresa.jasper";
                break;
            case "Data":
                relatorio = "../src/relatorio/BoletoRelatorioListarData.jasper";
                break;
            case "Período":
                relatorio = "../src/relatorio/BoletoRelatorioListarPeriodo.jasper";
                break;
            case "Vencidos":
                relatorio = "../src/relatorio/BoletoRelatorioListarVencidos.jasper";
                break;
            case "Pagos":
                relatorio = "../src/relatorio/BoletoRelatorioListarPagos.jasper";
                break;
            case "Vencidos por Data":
                relatorio = "../src/relatorio/BoletoRelatorioListarVencidosData.jasper";
                break;
            case "Vencidos por Período":
                relatorio = "../src/relatorio/BoletoRelatorioListarVencidosPeriodo.jasper";
                break;
            case "Vencidos por Empresa":
                relatorio = "../src/relatorio/BoletoRelatorioListarVencidosEmpresa.jasper";
                break;
            case "Pagos por Data":
                relatorio = "../src/relatorio/BoletoRelatorioListarPagosData.jasper";
                break;
            case "Pagos por Período":
                relatorio = "../src/relatorio/BoletoRelatorioListarPagosPeriodo.jasper";
                break;
            case "Pagos por Empresa":
                relatorio = "../src/relatorio/BoletoRelatorioListarPagosEmpresa.jasper";
                break;
            case "Empresas por Data":
                relatorio = "../src/relatorio/BoletoRelatorioListarEmpresaData.jasper";
                break;
            case "Empresas por Período":
                relatorio = "../src/relatorio/BoletoRelatorioListarEmpresaPeriodo.jasper";
                break;
            default:
                break;
        }

        Relatorios(
                relatorio,
                Empresa,
                dataAtual,
                dataInicial,
                dataFinal
        );

    }

}
