package controladorFXML;

import classes.Empresa;
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
public class FXMLEmpresaController implements Initializable {

    Empresa empresa = new Empresa();

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

    public FXMLEmpresaController(
            TextField nomeEmpresaTF,
            TextField telefoneEmpresaTF,
            TextField emailEmpresaTF,
            TextField loginEmpresaTF,
            TextField senhaEmpresaTF,
            TextField produtoEmpresaTF,
            TextField siteEmpresaTF
    ) {
        this.nomeEmpresaTF = nomeEmpresaTF;
        this.telefoneEmpresaTF = telefoneEmpresaTF;
        this.emailEmpresaTF = emailEmpresaTF;
        this.loginEmpresaTF = loginEmpresaTF;
        this.senhaEmpresaTF = senhaEmpresaTF;
        this.produtoEmpresaTF = produtoEmpresaTF;
        this.siteEmpresaTF = siteEmpresaTF;
    }

    public FXMLEmpresaController() {

    }

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private Pane formularioPane;

    @FXML
    private Button novaEmpresaBT;

    @FXML
    private TextField nomeEmpresaTF;

    @FXML
    private TextField telefoneEmpresaTF;

    @FXML
    private TextField emailEmpresaTF;

    @FXML
    private TextField loginEmpresaTF;

    @FXML
    private TextField senhaEmpresaTF;

    @FXML
    private TextField produtoEmpresaTF;

    @FXML
    private TextField siteEmpresaTF;

    @FXML
    private ImageView fotoEmpresaIV;

    @FXML
    private Button escolherImagemBT;

    @FXML
    private Button salvarBT;

    @FXML
    private Button atualizarBT;

    @FXML
    private Button deletarBT;

    @FXML
    private Button listarTabelaBT;

    @FXML
    private TableView<Empresa> tabelaEmpresa;

    @FXML
    private TableColumn<Empresa, String> colunaNome;

    @FXML
    private TableColumn<Empresa, String> colunaProduto;

    @FXML
    private TableColumn<Empresa, String> colunaTelefone;

    @FXML
    private TableColumn<Empresa, String> colunaSite;

    @FXML
    private TableColumn<Empresa, String> colunaEmail;

    @FXML
    private TableColumn<Empresa, String> colunaLogin;

    @FXML
    private TableColumn<Empresa, String> colunaSenha;

    @FXML
    private Button imprimirBT;

    @FXML
    private Button voltarMenuBT;

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

    public Button getNovaEmpresaBT() {
        return novaEmpresaBT;
    }

    public void setNovaEmpresaBT(Button novaEmpresaBT) {
        this.novaEmpresaBT = novaEmpresaBT;
    }

    public TextField getNomeEmpresaTF() {
        return nomeEmpresaTF;
    }

    public void setNomeEmpresaTF(TextField nomeEmpresaTF) {
        this.nomeEmpresaTF = nomeEmpresaTF;
    }

    public TextField getTelefoneEmpresaTF() {
        return telefoneEmpresaTF;
    }

    public void setTelefoneEmpresaTF(TextField telefoneEmpresaTF) {
        this.telefoneEmpresaTF = telefoneEmpresaTF;
    }

    public TextField getEmailEmpresaTF() {
        return emailEmpresaTF;
    }

    public void setEmailEmpresaTF(TextField emailEmpresaTF) {
        this.emailEmpresaTF = emailEmpresaTF;
    }

    public TextField getLoginEmpresaTF() {
        return loginEmpresaTF;
    }

    public void setLoginEmpresaTF(TextField loginEmpresaTF) {
        this.loginEmpresaTF = loginEmpresaTF;
    }

    public TextField getSenhaEmpresaTF() {
        return senhaEmpresaTF;
    }

    public void setSenhaEmpresaTF(TextField senhaEmpresaTF) {
        this.senhaEmpresaTF = senhaEmpresaTF;
    }

    public TextField getProdutoEmpresaTF() {
        return produtoEmpresaTF;
    }

