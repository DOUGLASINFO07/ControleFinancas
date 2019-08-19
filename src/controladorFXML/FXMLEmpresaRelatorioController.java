package controladorFXML;

import classes.EmpresaRelatorio;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import util.Relogio;

/**
 *
 * @author Douglas Borges Egidio
 */
public class FXMLEmpresaRelatorioController implements Initializable {

    EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio();

    public FXMLEmpresaRelatorioController() {
    }

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private TableView<EmpresaRelatorio> tabelaEmpresaTV;

    @FXML
    private TableColumn<EmpresaRelatorio, String> colunaNome;

    @FXML
    private TableColumn<EmpresaRelatorio, String> colunaProduto;

    @FXML
    private TableColumn<EmpresaRelatorio, String> colunaTelefone;

    @FXML
    private TableColumn<EmpresaRelatorio, String> colunaSite;

    @FXML
    private TableColumn<EmpresaRelatorio, String> colunaEmail;

    @FXML
    private TableColumn<EmpresaRelatorio, String> colunaLogin;

    @FXML
    private TableColumn<EmpresaRelatorio, String> colunaSenha;

    @FXML
    private ComboBox<EmpresaRelatorio> filtroPesquisaCB;

    @FXML
    private TextField campoEmailPesquisaTF;

    @FXML
    private TextField campoNomePesquisaTF;

    @FXML
    private TextField campoTelefonePesquisaTF;

    @FXML
    private TextField campoTodosEmpresaPesquisaTF;

    @FXML
    private Button listarTodosBT;

    @FXML
    private Button imprimirBT;

    @FXML
    private Button voltarMenuBT;

    public EmpresaRelatorio getEmpresaRelatorio() {
        return empresaRelatorio;
    }

