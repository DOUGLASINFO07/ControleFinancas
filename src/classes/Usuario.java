//Classe de implemento da Interface UsuarioInterface.
package classes;

import bancoConexaoDAO.UsuarioDAO;
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
import javafx.scene.layout.Pane;
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
public class Usuario extends Application{

    Connection conn;

    Utilitario util = new Utilitario(conn);

    //VARIÁVEIS DA CLASSE.
    private String nomeUsuario;
    private String telefoneUsuario;
    private String emailUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private String caminhoFoto;
    private ImageView fotoUsuario;
    //FIM DAS VARIÁVEIS.

    //INICIO CONSTRUTOR.
    public Usuario(
            String nomeUsuario,
            String telefoneUsuario,
            String emailUsuario,
            String loginUsuario,
            String senhaUsuario,
            String caminhoFoto,
            ImageView fotoUsuario
    ) {
        this.nomeUsuario = nomeUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.emailUsuario = emailUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.caminhoFoto = caminhoFoto;
        this.fotoUsuario = fotoUsuario;

    }//FIM DO CONSTRUTOR.

    //INICIO CONSTRUTOR.
    public Usuario(
            String nomeUsuario,
            String telefoneUsuario,
            String emailUsuario,
            String loginUsuario,
            String senhaUsuario,
            String caminhoFoto
    ) {
        this.nomeUsuario = nomeUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.emailUsuario = emailUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.caminhoFoto = caminhoFoto;

    }//FIM DO CONSTRUTOR.

    public Usuario(String caminhoFoto, ImageView fotoUsuario) {
        this.caminhoFoto = caminhoFoto;
        this.fotoUsuario = fotoUsuario;
    }