    public void setProdutoEmpresaTF(TextField produtoEmpresaTF) {
        this.produtoEmpresaTF = produtoEmpresaTF;
    }

    public TextField getSiteEmpresaTF() {
        return siteEmpresaTF;
    }

    public void setSiteEmpresaTF(TextField siteEmpresaTF) {
        this.siteEmpresaTF = siteEmpresaTF;
    }

    public ImageView getFotoEmpresaIV() {
        return fotoEmpresaIV;
    }

    public void setFotoEmpresaIV(ImageView fotoEmpresaIV) {
        this.fotoEmpresaIV = fotoEmpresaIV;
    }

    public Button getEscolherImagemBT() {
        return escolherImagemBT;
    }

    public void setEscolherImagemBT(Button escolherImagemBT) {
        this.escolherImagemBT = escolherImagemBT;
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

    public TableView<?> getTabelaEmpresa() {
        return tabelaEmpresa;
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

//    //IDENTIFICAÇÃO DOS COMPONENTES DA INTERFACE GRÁFICA.
    //CONSTRUTOR INICIALIZADOR DA CLASSE QUE CONTROLA AS AÇÕES 
    //DOS COMPONENTES DA INTERFACE GRÁFICA USUÁRIO.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Relogio relogio = new Relogio(horasLB);
        Empresa e = new Empresa();
        e.bloquearCamposFormulario(
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );

        e.limitarQantidadeCaractere(getTelefoneEmpresaTF(), 14);
        Utilitario.validarTextField(getTelefoneEmpresaTF());
        e.formatarTelefone(getTelefoneEmpresaTF());

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

            empresa.abrirMenu();
        }
    }//FIM DO MÉTODO kEYEVENT.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO CLIC DO MOUSE.
    void abrirMenuMouse(MouseEvent event) {
        Empresa empresa = new Empresa();
        empresa.abrirMenu();
//        usuario.fecharUsuario();
    }//FIM DO MÉTODO.

