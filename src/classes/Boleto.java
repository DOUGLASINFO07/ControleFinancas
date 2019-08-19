//Classe de implemento da Interface UsuarioInterface.
package classes;

import bancoConexaoDAO.BoletoDAO;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
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
public class Boleto extends Application {

    Connection conn;

    //VARIÁVEIS DA CLASSE.
    private String nomeEmpresaBoleto;
    private String produtoBoleto;
    private String valorBoleto;
    private String parcelaBoleto;
    private String dataVencimentoBoleto;
    private String formaPagamentoBoleto;
    private String caminhoFoto;
    private ImageView fotoEmpresa;
    
    private ImageView fotoEmpresa56;
    private ImageView fotoEmpresa12;

    //FIM DAS VARIÁVEIS.

    public Boleto(
            String nomeEmpresaBoleto,
            String produtoBoleto,
            String valorBoleto,
            String ParcelaBoleto,
            String dataVencimentoBoleto,
            String formaPagamentoBoleto,
            String caminhoFoto,
            ImageView fotoEmpresa
    ) {
        this.nomeEmpresaBoleto = nomeEmpresaBoleto;
        this.produtoBoleto = produtoBoleto;
        this.valorBoleto = valorBoleto;
        this.parcelaBoleto = parcelaBoleto;
        this.dataVencimentoBoleto = dataVencimentoBoleto;
        this.formaPagamentoBoleto = formaPagamentoBoleto;
        this.fotoEmpresa = fotoEmpresa;
    }

    public Boleto(
            String nomeEmpresaBoleto,
            String produtoBoleto,
            String valorBoleto,
            String ParcelaBoleto,
            String dataVencimentoBoleto,
            String formaPagamentoBoleto,
            String caminhoFoto
    ) {
        this.nomeEmpresaBoleto = nomeEmpresaBoleto;
        this.produtoBoleto = produtoBoleto;
        this.valorBoleto = valorBoleto;
        this.parcelaBoleto = parcelaBoleto;
        this.dataVencimentoBoleto = dataVencimentoBoleto;
        this.formaPagamentoBoleto = formaPagamentoBoleto;
        this.fotoEmpresa = fotoEmpresa;
        this.caminhoFoto = caminhoFoto;
    }

    public Boleto(
            String caminhoFoto,
            ImageView fotoEmpresa
    ) {
        this.caminhoFoto = caminhoFoto;
        this.fotoEmpresa = fotoEmpresa;
    }

    public Boleto(
            int posicao,
            String formaPagamentoBoleto
    ) {
        this.formaPagamentoBoleto = formaPagamentoBoleto;
    }

    public Boleto(
            String formaPagamentoBoleto
    ) {
        this.formaPagamentoBoleto = formaPagamentoBoleto;
    }

    public Boleto(
            String nomeEmpresaBoleto,
            String produtoBoleto,
            String valorBoleto,
            String dataVencimentoBoleto,
            String parcelaBoleto,
            String formaPagamentoBoleto
    ) {
        this.nomeEmpresaBoleto = nomeEmpresaBoleto;
        this.produtoBoleto = produtoBoleto;
        this.valorBoleto = valorBoleto;
        this.parcelaBoleto = parcelaBoleto;
        this.dataVencimentoBoleto = dataVencimentoBoleto;
        this.formaPagamentoBoleto = formaPagamentoBoleto;
    }

