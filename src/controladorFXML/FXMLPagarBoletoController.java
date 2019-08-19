package controladorFXML;

import bancoConexaoDAO.BoletoDAO;
import bancoConexaoDAO.PagarBoletoDAO;
import classes.Boleto;
import classes.Boleto;
import classes.PagarBoleto;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import util.Relogio;
import util.Utilitario;

/**
 * @author douglas borges egidio
 */
public class FXMLPagarBoletoController implements Initializable {

    PagarBoleto pagarBoleto = new PagarBoleto();

    private String caminhoFoto;

    public FXMLPagarBoletoController( //            ComboBox nomeEmpresaCB,
            //            TextField boletoTF,
            //            DatePicker dataRecebimentoDP,
            //            ComboBox tipoPagamentoCB
            ) {
//        this.nomeEmpresaCB = nomeEmpresaCB;
//        this.boletoTF = boletoTF;
//        this.dataRecebimentoDP = dataRecebimentoDP;
//        this.tipoPagamentoCB = tipoPagamentoCB;
    }

//    public FXMLBoletoController() {
//
//    }
    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private Pane formularioPane;

    @FXML
    private ImageView fotoEmpresaIV;

    @FXML
    private TextField parcelaTF;

    @FXML
    private Button pagarBT;

    @FXML
    private TextField valorBoletoTF;

    @FXML
    private TextField nomeEmpresaTF;

    @FXML
    private TextField produtoTF;

    @FXML
    private TextField dataVencimentoTF;

    @FXML
    private TextField formaPagamentoTF;

    @FXML
    private TextField valorPagamentoTF;

    @FXML
    private ComboBox<PagarBoleto> localPagamentoCB;

    @FXML
    private ComboBox<PagarBoleto> pagadorCB;

    @FXML
    private DatePicker dataPagamentoDP;

    @FXML
    private ImageView fotoUsuarioIV;

    @FXML
    private TableView<PagarBoleto> tabelaPagarBoletoTV;

    @FXML
    private TableColumn<PagarBoleto, String> colunaNomeEmpresa;

    @FXML
    private TableColumn<PagarBoleto, String> colunaProduto;

    @FXML
    private TableColumn<PagarBoleto, String> colunaValorBoleto;

    @FXML
    private TableColumn<PagarBoleto, String> colunaParcela;

    @FXML
    private TableColumn<PagarBoleto, String> colunaVencimento;

    @FXML
    private TableColumn<PagarBoleto, String> colunaFormaPagamento;

    @FXML
    private Button imprimirBT;

    @FXML
    private Button listarTabelaBT;

    @FXML
    private Button boletosPagosBT;

    @FXML
    private Button voltarMenuBT;

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    public Label getDataLB() {
        return dataLB;
    }

    public void setDataLB(Label dataLB) {
        this.dataLB = dataLB;
    }

    public Label getHorasLB() {
        return horasLB;
    }

    public void setHorasLB(Label horasLB) {
        this.horasLB = horasLB;
    }

    public Pane getFormularioPane() {
        return formularioPane;
    }

    public void setFormularioPane(Pane formularioPane) {
        this.formularioPane = formularioPane;
    }

    public ImageView getFotoEmpresaIV() {
        return fotoEmpresaIV;
    }

    public void setFotoEmpresaIV(ImageView fotoEmpresaIV) {
        this.fotoEmpresaIV = fotoEmpresaIV;
    }

    public TextField getParcelaTF() {
        return parcelaTF;
    }

    public void setParcelaTF(TextField parcelaTF) {
        this.parcelaTF = parcelaTF;
    }

    public Button getPagarBT() {
        return pagarBT;
    }

    public void setPagarBT(Button pagarBT) {
        this.pagarBT = pagarBT;
    }

    public TextField getValorBoletoTF() {
        return valorBoletoTF;
    }

    public void setValorBoletoTF(TextField valorBoletoTF) {
        this.valorBoletoTF = valorBoletoTF;
    }

    public TextField getNomeEmpresaTF() {
        return nomeEmpresaTF;
    }