    @FXML
    void salvarEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            empresa.cadastrarEmpresa(
                    caminhoFoto,
                    fotoEmpresaIV,
                    escolherImagemBT,
                    novaEmpresaBT,
                    nomeEmpresaTF,
                    produtoEmpresaTF,
                    telefoneEmpresaTF,
                    siteEmpresaTF,
                    emailEmpresaTF,
                    loginEmpresaTF,
                    senhaEmpresaTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaEmpresa,
                    imprimirBT,
                    voltarMenuBT
            );
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(escolherImagemBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void salvarMouse(MouseEvent event) {

        empresa.cadastrarEmpresa(
                caminhoFoto,
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );
    }

    @FXML
    void novoCadastroEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

            empresa.limparFormulario(
                    fotoEmpresaIV,
                    escolherImagemBT,
                    novaEmpresaBT,
                    nomeEmpresaTF,
                    produtoEmpresaTF,
                    telefoneEmpresaTF,
                    siteEmpresaTF,
                    emailEmpresaTF,
                    loginEmpresaTF,
                    senhaEmpresaTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaEmpresa,
                    imprimirBT,
                    voltarMenuBT
            );

            empresa.liberarCamposFormulario(
                    fotoEmpresaIV,
                    escolherImagemBT,
                    novaEmpresaBT,
                    nomeEmpresaTF,
                    produtoEmpresaTF,
                    telefoneEmpresaTF,
                    siteEmpresaTF,
                    emailEmpresaTF,
                    loginEmpresaTF,
                    senhaEmpresaTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaEmpresa,
                    imprimirBT,
                    voltarMenuBT
            );
            salvarBT.setDisable(false);
            atualizarBT.setDisable(true);
            deletarBT.setDisable(true);
            tabelaEmpresa.getItems().clear();
            Platform.runLater(escolherImagemBT::requestFocus);
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(escolherImagemBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void novoCadastroMouse(MouseEvent event) {
//        Usuario u = new Usuario();
        empresa.limparFormulario(
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );
        empresa.liberarCamposFormulario(
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );

        salvarBT.setDisable(false);
        atualizarBT.setDisable(true);
        deletarBT.setDisable(true);
        tabelaEmpresa.getItems().clear();
        Platform.runLater(escolherImagemBT::requestFocus);
    }

    @FXML
    void listarTabelaMouse(MouseEvent event) {

        empresa.limparFormulario(
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );

        empresa.bloquearCamposFormulario(
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );

        empresa.iniciarTabela(
                colunaNome,
                colunaProduto,
                colunaTelefone,
                colunaSite,
                colunaEmail,
                colunaLogin,
                colunaSenha,
                tabelaEmpresa
        );
        salvarBT.setDisable(true);
        imprimirBT.setDisable(false);

//        //Inicio run que encapsula o requestFocus().
//        Platform.runLater(tabelaUsuario::requestFocus);//fim do run.
    }

    @FXML
    void listarTabelaEnter(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            empresa.limparFormulario(
                    fotoEmpresaIV,
                    escolherImagemBT,
                    novaEmpresaBT,
                    nomeEmpresaTF,
                    produtoEmpresaTF,
                    telefoneEmpresaTF,
                    siteEmpresaTF,
                    emailEmpresaTF,
                    loginEmpresaTF,
                    senhaEmpresaTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaEmpresa,
                    imprimirBT,
                    voltarMenuBT
            );
            empresa.bloquearCamposFormulario(
                    fotoEmpresaIV,
                    escolherImagemBT,
                    novaEmpresaBT,
                    nomeEmpresaTF,
                    produtoEmpresaTF,
                    telefoneEmpresaTF,
                    siteEmpresaTF,
                    emailEmpresaTF,
                    loginEmpresaTF,
                    senhaEmpresaTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaEmpresa,
                    imprimirBT,
                    voltarMenuBT
            );

            empresa.iniciarTabela(
                    colunaNome,
                    colunaProduto,
                    colunaTelefone,
                    colunaSite,
                    colunaEmail,
                    colunaLogin,
                    colunaSenha,
                    tabelaEmpresa
            );
            salvarBT.setDisable(true);
            imprimirBT.setDisable(false);

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(tabelaEmpresa::requestFocus);//fim do run.
        }
    }

    @FXML
    void pegarDadoTabelaMouse(MouseEvent event) {

        empresa.liberarCamposFormulario(
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );

        empresa.pegarDadoTabela(
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );
        nomeEmpresaTF.setEditable(false);
        Platform.runLater(produtoEmpresaTF::requestFocus);//fim do run.
    }

    @FXML
    void pegarDadoTabelaEnter(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            empresa.liberarCamposFormulario(
                    fotoEmpresaIV,
                    escolherImagemBT,
                    novaEmpresaBT,
                    nomeEmpresaTF,
                    produtoEmpresaTF,
                    telefoneEmpresaTF,
                    siteEmpresaTF,
                    emailEmpresaTF,
                    loginEmpresaTF,
                    senhaEmpresaTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaEmpresa,
                    imprimirBT,
                    voltarMenuBT
            );
            empresa.pegarDadoTabela(
                    fotoEmpresaIV,
                    escolherImagemBT,
                    novaEmpresaBT,
                    nomeEmpresaTF,
                    produtoEmpresaTF,
                    telefoneEmpresaTF,
                    siteEmpresaTF,
                    emailEmpresaTF,
                    loginEmpresaTF,
                    senhaEmpresaTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaEmpresa,
                    imprimirBT,
                    voltarMenuBT
            );
            nomeEmpresaTF.setEditable(false);
            Platform.runLater(produtoEmpresaTF::requestFocus);//fim do run.
        }

    }

    @FXML
    void atualizarMouse(MouseEvent event) {

        empresa.atualizarEmpresa(
                caminhoFoto,
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );
//        Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
    }