    public Usuario(
            String nomeUsuario,
            String telefoneUsuario,
            String emailUsuario,
            String loginUsuario,
            String senhaUsuario
    ) {
        this.nomeUsuario = nomeUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.emailUsuario = emailUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    //CONSTRUTOR VAZIO 
    public Usuario() {

    }//FIM DO CONSTRUTOR VAZIO.

    public ImageView getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(ImageView fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    //MÉTODOS GETTER E SETTER.
    //NOME
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    //TELEFONE
    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    //EMAIL
    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    //LOGIN
    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    //SENHA
    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    //FIM DOS MÉTODOS GETTER E SETTER.
    
    //FORMATAR CAMPO TELEFONE.
    public void formatarTelefone(TextField telefone) {
        MaskFormatter formatter = new MaskFormatter(telefone);
        formatter.setMask(MaskFormatter.TEL_9DIG);
    }//FIM DO MÉTODO FORMATAR TELEFONE.

    public void limitarQantidadeCaractere(TextField textField, int limite) {
        Utilitario.limitarQuantidadeCaracteres(textField, limite);
    }

    //MÉTODO FECHAR USUARIO.
    public void fecharUsuario() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        Menu menu = new Menu();
        try {
            menu.start(new Stage());
            fecharUsuario();
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
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
        Parent root = FXMLLoader.load(getClass().getResource("/telas/FXMLUsuario.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/consultarVenda.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Cadastrar Usuario");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    public void limparFormulario(
            ImageView fotoUsuario,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeUsuario,
            TextField telefoneUsuario,
            TextField emailUsusario,
            TextField loginUsuario,
            TextField senhaUsuario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Usuario> tabelaUsuario,
            Button imprimir,
            Button voltarMenu
    ) {
        nomeUsuario.setText("");
        telefoneUsuario.setText("");
        emailUsusario.setText("");
        loginUsuario.setText("");
        senhaUsuario.setText("");
        fotoUsuario.setImage(new Image("/imagens/semFoto.jpg"));

    }

    public void liberarCamposFormulario(
            ImageView fotoUsuario,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeUsuario,
            TextField telefoneUsuario,
            TextField emailUsusario,
            TextField loginUsuario,
            TextField senhaUsuario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Usuario> tabelaUsuario,
            Button imprimir,
            Button voltarMenu
    ) {
        nomeUsuario.setEditable(true);
        telefoneUsuario.setEditable(true);
        emailUsusario.setEditable(true);
        loginUsuario.setEditable(true);
        senhaUsuario.setEditable(true);
        nomeUsuario.setDisable(false);
        telefoneUsuario.setDisable(false);
        emailUsusario.setDisable(false);
        loginUsuario.setDisable(false);
        senhaUsuario.setDisable(false);
        atualizar.setDisable(false);
        excluir.setDisable(false);
        BuscarImagem.setDisable(false);

        Platform.runLater(nomeUsuario::requestFocus);
    }

    public void bloquearCamposFormulario(
            ImageView fotoUsuario,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeUsuario,
            TextField telefoneUsuario,
            TextField emailUsusario,
            TextField loginUsuario,
            TextField senhaUsuario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Usuario> tabelaUsuario,
            Button imprimir,
            Button voltarMenu
    ) {
        nomeUsuario.setDisable(true);
        telefoneUsuario.setDisable(true);
        emailUsusario.setDisable(true);
        loginUsuario.setDisable(true);
        senhaUsuario.setDisable(true);
        salvar.setDisable(true);
        atualizar.setDisable(true);
        excluir.setDisable(true);
        BuscarImagem.setDisable(true);
        imprimir.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn nome,
            TableColumn telefone,
            TableColumn email,
            TableColumn login,
            TableColumn senha,
            TableView tabelaUsuario
    ) {
        nome.setCellValueFactory(new PropertyValueFactory("nomeUsuario"));
        telefone.setCellValueFactory(new PropertyValueFactory("telefoneUsuario"));
        email.setCellValueFactory(new PropertyValueFactory("emailUsuario"));
        login.setCellValueFactory(new PropertyValueFactory("loginUsuario"));
        senha.setCellValueFactory(new PropertyValueFactory("senhaUsuario"));
        tabelaUsuario.setItems(atualizaTabela());
    }

    public ObservableList<Usuario> atualizaTabela() {
        UsuarioDAO dao = new UsuarioDAO();
        return FXCollections.observableArrayList(dao.listaUsuario());
    }

    public void pegarDadoTabela(
            ImageView fotoUsuario,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeUsuario,
            TextField telefoneUsuario,
            TextField emailUsusario,
            TextField loginUsuario,
            TextField senhaUsuario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Usuario> tabelaUsuario,
            Button imprimir,
            Button voltarMenu
    ) {
        nomeUsuario.setText(tabelaUsuario.getSelectionModel().getSelectedItem().getNomeUsuario());
        telefoneUsuario.setText(tabelaUsuario.getSelectionModel().getSelectedItem().getTelefoneUsuario());
        emailUsusario.setText(tabelaUsuario.getSelectionModel().getSelectedItem().getEmailUsuario());
        loginUsuario.setText(tabelaUsuario.getSelectionModel().getSelectedItem().getLoginUsuario());
        senhaUsuario.setText(tabelaUsuario.getSelectionModel().getSelectedItem().getSenhaUsuario());

        String nome = tabelaUsuario.getSelectionModel().getSelectedItem().getNomeUsuario();
        String email = tabelaUsuario.getSelectionModel().getSelectedItem().getEmailUsuario();
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.buscarFoto(nome, email);
        fotoUsuario.getClass().getResource(dao.getCaminhoFoto());
        fotoUsuario.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));
        
        caminhoFoto = dao.getCaminhoFoto();
        System.out.println("" + dao.getCaminhoFoto());
    }
    //FIM DOS MÉTODO PARA MANIPULAÇÃO DA TABELA.

    public void cadastrarUsuario(
            String caminhoFoto,
            ImageView fotoUsuario,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeUsuario,
            TextField telefoneUsuario,
            TextField emailUsusario,
            TextField loginUsuario,
            TextField senhaUsuario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Usuario> tabelaUsuario,
            Button imprimir,
            Button voltarMenu,
            Pane formularioPane
    ) {
       

        String nome = nomeUsuario.getText();
        String telefone = telefoneUsuario.getText();
        String email = emailUsusario.getText();
        String login = loginUsuario.getText();
        String senha = senhaUsuario.getText();
//        setCaminhoFoto(caminhoFoto);

        //confere se todos os campos estão preenchidos
        if (nomeUsuario.getText().equals("")
                || telefoneUsuario.getText().equals("")
                || emailUsusario.getText().equals("")
                || loginUsuario.getText().equals("")
                || senhaUsuario.getText().equals("")) {

            util.alertConfiraFormulario();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    nomeUsuario.requestFocus();
                }
            });

        } else {

            //confere se o campo telefone contem todos os números.
            if (telefoneUsuario.getText().length() < 15) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        telefoneUsuario.requestFocus();
                        telefoneUsuario.positionCaret(telefoneUsuario.getText().length());
                    }
                });

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
                alert.setContentText("ATENÇÃO!!\n Confira o número do telefone!!");
                alert.show();//Fim do if.
            } else {
                //Confere se o email contém o @.
//                if (!emailUsusario.getText().contains("@") || !emailUsusario.getText().contains(".com")) {
                Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
                Matcher m = p.matcher(emailUsusario.getText());
                if (!(m.find() && m.group().equals(emailUsusario.getText()))) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            emailUsusario.requestFocus();
                        }
                    });
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
                    alert.setContentText("ATENÇÃO!!\nConfira o email!!");
                    alert.show();//Fim do if.
                } else {
                    //confere se a senha possui 6 caracteres
                    if (senhaUsuario.getText().length() != 6) {

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                senhaUsuario.requestFocus();
                                senhaUsuario.positionCaret(senhaUsuario.getText().length());
                            }
                        });
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
                        alert.setContentText("ATENÇÃO!!\n"
                                + "A senha deve conter 6 caracteres!!");
                        alert.show();//Fim do if.

                    } else {
                        //Confere se está tudo ok com o banco de dados
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        Usuario u = new Usuario(nome, telefone, email, login, senha, getCaminhoFoto());
                        if (usuarioDAO.Inserir(u)) {
//                            Platform.runLater(NovoCadastro::requestFocus);//fim do run.
                            limparFormulario(
                                    fotoUsuario,
                                    BuscarImagem,
                                    NovoCadastro,
                                    nomeUsuario,
                                    telefoneUsuario,
                                    emailUsusario,
                                    loginUsuario,
                                    senhaUsuario,
                                    salvar,
                                    atualizar,
                                    excluir,
                                    listarTabela,
                                    tabelaUsuario,
                                    imprimir,
                                    voltarMenu
                            );

                            bloquearCamposFormulario(
                                    fotoUsuario,
                                    BuscarImagem,
                                    NovoCadastro,
                                    nomeUsuario,
                                    telefoneUsuario,
                                    emailUsusario,
                                    loginUsuario,
                                    senhaUsuario,
                                    salvar,
                                    atualizar,
                                    excluir,
                                    listarTabela,
                                    tabelaUsuario,
                                    imprimir,
                                    voltarMenu
                            );

                            //exibe mensagem de cadastrado com sucesso.
                            util.alertCadastrado("Usuário " + nome);//Fim do if.

                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Platform.runLater(NovoCadastro::requestFocus);
                                }
                            });
