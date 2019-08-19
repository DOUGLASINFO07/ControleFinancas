//Classe de implemento da Interface UsuarioInterface.
package classes;

import bancoConexaoDAO.PagarBoletoDAO;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import util.Utilitario;

/**
 *
 * @author douglas borges egidio
 * @since 25/09/2018
 */
public class PagarBoleto extends Application {

    Connection conn;

    //VARIÁVEIS DA CLASSE.
    private String nomeEmpresaBoleto;
    private String produtoBoleto;
    private String valorBoleto;
    private String dataVencimentoBoleto;
    private String parcelaBoleto;
    private String formaPagamentoBoleto;
    private String dataPagamentoBoleto;
    private String valorPagoBoleto;
    private String localPagamentoBoleto;
    private String pagadorBoleto;
    private String caminhoFoto;
    private ImageView fotoEmpresa;
    private ImageView fotoUsuario;
    //FIM DAS VARIÁVEIS.

    public PagarBoleto(
            String nomeEmpresaBoleto,
            String produtoBoleto,
            String valorBoleto,
            String dataVencimentoBoleto,
            String parcelaBoleto,
            String formaPagamentoBoleto,
            String dataPagamentoBoleto,
            String valorPagoBoleto,
            String localPagamentoBoleto,
            String pagadorBoleto,
            ImageView fotoEmpresa,
            ImageView fotoUsuario
    ) {
        this.nomeEmpresaBoleto = nomeEmpresaBoleto;
        this.produtoBoleto = produtoBoleto;
        this.valorBoleto = valorBoleto;
        this.parcelaBoleto = parcelaBoleto;
        this.dataVencimentoBoleto = dataVencimentoBoleto;
        this.formaPagamentoBoleto = formaPagamentoBoleto;
        this.dataPagamentoBoleto = dataPagamentoBoleto;
        this.valorPagoBoleto = valorPagoBoleto;
        this.localPagamentoBoleto = localPagamentoBoleto;
        this.pagadorBoleto = pagadorBoleto;
        this.fotoEmpresa = fotoEmpresa;
        this.fotoUsuario = fotoUsuario;
    }

    public PagarBoleto(
            String nomeEmpresaBoleto,
            String produtoBoleto,
            String valorBoleto,
            String dataVencimentoBoleto,
            String parcelaBoleto,
            String formaPagamentoBoleto,
            String dataPagamentoBoleto,
            String valorPagoBoleto,
            String localPagamentoBoleto,
            String pagadorBoleto,
            String caminhoFoto,
            ImageView fotoEmpresa,
            ImageView fotoUsuario
    ) {
        this.nomeEmpresaBoleto = nomeEmpresaBoleto;
        this.produtoBoleto = produtoBoleto;
        this.valorBoleto = valorBoleto;
        this.parcelaBoleto = parcelaBoleto;
        this.dataVencimentoBoleto = dataVencimentoBoleto;
        this.formaPagamentoBoleto = formaPagamentoBoleto;
        this.dataPagamentoBoleto = dataPagamentoBoleto;
        this.valorPagoBoleto = valorPagoBoleto;
        this.localPagamentoBoleto = localPagamentoBoleto;
        this.pagadorBoleto = pagadorBoleto;
        this.caminhoFoto = caminhoFoto;
        this.fotoEmpresa = fotoEmpresa;
        this.fotoUsuario = fotoUsuario;
    }

    public PagarBoleto(
            String caminhoFoto,
            ImageView fotoEmpresa,
            ImageView fotoUsuario
    ) {
        this.caminhoFoto = caminhoFoto;
        this.fotoEmpresa = fotoEmpresa;
        this.fotoUsuario = fotoUsuario;
    }

