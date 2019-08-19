//Classe de implemento da Interface SalarioInterface.
package classes;

import bancoConexaoDAO.Conexao;
import bancoConexaoDAO.SalarioRelatorioDAO;
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
public class SalarioRelatorio extends Application {

    Connection conn;

    Utilitario util = new Utilitario(conn);

    //VARIÁVEIS DA CLASSE.
    private String empresa;
    private String salario;
    private String dataRecebimento;
    private String tipoPagamento;
    private ComboBox<SalarioRelatorio> filtroPesquisaCB;
    private ComboBox<SalarioRelatorio> empresaPagadoraCB;
    private DatePicker dataInicalDP;
    private DatePicker dataFinalDP;
    private String filtroPesquisa;
    private String empresaPagadora;
    private String dataInicial;
    private String dataFinal;
    //FIM DAS VARIÁVEIS.

    public SalarioRelatorio(
            int posicao,
            String filtroPesquisa
    ) {
        this.filtroPesquisa = filtroPesquisa;
    }

    public SalarioRelatorio(
            String filtroPesquisa, 
            String empresaPagadora,
            String dataInicial,
            String dataFinal
    ) {
        this.filtroPesquisa = filtroPesquisa;
        this.empresaPagadora = empresaPagadora;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        
    }

    //CONSTRUTOR VAZIO 
    public SalarioRelatorio() {

    }//FIM DO CONSTRUTOR VAZIO.

    //MÉTODOS GETTER E SETTER.
    //NOME

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public ComboBox<SalarioRelatorio> getFiltroPesquisaCB() {
        return filtroPesquisaCB;
    }

    public void setFiltroPesquisaCB(ComboBox<SalarioRelatorio> filtroPesquisaCB) {
        this.filtroPesquisaCB = filtroPesquisaCB;
    }

    public ComboBox<SalarioRelatorio> getEmpresaPagadoraCB() {
        return empresaPagadoraCB;
    }