    //CONSTRUTOR VAZIO 
    public Boleto() {

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

    public String getParcelaBoleto() {
        return parcelaBoleto;
    }

    public void setParcelaBoleto(String parcelaBoleto) {
        this.parcelaBoleto = parcelaBoleto;
    }

    public String getDataVencimentoBoleto() {
        return dataVencimentoBoleto;
    }

    public void setDataVencimentoBoleto(String dataVencimentoBoleto) {
        this.dataVencimentoBoleto = dataVencimentoBoleto;
    }

    public String getFormaPagamentoBoleto() {
        return formaPagamentoBoleto;
    }

    public void setFormaPagamentoBoleto(String formaPagamentoBoleto) {
        this.formaPagamentoBoleto = formaPagamentoBoleto;
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

    @Override
    public String toString() {
        return getFormaPagamentoBoleto();
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
            Logger.getLogger(Boleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //CONJUNTO DE MÉTODOS PARA ABRIR A TELA CADASTRO DE USUÁRIO.
    private static Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        Boleto.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/FXMLBoleto.fxml"));
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
            Button novoBoleto,
            ComboBox empresaBoleto,
            ComboBox produtoBoleto,
            TextField valorBoleto,
            TextField parcelaBoleto,
            DatePicker dataVencimentoBoleto,
            ComboBox formaPagamentoBoleto,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Boleto> tabelaBoleto,
            Button imprimir,
            Button voltarMenu
    ) {
        empresaBoleto.setValue("Selecione");
        produtoBoleto.setValue("Selecione");
        valorBoleto.setText("");
        parcelaBoleto.setText("");
        dataVencimentoBoleto.setValue(null);
        formaPagamentoBoleto.setValue("Selecione");
        fotoEmpresa.setImage(new Image("/imagens/semFoto.jpg"));
    }

    public void liberarCamposFormulario(
            ImageView fotoEmpresa,
            Button novoBoleto,
            ComboBox empresaBoleto,
            ComboBox produtoBoleto,
            TextField valorBoleto,
            TextField parcelaBoleto,
            DatePicker dataVencimentoBoleto,
            ComboBox formaPagamentoBoleto,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Boleto> tabelaBoleto,
            Button imprimir,
            Button voltarMenu
    ) {
        empresaBoleto.setDisable(false);
        produtoBoleto.setDisable(false);
        valorBoleto.setEditable(true);
        parcelaBoleto.setEditable(true);
        dataVencimentoBoleto.setEditable(true);
        formaPagamentoBoleto.setDisable(false);
        valorBoleto.setDisable(false);
        parcelaBoleto.setDisable(false);
        dataVencimentoBoleto.setDisable(false);
        formaPagamentoBoleto.setDisable(false);
        atualizar.setDisable(false);
        excluir.setDisable(false);

//        Platform.runLater(empresaBoleto::requestFocus);
    }

    public void bloquearCamposFormulario(
            ImageView fotoEmpresa,
            Button novoBoleto,
            ComboBox empresaBoleto,
            ComboBox produtoBoleto,
            TextField valorBoleto,
            TextField parcelaBoleto,
            DatePicker dataVencimentoBoleto,
            ComboBox formaPagamentoBoleto,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Boleto> tabelaBoleto,
            Button imprimir,
            Button voltarMenu
    ) {
        empresaBoleto.setDisable(true);
        produtoBoleto.setDisable(true);
        valorBoleto.setDisable(true);
        parcelaBoleto.setDisable(true);
        dataVencimentoBoleto.setDisable(true);
        formaPagamentoBoleto.setDisable(true);
        salvar.setDisable(true);
        atualizar.setDisable(true);
        excluir.setDisable(true);
        imprimir.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn nome,
            TableColumn produto,
            TableColumn valorBoleto,
            TableColumn parcelas,
            TableColumn vencimento,
            TableColumn formaPagamento,
            TableView<Boleto> tabelaBoleto
    ) {
        nome.setCellValueFactory(new PropertyValueFactory("nomeEmpresaBoleto"));
        produto.setCellValueFactory(new PropertyValueFactory("produtoBoleto"));
        valorBoleto.setCellValueFactory(new PropertyValueFactory("valorBoleto"));
        parcelas.setCellValueFactory(new PropertyValueFactory("parcelaBoleto"));
        vencimento.setCellValueFactory(new PropertyValueFactory("dataVencimentoBoleto"));
        formaPagamento.setCellValueFactory(new PropertyValueFactory("formaPagamentoBoleto"));
        tabelaBoleto.setItems(atualizaTabela());
    }

    public ObservableList<Boleto> atualizaTabela() {
        BoletoDAO dao = new BoletoDAO();
        return FXCollections.observableArrayList(dao.listaBoleto());
    }

    public void pegarDadoTabela(
            ImageView fotoEmpresa,
            Button novoBoleto,
            ComboBox empresaBoleto,
            ComboBox produtoBoleto,
            TextField valorBoleto,
            TextField parcelaBoleto,
            DatePicker dataVencimentoBoleto,
            ComboBox formaPagamentoBoleto,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Boleto> tabelaBoleto,
            Button imprimir,
            Button voltarMenu
    ) {
        empresaBoleto.setValue(tabelaBoleto.getSelectionModel().getSelectedItem().getNomeEmpresaBoleto());
        produtoBoleto.setValue(tabelaBoleto.getSelectionModel().getSelectedItem().getProdutoBoleto());
        valorBoleto.setText("" + tabelaBoleto.getSelectionModel().getSelectedItem().getValorBoleto());
        parcelaBoleto.setText("" + tabelaBoleto.getSelectionModel().getSelectedItem().getParcelaBoleto());

        String data = tabelaBoleto.getSelectionModel().getSelectedItem().getDataVencimentoBoleto();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataVencimentoBoleto.setValue(LocalDate.parse(data, formatter));

        formaPagamentoBoleto.setValue(tabelaBoleto.getSelectionModel().getSelectedItem().getFormaPagamentoBoleto());

        String nome = tabelaBoleto.getSelectionModel().getSelectedItem().getNomeEmpresaBoleto();

        setCaminhoFoto("");
        BoletoDAO dao = new BoletoDAO();

        dao.buscarFoto(nome);
//        fotoEmpresa.getClass().getResource(dao.getCaminhoFoto());
        fotoEmpresa.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));

        caminhoFoto = dao.getCaminhoFoto();

        System.out.println("" + dao.getCaminhoFoto());

    }
    //FIM DOS MÉTODO PARA MANIPULAÇÃO DA TABELA.

    public void cadastrarBoleto(
            String caminhoFoto,
            ImageView fotoEmpresa,
            Button novoBoleto,
            ComboBox empresaBoleto,
            ComboBox produtoBoleto,
            TextField valorBoleto,
            TextField parcelaBoleto,
            DatePicker dataVencimentoBoleto,
            ComboBox formaPagamentoBoleto,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Boleto> tabelaBoleto,
            Button imprimir,
            Button voltarMenu
    ) {
        Utilitario util = new Utilitario();

        String nome = empresaBoleto.getSelectionModel().getSelectedItem().toString();
        String produto = produtoBoleto.getSelectionModel().getSelectedItem().toString();

        String boleto;
        if ("".equals(valorBoleto.getText())) {
            boleto = "0";
        } else {
            boleto = util.converterCifraoBrasiloAmericano(valorBoleto.getText());
        }

        int parcela;
        if ("".equals(parcelaBoleto.getText())) {
            parcela = 0;
        } else {
            parcela = Integer.parseInt(parcelaBoleto.getText());
        }

        LocalDate dataRecebimento1 = dataVencimentoBoleto.getValue();
        String data = util.converterDataAmericanoBrasil("" + dataRecebimento1);
        System.out.println(data);

        String formaPagamento = formaPagamentoBoleto.getSelectionModel().getSelectedItem().toString();

        //confere se todos os campos estão preenchidos
        if (empresaBoleto.getValue().equals("Selecione")
                || produtoBoleto.getValue().equals("Selecione")
                || boleto.equals("0")
                || parcela == 0
                || dataVencimentoBoleto.getValue() == null
                || formaPagamentoBoleto.getValue().equals("Selecione")) {

            util.alertConfiraFormulario();

            Platform.runLater(empresaBoleto::requestFocus);

        } else {

            int contador = 1;
            int diaVencimento = Integer.parseInt((String) data.subSequence(0, 2));
            int mesVencimento = Integer.parseInt((String) data.subSequence(3, 5));
            int anoVencimento = Integer.parseInt((String) data.subSequence(6, 10));
            String dataVencimento;

            while (parcela >= contador) {

                if (mesVencimento > 12) {
                    mesVencimento = 1;
                    anoVencimento++;

                    String diaVencimentoTeste;
                    String mesVencimentoTeste;

                    if (diaVencimento <= 9) {
                        diaVencimentoTeste = "0" + diaVencimento;
                    } else {
                        diaVencimentoTeste = "" + diaVencimento;
                    }
                    if (mesVencimento <= 9) {
                        mesVencimentoTeste = "0" + mesVencimento;
                    } else {
                        mesVencimentoTeste = "" + mesVencimento;
                    }
                    dataVencimento = anoVencimento + "/" + mesVencimentoTeste + "/" + diaVencimentoTeste;
                } else {
                    String diaVencimentoTeste;
                    String mesVencimentoTeste;
                    if (diaVencimento <= 9) {
                        diaVencimentoTeste = "0" + diaVencimento;
                    } else {
                        diaVencimentoTeste = "" + diaVencimento;
                    }
                    if (mesVencimento <= 9) {
                        mesVencimentoTeste = "0" + mesVencimento;
                    } else {
                        mesVencimentoTeste = "" + mesVencimento;
                    }
                    dataVencimento = anoVencimento + "/" + mesVencimentoTeste + "/" + diaVencimentoTeste;
                }

                mesVencimento++;

                setDataVencimentoBoleto(dataVencimento);

                //Confere se está tudo ok com o banco de dados
                BoletoDAO boletoDAO = new BoletoDAO();
                Boleto s = new Boleto(nome, produto, boleto, dataVencimento, contador + " de " + parcela, formaPagamento);

                if (boletoDAO.Inserir(s)) {
                    contador++;
//                            Platform.runLater(NovoCadastro::requestFocus);//fim do run.
                    limparFormulario(
                            fotoEmpresa,
                            novoBoleto,
                            empresaBoleto,
                            produtoBoleto,
                            valorBoleto,
                            parcelaBoleto,
                            dataVencimentoBoleto,
                            formaPagamentoBoleto,
                            salvar,
                            atualizar,
                            excluir,
                            listarTabela,
                            tabelaBoleto,
                            imprimir,
                            voltarMenu
                    );

                    bloquearCamposFormulario(
                            fotoEmpresa,
                            novoBoleto,
                            empresaBoleto,
                            produtoBoleto,
                            valorBoleto,
                            parcelaBoleto,
                            dataVencimentoBoleto,
                            formaPagamentoBoleto,
                            salvar,
                            atualizar,
                            excluir,
                            listarTabela,
                            tabelaBoleto,
                            imprimir,
                            voltarMenu
                    );
                    if (contador == 2) {
                        //exibe mensagem de cadastrado com sucesso.
                        util.alertCadastrado("Boleto " + nome);//Fim do if.
                    }
                    
                    Platform.runLater(() -> {
                        Platform.runLater(novoBoleto::requestFocus);
                    });
//                           if (event.getCode() == KeyCode.TAB) {
                    salvar.setDisable(true);
                } else {
                    util.alertNaoCadastrado("Boleto " + nome);
                }

            }
        }
    }

    public void atualizarBoleto(
            ImageView fotoEmpresa,
            Button novoBoleto,
            ComboBox empresaBoleto,
            ComboBox produtoBoleto,
            TextField valorBoleto,
            TextField parcelaBoleto,
            DatePicker dataVencimentoBoleto,
            ComboBox formaPagamentoBoleto,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Boleto> tabelaBoleto,
            Button imprimir,
            Button voltarMenu
    ) {
        Utilitario util = new Utilitario();

        String nome = empresaBoleto.getSelectionModel().getSelectedItem().toString();
        String produto = produtoBoleto.getSelectionModel().getSelectedItem().toString();

        String boleto;
        if ("".equals(valorBoleto.getText())) {
            boleto = "0";
        } else {
            boleto = util.converterCifraoBrasiloAmericano(valorBoleto.getText());
        }

        String parcela = parcelaBoleto.getText();

        LocalDate dataRecebimento1 = dataVencimentoBoleto.getValue();
        String data = "" + dataRecebimento1;

        String formaPagamento = formaPagamentoBoleto.getSelectionModel().getSelectedItem().toString();

        //confere se todos os campos estão preenchidos
        if (empresaBoleto.getValue().equals("Selecione")
                || produtoBoleto.getValue().equals("Selecione")
                || boleto.equals("0")
                || parcela.equals("")
                || dataVencimentoBoleto.getValue() == null
                || formaPagamentoBoleto.getValue().equals("Selecione")) {

            util.alertConfiraFormulario();

            Platform.runLater(empresaBoleto::requestFocus);

        } else {
            BoletoDAO boletoDAO = new BoletoDAO();
            Boleto s = new Boleto(nome, produto, boleto, data, parcela, formaPagamento);
            if (boletoDAO.atualizar(s)) {
                limparFormulario(
                        fotoEmpresa,
                        novoBoleto,
                        empresaBoleto,
                        produtoBoleto,
                        valorBoleto,
                        parcelaBoleto,
                        dataVencimentoBoleto,
                        formaPagamentoBoleto,
                        salvar,
                        atualizar,
                        excluir,
                        listarTabela,
                        tabelaBoleto,
                        imprimir,
                        voltarMenu
                );
                bloquearCamposFormulario(
                        fotoEmpresa,
                        novoBoleto,
                        empresaBoleto,
                        produtoBoleto,
                        valorBoleto,
                        parcelaBoleto,
                        dataVencimentoBoleto,
                        formaPagamentoBoleto,
                        salvar,
                        atualizar,
                        excluir,
                        listarTabela,
                        tabelaBoleto,
                        imprimir,
                        voltarMenu
                );
                tabelaBoleto.getItems().clear();
                util.alertAtualizacao("Boleto " + nome);//Fim do if.
            } else {
                util.alertNaoAtualizado("Boleto " + nome);
            }
        }
    }

    public void excluirBoleto(
            ImageView fotoEmpresa,
            Button novoBoleto,
            ComboBox empresaBoleto,
            ComboBox produtoBoleto,
            TextField valorBoleto,
            TextField parcelaBoleto,
            DatePicker dataVencimentoBoleto,
            ComboBox formaPagamentoBoleto,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Boleto> tabelaBoleto,
            Button imprimir,
            Button voltarMenu
    ) {
        Utilitario util = new Utilitario();

        String nome = (String) empresaBoleto.getValue();
        String produto = (String) produtoBoleto.getValue();
        String boleto = valorBoleto.getText();
        String parcela = valorBoleto.getText();
        String data = dataVencimentoBoleto.getValue().toString();
        String formaPagamento = (String) formaPagamentoBoleto.getValue();

        //Confere se está tudo ok com o banco de dados
        BoletoDAO boletoDAO = new BoletoDAO();
        Boleto e = new Boleto(nome, produto, boleto, data, parcela, formaPagamento);
        if (boletoDAO.apagar(e)) {

            limparFormulario(
                    fotoEmpresa,
                    novoBoleto,
                    empresaBoleto,
                    produtoBoleto,
                    valorBoleto,
                    parcelaBoleto,
                    dataVencimentoBoleto,
                    formaPagamentoBoleto,
                    salvar,
                    atualizar,
                    excluir,
                    listarTabela,
                    tabelaBoleto,
                    imprimir,
                    voltarMenu
            );

            bloquearCamposFormulario(
                    fotoEmpresa,
                    novoBoleto,
                    empresaBoleto,
                    produtoBoleto,
                    valorBoleto,
                    parcelaBoleto,
                    dataVencimentoBoleto,
                    formaPagamentoBoleto,
                    salvar,
                    atualizar,
                    excluir,
                    listarTabela,
                    tabelaBoleto,
                    imprimir,
                    voltarMenu
            );
            tabelaBoleto.getItems().clear();
            //exibe mensagem de cadastrado com sucesso.
            util.alertExcluido("Boleto " + nome);//Fim do if.

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoBoleto::requestFocus);//fim do run.

        } else {
            util.alertNaoExcluído("Boleto " + nome);
        }
    }