//                           if (event.getCode() == KeyCode.TAB) {
                            salvar.setDisable(true);

                        } else {
                            util.alertNaoCadastrado("Usuário " + nome);
                        }
                    }
                }
            }
        }
    }

    public void atualizarUsuario(
            String caminhoFoto,
            ImageView fotoUsuario,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeUsuario,
            TextField telefoneUsuario,
            TextField emailUsusario,
            TextField loginUsuario,
            TextField senhaUsuario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Usuario> tabelaUsuario,
            Button imprimir,
            Button voltarMenu
    ) {
        String nome = nomeUsuario.getText();
        String telefone = telefoneUsuario.getText();
        String email = emailUsusario.getText();
        String login = loginUsuario.getText();
        String senha = senhaUsuario.getText();
//        setCaminhoFoto(caminhoFoto);
        //confere se todos os campos estão preenchidos
        if (nomeUsuario.getText().equals("")
                || telefoneUsuario.getText().equals("")
                || emailUsusario.getText().equals("")
                || loginUsuario.getText().equals("")
                || senhaUsuario.getText().equals("")) {
            util.alertConfiraFormulario();
        } else {
            //confere se o campo telefone contem todos os números.
            if (telefoneUsuario.getText().length() < 15) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        telefoneUsuario.requestFocus();
                        telefoneUsuario.positionCaret(telefoneUsuario.getText().length());
                    }
                });
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
                alert.setContentText("ATENÇÃO!!\n Confira o número do telefone!!");
                alert.show();//Fim do if.
            } else {
                //Confere se o email contém o @.
//                if (!emailUsusario.getText().contains("@") || !emailUsusario.getText().contains(".com")) {
                Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
                Matcher m = p.matcher(emailUsusario.getText());
                if (!(m.find() && m.group().equals(emailUsusario.getText()))) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            emailUsusario.requestFocus();
                        }
                    });
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
                    alert.setContentText("ATENÇÃO!!\nConfira o email!!");
                    alert.show();//Fim do if.
                } else {
                    //confere se a senha possui 6 caracteres
                    if (senhaUsuario.getText().length() != 6) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                senhaUsuario.requestFocus();
                                senhaUsuario.positionCaret(senhaUsuario.getText().length());
                            }
                        });
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("CONTROLE DE FINANÇAS\nCADASTRO DE USUÁRIO");
                        alert.setContentText("ATENÇÃO!!\n"
                                + "A senha deve conter 6 caracteres!!");
                        alert.show();//Fim do if.
                    } else {
                        //Confere se está tudo ok com o banco de dados
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        Usuario u = new Usuario(nome, telefone, email, login, senha, getCaminhoFoto());
                        if (usuarioDAO.atualizar(u)) {
                            limparFormulario(
                                    fotoUsuario,
                                    BuscarImagem,
                                    NovoCadastro,
                                    nomeUsuario,
                                    telefoneUsuario,
                                    emailUsusario,
                                    loginUsuario,
                                    senhaUsuario,
                                    salvar,
                                    atualizar,
                                    excluir,
                                    listarTabela,
                                    tabelaUsuario,
                                    imprimir,
                                    voltarMenu
                            );
                            bloquearCamposFormulario(
                                    fotoUsuario,
                                    BuscarImagem,
                                    NovoCadastro,
                                    nomeUsuario,
                                    telefoneUsuario,
                                    emailUsusario,
                                    loginUsuario,
                                    senhaUsuario,
                                    salvar,
                                    atualizar,
                                    excluir,
                                    listarTabela,
                                    tabelaUsuario,
                                    imprimir,
                                    voltarMenu
                            );

                            tabelaUsuario.getItems().clear();
                            //exibe mensagem de cadastrado com sucesso.
                            util.alertAtualizacao("Usuário " + nome);//Fim do if.
//                            Platform.runLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    NovoCadastro.requestFocus();
//                                }
//                            });
                        } else {
                            util.alertNaoAtualizado("Usuário " + nome);
                        }
                    }
                }
            }
        }
    }

    public void excluirUsuario(
            ImageView fotoUsuario,
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeUsuario,
            TextField telefoneUsuario,
            TextField emailUsusario,
            TextField loginUsuario,
            TextField senhaUsuario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Usuario> tabelaUsuario,
            Button imprimir,
            Button voltarMenu
    ) {
        String nome = nomeUsuario.getText();
        String telefone = telefoneUsuario.getText();
        String email = emailUsusario.getText();
        String login = loginUsuario.getText();
        String senha = senhaUsuario.getText();
        //Confere se está tudo ok com o banco de dados.
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario u = new Usuario(nome, telefone, email, login, senha);
        if (usuarioDAO.apagar(u)) {
       
            File img = new File("../src/"+getCaminhoFoto());
            img.delete();
            
            limparFormulario(
                    fotoUsuario,
                    BuscarImagem,
                    NovoCadastro,
                    nomeUsuario,
                    telefoneUsuario,
                    emailUsusario,
                    loginUsuario,
                    senhaUsuario,
                    salvar,
                    atualizar,
                    excluir,
                    listarTabela,
                    tabelaUsuario,
                    imprimir,
                    voltarMenu
            );
            
            bloquearCamposFormulario(
                    fotoUsuario,
                    BuscarImagem,
                    NovoCadastro,
                    nomeUsuario,
                    telefoneUsuario,
                    emailUsusario,
                    loginUsuario,
                    senhaUsuario,
                    salvar,
                    atualizar,
                    excluir,
                    listarTabela,
                    tabelaUsuario,
                    imprimir,
                    voltarMenu
            );
            
            tabelaUsuario.getItems().clear();
            //exibe mensagem de cadastrado com sucesso.
            util.alertExcluido("Usuário " + nome);//Fim do if.

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(NovoCadastro::requestFocus);//fim do run.
        } else {
            util.alertNaoExcluído("Usuário " + nome);
        }
    }
    public void gerarRelatorio() {
        Utilitario util = new Utilitario(conn);
        String relatorio = "../src/relatorio/Usuario.jasper";
        util.relatorio(relatorio);
    }

    public void selecionarFoto(
            ImageView fotoUsuario
    ) {
        FileChooser buscarImage = new FileChooser();
        buscarImage.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg"));

        File imagem = buscarImage.showOpenDialog(new Stage());
        if (imagem != null) {
            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };
            setCaminhoFoto("fotosUsuarios/" + imagem.getName());

            try {
                Files.copy(Paths.get(imagem.getAbsolutePath()), Paths.get("../src/fotosUsuarios/" + imagem.getName()), options);
            } catch (IOException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            fotoUsuario.setImage(new Image("file:///" + imagem.getAbsolutePath()));
            
            System.out.println("" + getCaminhoFoto());
        }
    }

}