    public PagarBoleto(
            int posicao,
            String localPagamentoBoleto
    ) {
        this.localPagamentoBoleto = localPagamentoBoleto;
    }
//
//    public PagarBoleto(
//            String formaPagamentoBoleto
//    ) {
//        this.formaPagamentoBoleto = formaPagamentoBoleto;
//    }
    public PagarBoleto(
                        String nomeEmpresaBoleto,
            //            String produtoBoleto,
            //            String valorBoleto,
                        String dataVencimentoBoleto,
            //            String parcelaBoleto,
            //            String formaPagamentoBoleto,
            String dataPagamentoBoleto,
            String valorPagoBoleto,
            String localPagamentoBoleto,
            String pagadorBoleto
    ) {
        this.nomeEmpresaBoleto = nomeEmpresaBoleto;
//        this.produtoBoleto = produtoBoleto;
//        this.valorBoleto = valorBoleto;
//        this.parcelaBoleto = parcelaBoleto;
        this.dataVencimentoBoleto = dataVencimentoBoleto;
//        this.formaPagamentoBoleto = formaPagamentoBoleto;
        this.dataPagamentoBoleto = dataPagamentoBoleto;
        this.valorPagoBoleto = valorPagoBoleto;
        this.localPagamentoBoleto = localPagamentoBoleto;
        this.pagadorBoleto = pagadorBoleto;
    }

    //CONSTRUTOR VAZIO 
    public PagarBoleto() {

    }//FIM DO CONSTRUTOR VAZIO.

    public String getNomeEmpresaBoleto() {
        return nomeEmpresaBoleto;
    }

    public void setNomeEmpresaBoleto(String nomeEmpresaBoleto) {
        this.nomeEmpresaBoleto = nomeEmpresaBoleto;
    }

    public String getProdutoBoleto() {
        return produtoBoleto;
    }

    public void setProdutoBoleto(String produtoBoleto) {
        this.produtoBoleto = produtoBoleto;
    }

