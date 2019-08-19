package controladorFXML;

import classes.Usuario;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import util.Relogio;
import util.Utilitario;

/**
 *
 * @author dougl
 */
public class FXMLUsuarioController implements Initializable {

    Usuario usuario = new Usuario();

    private String caminhoFoto;
    private String teste;

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    //IDENTIFICAÇÃO DOS COMPONENTES DA INTERFACE GRÁFICA.
    @FXML
    private TextField nomeUsuarioTF;
    @FXML
    private TextField celularUsuarioTF;
    @FXML
    private TextField emailUsuarioTF;
    @FXML
    private TextField loginUsuarioTF;
    @FXML
    private TextField senhaUsuarioTF;

    public FXMLUsuarioController(TextField nomeUsuarioTF, TextField celularUsuarioTF, TextField emailUsuarioTF, TextField loginUsuarioTF, TextField senhaUsuarioTF) {
        this.nomeUsuarioTF = nomeUsuarioTF;
        this.celularUsuarioTF = celularUsuarioTF;
        this.emailUsuarioTF = emailUsuarioTF;
        this.loginUsuarioTF = loginUsuarioTF;
        this.senhaUsuarioTF = senhaUsuarioTF;
    }

    public FXMLUsuarioController() {
    }

    public TextField getNomeUsuarioTF() {
        return nomeUsuarioTF;
    }

    public void setNomeUsuarioTF(TextField nomeUsuarioTF) {
        this.nomeUsuarioTF = nomeUsuarioTF;
    }

    public TextField getCelularUsuarioTF() {
        return celularUsuarioTF;
    }

    public void setCelularUsuarioTF(TextField celularUsuarioTF) {
        this.celularUsuarioTF = celularUsuarioTF;
    }

    public TextField getEmailUsuarioTF() {
        return emailUsuarioTF;
    }

    public void setEmailUsuarioTF(TextField emailUsuarioTF) {
        this.emailUsuarioTF = emailUsuarioTF;
    }

    public TextField getLoginUsuarioTF() {
        return loginUsuarioTF;
    }

    public void setLoginUsuarioTF(TextField loginUsuarioTF) {
        this.loginUsuarioTF = loginUsuarioTF;
    }

    public TextField getSenhaUsuarioTF() {
        return senhaUsuarioTF;
    }

    public void setSenhaUsuarioTF(TextField senhaUsuarioTF) {
        this.senhaUsuarioTF = senhaUsuarioTF;
    }

    @FXML
    private Button novoCadastroBT;
    @FXML
    private Button salvarBT;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Button getNovoCadastroBT() {
        return novoCadastroBT;
    }