    @FXML
    void atualizarEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            empresa.atualizarEmpresa(
                    caminhoFoto,
                    fotoEmpresaIV,
                    escolherImagemBT,
                    novaEmpresaBT,
                    nomeEmpresaTF,
                    produtoEmpresaTF,
                    telefoneEmpresaTF,
                    siteEmpresaTF,
                    emailEmpresaTF,
                    loginEmpresaTF,
                    senhaEmpresaTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaEmpresa,
                    imprimirBT,
                    voltarMenuBT
            );
//            Platform.runLater(novoCadastroBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void excluirMouse(MouseEvent event) {
        empresa.excluirEmpresa(
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );
        empresa.bloquearCamposFormulario(
                fotoEmpresaIV,
                escolherImagemBT,
                novaEmpresaBT,
                nomeEmpresaTF,
                produtoEmpresaTF,
                telefoneEmpresaTF,
                siteEmpresaTF,
                emailEmpresaTF,
                loginEmpresaTF,
                senhaEmpresaTF,
                salvarBT,
                atualizarBT,
                deletarBT,
                listarTabelaBT,
                tabelaEmpresa,
                imprimirBT,
                voltarMenuBT
        );
        //Inicio run que encapsula o requestFocus().
        Platform.runLater(novaEmpresaBT::requestFocus);//fim do run.
    }

    @FXML
    void excluirEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            empresa.excluirEmpresa(
                    fotoEmpresaIV,
                    escolherImagemBT,
                    novaEmpresaBT,
                    nomeEmpresaTF,
                    produtoEmpresaTF,
                    telefoneEmpresaTF,
                    siteEmpresaTF,
                    emailEmpresaTF,
                    loginEmpresaTF,
                    senhaEmpresaTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaEmpresa,
                    imprimirBT,
                    voltarMenuBT
            );
            empresa.bloquearCamposFormulario(
                    fotoEmpresaIV,
                    escolherImagemBT,
                    novaEmpresaBT,
                    nomeEmpresaTF,
                    produtoEmpresaTF,
                    telefoneEmpresaTF,
                    siteEmpresaTF,
                    emailEmpresaTF,
                    loginEmpresaTF,
                    senhaEmpresaTF,
                    salvarBT,
                    atualizarBT,
                    deletarBT,
                    listarTabelaBT,
                    tabelaEmpresa,
                    imprimirBT,
                    voltarMenuBT
            );
            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novaEmpresaBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void imprimirEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

            empresa.gerarRelatorio();
        }
    }

    @FXML
    void imprimirMouse(MouseEvent event) {

        empresa.gerarRelatorio();
    }

    @FXML
    void selecionaFotoMouse(MouseEvent event) throws IOException {

        empresa.selecionarFoto(
                fotoEmpresaIV,
                caminhoFoto
        );

        Platform.runLater(nomeEmpresaTF::requestFocus);//fim do run.
    }

    @FXML
    void selecionaFotoEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            empresa.selecionarFoto(
                    fotoEmpresaIV,
                    caminhoFoto
            );

            Platform.runLater(nomeEmpresaTF::requestFocus);//fim do run.
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(nomeEmpresaTF::requestFocus);//fim do run.
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

    @FXML
    void emailEmpresaTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(loginEmpresaTF::requestFocus);//fim do run.
        }
    }

    @FXML
    void loginEmpresaTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(senhaEmpresaTF::requestFocus);//fim do run.
        }
    }

    @FXML
    void nomeEmpresaTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(produtoEmpresaTF  ::requestFocus);//fim do run.
        }
    }

    @FXML
    void produtoEmpresaTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(telefoneEmpresaTF::requestFocus);//fim do run.
        }
    }

    @FXML
    void senhaEmpresaTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(salvarBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void siteEmpresaTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(emailEmpresaTF::requestFocus);//fim do run.
        }
    }

    @FXML
    void telefoneEmpresaTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(siteEmpresaTF::requestFocus);//fim do run.
            Platform.runLater(atualizarBT::requestFocus);//fim do run.
        }
    }

}
