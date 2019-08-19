package controladorFXML;

import bancoConexaoDAO.BoletoDAO;
import classes.Boleto;
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
public class FXMLBoletoController implements Initializable {

    Boleto boleto = new Boleto();

    private String caminhoFoto;

    public FXMLBoletoController( //            ComboBox nomeEmpresaCB,
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
    private Button novoBoletoBT;

    @FXML
    private ComboBox<Boleto> nomeEmpresaCB;

    @FXML
    private DatePicker dataVencimentoDP;

    @FXML
    private ComboBox<Boleto> formaPagamentoCB;

    @FXML
    private ImageView fotoEmpresaIV;

    @FXML
    private TextField numeroParcelaTF;

    @FXML
    private Button deletarBT;

    @FXML
    private Button atualizarBT;

    @FXML
    private Button salvarBT;
    
    @FXML
    private ComboBox<Boleto> nomeProdutoCB;

    @FXML
    private TextField valorBoletoTF;

    @FXML
    private Button listarTabelaBT;

    @FXML
    private TableView<Boleto> tabelaBoletoTV;

    @FXML
    private TableColumn<Boleto, String> colunaNomeEmpresa;

    @FXML
    private TableColumn<Boleto, String> colunaProduto;

    @FXML
    private TableColumn<Boleto, String> colunaValorBoleto;

    @FXML
    private TableColumn<Boleto, String> colunaParcela;

    @FXML
    private TableColumn<Boleto, String> colunaVencimento;

    @FXML
    private TableColumn<Boleto, String> colunaFormaPagamento;

    @FXML
    private Button imprimirBT;

    @FXML
    private Button voltarMenuBT;

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

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

    public Button getNovoBoletoBT() {
        return novoBoletoBT;
    }

    public void setNovoBoletoBT(Button novoBoletoBT) {
        this.novoBoletoBT = novoBoletoBT;
    }

    public ComboBox<Boleto> getNomeEmpresaCB() {
        return nomeEmpresaCB;
    }

    public void setNomeEmpresaCB(ComboBox<Boleto> nomeEmpresaCB) {
        this.nomeEmpresaCB = nomeEmpresaCB;
    }

    public DatePicker getDataVencimentoDP() {
        return dataVencimentoDP;
    }

    public void setDataVencimentoDP(DatePicker dataVencimentoDP) {
        this.dataVencimentoDP = dataVencimentoDP;
    }

    public ComboBox<Boleto> getFormaPagamentoCB() {
        return formaPagamentoCB;
    }

    public void setFormaPagamentoCB(ComboBox<Boleto> formaPagamentoCB) {
        this.formaPagamentoCB = formaPagamentoCB;
    }

    public ImageView getFotoEmpresaIV() {
        return fotoEmpresaIV;
    }

    public void setFotoEmpresaIV(ImageView fotoEmpresaIV) {
        this.fotoEmpresaIV = fotoEmpresaIV;
    }

    public TextField getNumeroParcelaTF() {
        return numeroParcelaTF;
    }

    public void setNumeroParcelaTF(TextField numeroParcelaTF) {
        this.numeroParcelaTF = numeroParcelaTF;
    }

    public Button getDeletarBT() {
        return deletarBT;
    }

    public void setDeletarBT(Button deletarBT) {
        this.deletarBT = deletarBT;
    }

    public Button getAtualizarBT() {
        return atualizarBT;
    }

    public void setAtualizarBT(Button atualizarBT) {
        this.atualizarBT = atualizarBT;
    }

    public Button getSalvarBT() {
        return salvarBT;
    }

    public void setSalvarBT(Button salvarBT) {
        this.salvarBT = salvarBT;
    }

    public ComboBox<Boleto> getNomeProdutoCB() {
        return nomeProdutoCB;
    }

    public void setNomeProdutoCB(ComboBox<Boleto> nomeProdutoCB) {
        this.nomeProdutoCB = nomeProdutoCB;
    }

    public TextField getValorBoletoTF() {
        return valorBoletoTF;
    }

    public void setValorBoletoTF(TextField valorBoletoTF) {
        this.valorBoletoTF = valorBoletoTF;
    }

    public Button getListarTabelaBT() {
        return listarTabelaBT;
    }

    public void setListarTabelaBT(Button listarTabelaBT) {
        this.listarTabelaBT = listarTabelaBT;
    }

    public TableView<Boleto> getTabelaBoletoTV() {
        return tabelaBoletoTV;
    }

    public void setTabelaBoletoTV(TableView<Boleto> tabelaBoletoTV) {
        this.tabelaBoletoTV = tabelaBoletoTV;
    }

    public TableColumn<Boleto, String> getColunaNomeEmpresa() {
        return colunaNomeEmpresa;
    }

    public void setColunaNomeEmpresa(TableColumn<Boleto, String> colunaNomeEmpresa) {
        this.colunaNomeEmpresa = colunaNomeEmpresa;
    }

    public TableColumn<Boleto, String> getColunaProduto() {
        return colunaProduto;
    }

    public void setColunaProduto(TableColumn<Boleto, String> colunaProduto) {
        this.colunaProduto = colunaProduto;
    }

    public TableColumn<Boleto, String> getColunaValorBoleto() {
        return colunaValorBoleto;
    }

    public void setColunaValorBoleto(TableColumn<Boleto, String> colunaValorBoleto) {
        this.colunaValorBoleto = colunaValorBoleto;
    }

    public TableColumn<Boleto, String> getColunaParcela() {
        return colunaParcela;
    }

    public void setColunaParcela(TableColumn<Boleto, String> colunaParcela) {
        this.colunaParcela = colunaParcela;
    }

    public TableColumn<Boleto, String> getColunaVencimento() {
        return colunaVencimento;
    }

    public void setColunaVencimento(TableColumn<Boleto, String> colunaVencimento) {
        this.colunaVencimento = colunaVencimento;
    }

    public TableColumn<Boleto, String> getColunaFormaPagamento() {
        return colunaFormaPagamento;
    }

    public void setColunaFormaPagamento(TableColumn<Boleto, String> colunaFormaPagamento) {
        this.colunaFormaPagamento = colunaFormaPagamento;
    }

    public Button getImprimirBT() {
        return imprimirBT;
    }

    public void setImprimirBT(Button imprimirBT) {
        this.imprimirBT = imprimirBT;
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
        Boleto e = new Boleto();
        e.bloquearCamposFormulario(
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
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

        try {
            relogio.relogio();
        } catch (Exception ex) {
            Logger.getLogger(Boleto.class.getName()).log(Level.SEVERE, null, ex);
        }
        BoletoDAO dao = new BoletoDAO();
        boleto.preencherComboBoxTipoPagamento(formaPagamentoCB);
        dao.listaEmpresa(nomeEmpresaCB);
        dao.listaProdutoEmpresa(nomeProdutoCB);

    }//FIM DOS CONSTRUTOR.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO TECLADO(TECLA ENTER)
    void voltarMenuTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            boleto.abrirMenu();
        }
    }//FIM DO MÉTODO kEYEVENT.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO CLIC DO MOUSE.
    void voltarMenuMouse(MouseEvent event) {
        boleto.abrirMenu();
    }//FIM DO MÉTODO.