    public String getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(String valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public String getDataVencimentoBoleto() {
        return dataVencimentoBoleto;
    }

    public void setDataVencimentoBoleto(String dataVencimentoBoleto) {
        this.dataVencimentoBoleto = dataVencimentoBoleto;
    }

    public String getParcelaBoleto() {
        return parcelaBoleto;
    }

    public void setParcelaBoleto(String parcelaBoleto) {
        this.parcelaBoleto = parcelaBoleto;
    }

    public String getFormaPagamentoBoleto() {
        return formaPagamentoBoleto;
    }

    public void setFormaPagamentoBoleto(String formaPagamentoBoleto) {
        this.formaPagamentoBoleto = formaPagamentoBoleto;
    }

    public String getDataPagamentoBoleto() {
        return dataPagamentoBoleto;
    }

    public void setDataPagamentoBoleto(String dataPagamentoBoleto) {
        this.dataPagamentoBoleto = dataPagamentoBoleto;
    }

    public String getValorPagoBoleto() {
        return valorPagoBoleto;
    }

    public void setValorPagoBoleto(String valorPagoBoleto) {
        this.valorPagoBoleto = valorPagoBoleto;
    }

    public String getLocalPagamentoBoleto() {
        return localPagamentoBoleto;
    }

    public void setLocalPagamentoBoleto(String localPagamentoBoleto) {
        this.localPagamentoBoleto = localPagamentoBoleto;
    }

    public String getPagadorBoleto() {
        return pagadorBoleto;
    }

    public void setPagadorBoleto(String pagadorBoleto) {
        this.pagadorBoleto = pagadorBoleto;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    public ImageView getFotoEmpresa() {
        return fotoEmpresa;
    }

    public void setFotoEmpresa(ImageView fotoEmpresa) {
        this.fotoEmpresa = fotoEmpresa;
    }

    public ImageView getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(ImageView fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    @Override
    public String toString() {
        return getLocalPagamentoBoleto();
    }

    //MÉTODO FECHAR USUARIO.
    public void fecharBoleto() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        Menu menu = new Menu();
        try {
            menu.start(new Stage());
            fecharBoleto();
        } catch (Exception ex) {
            Logger.getLogger(PagarBoleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //CONJUNTO DE MÉTODOS PARA ABRIR A TELA CADASTRO DE USUÁRIO.
    private static Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        PagarBoleto.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/FXMLPagarBoleto.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/consultarVenda.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Cadastrar Boleto");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    public void limparFormulario(
            ImageView fotoEmpresa,
            ImageView fotoUsuario,
            TextField nomeEmpresaBoleto,
            TextField produtoBoleto,
            TextField valorBoleto,
            TextField dataVencimentoBoleto,
            TextField parcelaBoleto,
            TextField formaPagamentoBoleto,
            DatePicker dataPagamentoBoleto,
            TextField valorPagoBoleto,
            ComboBox localPagamentoBoleto,
            ComboBox pagadorBoleto,
            Button pagar,
            Button listarTabela,
            TableView<PagarBoleto> tabelaBoleto,
            Button imprimir,
            Button boletosPagos,
            Button voltarMenu
    ) {
        fotoEmpresa.setImage(new Image("/imagens/semFoto.jpg"));
        fotoUsuario.setImage(new Image("/imagens/semFoto.jpg"));
        nomeEmpresaBoleto.setText("");
        produtoBoleto.setText("");
        valorBoleto.setText("");
        dataVencimentoBoleto.setText("");
        parcelaBoleto.setText("");
        formaPagamentoBoleto.setText("");
        dataPagamentoBoleto.setValue(null);
        valorPagoBoleto.setText("");
        localPagamentoBoleto.setValue("Selecione");
        pagadorBoleto.setValue("Selecione");
    }

    public void liberarCamposFormulario(
            ImageView fotoEmpresa,
            ImageView fotoUsuario,
            TextField nomeEmpresaBoleto,
            TextField produtoBoleto,
            TextField valorBoleto,
            TextField dataVencimentoBoleto,
            TextField parcelaBoleto,
            TextField formaPagamentoBoleto,
            DatePicker dataPagamentoBoleto,
            TextField valorPagoBoleto,
            ComboBox localPagamentoBoleto,
            ComboBox pagadorBoleto,
            Button pagar,
            Button listarTabela,
            TableView<PagarBoleto> tabelaBoleto,
            Button imprimir,
            Button boletosPagos,
            Button voltarMenu
    ) {
        dataPagamentoBoleto.setDisable(false);
        valorPagoBoleto.setDisable(false);
        localPagamentoBoleto.setDisable(false);
        pagadorBoleto.setDisable(false);
        pagar.setDisable(false);
    }

    public void bloquearCamposFormulario(
            ImageView fotoEmpresa,
            ImageView fotoUsuario,
            TextField nomeEmpresaBoleto,
            TextField produtoBoleto,
            TextField valorBoleto,
            TextField dataVencimentoBoleto,
            TextField parcelaBoleto,
            TextField formaPagamentoBoleto,
            DatePicker dataPagamentoBoleto,
            TextField valorPagoBoleto,
            ComboBox localPagamentoBoleto,
            ComboBox pagadorBoleto,
            Button pagar,
            Button listarTabela,
            TableView<PagarBoleto> tabelaBoleto,
            Button imprimir,
            Button boletosPagos,
            Button voltarMenu
    ) {
        dataPagamentoBoleto.setDisable(true);
        valorPagoBoleto.setDisable(true);
        localPagamentoBoleto.setDisable(true);
        pagadorBoleto.setDisable(true);
        pagar.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn nome,
            TableColumn produto,
            TableColumn valorBoleto,
            TableColumn parcelas,
            TableColumn vencimento,
            TableColumn formaPagamento,
            TableView<PagarBoleto> tabelaBoleto
    ) {
        nome.setCellValueFactory(new PropertyValueFactory("nomeEmpresaBoleto"));
        produto.setCellValueFactory(new PropertyValueFactory("produtoBoleto"));
        valorBoleto.setCellValueFactory(new PropertyValueFactory("valorBoleto"));
        parcelas.setCellValueFactory(new PropertyValueFactory("parcelaBoleto"));
        vencimento.setCellValueFactory(new PropertyValueFactory("dataVencimentoBoleto"));
        formaPagamento.setCellValueFactory(new PropertyValueFactory("formaPagamentoBoleto"));
        tabelaBoleto.setItems(atualizaTabela());
    }

    public ObservableList<PagarBoleto> atualizaTabela() {
        PagarBoletoDAO dao = new PagarBoletoDAO();
        return FXCollections.observableArrayList(dao.listaPagarBoleto());
    }

    public void pegarDadoTabela(
            ImageView fotoEmpresa,
            ImageView fotoUsuario,
            TextField nomeEmpresaBoleto,
            TextField produtoBoleto,
            TextField valorBoleto,
            TextField dataVencimentoBoleto,
            TextField parcelaBoleto,
            TextField formaPagamentoBoleto,
            DatePicker dataPagamentoBoleto,
            TextField valorPagoBoleto,
            ComboBox localPagamentoBoleto,
            ComboBox pagadorBoleto,
            Button pagar,
            Button listarTabela,
            TableView<PagarBoleto> tabelaBoleto,
            Button imprimir,
            Button boletosPagos,
            Button voltarMenu
    ) {
        nomeEmpresaBoleto.setText(tabelaBoleto.getSelectionModel().getSelectedItem().getNomeEmpresaBoleto());
        produtoBoleto.setText(tabelaBoleto.getSelectionModel().getSelectedItem().getProdutoBoleto());
        valorBoleto.setText("" + tabelaBoleto.getSelectionModel().getSelectedItem().getValorBoleto());
        parcelaBoleto.setText("" + tabelaBoleto.getSelectionModel().getSelectedItem().getParcelaBoleto());
        dataVencimentoBoleto.setText(tabelaBoleto.getSelectionModel().getSelectedItem().getDataVencimentoBoleto());
        formaPagamentoBoleto.setText(tabelaBoleto.getSelectionModel().getSelectedItem().getFormaPagamentoBoleto());

        String nome = tabelaBoleto.getSelectionModel().getSelectedItem().getNomeEmpresaBoleto();

        setCaminhoFoto("");
        PagarBoletoDAO dao = new PagarBoletoDAO();

        dao.buscarFoto(nome);
//        fotoEmpresa.getClass().getResource(dao.getCaminhoFoto());
        fotoEmpresa.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));

        caminhoFoto = dao.getCaminhoFoto();

        System.out.println("" + dao.getCaminhoFoto());

    }
    //FIM DOS MÉTODO PARA MANIPULAÇÃO DA TABELA

    public void atualizarBoleto(
            ImageView fotoEmpresa,
            ImageView fotoUsuario,
            TextField nomeEmpresaBoleto,
            TextField produtoBoleto,
            TextField valorBoleto,
            TextField dataVencimentoBoleto,
            TextField parcelaBoleto,
            TextField formaPagamentoBoleto,
            DatePicker dataPagamentoBoleto,
            TextField valorPagoBoleto,
            ComboBox localPagamentoBoleto,
            ComboBox pagadorBoleto,
            Button pagar,
            Button listarTabela,
            TableView<PagarBoleto> tabelaBoleto,
            Button imprimir,
            Button boletosPagos,
            Button voltarMenu
    ) {
        Utilitario util = new Utilitario();
        
        String nome = nomeEmpresaBoleto.getText();
        String dataVencimento = util.converterDataBrasilAmericano(dataVencimentoBoleto.getText());

        LocalDate dataPagamento = dataPagamentoBoleto.getValue();
        String data = "" + dataPagamento;

        String boleto;
        if ("".equals(valorPagoBoleto.getText())) {
            boleto = "0";
        } else {
            boleto = util.converterCifraoBrasiloAmericano(valorPagoBoleto.getText());
        }

        String localPagamento = localPagamentoBoleto.getSelectionModel().getSelectedItem().toString();
        String pagador = pagadorBoleto.getSelectionModel().getSelectedItem().toString();

        //confere se todos os campos estão preenchidos
        if (localPagamentoBoleto.getValue().equals("Selecione")
                || pagadorBoleto.getValue().equals("Selecione")
                || boleto.equals("0")
                || dataPagamentoBoleto.getValue() == null) {

            util.alertConfiraFormulario();

        } else {
            PagarBoletoDAO boletoDAO = new PagarBoletoDAO();
            PagarBoleto s = new PagarBoleto(nome, dataVencimento, data, boleto, localPagamento, pagador);
            if (boletoDAO.atualizar(s)) {
                limparFormulario(
                        fotoEmpresa,
                        fotoUsuario,
                        nomeEmpresaBoleto,
                        produtoBoleto,
                        valorBoleto,
                        dataVencimentoBoleto,
                        parcelaBoleto,
                        formaPagamentoBoleto,
                        dataPagamentoBoleto,
                        valorPagoBoleto,
                        localPagamentoBoleto,
                        pagadorBoleto,
                        pagar,
                        listarTabela,
                        tabelaBoleto,
                        imprimir,
                        boletosPagos,
                        voltarMenu
                );
                bloquearCamposFormulario(
                        fotoEmpresa,
                        fotoUsuario,
                        nomeEmpresaBoleto,
                        produtoBoleto,
                        valorBoleto,
                        dataVencimentoBoleto,
                        parcelaBoleto,
                        formaPagamentoBoleto,
                        dataPagamentoBoleto,
                        valorPagoBoleto,
                        localPagamentoBoleto,
                        pagadorBoleto,
                        pagar,
                        listarTabela,
                        tabelaBoleto,
                        imprimir,
                        boletosPagos,
                        voltarMenu
                );
                tabelaBoleto.getItems().clear();
                util.alertAtualizacao("Boleto " + nome);//Fim do if.
            } else {
                util.alertNaoAtualizado("Boleto " + nome);
            }
        }
    }

    

    public void gerarRelatorio() {
        Utilitario util = new Utilitario(conn);
        String relatorio = "../src/relatorio/PagarBoleto.jasper";
        util.relatorio(relatorio);
    }

    public void preencherComboBoxLocalPagamento(ComboBox<PagarBoleto> localPagamento) {

        List<PagarBoleto> localPagamentoCB = new ArrayList<>();

        ObservableList<PagarBoleto> observableListPagarBoleto;

        PagarBoleto localPagamento1 = new PagarBoleto(1, "Aplicativo Banco");
        PagarBoleto localPagamento2 = new PagarBoleto(2, "Caixa Eletrônico");
        PagarBoleto localPagamento3 = new PagarBoleto(3, "Caixa do Banco");
        PagarBoleto localPagamento4 = new PagarBoleto(4, "Cartão de Crébito");
        PagarBoleto localPagamento5 = new PagarBoleto(5, "Própria Empresa");
        PagarBoleto localPagamento6 = new PagarBoleto(6, "Casa Lotérica");
        PagarBoleto localPagamento7 = new PagarBoleto(7, "PayPal");

        localPagamentoCB.add(localPagamento1);
        localPagamentoCB.add(localPagamento2);
        localPagamentoCB.add(localPagamento3);
        localPagamentoCB.add(localPagamento4);
        localPagamentoCB.add(localPagamento5);
        localPagamentoCB.add(localPagamento6);
        localPagamentoCB.add(localPagamento7);

        observableListPagarBoleto = FXCollections.observableArrayList(localPagamentoCB);

        localPagamento.setItems(observableListPagarBoleto);
    }

}