    public void gerarRelatorio() {
        Utilitario util = new Utilitario(conn);
        String relatorio = "../src/relatorio/Boleto.jasper";
        util.relatorio(relatorio);
    }

    public void preencherComboBoxTipoPagamento(ComboBox<Boleto> tipoPagamento) {

        List<Boleto> tipoPagamentoCB = new ArrayList<>();

        ObservableList<Boleto> observableListBoleto;

        Boleto tipoPagamento1 = new Boleto(1, "Boleto");
        Boleto tipoPagamento2 = new Boleto(2, "Transferência");
        Boleto tipoPagamento3 = new Boleto(3, "Promissória");
        Boleto tipoPagamento4 = new Boleto(4, "Cartão de Débito");
        Boleto tipoPagamento5 = new Boleto(5, "Em mãos");
        Boleto tipoPagamento6 = new Boleto(6, "Cartão de crédito");
//        Boleto tipoPagamento7 = new Boleto(7, "Semanal");

        tipoPagamentoCB.add(tipoPagamento1);
        tipoPagamentoCB.add(tipoPagamento2);
        tipoPagamentoCB.add(tipoPagamento3);
        tipoPagamentoCB.add(tipoPagamento4);
        tipoPagamentoCB.add(tipoPagamento5);
        tipoPagamentoCB.add(tipoPagamento6);
//        tipoPagamentoCB.add(tipoPagamento7);

        observableListBoleto = FXCollections.observableArrayList(tipoPagamentoCB);

        tipoPagamento.setItems(observableListBoleto);

    }

////    MÉTODOS PARA MANIPULAÇÃO DA TABELA.
//    public void preencherComboBoxEmpresa(
//            ComboBox<Boleto> empresa
//    ) {
//        BoletoDAO dao = new BoletoDAO();
//
//        empresa.setItems(dao.listaEmpresa());
//
//    }
}