    public void setEmpresaRelatorio(EmpresaRelatorio empresaRelatorio) {
        this.empresaRelatorio = empresaRelatorio;
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

    public TableView<EmpresaRelatorio> getTabelaEmpresaTV() {
        return tabelaEmpresaTV;
    }

    public void setTabelaEmpresaTV(TableView<EmpresaRelatorio> tabelaEmpresaTV) {
        this.tabelaEmpresaTV = tabelaEmpresaTV;
    }

    public TableColumn<EmpresaRelatorio, String> getColunaNome() {
        return colunaNome;
    }

    public void setColunaNome(TableColumn<EmpresaRelatorio, String> colunaNome) {
        this.colunaNome = colunaNome;
    }

    public TableColumn<EmpresaRelatorio, String> getColunaProduto() {
        return colunaProduto;
    }

    public void setColunaProduto(TableColumn<EmpresaRelatorio, String> colunaProduto) {
        this.colunaProduto = colunaProduto;
    }

    public TableColumn<EmpresaRelatorio, String> getColunaTelefone() {
        return colunaTelefone;
    }

    public void setColunaTelefone(TableColumn<EmpresaRelatorio, String> colunaTelefone) {
        this.colunaTelefone = colunaTelefone;
    }

    public TableColumn<EmpresaRelatorio, String> getColunaSite() {
        return colunaSite;
    }

    public void setColunaSite(TableColumn<EmpresaRelatorio, String> colunaSite) {
        this.colunaSite = colunaSite;
    }

    public TableColumn<EmpresaRelatorio, String> getColunaEmail() {
        return colunaEmail;
    }

    public void setColunaEmail(TableColumn<EmpresaRelatorio, String> colunaEmail) {
        this.colunaEmail = colunaEmail;
    }

    public TableColumn<EmpresaRelatorio, String> getColunaLogin() {
        return colunaLogin;
    }

    public void setColunaLogin(TableColumn<EmpresaRelatorio, String> colunaLogin) {
        this.colunaLogin = colunaLogin;
    }

    public TableColumn<EmpresaRelatorio, String> getColunaSenha() {
        return colunaSenha;
    }

    public void setColunaSenha(TableColumn<EmpresaRelatorio, String> colunaSenha) {
        this.colunaSenha = colunaSenha;
    }

    public ComboBox<EmpresaRelatorio> getFiltroPesquisaCB() {
        return filtroPesquisaCB;
    }

    public void setFiltroPesquisaCB(ComboBox<EmpresaRelatorio> filtroPesquisaCB) {
        this.filtroPesquisaCB = filtroPesquisaCB;
    }

    public TextField getCampoEmailPesquisaTF() {
        return campoEmailPesquisaTF;
    }

    public void setCampoEmailPesquisaTF(TextField campoEmailPesquisaTF) {
        this.campoEmailPesquisaTF = campoEmailPesquisaTF;
    }

    public TextField getCampoNomePesquisaTF() {
        return campoNomePesquisaTF;
    }

    public void setCampoNomePesquisaTF(TextField campoNomePesquisaTF) {
        this.campoNomePesquisaTF = campoNomePesquisaTF;
    }

    public TextField getCampoTelefonePesquisaTF() {
        return campoTelefonePesquisaTF;
    }

    public void setCampoTelefonePesquisaTF(TextField campoTelefonePesquisaTF) {
        this.campoTelefonePesquisaTF = campoTelefonePesquisaTF;
    }

    public TextField getCampoTodosEmpresaPesquisaTF() {
        return campoTodosEmpresaPesquisaTF;
    }

    public void setCampoTodosEmpresaPesquisaTF(TextField campoTodosEmpresaPesquisaTF) {
        this.campoTodosEmpresaPesquisaTF = campoTodosEmpresaPesquisaTF;
    }

    public Button getListarTodosBT() {
        return listarTodosBT;
    }

    public void setListarTodosBT(Button listarTodosBT) {
        this.listarTodosBT = listarTodosBT;
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

    //FIM DOS COMPONENTES GRÁFICOS.
    //CONSTRUTOR INICIALIZADOR DA CLASSE QUE CONTROLA AS AÇÕES 
    //DOS COMPONENTES DA INTERFACE GRÁFICA USUÁRIO.
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio();
        Relogio relogio = new Relogio(horasLB);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");

        Date date = new Date();
        dataLB.setTextFill(Color.GRAY);
        dataLB.setText("Hoje é " + sdf.format(date));
        try {
            relogio.relogio();
        } catch (Exception ex) {
        }
        Platform.runLater(filtroPesquisaCB::requestFocus);//fim do run.

        empresaRelatorio.preencherComboBoxFiltroPesquisa(filtroPesquisaCB);

        filtroPesquisaCB.getSelectionModel().selectFirst();
    }//FIM DOS CONSTRUTOR.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO TECLADO(TECLA ENTER)
    void voltarMenuBTTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            empresaRelatorio.abrirMenu();
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(filtroPesquisaCB::requestFocus);//fim do run.
            filtroPesquisaCB.getSelectionModel().selectFirst();
        }
    }//FIM DO MÉTODO kEYEVENT.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO CLIC DO MOUSE.
    void voltarMenuBTMouse(MouseEvent event) {
        EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio();
        empresaRelatorio.abrirMenu();
        empresaRelatorio.fecharEmpresa();
        Platform.runLater(filtroPesquisaCB::requestFocus);//fim do run.
        filtroPesquisaCB.getSelectionModel().selectFirst();
    }//FIM DO MÉTODO

    @FXML
    void tabelaEmpresaTVMouse(MouseEvent event) {
        tabelaEmpresaTV.getSelectionModel().selectFirst();
        Platform.runLater(imprimirBT::requestFocus);//fim do run.
    }

    @FXML
    void tabelaEmpresaTVTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(imprimirBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio();
            empresaRelatorio.imprimir(
                    filtroPesquisaCB,
                    campoNomePesquisaTF,
                    campoTelefonePesquisaTF,
                    campoEmailPesquisaTF);
        }

        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(voltarMenuBT::requestFocus);//fim do run.
        }