    public void setNovoCadastroBT(Button novoCadastroBT) {
        this.novoCadastroBT = novoCadastroBT;
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

    public TableView<Usuario> getTabelaUsuario() {
        return tabelaUsuario;
    }

    public void setTabelaUsuario(TableView<Usuario> tabelaUsuario) {
        this.tabelaUsuario = tabelaUsuario;
    }

    public TableColumn<Usuario, String> getColunaNome() {
        return colunaNome;
    }

    public void setColunaNome(TableColumn<Usuario, String> colunaNome) {
        this.colunaNome = colunaNome;
    }

    public TableColumn<Usuario, String> getColunaTelefone() {
        return colunaTelefone;
    }

    public void setColunaTelefone(TableColumn<Usuario, String> colunaTelefone) {
        this.colunaTelefone = colunaTelefone;
    }

    public TableColumn<Usuario, String> getColunaEmail() {
        return colunaEmail;
    }

    public void setColunaEmail(TableColumn<Usuario, String> colunaEmail) {
        this.colunaEmail = colunaEmail;
    }

    public TableColumn<Usuario, String> getColunaLogin() {
        return colunaLogin;
    }

    public void setColunaLogin(TableColumn<Usuario, String> colunaLogin) {
        this.colunaLogin = colunaLogin;
    }

    public TableColumn<Usuario, String> getColunaSenha() {
        return colunaSenha;
    }

    public void setColunaSenha(TableColumn<Usuario, String> colunaSenha) {
        this.colunaSenha = colunaSenha;
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

    public Label getHorasLB() {
        return horasLB;
    }

    public void setHorasLB(Label horasLB) {
        this.horasLB = horasLB;
    }

    public Label getDataLB() {
        return dataLB;
    }

    public void setDataLB(Label dataLB) {
        this.dataLB = dataLB;
    }

    public Button getBuscarFotoBT() {
        return buscarFotoBT;
    }

    public void setBuscarFotoBT(Button buscarFotoBT) {
        this.buscarFotoBT = buscarFotoBT;
    }

    public ImageView getFotoUsuarioIV() {
        return fotoUsuarioIV;
    }

    public void setFotoUsuarioIV(ImageView fotoUsuarioIV) {
        this.fotoUsuarioIV = fotoUsuarioIV;
    }
    @FXML
    private Button atualizarBT;
    @FXML
    private Button deletarBT;
    @FXML
    private Button listarTabelaBT;
    @FXML
    private TableView<Usuario> tabelaUsuario;
    @FXML
    private TableColumn<Usuario, String> colunaNome;
    @FXML
    private TableColumn<Usuario, String> colunaTelefone;
    @FXML
    private TableColumn<Usuario, String> colunaEmail;
    @FXML
    private TableColumn<Usuario, String> colunaLogin;
    @FXML
    private TableColumn<Usuario, String> colunaSenha;
    @FXML
    private Button imprimirBT;
    @FXML
    private Button botaoVoltarMenu;
    @FXML
    private Label horasLB;
    @FXML
    private Label dataLB;
    @FXML
    private Button buscarFotoBT;
    @FXML
    private ImageView fotoUsuarioIV;
    @FXML
    private Pane formularioPane;
    //FIM DOS COMPONENTES GRÁFICOS.

    //CONSTRUTOR INICIALIZADOR DA CLASSE QUE CONTROLA AS AÇÕES 
    //DOS COMPONENTES DA INTERFACE GRÁFICA USUÁRIO.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario u = new Usuario();
        Relogio relogio = new Relogio(horasLB);
        u.bloquearCamposFormulario(
                fotoUsuarioIV,
                buscarFotoBT,
                novoCadastroBT,
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu
        );

        u.limitarQantidadeCaractere(getCelularUsuarioTF(), 15);
        Utilitario.validarTextField(getCelularUsuarioTF());
        u.formatarTelefone(getCelularUsuarioTF());
        u.limitarQantidadeCaractere(getSenhaUsuarioTF(), 6);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date = new Date();
        dataLB.setTextFill(Color.GRAY);
        dataLB.setText("Hoje é " + sdf.format(date));

//        u.selecionarFoto(
//                fotoUsuarioIV
//        );
        try {
            relogio.relogio();
        } catch (Exception ex) {
        }

    }//FIM DOS CONSTRUTOR.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO TECLADO(TECLA ENTER)
    void abrirMenuEnter(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            usuario.abrirMenu();
        }
    }//FIM DO MÉTODO kEYEVENT.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO CLIC DO MOUSE.
    void abrirMenuMouse(MouseEvent event) {
        Usuario usuario = new Usuario();
        usuario.abrirMenu();
//        usuario.fecharUsuario();
    }//FIM DO MÉTODO.

