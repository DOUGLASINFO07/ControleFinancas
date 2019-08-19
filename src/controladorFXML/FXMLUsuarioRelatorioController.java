package controladorFXML;

import bancoConexaoDAO.PagarBoletoDAO;
import classes.UsuarioRelatorio;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import util.Relogio;
import util.Utilitario;

/**
 *
 * @author dougl
 */
public class FXMLUsuarioRelatorioController implements Initializable {

    UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio();

    public FXMLUsuarioRelatorioController() {
    }

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private Button listarTabelaBT;

    @FXML
    private TextField campoTodosUsuariosPesquisaTF;

    @FXML
    private TextField campoNomePesquisaTF;

    @FXML
    private TextField campoTelefonePesquisaTF;

    @FXML
    private TextField campoEmailPesquisaTF;

    @FXML
    private Button imprimirBT;

    @FXML
    private Button voltarMenuBT;

    @FXML
    private TableView<UsuarioRelatorio> tabelaUsuarioTV;

    @FXML
    private TableColumn<UsuarioRelatorio, String> colunaNome;

    @FXML
    private TableColumn<UsuarioRelatorio, String> colunaTelefone;

    @FXML
    private TableColumn<UsuarioRelatorio, String> colunaEmail;

    @FXML
    private TableColumn<UsuarioRelatorio, String> colunaLogin;

    @FXML
    private TableColumn<UsuarioRelatorio, String> colunaSenha;

    @FXML
    private ComboBox<UsuarioRelatorio> filtroPesquisaCB;

    @FXML
    private TextField campoPesquisaTF;

    @FXML
    private ImageView fotoUsuarioIV;

    @FXML
    private Button botaoVoltarMenu;

    @FXML
    private Button listarTodosBT;

    public Button getListarTodosBT() {
        return listarTodosBT;
    }

    public void setListarTodosBT(Button listarTodosBT) {
        this.listarTodosBT = listarTodosBT;
    }

    public UsuarioRelatorio getUsuarioRelatorio() {
        return usuarioRelatorio;
    }

    public void setUsuarioRelatorio(UsuarioRelatorio usuarioRelatorio) {
        this.usuarioRelatorio = usuarioRelatorio;
    }

    public TextField getCampoTodosUsuariosPesquisaTF() {
        return campoTodosUsuariosPesquisaTF;
    }