//        filtroPesquisaCB.getSelectionModel().selectFirst();
    }

    @FXML
    void imprimirBTMouse(MouseEvent event) {
        EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio();
        empresaRelatorio.imprimir(
                filtroPesquisaCB,
                campoNomePesquisaTF,
                campoTelefonePesquisaTF,
                campoEmailPesquisaTF);

//        filtroPesquisaCB.getSelectionModel().selectFirst();
    }

    @FXML
    void campoTodosEmpresaPesquisaTFMouse(MouseEvent event) {

    }

    @FXML
    void campoTodosEmpresaPesquisaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaEmpresaTV::requestFocus);//fim do run.
            tabelaEmpresaTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void campoTodosEmpresaPesquisaTFReleaseTeclado(KeyEvent event) {
        imprimirBT.setDisable(false);

        EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoTodosEmpresaPesquisaTF.getText()
        );

        if (event.getCode() != KeyCode.TAB) {
            empresaRelatorio.iniciarTabela(
                    colunaNome,
                    colunaProduto,
                    colunaTelefone,
                    colunaSite,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaEmpresaTV
            );
        }
        if (campoTodosEmpresaPesquisaTF.getText().isEmpty()) {
            tabelaEmpresaTV.getItems().clear();
        }

    }

    @FXML
    void campoEmailPesquisaTFMouse(MouseEvent event) {

    }

    @FXML
    void campoEmailPesquisaTFReleaseTeclado(KeyEvent event) {
        imprimirBT.setDisable(false);
        EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoEmailPesquisaTF.getText()
        );

        if (event.getCode() != KeyCode.TAB) {
            empresaRelatorio.iniciarTabela(
                    colunaNome,
                    colunaProduto,
                    colunaTelefone,
                    colunaSite,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaEmpresaTV
            );
        }
        if (campoEmailPesquisaTF.getText().isEmpty()) {
            tabelaEmpresaTV.getItems().clear();
        }
    }

    @FXML
    void campoEmailPesquisaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaEmpresaTV::requestFocus);//fim do run.
            tabelaEmpresaTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void campoNomePesquisaTFMouse(MouseEvent event) {
    }

    @FXML
    void campoNomePesquisaTFReleaseTeclado(KeyEvent event) {
        imprimirBT.setDisable(false);
        EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoNomePesquisaTF.getText()
        );

        if (event.getCode() != KeyCode.TAB) {
            empresaRelatorio.iniciarTabela(
                    colunaNome,
                    colunaProduto,
                    colunaTelefone,
                    colunaSite,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaEmpresaTV
            );
        }

        if (campoNomePesquisaTF.getText().isEmpty()) {
            tabelaEmpresaTV.getItems().clear();
        }
    }

    @FXML
    void campoNomePesquisaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaEmpresaTV::requestFocus);//fim do run.
            tabelaEmpresaTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void campoTelefonePesquisaTFMouse(MouseEvent event) {

    }

    @FXML
    void campoTelefonePesquisaTFReleaseTeclado(KeyEvent event) {
        imprimirBT.setDisable(false);

        EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoTelefonePesquisaTF.getText()
        );

        if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Telefone")) {
            empresaRelatorio.formatarTelefone(campoTelefonePesquisaTF);
        } else {
        }
        if (event.getCode() != KeyCode.TAB) {
            empresaRelatorio.iniciarTabela(
                    colunaNome,
                    colunaProduto,
                    colunaTelefone,
                    colunaSite,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaEmpresaTV
            );
        }
        if (campoTelefonePesquisaTF.getText().isEmpty()) {
            tabelaEmpresaTV.getItems().clear();
        }
    }

    @FXML
    void campoTelefonePesquisaTFTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaEmpresaTV::requestFocus);//fim do run.
            tabelaEmpresaTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void filtroPesquisaCBMouse(MouseEvent event) {

        
        
        filtroPesquisaCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                imprimirBT.setDisable(true);
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Selecione um filtro")) {
                    campoTodosEmpresaPesquisaTF.setVisible(true);
                    campoTodosEmpresaPesquisaTF.setText("Escolheu um filtro de pesquisa?... não?!... Então, escolha um e depois CLIC AQUI!!");
                    campoTodosEmpresaPesquisaTF.setDisable(true);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    campoEmailPesquisaTF.clear();
                    tabelaEmpresaTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Nome da Empresa")) {
                    campoTodosEmpresaPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(true);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoTelefonePesquisaTF.clear();
                    campoEmailPesquisaTF.clear();
                    campoTodosEmpresaPesquisaTF.clear();
                    tabelaEmpresaTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Telefone")) {
                    campoTodosEmpresaPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(true);
                    empresaRelatorio.formatarTelefone(campoTelefonePesquisaTF);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoEmailPesquisaTF.clear();
                    campoTodosEmpresaPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    tabelaEmpresaTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("E-mail")) {
                    campoTodosEmpresaPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(true);
                    listarTodosBT.setVisible(false);
                    campoTodosEmpresaPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    tabelaEmpresaTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Todos")) {
                    campoTodosEmpresaPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(true);
                    campoTodosEmpresaPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    tabelaEmpresaTV.getItems().clear();
                }
            }
        });
    }

    @FXML
    void filtroPesquisaCBTeclado(KeyEvent event) {
        filtroPesquisaCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                imprimirBT.setDisable(true);
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Selecione um filtro")) {
                    campoTodosEmpresaPesquisaTF.setVisible(true);
                    campoTodosEmpresaPesquisaTF.setText("Escolheu um filtro de pesquisa?... não?!... Então, escolha um e depois CLIC AQUI!!");
                    campoTodosEmpresaPesquisaTF.setDisable(true);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    campoEmailPesquisaTF.clear();
                    tabelaEmpresaTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Nome da Empresa")) {
                    campoTodosEmpresaPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(true);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoTelefonePesquisaTF.clear();
                    campoEmailPesquisaTF.clear();
                    campoTodosEmpresaPesquisaTF.clear();
                    tabelaEmpresaTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Telefone")) {
                    campoTodosEmpresaPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(true);
                    empresaRelatorio.formatarTelefone(campoTelefonePesquisaTF);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoEmailPesquisaTF.clear();
                    campoTodosEmpresaPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    tabelaEmpresaTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("E-mail")) {
                    campoTodosEmpresaPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(true);
                    listarTodosBT.setVisible(false);
                    campoTodosEmpresaPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    tabelaEmpresaTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Todos")) {
                    campoTodosEmpresaPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(true);
                    campoTodosEmpresaPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    tabelaEmpresaTV.getItems().clear();
                }
            }
        });

    }

    @FXML
    void listarTodosBTTeclado(KeyEvent event) {

        imprimirBT.setDisable(false);

        EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoTelefonePesquisaTF.getText()
        );

        if (event.getCode() != KeyCode.TAB
                && event.getCode() == KeyCode.ENTER) {
            empresaRelatorio.iniciarTabela(
                    colunaNome,
                    colunaProduto,
                    colunaTelefone,
                    colunaSite,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaEmpresaTV
            );
        }

        Platform.runLater(tabelaEmpresaTV::requestFocus);//fim do run.

    }

    @FXML
    void listarTodosBTMouse(MouseEvent event) {
        imprimirBT.setDisable(false);

        EmpresaRelatorio empresaRelatorio = new EmpresaRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoTelefonePesquisaTF.getText()
        );

        empresaRelatorio.iniciarTabela(
                colunaNome,
                colunaProduto,
                colunaTelefone,
                colunaSite,
                colunaEmail,
                colunaLogin,
                colunaSenha,
                tabelaEmpresaTV
        );

        Platform.runLater(tabelaEmpresaTV::requestFocus);//fim do run.

    }
   
}