    @FXML
    void salvarEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            usuario.cadastrarUsuario(
                    caminhoFoto,
                    fotoUsuarioIV,
                    buscarFotoBT,
                    novoCadastroBT,
                    nomeUsuarioTF,
                    celularUsuarioTF,
                    emailUsuarioTF,
                    loginUsuarioTF,
                    senhaUsuarioTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaUsuario,
                    imprimirBT,
                    botaoVoltarMenu,
                    formularioPane
            );
        }
    }

    @FXML
    void salvarMouse(MouseEvent event) {

        usuario.cadastrarUsuario(
                caminhoFoto,
                fotoUsuarioIV,
                buscarFotoBT,
                novoCadastroBT,
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu,
                formularioPane
        );
    }

    @FXML
    void novoCadastroEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            
            usuario.limparFormulario(
                    fotoUsuarioIV,
                    buscarFotoBT,
                    getNovoCadastroBT(),
                    nomeUsuarioTF,
                    celularUsuarioTF,
                    emailUsuarioTF,
                    loginUsuarioTF,
                    senhaUsuarioTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaUsuario,
                    imprimirBT,
                    botaoVoltarMenu
            );

            usuario.liberarCamposFormulario(
                    fotoUsuarioIV,
                    buscarFotoBT,
                    getNovoCadastroBT(),
                    nomeUsuarioTF,
                    celularUsuarioTF,
                    emailUsuarioTF,
                    loginUsuarioTF,
                    senhaUsuarioTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaUsuario,
                    imprimirBT,
                    botaoVoltarMenu
            );
            salvarBT.setDisable(false);
            atualizarBT.setDisable(true);
            deletarBT.setDisable(true);
            tabelaUsuario.getItems().clear();
            Platform.runLater(buscarFotoBT::requestFocus);
        }

    }

    @FXML
    void novoCadastroMouse(MouseEvent event) {
//        Usuario u = new Usuario();
        usuario.limparFormulario(
                fotoUsuarioIV,
                buscarFotoBT,
                getNovoCadastroBT(),
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu
        );
        usuario.liberarCamposFormulario(
                fotoUsuarioIV,
                buscarFotoBT,
                novoCadastroBT,
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu
        );

        salvarBT.setDisable(false);
        atualizarBT.setDisable(true);
        deletarBT.setDisable(true);
        tabelaUsuario.getItems().clear();
         Platform.runLater(buscarFotoBT::requestFocus);
    }

    @FXML
    void listarTabelaMouse(MouseEvent event) {

        Usuario u = new Usuario();
        u.limparFormulario(
                fotoUsuarioIV,
                buscarFotoBT,
                novoCadastroBT,
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu
        );

        u.bloquearCamposFormulario(
                fotoUsuarioIV,
                buscarFotoBT,
                novoCadastroBT,
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu
        );

        u.iniciarTabela(
                colunaNome,
                colunaTelefone,
                colunaEmail,
                colunaLogin,
                colunaSenha,
                tabelaUsuario
        );
        salvarBT.setDisable(true);
        imprimirBT.setDisable(false);

//        //Inicio run que encapsula o requestFocus().
//        Platform.runLater(tabelaUsuario::requestFocus);//fim do run.
    }

    @FXML
    void listarTabelaEnter(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            Usuario u = new Usuario();
            u.limparFormulario(
                    fotoUsuarioIV,
                    buscarFotoBT,
                    novoCadastroBT,
                    nomeUsuarioTF,
                    celularUsuarioTF,
                    emailUsuarioTF,
                    loginUsuarioTF,
                    senhaUsuarioTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaUsuario,
                    imprimirBT,
                    botaoVoltarMenu
            );
            u.bloquearCamposFormulario(
                    fotoUsuarioIV,
                    buscarFotoBT,
                    novoCadastroBT,
                    nomeUsuarioTF,
                    celularUsuarioTF,
                    emailUsuarioTF,
                    loginUsuarioTF,
                    senhaUsuarioTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaUsuario,
                    imprimirBT,
                    botaoVoltarMenu
            );

            u.iniciarTabela(
                    colunaNome,
                    colunaTelefone,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaUsuario
            );
            salvarBT.setDisable(true);
            imprimirBT.setDisable(false);

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(tabelaUsuario::requestFocus);//fim do run.
        }
    }

    @FXML
    void pegarDadoTabelaMouse(MouseEvent event) {

        Usuario u = new Usuario();
        u.liberarCamposFormulario(
                fotoUsuarioIV,
                buscarFotoBT,
                novoCadastroBT,
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu
        );

        u.pegarDadoTabela(
                fotoUsuarioIV,
                buscarFotoBT,
                novoCadastroBT,
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu
        );
        nomeUsuarioTF.setEditable(false);
        Platform.runLater(celularUsuarioTF::requestFocus);//fim do run.
    }

    @FXML
    void pegarDadoTabelaEnter(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            Usuario u = new Usuario();
            u.liberarCamposFormulario(
                    fotoUsuarioIV,
                    buscarFotoBT,
                    novoCadastroBT,
                    nomeUsuarioTF,
                    celularUsuarioTF,
                    emailUsuarioTF,
                    loginUsuarioTF,
                    senhaUsuarioTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaUsuario,
                    imprimirBT,
                    botaoVoltarMenu
            );
            u.pegarDadoTabela(
                    fotoUsuarioIV,
                    buscarFotoBT,
                    novoCadastroBT,
                    nomeUsuarioTF,
                    celularUsuarioTF,
                    emailUsuarioTF,
                    loginUsuarioTF,
                    senhaUsuarioTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaUsuario,
                    imprimirBT,
                    botaoVoltarMenu
            );
            nomeUsuarioTF.setEditable(false);
            Platform.runLater(celularUsuarioTF::requestFocus);//fim do run.
        }

    }

    @FXML
    void atualizarMouse(MouseEvent event) {
        usuario.atualizarUsuario(
                getCaminhoFoto(),
                fotoUsuarioIV,
                buscarFotoBT,
                novoCadastroBT,
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu
        );
//        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    @FXML
    void atualizarEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            usuario.atualizarUsuario(
                    getCaminhoFoto(),
                    fotoUsuarioIV,
                    buscarFotoBT,
                    novoCadastroBT,
                    nomeUsuarioTF,
                    celularUsuarioTF,
                    emailUsuarioTF,
                    loginUsuarioTF,
                    senhaUsuarioTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaUsuario,
                    imprimirBT,
                    botaoVoltarMenu
            );
//            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void excluirMouse(MouseEvent event) {
        usuario.excluirUsuario(
                fotoUsuarioIV,
                buscarFotoBT,
                novoCadastroBT,
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu
        );
        usuario.bloquearCamposFormulario(
                fotoUsuarioIV,
                buscarFotoBT,
                novoCadastroBT,
                nomeUsuarioTF,
                celularUsuarioTF,
                emailUsuarioTF,
                loginUsuarioTF,
                senhaUsuarioTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaUsuario,
                imprimirBT,
                botaoVoltarMenu
        );
        //Inicio run que encapsula o requestFocus().
        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    @FXML
    void excluirEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            usuario.excluirUsuario(
                    fotoUsuarioIV,
                    buscarFotoBT,
                    novoCadastroBT,
                    nomeUsuarioTF,
                    celularUsuarioTF,
                    emailUsuarioTF,
                    loginUsuarioTF,
                    senhaUsuarioTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaUsuario,
                    imprimirBT,
                    botaoVoltarMenu
            );
            usuario.bloquearCamposFormulario(
                    fotoUsuarioIV,
                    buscarFotoBT,
                    novoCadastroBT,
                    nomeUsuarioTF,
                    celularUsuarioTF,
                    emailUsuarioTF,
                    loginUsuarioTF,
                    senhaUsuarioTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaUsuario,
                    imprimirBT,
                    botaoVoltarMenu
            );
            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void imprimirEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            Usuario usuario = new Usuario();
            usuario.gerarRelatorio();
        }
    }

    @FXML
    void imprimirMouse(MouseEvent event) {
        Usuario usuario = new Usuario();
        usuario.gerarRelatorio();
    }

    @FXML
    void selecionaFotoMouse(MouseEvent event) throws IOException {
        usuario.selecionarFoto(
                fotoUsuarioIV
        );
        Platform.runLater(nomeUsuarioTF::requestFocus);//fim do run.
    }

    @FXML
    void selecionaFotoEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            Usuario u = new Usuario();
            u.selecionarFoto(fotoUsuarioIV);
            setCaminhoFoto(u.getCaminhoFoto());
            Platform.runLater(nomeUsuarioTF::requestFocus);//fim do run.
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(nomeUsuarioTF::requestFocus);//fim do run.
        }
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

}