    public void setCampoTodosUsuariosPesquisaTF(TextField campoTodosUsuariosPesquisaTF) {
        this.campoTodosUsuariosPesquisaTF = campoTodosUsuariosPesquisaTF;
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

    public TextField getCampoEmailPesquisaTF() {
        return campoEmailPesquisaTF;
    }

    public void setCampoEmailPesquisaTF(TextField campoEmailPesquisaTF) {
        this.campoEmailPesquisaTF = campoEmailPesquisaTF;
    }

    public Button getVoltarMenuBT() {
        return voltarMenuBT;
    }

    public void setVoltarMenuBT(Button voltarMenuBT) {
        this.voltarMenuBT = voltarMenuBT;
    }

    public TableView<UsuarioRelatorio> getTabelaUsuarioTV() {
        return tabelaUsuarioTV;
    }

    public void setTabelaUsuarioTV(TableView<UsuarioRelatorio> tabelaUsuarioTV) {
        this.tabelaUsuarioTV = tabelaUsuarioTV;
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

    public TableColumn<UsuarioRelatorio, String> getColunaNome() {
        return colunaNome;
    }

    public void setColunaNome(TableColumn<UsuarioRelatorio, String> colunaNome) {
        this.colunaNome = colunaNome;
    }

    public TableColumn<UsuarioRelatorio, String> getColunaTelefone() {
        return colunaTelefone;
    }

    public void setColunaTelefone(TableColumn<UsuarioRelatorio, String> colunaTelefone) {
        this.colunaTelefone = colunaTelefone;
    }

    public TableColumn<UsuarioRelatorio, String> getColunaEmail() {
        return colunaEmail;
    }

    public void setColunaEmail(TableColumn<UsuarioRelatorio, String> colunaEmail) {
        this.colunaEmail = colunaEmail;
    }

    public TableColumn<UsuarioRelatorio, String> getColunaLogin() {
        return colunaLogin;
    }

    public void setColunaLogin(TableColumn<UsuarioRelatorio, String> colunaLogin) {
        this.colunaLogin = colunaLogin;
    }

    public TableColumn<UsuarioRelatorio, String> getColunaSenha() {
        return colunaSenha;
    }

    public void setColunaSenha(TableColumn<UsuarioRelatorio, String> colunaSenha) {
        this.colunaSenha = colunaSenha;
    }

    public Button getListarTabelaBT() {
        return listarTabelaBT;
    }

    public void setListarTabelaBT(Button listarTabelaBT) {
        this.listarTabelaBT = listarTabelaBT;
    }

    public ComboBox<UsuarioRelatorio> getFiltroPesquisaCB() {
        return filtroPesquisaCB;
    }

    public void setFiltroPesquisaCB(ComboBox<UsuarioRelatorio> filtroPesquisaCB) {
        this.filtroPesquisaCB = filtroPesquisaCB;
    }

    public TextField getCampoPesquisaTF() {
        return campoPesquisaTF;
    }

    public void setCampoPesquisaTF(TextField campoPesquisaTF) {
        this.campoPesquisaTF = campoPesquisaTF;
    }

    public Button getImprimirBT() {
        return imprimirBT;
    }

    public void setImprimirBT(Button imprimirBT) {
        this.imprimirBT = imprimirBT;
    }

    public Button getBotaoVoltarMenu() {
        return botaoVoltarMenu;
    }

    public void setBotaoVoltarMenu(Button botaoVoltarMenu) {
        this.botaoVoltarMenu = botaoVoltarMenu;
    }

    //FIM DOS COMPONENTES GRÁFICOS.
    //CONSTRUTOR INICIALIZADOR DA CLASSE QUE CONTROLA AS AÇÕES 
    //DOS COMPONENTES DA INTERFACE GRÁFICA USUÁRIO.
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio();
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

        usuarioRelatorio.preencherComboBoxFiltroPesquisa(filtroPesquisaCB);

        filtroPesquisaCB.getSelectionModel().selectFirst();
    }//FIM DOS CONSTRUTOR.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO TECLADO(TECLA ENTER)
    void voltarMenuBTTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            usuarioRelatorio.abrirMenu();
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(filtroPesquisaCB::requestFocus);//fim do run.
            filtroPesquisaCB.getSelectionModel().selectFirst();
        }
    }//FIM DO MÉTODO kEYEVENT.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO CLIC DO MOUSE.
    void voltarMenuBTMouse(MouseEvent event) {
        UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio();
        usuarioRelatorio.abrirMenu();
        usuarioRelatorio.fecharUsuario();
        Platform.runLater(filtroPesquisaCB::requestFocus);//fim do run.
        filtroPesquisaCB.getSelectionModel().selectFirst();
    }//FIM DO MÉTODO

    @FXML
    void tabelaUsuarioTVMouse(MouseEvent event) {
        tabelaUsuarioTV.getSelectionModel().selectFirst();
        Platform.runLater(imprimirBT::requestFocus);//fim do run.
    }

    @FXML
    void tabelaUsuarioTVTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(imprimirBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio();
            usuarioRelatorio.imprimir(
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
        UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio();
        usuarioRelatorio.imprimir(
                filtroPesquisaCB,
                campoNomePesquisaTF,
                campoTelefonePesquisaTF,
                campoEmailPesquisaTF);

//        filtroPesquisaCB.getSelectionModel().selectFirst();
    }

    @FXML
    void campoTodosUsuariosPesquisaTFMouse(MouseEvent event) {

    }

    @FXML
    void campoTodosUsuariosPesquisaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaUsuarioTV::requestFocus);//fim do run.
            tabelaUsuarioTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void campoTodosUsuariosPesquisaTFReleaseTeclado(KeyEvent event) {
        imprimirBT.setDisable(false);

        UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoTodosUsuariosPesquisaTF.getText()
        );

        if (event.getCode() != KeyCode.TAB) {
            usuarioRelatorio.iniciarTabela(
                    colunaNome,
                    colunaTelefone,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaUsuarioTV
            );
        }
        if (campoTodosUsuariosPesquisaTF.getText().isEmpty()) {
            tabelaUsuarioTV.getItems().clear();
        }

    }

    @FXML
    void campoEmailPesquisaTFMouse(MouseEvent event) {

    }

    @FXML
    void campoEmailPesquisaTFReleaseTeclado(KeyEvent event) {
        imprimirBT.setDisable(false);
        UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoEmailPesquisaTF.getText()
        );

        if (event.getCode() != KeyCode.TAB) {
            usuarioRelatorio.iniciarTabela(
                    colunaNome,
                    colunaTelefone,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaUsuarioTV
            );
        }
        if (campoEmailPesquisaTF.getText().isEmpty()) {
            tabelaUsuarioTV.getItems().clear();
        }
    }

    @FXML
    void campoEmailPesquisaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaUsuarioTV::requestFocus);//fim do run.
            tabelaUsuarioTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void campoNomePesquisaTFMouse(MouseEvent event) {
    }

    @FXML
    void campoNomePesquisaTFReleaseTeclado(KeyEvent event) {
        imprimirBT.setDisable(false);
        UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoNomePesquisaTF.getText()
        );

        if (event.getCode() != KeyCode.TAB) {
            usuarioRelatorio.iniciarTabela(
                    colunaNome,
                    colunaTelefone,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaUsuarioTV
            );
        }

        if (campoNomePesquisaTF.getText().isEmpty()) {
            tabelaUsuarioTV.getItems().clear();
        }
    }

    @FXML
    void campoNomePesquisaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaUsuarioTV::requestFocus);//fim do run.
            tabelaUsuarioTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void campoTelefonePesquisaTFMouse(MouseEvent event) {

    }

    @FXML
    void campoTelefonePesquisaTFReleaseTeclado(KeyEvent event) {
        imprimirBT.setDisable(false);

        UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoTelefonePesquisaTF.getText()
        );

        if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Telefone")) {
            usuarioRelatorio.formatarTelefone(campoTelefonePesquisaTF);
        } else {
        }
        if (event.getCode() != KeyCode.TAB) {
            usuarioRelatorio.iniciarTabela(
                    colunaNome,
                    colunaTelefone,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaUsuarioTV
            );
        }
        if (campoTelefonePesquisaTF.getText().isEmpty()) {
            tabelaUsuarioTV.getItems().clear();
        }
    }

    @FXML
    void campoTelefonePesquisaTFTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaUsuarioTV::requestFocus);//fim do run.
            tabelaUsuarioTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void filtroPesquisaCBMouse(MouseEvent event) {

        filtroPesquisaCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                imprimirBT.setDisable(true);
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Selecione um filtro")) {
                    campoTodosUsuariosPesquisaTF.setVisible(true);
                    campoTodosUsuariosPesquisaTF.setText("Escolheu um filtro de pesquisa?... não?!... Então, escolha um e depois CLIC AQUI!!");
                    campoTodosUsuariosPesquisaTF.setDisable(true);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    campoEmailPesquisaTF.clear();
                    tabelaUsuarioTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Nome")) {
                    campoTodosUsuariosPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(true);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoTelefonePesquisaTF.clear();
                    campoEmailPesquisaTF.clear();
                    campoTodosUsuariosPesquisaTF.clear();
                    tabelaUsuarioTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Telefone")) {
                    campoTodosUsuariosPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(true);
                    usuarioRelatorio.formatarTelefone(campoTelefonePesquisaTF);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoEmailPesquisaTF.clear();
                    campoTodosUsuariosPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    tabelaUsuarioTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("E-mail")) {
                    campoTodosUsuariosPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(true);
                    listarTodosBT.setVisible(false);
                    campoTodosUsuariosPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    tabelaUsuarioTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Todos")) {
                    campoTodosUsuariosPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(true);
                    campoTodosUsuariosPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    tabelaUsuarioTV.getItems().clear();
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
                    campoTodosUsuariosPesquisaTF.setVisible(true);
                    campoTodosUsuariosPesquisaTF.setText("Escolheu um filtro de pesquisa?... não?!... Então, escolha um e depois CLIC AQUI!!");
                    campoTodosUsuariosPesquisaTF.setDisable(true);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    campoEmailPesquisaTF.clear();
                    tabelaUsuarioTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Nome")) {
                    campoTodosUsuariosPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(true);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoTelefonePesquisaTF.clear();
                    campoEmailPesquisaTF.clear();
                    campoTodosUsuariosPesquisaTF.clear();
                    tabelaUsuarioTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Telefone")) {
                    campoTodosUsuariosPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(true);
                    usuarioRelatorio.formatarTelefone(campoTelefonePesquisaTF);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(false);
                    campoEmailPesquisaTF.clear();
                    campoTodosUsuariosPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    tabelaUsuarioTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("E-mail")) {
                    campoTodosUsuariosPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(true);
                    listarTodosBT.setVisible(false);
                    campoTodosUsuariosPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    tabelaUsuarioTV.getItems().clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Todos")) {
                    campoTodosUsuariosPesquisaTF.setVisible(false);
                    campoNomePesquisaTF.setVisible(false);
                    campoTelefonePesquisaTF.setVisible(false);
                    campoEmailPesquisaTF.setVisible(false);
                    listarTodosBT.setVisible(true);
                    campoTodosUsuariosPesquisaTF.clear();
                    campoNomePesquisaTF.clear();
                    campoTelefonePesquisaTF.clear();
                    tabelaUsuarioTV.getItems().clear();
                }
            }
        });

    }

    @FXML
    void filtroPesquisaCBReleaseTeclado(KeyEvent event) {

    }

    @FXML
    void filtroPesquisaCBReleaseMouse(MouseEvent event) {

    }

    @FXML
    void listarTodosBTTeclado(KeyEvent event) {

        imprimirBT.setDisable(false);

        UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoTelefonePesquisaTF.getText()
        );

        if (event.getCode() != KeyCode.TAB
                && event.getCode() == KeyCode.ENTER) {
            usuarioRelatorio.iniciarTabela(
                    colunaNome,
                    colunaTelefone,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaUsuarioTV
            );
        }

        Platform.runLater(tabelaUsuarioTV::requestFocus);//fim do run.

    }

    @FXML
    void listarTodosBTMouse(MouseEvent event) {
        imprimirBT.setDisable(false);

        UsuarioRelatorio usuarioRelatorio = new UsuarioRelatorio(
                (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString(),
                campoTelefonePesquisaTF.getText()
        );

        usuarioRelatorio.iniciarTabela(
                colunaNome,
                colunaTelefone,
                colunaEmail,
                colunaLogin,
                colunaSenha,
                tabelaUsuarioTV
        );

        Platform.runLater(tabelaUsuarioTV::requestFocus);//fim do run.

    }
}