    @FXML
    void salvarTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            boleto.cadastrarBoleto(
                    caminhoFoto,
                    fotoEmpresaIV,
                    novoBoletoBT,
                    nomeEmpresaCB,
                    nomeProdutoCB,
                    valorBoletoTF,
                    numeroParcelaTF,
                    dataVencimentoDP,
                    formaPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaBoletoTV,
                    imprimirBT,
                    voltarMenuBT
            );
        }
        if (event.getCode() == KeyCode.TAB) {
            if (atualizarBT.isDisable()) {
                Platform.runLater(listarTabelaBT::requestFocus);//fim do run.
            }
        }
    }

    @FXML
    void salvarMouse(MouseEvent event) {

        boleto.cadastrarBoleto(
                caminhoFoto,
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
                voltarMenuBT
        );
    }

    @FXML
    void novoCadastroTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            boleto.limparFormulario(
                    fotoEmpresaIV,
                    novoBoletoBT,
                    nomeEmpresaCB,
                    nomeProdutoCB,
                    valorBoletoTF,
                    numeroParcelaTF,
                    dataVencimentoDP,
                    formaPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaBoletoTV,
                    imprimirBT,
                    voltarMenuBT
            );

            boleto.liberarCamposFormulario(
                    fotoEmpresaIV,
                    novoBoletoBT,
                    nomeEmpresaCB,
                    nomeProdutoCB,
                    valorBoletoTF,
                    numeroParcelaTF,
                    dataVencimentoDP,
                    formaPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaBoletoTV,
                    imprimirBT,
                    voltarMenuBT
            );
            salvarBT.setDisable(false);
            atualizarBT.setDisable(true);
            deletarBT.setDisable(true);
            tabelaBoletoTV.getItems().clear();
            Platform.runLater(nomeEmpresaCB::requestFocus);
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(nomeEmpresaCB::requestFocus);//fim do run.
        }
    }

    @FXML
    void novoCadastroMouse(MouseEvent event) {
//        Usuario u = new Usuario();
        boleto.limparFormulario(
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
                voltarMenuBT
        );
        boleto.liberarCamposFormulario(
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
                voltarMenuBT
        );

        salvarBT.setDisable(false);
        atualizarBT.setDisable(true);
        deletarBT.setDisable(true);
        tabelaBoletoTV.getItems().clear();
        Platform.runLater(nomeEmpresaCB::requestFocus);
    }

    @FXML
    void listarTabelaMouse(MouseEvent event) {

        boleto.limparFormulario(
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
                voltarMenuBT
        );

        boleto.bloquearCamposFormulario(
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
                voltarMenuBT
        );

        boleto.iniciarTabela(
                colunaNomeEmpresa,
                colunaProduto,
                colunaValorBoleto,
                colunaParcela,
                colunaVencimento,
                colunaFormaPagamento,
                tabelaBoletoTV
        );
        salvarBT.setDisable(true);
        imprimirBT.setDisable(false);
        
        

//        //Inicio run que encapsula o requestFocus().
        Platform.runLater(tabelaBoletoTV::requestFocus);//fim do run.
        
        tabelaBoletoTV.getSelectionModel().selectFirst();
    }

    @FXML
    void listarTabelaTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            boleto.limparFormulario(
                    fotoEmpresaIV,
                    novoBoletoBT,
                    nomeEmpresaCB,
                    nomeProdutoCB,
                    valorBoletoTF,
                    numeroParcelaTF,
                    dataVencimentoDP,
                    formaPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaBoletoTV,
                    imprimirBT,
                    voltarMenuBT
            );
            boleto.bloquearCamposFormulario(
                    fotoEmpresaIV,
                    novoBoletoBT,
                    nomeEmpresaCB,
                    nomeProdutoCB,
                    valorBoletoTF,
                    numeroParcelaTF,
                    dataVencimentoDP,
                    formaPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaBoletoTV,
                    imprimirBT,
                    voltarMenuBT
            );

            boleto.iniciarTabela(
                    colunaNomeEmpresa,
                    colunaProduto,
                    colunaValorBoleto,
                    colunaParcela,
                    colunaVencimento,
                    colunaFormaPagamento,
                    tabelaBoletoTV
            );
            salvarBT.setDisable(true);
            imprimirBT.setDisable(false);
            

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(tabelaBoletoTV::requestFocus);//fim do run.
            
            tabelaBoletoTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void pegarDadoTabelaMouse(MouseEvent event) {

        boleto.liberarCamposFormulario(
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
                voltarMenuBT
        );
        boleto.pegarDadoTabela(
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
                voltarMenuBT
        );
        nomeEmpresaCB.setDisable(true);
        dataVencimentoDP.setDisable(true);
        Platform.runLater(nomeProdutoCB::requestFocus);//fim do run.
    }

    @FXML
    void pegarDadoTabelaTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            boleto.liberarCamposFormulario(
                    fotoEmpresaIV,
                    novoBoletoBT,
                    nomeEmpresaCB,
                    nomeProdutoCB,
                    valorBoletoTF,
                    numeroParcelaTF,
                    dataVencimentoDP,
                    formaPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaBoletoTV,
                    imprimirBT,
                    voltarMenuBT
            );
            boleto.pegarDadoTabela(
                    fotoEmpresaIV,
                    novoBoletoBT,
                    nomeEmpresaCB,
                    nomeProdutoCB,
                    valorBoletoTF,
                    numeroParcelaTF,
                    dataVencimentoDP,
                    formaPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaBoletoTV,
                    imprimirBT,
                    voltarMenuBT
            );
            nomeEmpresaCB.setDisable(true);
            dataVencimentoDP.setDisable(true);
            Platform.runLater(nomeProdutoCB::requestFocus);//fim do run.
        }

        tabelaBoletoTV.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                boleto.pegarDadoTabela(
                        fotoEmpresaIV,
                        novoBoletoBT,
                        nomeEmpresaCB,
                        nomeProdutoCB,
                        valorBoletoTF,
                        numeroParcelaTF,
                        dataVencimentoDP,
                        formaPagamentoCB,
                        salvarBT,
                        atualizarBT,
                        deletarBT,
                        listarTabelaBT,
                        tabelaBoletoTV,
                        imprimirBT,
                        voltarMenuBT
                );
            }
        });
    }

    @FXML
    void atualizarMouse(MouseEvent event) {

        boleto.atualizarBoleto(
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
                voltarMenuBT
        );
//        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    @FXML
    void atualizarTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            boleto.atualizarBoleto(
                    fotoEmpresaIV,
                    novoBoletoBT,
                    nomeEmpresaCB,
                    nomeProdutoCB,
                    valorBoletoTF,
                    numeroParcelaTF,
                    dataVencimentoDP,
                    formaPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaBoletoTV,
                    imprimirBT,
                    voltarMenuBT
            );
        }
         if (event.getCode() == KeyCode.TAB) {   
            Platform.runLater(deletarBT::requestFocus);//fim do run.
         }
    }

    @FXML
    void excluirMouse(MouseEvent event) {
        boleto.excluirBoleto(
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
                voltarMenuBT
        );
        boleto.bloquearCamposFormulario(
                fotoEmpresaIV,
                novoBoletoBT,
                nomeEmpresaCB,
                nomeProdutoCB,
                valorBoletoTF,
                numeroParcelaTF,
                dataVencimentoDP,
                formaPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaBoletoTV,
                imprimirBT,
                voltarMenuBT
        );
        //Inicio run que encapsula o requestFocus().
        Platform.runLater(novoBoletoBT::requestFocus);//fim do run.
    }

    @FXML
    void excluirTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            boleto.excluirBoleto(
                    fotoEmpresaIV,
                    novoBoletoBT,
                    nomeEmpresaCB,
                    nomeProdutoCB,
                    valorBoletoTF,
                    numeroParcelaTF,
                    dataVencimentoDP,
                    formaPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaBoletoTV,
                    imprimirBT,
                    voltarMenuBT
            );
            boleto.bloquearCamposFormulario(
                    fotoEmpresaIV,
                    novoBoletoBT,
                    nomeEmpresaCB,
                    nomeProdutoCB,
                    valorBoletoTF,
                    numeroParcelaTF,
                    dataVencimentoDP,
                    formaPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaBoletoTV,
                    imprimirBT,
                    voltarMenuBT
            );
            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoBoletoBT::requestFocus);//fim do run.
        }
        if (event.getCode() == KeyCode.TAB) {   
            Platform.runLater(listarTabelaBT::requestFocus);//fim do run.
         }
    }

    @FXML
    void imprimirTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            boleto.gerarRelatorio();
        }
    }

    @FXML
    void imprimirMouse(MouseEvent event) {

        boleto.gerarRelatorio();
    }

    @FXML
    void senhaFocusTeclaTab(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {

            if (salvarBT.isDisable()) {
                Platform.runLater(atualizarBT::requestFocus);//fim do run.
            } else {
                Platform.runLater(salvarBT::requestFocus);//fim do run.

            }
        }
    }

    @FXML
    void nomeEmpresaCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(nomeProdutoCB::requestFocus);//fim do run.
        }

        if (event.getCode() == KeyCode.ENTER) {
            nomeEmpresaCB.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    BoletoDAO dao = new BoletoDAO();
                    String nome = (String) (Object) nomeEmpresaCB.getSelectionModel().getSelectedItem();
                    System.out.println(nome);
                    dao.buscarFoto("" + nome);
//            fotoEmpresaIV.getClass().getResource(dao.getCaminhoFoto());
                    fotoEmpresaIV.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));
                    System.out.println("" + dao.getCaminhoFoto());
                }
            });
        }

        nomeEmpresaCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BoletoDAO dao = new BoletoDAO();
                String nome = (String) (Object) nomeEmpresaCB.getSelectionModel().getSelectedItem();
                System.out.println(nome);
                dao.buscarFoto("" + nome);
