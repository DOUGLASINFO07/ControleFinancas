//Classe de implemento da Interface UsuarioInterface.
package classes;

import bancoConexaoDAO.EmpresaDAO;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import jeanderson.br.util.MaskFormatter;
import util.Utilitario;

/**
 *
 * @author douglas borges egidio
 * @since 25/09/2018
 */
public class Empresa extends Application {

    Connection conn;

    //VARIÁVEIS DA CLASSE.
    private String nomeEmpresa;
    private String produtoEmpresa;
    private String telefoneEmpresa;
    private String siteEmpresa;
    private String emailEmpresa;
    private String loginEmpresa;
    private String senhaEmpresa;
    private String caminhoFoto;
    private ImageView fotoEmpresa;
    //FIM DAS VARIÁVEIS.

    public Empresa(
            String nomeEmpresa,
            String produtoEmpresa,
            String telefoneEmpresa,
            String siteEmpresa,
            String emailEmpresa,
            String loginEmpresa,
            String senhaEmpresa,
            ImageView fotoEmpresa
    ) {
        this.nomeEmpresa = nomeEmpresa;
        this.produtoEmpresa = produtoEmpresa;
        this.telefoneEmpresa = telefoneEmpresa;
        this.siteEmpresa = siteEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.loginEmpresa = loginEmpresa;
        this.senhaEmpresa = senhaEmpresa;
        this.fotoEmpresa = fotoEmpresa;
    }

    public Empresa(
            String nomeEmpresa,
            String produtoEmpresa,
            String telefoneEmpresa,
            String siteEmpresa,
            String emailEmpresa,
            String loginEmpresa,
            String senhaEmpresa,
            String caminhoFoto
    ) {
        this.nomeEmpresa = nomeEmpresa;
        this.produtoEmpresa = produtoEmpresa;
        this.telefoneEmpresa = telefoneEmpresa;
        this.siteEmpresa = siteEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.loginEmpresa = loginEmpresa;
        this.senhaEmpresa = senhaEmpresa;
        this.caminhoFoto = caminhoFoto;
    }

    public Empresa(String caminhoFoto, ImageView fotoEmpresa) {
        this.caminhoFoto = caminhoFoto;
        this.fotoEmpresa = fotoEmpresa;
    }

    public Empresa(
            String nomeEmpresa,
            String produtoEmpresa,
            String telefoneEmpresa,
            String siteEmpresa,
            String emailEmpresa,
            String senhaEmpresa,
            String loginEmpresa
    ) {
        this.nomeEmpresa = nomeEmpresa;
        this.produtoEmpresa = produtoEmpresa;
        this.telefoneEmpresa = telefoneEmpresa;
        this.siteEmpresa = siteEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.loginEmpresa = loginEmpresa;
        this.senhaEmpresa = senhaEmpresa;
    }

    //CONSTRUTOR VAZIO 
    public Empresa() {

    }//FIM DO CONSTRUTOR VAZIO.

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getProdutoEmpresa() {
        return produtoEmpresa;
    }

    public void setProdutoEmpresa(String produtoEmpresa) {
        this.produtoEmpresa = produtoEmpresa;
    }

    public String getTelefoneEmpresa() {
        return telefoneEmpresa;
    }

    public void setTelefoneEmpresa(String telefoneEmpresa) {
        this.telefoneEmpresa = telefoneEmpresa;
    }

    public String getSiteEmpresa() {
        return siteEmpresa;
    }