    public void setNomeEmpresaTF(TextField nomeEmpresaTF) {
        this.nomeEmpresaTF = nomeEmpresaTF;
    }

    public TextField getProdutoTF() {
        return produtoTF;
    }

    public void setProdutoTF(TextField produtoTF) {
        this.produtoTF = produtoTF;
    }

    public TextField getDataVencimentoTF() {
        return dataVencimentoTF;
    }

    public void setDataVencimentoTF(TextField dataVencimentoTF) {
        this.dataVencimentoTF = dataVencimentoTF;
    }

    public TextField getFormaPagamentoTF() {
        return formaPagamentoTF;
    }

    public void setFormaPagamentoTF(TextField formaPagamentoTF) {
        this.formaPagamentoTF = formaPagamentoTF;
    }

    public TextField getValorPagamentoTF() {
        return valorPagamentoTF;
    }

    public void setValorPagamentoTF(TextField valorPagamentoTF) {
        this.valorPagamentoTF = valorPagamentoTF;
    }

    public ComboBox<PagarBoleto> getLocalPagamentoCB() {
        return localPagamentoCB;
    }

    public void setLocalPagamentoCB(ComboBox<PagarBoleto> localPagamentoCB) {
        this.localPagamentoCB = localPagamentoCB;
    }

    public ComboBox<PagarBoleto> getPagadorCB() {
        return pagadorCB;
    }

    public void setPagadorCB(ComboBox<PagarBoleto> pagadorCB) {
        this.pagadorCB = pagadorCB;
    }

    public DatePicker getDataPagaemntoDP() {
        return dataPagamentoDP;
    }

    public void setDataPagaemntoDP(DatePicker dataPagamentoDP) {
        this.dataPagamentoDP = dataPagamentoDP;
    }

    public ImageView getFotoUsuarioIV() {
        return fotoUsuarioIV;
    }

    public void setFotoUsuarioIV(ImageView fotoUsuarioIV) {
        this.fotoUsuarioIV = fotoUsuarioIV;
    }

    public TableView<PagarBoleto> getTabelaPagarBoletoTV() {
        return tabelaPagarBoletoTV;
    }

    public void setTabelaPagarBoletoTV(TableView<PagarBoleto> tabelaPagarBoletoTV) {
        this.tabelaPagarBoletoTV = tabelaPagarBoletoTV;
    }

    public TableColumn<PagarBoleto, String> getColunaNomeEmpresa() {
        return colunaNomeEmpresa;
    }

    public void setColunaNomeEmpresa(TableColumn<PagarBoleto, String> colunaNomeEmpresa) {
        this.colunaNomeEmpresa = colunaNomeEmpresa;
    }

    public TableColumn<PagarBoleto, String> getColunaProduto() {
        return colunaProduto;
    }

    public void setColunaProduto(TableColumn<PagarBoleto, String> colunaProduto) {
        this.colunaProduto = colunaProduto;
    }

    public TableColumn<PagarBoleto, String> getColunaValorBoleto() {
        return colunaValorBoleto;
    }

    public void setColunaValorBoleto(TableColumn<PagarBoleto, String> colunaValorBoleto) {
        this.colunaValorBoleto = colunaValorBoleto;
    }

    public TableColumn<PagarBoleto, String> getColunaParcela() {
        return colunaParcela;
    }

    public void setColunaParcela(TableColumn<PagarBoleto, String> colunaParcela) {
        this.colunaParcela = colunaParcela;
    }

    public TableColumn<PagarBoleto, String> getColunaVencimento() {
        return colunaVencimento;
    }

    public void setColunaVencimento(TableColumn<PagarBoleto, String> colunaVencimento) {
        this.colunaVencimento = colunaVencimento;
    }

    public TableColumn<PagarBoleto, String> getColunaFormaPagamento() {
        return colunaFormaPagamento;
    }

    public void setColunaFormaPagamento(TableColumn<PagarBoleto, String> colunaFormaPagamento) {
        this.colunaFormaPagamento = colunaFormaPagamento;
    }

