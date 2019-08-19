package controladorFXML;

import bancoConexaoDAO.SalarioDAO;
import classes.Salario;
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
public class FXMLSalarioController implements Initializable {

    Salario salario = new Salario();

    private String caminhoFoto;

    public FXMLSalarioController(
            ComboBox nomeEmpresaCB,
            TextField salarioTF,
            DatePicker dataRecebimentoDP,
            ComboBox tipoPagamentoCB
    ) {
        this.nomeEmpresaCB = nomeEmpresaCB;
        this.salarioTF = salarioTF;
        this.dataRecebimentoDP = dataRecebimentoDP;
        this.tipoPagamentoCB = tipoPagamentoCB;
    }

    public FXMLSalarioController() {

    }

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private Pane formularioPane;

    @FXML
    private Button novoSalarioBT;

    @FXML
    private TextField salarioTF;

    @FXML
    private DatePicker dataRecebimentoDP;

    @FXML
    private ComboBox<Salario> nomeEmpresaCB;

    @FXML
    private ComboBox<Salario> tipoPagamentoCB;

    @FXML
    private ImageView fotoEmpresaIV;

    @FXML
    private Button salvarBT;

    @FXML
    private Button atualizarBT;

    @FXML
    private Button deletarBT;

    @FXML
    private Button listarTabelaBT;

    @FXML
    private TableView<Salario> tabelaSalario;

    @FXML
    private TableColumn<Salario, String> colunaNomeEmpresa;

    @FXML
    private TableColumn<Salario, String> colunaSalario;

    @FXML
    private TableColumn<Salario, String> colunaDataRecebimento;

    @FXML
    private TableColumn<Salario, String> colunaTipoPagamento;

    @FXML
    private Button imprimirBT;

    @FXML
    private Button voltarMenuBT;

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
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

    public Button getNovoSalarioBT() {
        return novoSalarioBT;
    }

    public void setNovoSalarioTeclado(Button novoSalarioBT) {
        this.novoSalarioBT = novoSalarioBT;
    }

    public TextField getSalarioTF() {
        return salarioTF;
    }

    public void setSalarioTF(TextField salarioTF) {
        this.salarioTF = salarioTF;
    }

    public DatePicker getDataRecebimentoDP() {
        return dataRecebimentoDP;
    }

    public void setDataRecebimentoDP(DatePicker dataRecebimentoDP) {
        this.dataRecebimentoDP = dataRecebimentoDP;
    }

    public ComboBox<Salario> getNomeEmpresaCB() {
        return nomeEmpresaCB;
    }

    public void setNomeEmpresaCB(ComboBox<Salario> nomeEmpresaCB) {
        this.nomeEmpresaCB = nomeEmpresaCB;
    }

    public ComboBox<Salario> getTipoPagamentoCB() {
        return tipoPagamentoCB;
    }

    public void setTipoPagamentoCB(ComboBox<Salario> tipoPagamentoCB) {
        this.tipoPagamentoCB = tipoPagamentoCB;
    }

    public ImageView getFotoEmpresaIV() {
        return fotoEmpresaIV;
    }

    public void setFotoEmpresaIV(ImageView fotoEmpresaIV) {
        this.fotoEmpresaIV = fotoEmpresaIV;
    }

    public Button getSalvarBT() {
        return salvarBT;
    }

    public void setSalvarBT(Button salvarBT) {
        this.salvarBT = salvarBT;
    }

    public Button getAtualizarBT() {
        return atualizarBT;
    }

    public void setAtualizarBT(Button atualizarBT) {
        this.atualizarBT = atualizarBT;
    }

    public Button getDeletarBT() {
        return deletarBT;
    }

    public void setDeletarBT(Button deletarBT) {
        this.deletarBT = deletarBT;
    }

    public Button getListarTabelaBT() {
        return listarTabelaBT;
    }

    public void setListarTabelaBT(Button listarTabelaBT) {
        this.listarTabelaBT = listarTabelaBT;
    }

    public TableView<?> getTabelaSalario() {
        return tabelaSalario;
    }

    public void setTabelaSalario(TableView<Salario> tabelaSalario) {
        this.tabelaSalario = tabelaSalario;
    }

    public TableColumn<Salario, String> getColunaNomeEmpresa() {
        return colunaNomeEmpresa;
    }

    public void setColunaNomeEmpresa(TableColumn<Salario, String> colunaNomeEmpresa) {
        this.colunaNomeEmpresa = colunaNomeEmpresa;
    }

    public TableColumn<Salario, String> getColunaSalario() {
        return colunaSalario;
    }

    public void setColunaSalario(TableColumn<Salario, String> colunaSalario) {
        this.colunaSalario = colunaSalario;
    }

    public TableColumn<Salario, String> getColunaDataRecebimento() {
        return colunaDataRecebimento;
    }

    public void setColunaDataRecebimento(TableColumn<Salario, String> colunaDataRecebimento) {
        this.colunaDataRecebimento = colunaDataRecebimento;
    }

    public TableColumn<Salario, String> getColunaTipoPagamento() {
        return colunaTipoPagamento;
    }