    public void setSiteEmpresa(String siteEmpresa) {
        this.siteEmpresa = siteEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getLoginEmpresa() {
        return loginEmpresa;
    }

    public void setLoginEmpresa(String loginEmpresa) {
        this.loginEmpresa = loginEmpresa;
    }

    public String getSenhaEmpresa() {
        return senhaEmpresa;
    }

    public void setSenhaEmpresa(String senhaEmpresa) {
        this.senhaEmpresa = senhaEmpresa;
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

    //FIM DOS MÉTODOS GETTER E SETTER.
    //FORMATAR CAMPO TELEFONE.
    public void formatarTelefone(TextField telefone) {
        MaskFormatter formatter = new MaskFormatter(telefone);
        formatter.setMask(MaskFormatter.TEL_8DIG);
    }//FIM DO MÉTODO FORMATAR TELEFONE.

    public void limitarQantidadeCaractere(TextField textField, int limite) {
        Utilitario.limitarQuantidadeCaracteres(textField, limite);
    }

    //MÉTODO FECHAR USUARIO.
    public void fecharEmpresa() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        Menu menu = new Menu();
        try {
            menu.start(new Stage());
            fecharEmpresa();
        } catch (Exception ex) {
            Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
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
        Parent root = FXMLLoader.load(getClass().getResource("/telas/FXMLEmpresa.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/consultarVenda.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Cadastrar Empresa");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    public void limparFormulario(
            ImageView fotoEmpresa,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeEmpresa,
            TextField produtoEmpresa,
            TextField telefoneEmpresa,
            TextField siteEmpresa,
            TextField emailEmpresa,
            TextField loginEmpresa,
            TextField senhaEmpresa,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Empresa> tabelaEmpresa,
            Button imprimir,
            Button voltarMenu
    ) {
        nomeEmpresa.setText("");
        produtoEmpresa.setText("");
        telefoneEmpresa.setText("");
        siteEmpresa.setText("");
        emailEmpresa.setText("");
        loginEmpresa.setText("");
        senhaEmpresa.setText("");
        fotoEmpresa.setImage(new Image("/imagens/semFoto.jpg"));

    }

    public void liberarCamposFormulario(
            ImageView fotoEmpresa,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeEmpresa,
            TextField produtoEmpresa,
            TextField telefoneEmpresa,
            TextField siteEmpresa,
            TextField emailEmpresa,
            TextField loginEmpresa,
            TextField senhaEmpresa,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Empresa> tabelaEmpresa,
            Button imprimir,
            Button voltarMenu
    ) {
        nomeEmpresa.setEditable(true);
        produtoEmpresa.setEditable(true);
        telefoneEmpresa.setEditable(true);
        siteEmpresa.setEditable(true);
        emailEmpresa.setEditable(true);
        loginEmpresa.setEditable(true);
        senhaEmpresa.setEditable(true);
        nomeEmpresa.setDisable(false);
        produtoEmpresa.setDisable(false);
        telefoneEmpresa.setDisable(false);
        siteEmpresa.setDisable(false);
        emailEmpresa.setDisable(false);
        loginEmpresa.setDisable(false);
        senhaEmpresa.setDisable(false);
        atualizar.setDisable(false);
        excluir.setDisable(false);
        BuscarImagem.setDisable(false);

        Platform.runLater(nomeEmpresa::requestFocus);
    }

    public void bloquearCamposFormulario(
            ImageView fotoEmpresa,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeEmpresa,
            TextField produtoEmpresa,
            TextField telefoneEmpresa,
            TextField siteEmpresa,
            TextField emailEmpresa,
            TextField loginEmpresa,
            TextField senhaEmpresa,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Empresa> tabelaEmpresa,
            Button imprimir,
            Button voltarMenu
    ) {
        nomeEmpresa.setDisable(true);
        produtoEmpresa.setDisable(true);
        telefoneEmpresa.setDisable(true);
        siteEmpresa.setDisable(true);
        emailEmpresa.setDisable(true);
        loginEmpresa.setDisable(true);
        senhaEmpresa.setDisable(true);
        salvar.setDisable(true);
        atualizar.setDisable(true);
        excluir.setDisable(true);
        BuscarImagem.setDisable(true);
        imprimir.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn nome,
            TableColumn produto,
            TableColumn telefone,
            TableColumn site,
            TableColumn email,
            TableColumn login,
            TableColumn senha,
            TableView tabelaEmpresa
    ) {
        nome.setCellValueFactory(new PropertyValueFactory("nomeEmpresa"));
        produto.setCellValueFactory(new PropertyValueFactory("produtoEmpresa"));
        telefone.setCellValueFactory(new PropertyValueFactory("telefoneEmpresa"));
        site.setCellValueFactory(new PropertyValueFactory("siteEmpresa"));
        email.setCellValueFactory(new PropertyValueFactory("emailEmpresa"));
        login.setCellValueFactory(new PropertyValueFactory("loginEmpresa"));
        senha.setCellValueFactory(new PropertyValueFactory("senhaEmpresa"));
        tabelaEmpresa.setItems(atualizaTabela());
    }

    public ObservableList<Empresa> atualizaTabela() {
        EmpresaDAO dao = new EmpresaDAO();
        return FXCollections.observableArrayList(dao.listaEmpresa());
    }

    public void pegarDadoTabela(
            ImageView fotoEmpresa,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeEmpresa,
            TextField produtoEmpresa,
            TextField telefoneEmpresa,
            TextField siteEmpresa,
            TextField emailEmpresa,
            TextField loginEmpresa,
            TextField senhaEmpresa,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Empresa> tabelaEmpresa,
            Button imprimir,
            Button voltarMenu
    ) {
        nomeEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getNomeEmpresa());
        produtoEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getProdutoEmpresa());
        telefoneEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getTelefoneEmpresa());
        siteEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getSiteEmpresa());
        emailEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getEmailEmpresa());
        loginEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getLoginEmpresa());
        senhaEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getSenhaEmpresa());

        String nome = tabelaEmpresa.getSelectionModel().getSelectedItem().getNomeEmpresa();
        String email = tabelaEmpresa.getSelectionModel().getSelectedItem().getEmailEmpresa();

        setCaminhoFoto("");
        EmpresaDAO dao = new EmpresaDAO();

        dao.buscarFoto(nome, email);
        fotoEmpresa.getClass().getResource(dao.getCaminhoFoto());
        fotoEmpresa.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));
        
        caminhoFoto = dao.getCaminhoFoto();
        
        System.out.println("" + dao.getCaminhoFoto());

    }
    //FIM DOS MÉTODO PARA MANIPULAÇÃO DA TABELA.

    public void cadastrarEmpresa(
            String caminhoFoto,
            ImageView fotoEmpresa,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeEmpresa,
            TextField produtoEmpresa,
            TextField telefoneEmpresa,
            TextField siteEmpresa,
            TextField emailEmpresa,
            TextField loginEmpresa,
            TextField senhaEmpresa,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Empresa> tabelaEmpresa,
            Button imprimir,
            Button voltarMenu
    ) {
        Utilitario util = new Utilitario();

        String nome = nomeEmpresa.getText();
        String produto = produtoEmpresa.getText();
        String telefone = telefoneEmpresa.getText();
        String site = siteEmpresa.getText();
        String email = emailEmpresa.getText();
        String login = loginEmpresa.getText();
        String senha = senhaEmpresa.getText();
//        setCaminhoFoto(caminhoFoto);

        //confere se todos os campos estão preenchidos
        if (nomeEmpresa.getText().equals("")
                || produtoEmpresa.getText().equals("")
                || telefoneEmpresa.getText().equals("")
                || siteEmpresa.getText().equals("")
                || emailEmpresa.getText().equals("")
                || loginEmpresa.getText().equals("")
                || senhaEmpresa.getText().equals("")) {

            util.alertConfiraFormulario();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    BuscarImagem.requestFocus();
                }
            });

        } else {

            //confere se o campo telefone contem todos os números.
            if (telefoneEmpresa.getText().length() < 14) {
                Platform.runLater(() -> {
                    telefoneEmpresa.requestFocus();
                    telefoneEmpresa.positionCaret(telefoneEmpresa.getText().length());
                });

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
                alert.setContentText("ATENÇÃO!!\n Confira o número do telefone!!");
                alert.show();//Fim do if.
            } else {
                //Confere se o email contém o @.
//                if (!emailUsusario.getText().contains("@") || !emailUsusario.getText().contains(".com")) {
                Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
                Matcher m = p.matcher(emailEmpresa.getText());
                if (!(m.find() && m.group().equals(emailEmpresa.getText()))) {
                    Platform.runLater(emailEmpresa::requestFocus);
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
                    alert.setContentText("ATENÇÃO!!\nConfira o email!!");
                    alert.show();//Fim do if.
                } else {

                    //Confere se está tudo ok com o banco de dados
                    EmpresaDAO empresaDAO = new EmpresaDAO();
                    Empresa e = new Empresa(nome, produto, telefone, site, email, login, senha, getCaminhoFoto());
                    if (empresaDAO.Inserir(e)) {
//                            Platform.runLater(NovoCadastro::requestFocus);//fim do run.
                        limparFormulario(
                                fotoEmpresa,
                                BuscarImagem,
                                NovoCadastro,
                                nomeEmpresa,
                                produtoEmpresa,
                                telefoneEmpresa,
                                siteEmpresa,
                                emailEmpresa,
                                loginEmpresa,
                                senhaEmpresa,
                                salvar,
                                atualizar,
                                excluir,
                                listarTabela,
                                tabelaEmpresa,
                                imprimir,
                                voltarMenu
                        );

                        bloquearCamposFormulario(
                                fotoEmpresa,
                                BuscarImagem,
                                NovoCadastro,
                                nomeEmpresa,
                                produtoEmpresa,
                                telefoneEmpresa,
                                siteEmpresa,
                                emailEmpresa,
                                loginEmpresa,
                                senhaEmpresa,
                                salvar,
                                atualizar,
                                excluir,
                                listarTabela,
                                tabelaEmpresa,
                                imprimir,
                                voltarMenu
                        );

                        //exibe mensagem de cadastrado com sucesso.
                        util.alertCadastrado("Empresa " + nome);//Fim do if.

                        Platform.runLater(() -> {
                            Platform.runLater(NovoCadastro::requestFocus);
                        });
//                           if (event.getCode() == KeyCode.TAB) {
                        salvar.setDisable(true);

                    } else {
                        util.alertNaoCadastrado("Empresa " + nome);
                    }
                }
            }
        }
    }

    public void atualizarEmpresa(
            String caminhoFoto,
            ImageView fotoEmpresa,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeEmpresa,
            TextField produtoEmpresa,
            TextField telefoneEmpresa,
            TextField siteEmpresa,
            TextField emailEmpresa,
            TextField loginEmpresa,
            TextField senhaEmpresa,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Empresa> tabelaEmpresa,
            Button imprimir,
            Button voltarMenu
    ) {
        Utilitario util = new Utilitario();

        String nome = nomeEmpresa.getText();
        String produto = produtoEmpresa.getText();
        String telefone = telefoneEmpresa.getText();
        String site = siteEmpresa.getText();
        String email = emailEmpresa.getText();
        String login = loginEmpresa.getText();
        String senha = senhaEmpresa.getText();
//        setCaminhoFoto(caminhoFoto);
        //confere se todos os campos estão preenchidos
        if (nomeEmpresa.getText().equals("")
                || produtoEmpresa.getText().equals("")
                || telefoneEmpresa.getText().equals("")
                || siteEmpresa.getText().equals("")
                || emailEmpresa.getText().equals("")
                || loginEmpresa.getText().equals("")
                || senhaEmpresa.getText().equals("")) {

            util.alertConfiraFormulario();
        } else {
            //confere se o campo telefone contem todos os números.
            if (telefoneEmpresa.getText().length() < 14) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        telefoneEmpresa.requestFocus();
                        telefoneEmpresa.positionCaret(telefoneEmpresa.getText().length());
                    }
                });
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
                alert.setContentText("ATENÇÃO!!\n Confira o número do telefone!!");
                alert.show();//Fim do if.
            } else {
//                if (!emailUsusario.getText().contains("@") || !emailUsusario.getText().contains(".com")) {
                Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
                Matcher m = p.matcher(emailEmpresa.getText());
                if (!(m.find() && m.group().equals(emailEmpresa.getText()))) {
                    Platform.runLater(emailEmpresa::requestFocus);
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
                    alert.setContentText("ATENÇÃO!!\nConfira o email!!");
                    alert.show();//Fim do if.
                } else {
                    EmpresaDAO empresaDAO = new EmpresaDAO();
                    Empresa e = new Empresa(nome, produto, telefone, site, email, login, senha, getCaminhoFoto());
                    if (empresaDAO.atualizar(e)) {
                        limparFormulario(
                                fotoEmpresa,
                                BuscarImagem,
                                NovoCadastro,
                                nomeEmpresa,
                                produtoEmpresa,
                                telefoneEmpresa,
                                siteEmpresa,
                                emailEmpresa,
                                loginEmpresa,
                                senhaEmpresa,
                                salvar,
                                atualizar,
                                excluir,
                                listarTabela,
                                tabelaEmpresa,
                                imprimir,
                                voltarMenu
                        );
                        bloquearCamposFormulario(
                                fotoEmpresa,
                                BuscarImagem,
                                NovoCadastro,
                                nomeEmpresa,
                                produtoEmpresa,
                                telefoneEmpresa,
                                siteEmpresa,
                                emailEmpresa,
                                loginEmpresa,
                                senhaEmpresa,
                                salvar,
                                atualizar,
                                excluir,
                                listarTabela,
                                tabelaEmpresa,
                                imprimir,
                                voltarMenu
                        );
                        tabelaEmpresa.getItems().clear();
                        util.alertAtualizacao("Empresa " + nome);//Fim do if.
                    } else {
                        util.alertNaoAtualizado("Empresa " + nome);
                    }
                }
            }
        }
    }

    public void excluirEmpresa(
            ImageView fotoEmpresa,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeEmpresa,
            TextField produtoEmpresa,
            TextField telefoneEmpresa,
            TextField siteEmpresa,
            TextField emailEmpresa,
            TextField loginEmpresa,
            TextField senhaEmpresa,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Empresa> tabelaEmpresa,
            Button imprimir,
            Button voltarMenu
    ) {
        Utilitario util = new Utilitario();

        String nome = nomeEmpresa.getText();
        String produto = produtoEmpresa.getText();
        String telefone = telefoneEmpresa.getText();
        String site = siteEmpresa.getText();
        String email = emailEmpresa.getText();
        String login = loginEmpresa.getText();
        String senha = senhaEmpresa.getText();

        //Confere se está tudo ok com o banco de dados
        EmpresaDAO empresaDAO = new EmpresaDAO();
        Empresa e = new Empresa(nome, produto, telefone, site, email, login, senha);
        if (empresaDAO.apagar(e)) {

            File img = new File("../src/" + getCaminhoFoto());
            img.delete();

            limparFormulario(
                    fotoEmpresa,
                    BuscarImagem,
                    NovoCadastro,
                    nomeEmpresa,
                    produtoEmpresa,
                    telefoneEmpresa,
                    siteEmpresa,
                    emailEmpresa,
                    loginEmpresa,
                    senhaEmpresa,
                    salvar,
                    atualizar,
                    excluir,
                    listarTabela,
                    tabelaEmpresa,
                    imprimir,
                    voltarMenu
            );

            bloquearCamposFormulario(
                    fotoEmpresa,
                    BuscarImagem,
                    NovoCadastro,
                    nomeEmpresa,
                    produtoEmpresa,
                    telefoneEmpresa,
                    siteEmpresa,
                    emailEmpresa,
                    loginEmpresa,
                    senhaEmpresa,
                    salvar,
                    atualizar,
                    excluir,
                    listarTabela,
                    tabelaEmpresa,
                    imprimir,
                    voltarMenu
            );
            tabelaEmpresa.getItems().clear();
            //exibe mensagem de cadastrado com sucesso.
            util.alertExcluido("Empresa " + nome);//Fim do if.

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(NovoCadastro::requestFocus);//fim do run.

        } else {
            util.alertNaoExcluído("Empresa " + nome);
        }
    }

    public void gerarRelatorio() {
        Utilitario util = new Utilitario(conn);
        String relatorio = "../src/relatorio/Empresa.jasper";
        util.relatorio(relatorio);
    }

    public void selecionarFoto(
            ImageView fotoEmpresa,
            String caminho
    ) {
        FileChooser buscarImage = new FileChooser();
        buscarImage.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg"));

        File imagem = buscarImage.showOpenDialog(new Stage());

        if (imagem != null) {
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };

            setCaminhoFoto("fotosEmpresas/" + imagem.getName());

            try {
                Files.copy(Paths.get((imagem.getAbsolutePath())), Paths.get("../src/fotosEmpresas/" + imagem.getName()), options);
            } catch (IOException ex) {
                Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
            }

            fotoEmpresa.setImage(new Image("file:///" + imagem.getAbsolutePath()));

            System.out.println("" + getCaminhoFoto());
        }
    }

}