    public Button getImprimirBT() {
        return imprimirBT;
    }

    public void setImprimirBT(Button imprimirBT) {
        this.imprimirBT = imprimirBT;
    }

    public Button getListarTabelaBT() {
        return listarTabelaBT;
    }

    public void setListarTabelaBT(Button listarTabelaBT) {
        this.listarTabelaBT = listarTabelaBT;
    }

    public Button getBoletosPagosBT() {
        return boletosPagosBT;
    }

    public void setBoletosPagosBT(Button boletosPagosBT) {
        this.boletosPagosBT = boletosPagosBT;
    }

    public Button getVoltarMenuBT() {
        return voltarMenuBT;
    }

    public void setVoltarMenuBT(Button voltarMenuBT) {
        this.voltarMenuBT = voltarMenuBT;
    }

    //IDENTIFICAÇÃO DOS COMPONENTES DA INTERFACE GRÁFICA.
    //CONSTRUTOR INICIALIZADOR DA CLASSE QUE CONTROLA AS AÇÕES 
    //DOS COMPONENTES DA INTERFACE GRÁFICA USUÁRIO.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Relogio relogio = new Relogio(horasLB);
        PagarBoleto pB = new PagarBoleto();
        pB.bloquearCamposFormulario(
                fotoEmpresaIV,
                fotoUsuarioIV,
                nomeEmpresaTF,
                produtoTF,
                valorBoletoTF,
                dataVencimentoTF,
                parcelaTF,
                formaPagamentoTF,
                dataPagamentoDP,
                valorPagamentoTF,
                localPagamentoCB,
                pagadorCB,
                pagarBT,
                listarTabelaBT,
                tabelaPagarBoletoTV,
                imprimirBT,
                boletosPagosBT,
                voltarMenuBT
        );

//        e.limitarQantidadeCaractere(getTelefoneBoletoTF(), 14);
//        Utilitario.validarTextField(getTelefoneBoletoTF());
//        e.formatarTelefone(getTelefoneBoletoTF());
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date = new Date();
        dataLB.setTextFill(Color.GRAY);
        dataLB.setText("Hoje é " + sdf.format(date));

        Utilitario util = new Utilitario();
        util.campoMoeda(valorBoletoTF);
        util.campoMoeda(valorPagamentoTF);

        Platform.runLater(listarTabelaBT::requestFocus);//fim do run.

        try {
            relogio.relogio();
        } catch (Exception ex) {
            Logger.getLogger(Boleto.class.getName()).log(Level.SEVERE, null, ex);
        }

        pagarBoleto.preencherComboBoxLocalPagamento(localPagamentoCB);