    public void setEmpresaPagadoraCB(ComboBox<SalarioRelatorio> empresaPagadoraCB) {
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
    public void fecharSalarioRelatorio() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        Menu menu = new Menu();
        try {
            menu.start(new Stage());
            fecharSalarioRelatorio();
        } catch (Exception ex) {
            Logger.getLogger(SalarioRelatorio.class.getName()).log(Level.SEVERE, null, ex);
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
        Parent root = FXMLLoader.load(getClass().getResource("/telas/FXMLSalarioRelatorio.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/consultarVenda.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Relatório de Usuário");
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn nomeEmpresa,
            TableColumn salario,
            TableColumn dataRecebimento,
            TableColumn tipoPagamento,
            TableView tabelaSalarioRelatorio
    ) {
        nomeEmpresa.setCellValueFactory(new PropertyValueFactory("empresa"));
        salario.setCellValueFactory(new PropertyValueFactory("salario"));
        dataRecebimento.setCellValueFactory(new PropertyValueFactory("dataRecebimento"));
        tipoPagamento.setCellValueFactory(new PropertyValueFactory("tipoPagamento"));
        tabelaSalarioRelatorio.setItems(atualizaTabela());
    }

    public ObservableList<SalarioRelatorio> atualizaTabela() {
        SalarioRelatorioDAO dao = new SalarioRelatorioDAO();
        return FXCollections.observableArrayList(dao.listaSalarioRelatorio(
                filtroPesquisa,
                empresaPagadora,
                dataInicial,
                dataFinal
        ));
    }
    
        public String somaSalario(){
        SalarioRelatorioDAO dao = new SalarioRelatorioDAO();
        return dao.somarSalarioRelatorio(
                filtroPesquisa,
                empresaPagadora,
                dataInicial,
                dataFinal
        );
        
    }

//    public void pegarDadoTabela(
//            ImageView fotoSalario,
//            Button BuscarImagem,
//            Button NovoCadastro,
//            TextField nomeSalario,
//            TextField telefoneSalario,
//            TextField emailUsusario,
//            TextField loginSalario,
//            TextField senhaSalario,
//            Button salvar,
//            Button atualizar,
//            Button excluir,
//            Button listarTabela,
//            TableView<SalarioRelatorio> tabelaSalario,
//            Button imprimir,
//            Button voltarMenu
//    ) {
//        nomeSalario.setText(tabelaSalario.getSelectionModel().getSelectedItem().getNomeSalario());
//        telefoneSalario.setText(tabelaSalario.getSelectionModel().getSelectedItem().getTelefoneSalario());
//        emailUsusario.setText(tabelaSalario.getSelectionModel().getSelectedItem().getEmailSalario());
//        loginSalario.setText(tabelaSalario.getSelectionModel().getSelectedItem().getLoginSalario());
//        senhaSalario.setText(tabelaSalario.getSelectionModel().getSelectedItem().getSenhaSalario());
//    }
//    //FIM DOS MÉTODO PARA MANIPULAÇÃO DA TABELA.
//
////    public void gerarRelatorio() {
////        Utilitario util = new Utilitario(conn);
////        String relatorio = "../src/relatorio/SalarioRelatório.jasper";
////        util.relatorio(relatorio);
////    }
    public void preencherComboBoxFiltroPesquisa(ComboBox filtroPesquisaCB) {

        List<SalarioRelatorio> filtroPesquisa = new ArrayList<>();

        ObservableList<SalarioRelatorio> observableListSalarioRelatorio;

        SalarioRelatorio filtroPesquisa1 = new SalarioRelatorio(1, "Selecione um filtro");
        SalarioRelatorio filtroPesquisa2 = new SalarioRelatorio(2, "Empresa Pagadora");
        SalarioRelatorio filtroPesquisa3 = new SalarioRelatorio(3, "Data");
        SalarioRelatorio filtroPesquisa4 = new SalarioRelatorio(4, "Período");
        SalarioRelatorio filtroPesquisa5 = new SalarioRelatorio(5, "Empresa e Data");
        SalarioRelatorio filtroPesquisa6 = new SalarioRelatorio(6, "Empresa e Período");
        SalarioRelatorio filtroPesquisa7 = new SalarioRelatorio(7, "Todos");

        filtroPesquisa.add(filtroPesquisa1);
        filtroPesquisa.add(filtroPesquisa2);
        filtroPesquisa.add(filtroPesquisa3);
        filtroPesquisa.add(filtroPesquisa4);
        filtroPesquisa.add(filtroPesquisa5);
        filtroPesquisa.add(filtroPesquisa6);
        filtroPesquisa.add(filtroPesquisa7);

        observableListSalarioRelatorio = FXCollections.observableArrayList(filtroPesquisa);

        filtroPesquisaCB.setItems(observableListSalarioRelatorio);

    }

    public void Relatorios(
            String relatorio,
            String nomeEmpresa,
            String dataInicial,
            String dataFinal
    ) {
        Conexao conn = new Conexao();

        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("empresaPagadora", nomeEmpresa);
        filtro.put("dataInicial", dataInicial);
        filtro.put("dataFinal", dataFinal);

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn.abrirConexao());
        } catch (JRException ex) {
            System.out.println("ERRO\n" + ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
    }

    public void imprimir(
            String filtro,
            String EmpresaPagadora,
            String dataInicial,
            String dataFinal
    ) {
        
        String relatorio = null;

        switch (filtro) {
            case "Todos":
                relatorio = "../src/relatorio/Salario.jasper";
                break;
            case "Empresa Pagadora":
                relatorio = "../src/relatorio/SalarioRelatorioListarEmpresa.jasper";
                break;
            case "Data":
                relatorio = "../src/relatorio/SalarioRelatorioListarData.jasper";
                break;
            case "Período":
                relatorio = "../src/relatorio/SalarioRelatorioListarPeriodo.jasper";
                break;
            case "Empresa e Período":
                relatorio = "../src/relatorio/SalarioRelatorioListarEmpresaPeriodo.jasper";
                break;
            case "Empresa e Data":
                relatorio = "../src/relatorio/SalarioRelatorioListarEmpresaData.jasper";
                break;
            default:
                break;
        }

        Relatorios(
                relatorio,
                EmpresaPagadora,
                dataInicial,
                dataFinal
        );

    }

}