    public void setColunaTipoPagamento(TableColumn<Salario, String> colunaTipoPagamento) {
        this.colunaTipoPagamento = colunaTipoPagamento;
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

//   //IDENTIFICAÇÃO DOS COMPONENTES DA INTERFACE GRÁFICA.
    //CONSTRUTOR INICIALIZADOR DA CLASSE QUE CONTROLA AS AÇÕES 
    //DOS COMPONENTES DA INTERFACE GRÁFICA USUÁRIO.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Relogio relogio = new Relogio(horasLB);
        Salario e = new Salario();
        e.bloquearCamposFormulario(
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );

//        e.limitarQantidadeCaractere(getTelefoneSalarioTF(), 14);
//        Utilitario.validarTextField(getTelefoneSalarioTF());
//        e.formatarTelefone(getTelefoneSalarioTF());
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date = new Date();
        dataLB.setTextFill(Color.GRAY);
        dataLB.setText("Hoje é " + sdf.format(date));

        Utilitario util = new Utilitario();
        util.campoMoeda(salarioTF);

        try {
            relogio.relogio();
        } catch (Exception ex) {
            Logger.getLogger(Salario.class.getName()).log(Level.SEVERE, null, ex);
        }
        SalarioDAO dao = new SalarioDAO();
        salario.preencherComboBoxTipoPagamento(tipoPagamentoCB);
        dao.listaEmpresa(nomeEmpresaCB);

    }//FIM DOS CONSTRUTOR.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO TECLADO(TECLA ENTER)
    void voltarMenuTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            salario.abrirMenu();
        }
    }//FIM DO MÉTODO kEYEVENT.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO CLIC DO MOUSE.
    void voltarMenuMouse(MouseEvent event) {
        salario.abrirMenu();
    }//FIM DO MÉTODO.

    @FXML
    void salvarTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            salario.cadastrarSalario(
                    caminhoFoto,
                    fotoEmpresaIV,
                    novoSalarioBT,
                    nomeEmpresaCB,
                    salarioTF,
                    dataRecebimentoDP,
                    tipoPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaSalario,
                    imprimirBT,
                    voltarMenuBT
            );
        }
        if (event.getCode() == KeyCode.TAB) {
        if(atualizarBT.isDisable()){
            Platform.runLater(listarTabelaBT::requestFocus);//fim do run.
            }
        }
    }

    @FXML
    void salvarMouse(MouseEvent event) {

        salario.cadastrarSalario(
                caminhoFoto,
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );
    }

    @FXML
    void novoCadastroTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            salario.limparFormulario(
                    fotoEmpresaIV,
                    novoSalarioBT,
                    nomeEmpresaCB,
                    salarioTF,
                    dataRecebimentoDP,
                    tipoPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaSalario,
                    imprimirBT,
                    voltarMenuBT
            );

            salario.liberarCamposFormulario(
                    fotoEmpresaIV,
                    novoSalarioBT,
                    nomeEmpresaCB,
                    salarioTF,
                    dataRecebimentoDP,
                    tipoPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaSalario,
                    imprimirBT,
                    voltarMenuBT
            );
            salvarBT.setDisable(false);
            atualizarBT.setDisable(true);
            deletarBT.setDisable(true);
            tabelaSalario.getItems().clear();
            Platform.runLater(nomeEmpresaCB::requestFocus);
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(nomeEmpresaCB::requestFocus);//fim do run.
        }
    }

    @FXML
    void novoCadastroMouse(MouseEvent event) {
//        Usuario u = new Usuario();
        salario.limparFormulario(
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );
        salario.liberarCamposFormulario(
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );

        salvarBT.setDisable(false);
        atualizarBT.setDisable(true);
        deletarBT.setDisable(true);
        tabelaSalario.getItems().clear();
        Platform.runLater(nomeEmpresaCB::requestFocus);
    }

    @FXML
    void listarTabelaMouse(MouseEvent event) {

        salario.limparFormulario(
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );

        salario.bloquearCamposFormulario(
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );

        salario.iniciarTabela(
                colunaNomeEmpresa,
                colunaSalario,
                colunaDataRecebimento,
                colunaTipoPagamento,
                tabelaSalario
        );
        salvarBT.setDisable(true);
        imprimirBT.setDisable(false);

//        //Inicio run que encapsula o requestFocus().
//        Platform.runLater(tabelaUsuario::requestFocus);//fim do run.
    }

    @FXML
    void listarTabelaTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            salario.limparFormulario(
                    fotoEmpresaIV,
                    novoSalarioBT,
                    nomeEmpresaCB,
                    salarioTF,
                    dataRecebimentoDP,
                    tipoPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaSalario,
                    imprimirBT,
                    voltarMenuBT
            );
            salario.bloquearCamposFormulario(
                    fotoEmpresaIV,
                    novoSalarioBT,
                    nomeEmpresaCB,
                    salarioTF,
                    dataRecebimentoDP,
                    tipoPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaSalario,
                    imprimirBT,
                    voltarMenuBT
            );

            salario.iniciarTabela(
                    colunaNomeEmpresa,
                    colunaSalario,
                    colunaDataRecebimento,
                    colunaTipoPagamento,
                    tabelaSalario
            );
            salvarBT.setDisable(true);
            imprimirBT.setDisable(false);

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(tabelaSalario::requestFocus);//fim do run.
        }
    }

    @FXML
    void pegarDadoTabelaMouse(MouseEvent event) {

        salario.liberarCamposFormulario(
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );
        salario.pegarDadoTabela(
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );
        nomeEmpresaCB.setDisable(true);
        dataRecebimentoDP.setDisable(true);
        Platform.runLater(salarioTF::requestFocus);//fim do run.
    }

    @FXML
    void pegarDadoTabelaTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            salario.liberarCamposFormulario(
                    fotoEmpresaIV,
                    novoSalarioBT,
                    nomeEmpresaCB,
                    salarioTF,
                    dataRecebimentoDP,
                    tipoPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaSalario,
                    imprimirBT,
                    voltarMenuBT
            );
            salario.pegarDadoTabela(
                    fotoEmpresaIV,
                    novoSalarioBT,
                    nomeEmpresaCB,
                    salarioTF,
                    dataRecebimentoDP,
                    tipoPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaSalario,
                    imprimirBT,
                    voltarMenuBT
            );
            nomeEmpresaCB.setDisable(true);
            dataRecebimentoDP.setDisable(true);
            Platform.runLater(salarioTF::requestFocus);//fim do run.
        }

        tabelaSalario.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                salario.pegarDadoTabela(
                        fotoEmpresaIV,
                        novoSalarioBT,
                        nomeEmpresaCB,
                        salarioTF,
                        dataRecebimentoDP,
                        tipoPagamentoCB,
                        salvarBT,
                        atualizarBT,
                        deletarBT,
                        listarTabelaBT,
                        tabelaSalario,
                        imprimirBT,
                        voltarMenuBT
                );
            }
        });
    }

    @FXML
    void atualizarMouse(MouseEvent event) {

        salario.atualizarSalario(
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );
//        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    @FXML
    void atualizarTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            salario.atualizarSalario(
                    fotoEmpresaIV,
                    novoSalarioBT,
                    nomeEmpresaCB,
                    salarioTF,
                    dataRecebimentoDP,
                    tipoPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaSalario,
                    imprimirBT,
                    voltarMenuBT
            );
//            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void excluirMouse(MouseEvent event) {
        salario.excluirSalario(
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );
        salario.bloquearCamposFormulario(
                fotoEmpresaIV,
                novoSalarioBT,
                nomeEmpresaCB,
                salarioTF,
                dataRecebimentoDP,
                tipoPagamentoCB,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaSalario,
                imprimirBT,
                voltarMenuBT
        );
        //Inicio run que encapsula o requestFocus().
        Platform.runLater(novoSalarioBT::requestFocus);//fim do run.
    }

    @FXML
    void excluirTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            salario.excluirSalario(
                    fotoEmpresaIV,
                    novoSalarioBT,
                    nomeEmpresaCB,
                    salarioTF,
                    dataRecebimentoDP,
                    tipoPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaSalario,
                    imprimirBT,
                    voltarMenuBT
            );
            salario.bloquearCamposFormulario(
                    fotoEmpresaIV,
                    novoSalarioBT,
                    nomeEmpresaCB,
                    salarioTF,
                    dataRecebimentoDP,
                    tipoPagamentoCB,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaSalario,
                    imprimirBT,
                    voltarMenuBT
            );
            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoSalarioBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void imprimirTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

            salario.gerarRelatorio();
        }
    }

    @FXML
    void imprimirMouse(MouseEvent event) {

        salario.gerarRelatorio();
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
            Platform.runLater(salarioTF::requestFocus);//fim do run.
        }

        if (event.getCode() == KeyCode.ENTER) {
            nomeEmpresaCB.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SalarioDAO dao = new SalarioDAO();
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
                SalarioDAO dao = new SalarioDAO();
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
                SalarioDAO dao = new SalarioDAO();
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
                SalarioDAO dao = new SalarioDAO();
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
    void salarioTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            if(dataRecebimentoDP.isDisable()){
            Platform.runLater(tipoPagamentoCB::requestFocus);//fim do run.
            }else{
            Platform.runLater(dataRecebimentoDP::requestFocus);//fim do run.  
            }
        }
    }

    @FXML
    void salarioTFMouse(MouseEvent event) {

    }

    @FXML
    void dataRecebimentoDPTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tipoPagamentoCB::requestFocus);//fim do run.
        }
    }

    @FXML
    void tipoPagamentoCBTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
           if(salvarBT.isDisable()){
            Platform.runLater(atualizarBT::requestFocus);//fim do run.
            }else{
            Platform.runLater(salvarBT::requestFocus);//fim do run. 
            }
        }
    }

    @FXML
    void dataRecebimentoDPMouse(MouseEvent event) {

    }

    @FXML
    void tipoPagamentoCBMouse(MouseEvent event) {

    }

}