        PagarBoletoDAO dao = new PagarBoletoDAO();
        dao.listaUsuario(pagadorCB);

    }//FIM DOS CONSTRUTOR.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO TECLADO(TECLA ENTER)
    void voltarMenuBTTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            pagarBoleto.abrirMenu();
        }

        if (event.getCode() == KeyCode.TAB) {
            if (dataPagamentoDP.isDisable()) {
                Platform.runLater(listarTabelaBT::requestFocus);//fim do run.
            } else {
                Platform.runLater(dataPagamentoDP::requestFocus);//fim do run.
            }
        }

    }//FIM DO MÉTODO kEYEVENT.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO CLIC DO MOUSE.
    void voltarMenuBTMouse(MouseEvent event) {
        pagarBoleto.abrirMenu();
    }//FIM DO MÉTODO.

    @FXML
    void listarTabelaBTMouse(MouseEvent event) {

        pagarBoleto.limparFormulario(
                fotoEmpresaIV,
                fotoUsuarioIV,
                nomeEmpresaTF,
                produtoTF,
                valorBoletoTF,
                dataVencimentoTF,
                parcelaTF,
                formaPagamentoTF,
                dataPagamentoDP,
                valorPagamentoTF,
                localPagamentoCB,
                pagadorCB,
                pagarBT,
                listarTabelaBT,
                tabelaPagarBoletoTV,
                imprimirBT,
                boletosPagosBT,
                voltarMenuBT
        );

        pagarBoleto.bloquearCamposFormulario(
                fotoEmpresaIV,
                fotoUsuarioIV,
                nomeEmpresaTF,
                produtoTF,
                valorBoletoTF,
                dataVencimentoTF,
                parcelaTF,
                formaPagamentoTF,
                dataPagamentoDP,
                valorPagamentoTF,
                localPagamentoCB,
                pagadorCB,
                pagarBT,
                listarTabelaBT,
                tabelaPagarBoletoTV,
                imprimirBT,
                boletosPagosBT,
                voltarMenuBT
        );

        pagarBoleto.iniciarTabela(
                colunaNomeEmpresa,
                colunaProduto,
                colunaValorBoleto,
                colunaParcela,
                colunaVencimento,
                colunaFormaPagamento,
                tabelaPagarBoletoTV
        );

        imprimirBT.setDisable(false);
//        //Inicio run que encapsula o requestFocus().
        Platform.runLater(tabelaPagarBoletoTV::requestFocus);//fim do run.

        tabelaPagarBoletoTV.getSelectionModel().selectFirst();
    }

    @FXML
    void listarTabelaBTTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            pagarBoleto.limparFormulario(
                    fotoEmpresaIV,
                    fotoUsuarioIV,
                    nomeEmpresaTF,
                    produtoTF,
                    valorBoletoTF,
                    dataVencimentoTF,
                    parcelaTF,
                    formaPagamentoTF,
                    dataPagamentoDP,
                    valorPagamentoTF,
                    localPagamentoCB,
                    pagadorCB,
                    pagarBT,
                    listarTabelaBT,
                    tabelaPagarBoletoTV,
                    imprimirBT,
                    boletosPagosBT,
                    voltarMenuBT
            );
            pagarBoleto.bloquearCamposFormulario(
                    fotoEmpresaIV,
                    fotoUsuarioIV,
                    nomeEmpresaTF,
                    produtoTF,
                    valorBoletoTF,
                    dataVencimentoTF,
                    parcelaTF,
                    formaPagamentoTF,
                    dataPagamentoDP,
                    valorPagamentoTF,
                    localPagamentoCB,
                    pagadorCB,
                    pagarBT,
                    listarTabelaBT,
                    tabelaPagarBoletoTV,
                    imprimirBT,
                    boletosPagosBT,
                    voltarMenuBT
            );

            pagarBoleto.iniciarTabela(
                    colunaNomeEmpresa,
                    colunaProduto,
                    colunaValorBoleto,
                    colunaParcela,
                    colunaVencimento,
                    colunaFormaPagamento,
                    tabelaPagarBoletoTV
            );
            imprimirBT.setDisable(false);

            Platform.runLater(tabelaPagarBoletoTV::requestFocus);//fim do run.

            tabelaPagarBoletoTV.getSelectionModel().selectFirst();
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaPagarBoletoTV::requestFocus);//fim do run.
        }
    }

    @FXML
    void tabelaPagarBoletoTVMouse(MouseEvent event) {

        pagarBoleto.liberarCamposFormulario(
                fotoEmpresaIV,
                fotoUsuarioIV,
                nomeEmpresaTF,
                produtoTF,
                valorBoletoTF,
                dataVencimentoTF,
                parcelaTF,
                formaPagamentoTF,
                dataPagamentoDP,
                valorPagamentoTF,
                localPagamentoCB,
                pagadorCB,
                pagarBT,
                listarTabelaBT,
                tabelaPagarBoletoTV,
                imprimirBT,
                boletosPagosBT,
                voltarMenuBT
        );
        pagarBoleto.pegarDadoTabela(
                fotoEmpresaIV,
                fotoUsuarioIV,
                nomeEmpresaTF,
                produtoTF,
                valorBoletoTF,
                dataVencimentoTF,
                parcelaTF,
                formaPagamentoTF,
                dataPagamentoDP,
                valorPagamentoTF,
                localPagamentoCB,
                pagadorCB,
                pagarBT,
                listarTabelaBT,
                tabelaPagarBoletoTV,
                imprimirBT,
                boletosPagosBT,
                voltarMenuBT
        );
        Platform.runLater(dataPagamentoDP::requestFocus);//fim do run.
    }

    @FXML
    void tabelaPagarBoletoTVTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            pagarBoleto.liberarCamposFormulario(
                    fotoEmpresaIV,
                    fotoUsuarioIV,
                    nomeEmpresaTF,
                    produtoTF,
                    valorBoletoTF,
                    dataVencimentoTF,
                    parcelaTF,
                    formaPagamentoTF,
                    dataPagamentoDP,
                    valorPagamentoTF,
                    localPagamentoCB,
                    pagadorCB,
                    pagarBT,
                    listarTabelaBT,
                    tabelaPagarBoletoTV,
                    imprimirBT,
                    boletosPagosBT,
                    voltarMenuBT
            );
            pagarBoleto.pegarDadoTabela(
                    fotoEmpresaIV,
                    fotoUsuarioIV,
                    nomeEmpresaTF,
                    produtoTF,
                    valorBoletoTF,
                    dataVencimentoTF,
                    parcelaTF,
                    formaPagamentoTF,
                    dataPagamentoDP,
                    valorPagamentoTF,
                    localPagamentoCB,
                    pagadorCB,
                    pagarBT,
                    listarTabelaBT,
                    tabelaPagarBoletoTV,
                    imprimirBT,
                    boletosPagosBT,
                    voltarMenuBT
            );
            Platform.runLater(dataPagamentoDP::requestFocus);//fim do run.
        }

        tabelaPagarBoletoTV.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                pagarBoleto.pegarDadoTabela(
                        fotoEmpresaIV,
                        fotoUsuarioIV,
                        nomeEmpresaTF,
                        produtoTF,
                        valorBoletoTF,
                        dataVencimentoTF,
                        parcelaTF,
                        formaPagamentoTF,
                        dataPagamentoDP,
                        valorPagamentoTF,
                        localPagamentoCB,
                        pagadorCB,
                        pagarBT,
                        listarTabelaBT,
                        tabelaPagarBoletoTV,
                        imprimirBT,
                        boletosPagosBT,
                        voltarMenuBT
                );
            }
        });

        if (event.getCode() == KeyCode.TAB) {
            if (imprimirBT.isDisable()) {
                Platform.runLater(boletosPagosBT::requestFocus);//fim do run.
            } else {
                Platform.runLater(imprimirBT::requestFocus);//fim do run.
            }
        }

    }

    @FXML
    void pagarMouse(MouseEvent event) {

        pagarBoleto.atualizarBoleto(
                fotoEmpresaIV,
                fotoUsuarioIV,
                nomeEmpresaTF,
                produtoTF,
                valorBoletoTF,
                dataVencimentoTF,
                parcelaTF,
                formaPagamentoTF,
                dataPagamentoDP,
                valorPagamentoTF,
                localPagamentoCB,
                pagadorCB,
                pagarBT,
                listarTabelaBT,
                tabelaPagarBoletoTV,
                imprimirBT,
                boletosPagosBT,
                voltarMenuBT
        );
        Platform.runLater(listarTabelaBT::requestFocus);//fim do run.
    }

    @FXML
    void pagarTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pagarBoleto.atualizarBoleto(
                    fotoEmpresaIV,
                    fotoUsuarioIV,
                    nomeEmpresaTF,
                    produtoTF,
                    valorBoletoTF,
                    dataVencimentoTF,
                    parcelaTF,
                    formaPagamentoTF,
                    dataPagamentoDP,
                    valorPagamentoTF,
                    localPagamentoCB,
                    pagadorCB,
                    pagarBT,
                    listarTabelaBT,
                    tabelaPagarBoletoTV,
                    imprimirBT,
                    boletosPagosBT,
                    voltarMenuBT
            );
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(listarTabelaBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pagarBoleto.gerarRelatorio();
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(boletosPagosBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void imprimirBTMouse(MouseEvent event) {

        pagarBoleto.gerarRelatorio();
    }

    @FXML
    void pagadorCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(pagarBT::requestFocus);//fim do run.
        }

        if (event.getCode() == KeyCode.ENTER) {
            pagadorCB.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    PagarBoletoDAO dao = new PagarBoletoDAO();
                    String nome = (String) (Object) pagadorCB.getSelectionModel().getSelectedItem();
                    System.out.println(nome);
                    dao.buscarFotoUsuario("" + nome);
//            fotoEmpresaIV.getClass().getResource(dao.getCaminhoFoto());
                    fotoUsuarioIV.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));
                    System.out.println("" + dao.getCaminhoFoto());
                }
            });
        }

        pagadorCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PagarBoletoDAO dao = new PagarBoletoDAO();
                String nome = (String) (Object) pagadorCB.getSelectionModel().getSelectedItem();
                System.out.println(nome);
                dao.buscarFotoUsuario("" + nome);
                fotoUsuarioIV.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));
                System.out.println("" + dao.getCaminhoFoto());
            }
        });
    }

    @FXML
    void pagadorCBMouse(MouseEvent event) {
        pagadorCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PagarBoletoDAO dao = new PagarBoletoDAO();
                String nome = (String) (Object) pagadorCB.getSelectionModel().getSelectedItem();
                System.out.println(nome);
                dao.buscarFotoUsuario("" + nome);
//            fotoEmpresaIV.getClass().getResource(dao.getCaminhoFoto());
                fotoUsuarioIV.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));
                System.out.println("" + dao.getCaminhoFoto());
            }
        });

    }

    @FXML
    void pagadorCBMouseReleased(MouseEvent event) {

//        pagadorCB.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                PagarBoletoDAO dao = new PagarBoletoDAO();
//                String nome = (String) (Object) pagadorCB.getSelectionModel().getSelectedItem();
//                System.out.println(nome);
//                dao.buscarFotoUsuario("" + nome);
////            fotoEmpresaIV.getClass().getResource(dao.getCaminhoFoto());
//                fotoUsuarioIV.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));
//                System.out.println("" + dao.getCaminhoFoto());
//            }
//        });
    }

    @FXML
    void boletosPagosBTMouse(MouseEvent event) {

    }

    @FXML
    void boletosPagosBTTeclado(KeyEvent event) {

    }

    @FXML
    void dataPagamentoDPMouse(MouseEvent event) {

    }

    @FXML
    void dataPagamentoDPTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(valorPagamentoTF::requestFocus);//fim do run.
        }
    }

    @FXML
    void dataVencimentoTFMouse(MouseEvent event) {

    }

    @FXML
    void dataVencimentoTFTeclado(KeyEvent event) {

    }

    @FXML
    void formaPagamentoTFMouse(MouseEvent event) {

    }

    @FXML
    void formaPagamentoTFTeclado(KeyEvent event) {

    }

    @FXML
    void localPagamentoCBMouse(MouseEvent event) {

    }

    @FXML
    void localPagamentoCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(pagadorCB::requestFocus);//fim do run.
        }
    }

    @FXML
    void nomeEmpresaTFMouse(MouseEvent event) {

    }

    @FXML
    void nomeEmpresaTFTeclado(KeyEvent event) {

    }

//    @FXML
//    void pagarBTTeclado(KeyEvent event) {
//
//    }
//
//    @FXML
//    void pagarBTMouse(MouseEvent event) {
//
//    }
    @FXML
    void parcelaTFMouse(MouseEvent event) {

    }

    @FXML
    void parcelaTFTeclado(KeyEvent event) {

    }

    @FXML
    void produtoTFMouse(MouseEvent event) {

    }

    @FXML
    void produtoTFTeclado(KeyEvent event) {

    }

    @FXML
    void valorBoletoTFMouse(MouseEvent event) {

    }

    @FXML
    void valorBoletoTFTeclado(KeyEvent event) {

    }

    @FXML
    void valorPagamentoTFMouse(MouseEvent event) {

    }

    @FXML
    void valorPagamentoTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(localPagamentoCB::requestFocus);//fim do run.
        }
    }

}