//            fotoEmpresaIV.getClass().getResource(dao.getCaminhoFoto());
                fotoEmpresaIV.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));
                System.out.println("" + dao.getCaminhoFoto());
            }
        });
    }

    @FXML
    void nomeEmpresaCBMouse(MouseEvent event) {
        nomeEmpresaCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BoletoDAO dao = new BoletoDAO();
                String nome = (String) (Object) nomeEmpresaCB.getSelectionModel().getSelectedItem();
                System.out.println(nome);
                dao.buscarFoto("" + nome);
//            fotoEmpresaIV.getClass().getResource(dao.getCaminhoFoto());
                fotoEmpresaIV.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));
                System.out.println("" + dao.getCaminhoFoto());
            }
        });

    }

    @FXML
    void nomeEmpresaCBMouseReleased(MouseEvent event) {

        nomeEmpresaCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BoletoDAO dao = new BoletoDAO();
                String nome = (String) (Object) nomeEmpresaCB.getSelectionModel().getSelectedItem();
                System.out.println(nome);
                dao.buscarFoto("" + nome);
//            fotoEmpresaIV.getClass().getResource(dao.getCaminhoFoto());
                fotoEmpresaIV.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));
                System.out.println("" + dao.getCaminhoFoto());
            }
        });
    }

    @FXML
    void dataVencimentoDPTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(formaPagamentoCB::requestFocus);//fim do run.
        }
    }

    @FXML
    void formaPagamentoCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            if (salvarBT.isDisable()) {
                Platform.runLater(atualizarBT::requestFocus);//fim do run.
            } else {
                Platform.runLater(salvarBT::requestFocus);//fim do run. 
            }
        }
    }

    @FXML
    void formaPagamentoCBMouse(MouseEvent event) {

    }

    @FXML
    void dataVencimentoDPMouse(MouseEvent event) {

    }

//    @FXML
//    void tipoPagamentoCBMouse(MouseEvent event) {
//
//    }

    @FXML
    void parcelaTFMouse(MouseEvent event) {

    }

    @FXML
    void parcelaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            if(dataVencimentoDP.isDisable()){
                Platform.runLater(formaPagamentoCB::requestFocus);//fim do run.
            }else{
            Platform.runLater(dataVencimentoDP::requestFocus);//fim do run.
            }
        }
    }

    @FXML
    void produtoCBMouse(MouseEvent event) {

    }

    @FXML
    void produtoCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(valorBoletoTF::requestFocus);//fim do run.
        }
    }

    @FXML
    void valorBoletoTFMouse(MouseEvent event) {

    }

    @FXML
    void valorBoletoTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(numeroParcelaTF::requestFocus);//fim do run.
        }
    }
    


  


        

}
