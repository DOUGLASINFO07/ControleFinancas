//Classe de implemento da Interface UsuarioInterface.
package classes;

import bancoConexaoDAO.Conexao;
import bancoConexaoDAO.UsuarioRelatorioDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jeanderson.br.util.MaskFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.Utilitario;

/**
 *
 * @author douglas borges egidio
 * @since 25/09/2018
 */
public class UsuarioRelatorio extends Application {

    Connection conn;

    Utilitario util = new Utilitario(conn);

    //VARIÁVEIS DA CLASSE.
    private String nomeUsuario;
    private String telefoneUsuario;
    private String emailUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private ComboBox<UsuarioRelatorio> filtroPesquisaCB;
    private TextField campoPesquisaTF;
    private String campoPesquisa;
    private String filtroPesquisa;
    //FIM DAS VARIÁVEIS.

    public UsuarioRelatorio(
            int posicao,
            String filtroPesquisa
    ) {
        this.filtroPesquisa = filtroPesquisa;
    }

    public UsuarioRelatorio(String filtroPesquisa, String campoPesquisa) {
        this.filtroPesquisa = filtroPesquisa;
        this.campoPesquisa = campoPesquisa;
    }

    //CONSTRUTOR VAZIO 
    public UsuarioRelatorio() {

    }//FIM DO CONSTRUTOR VAZIO.

    //MÉTODOS GETTER E SETTER.
    //NOME
    public String getFiltroPesquisa() {
        return filtroPesquisa;
    }

    public void setFiltroPesquisa(String filtroPesquisa) {
        this.filtroPesquisa = filtroPesquisa;
    }

    public String getCampoPesquisa() {
        return campoPesquisa;
    }

    public void setCampoPesquisa(String campoPesquisa) {
        this.campoPesquisa = campoPesquisa;
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

    @Override
    public String toString() {
        return getFiltroPesquisa();
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
            Logger.getLogger(UsuarioRelatorio.class.getName()).log(Level.SEVERE, null, ex);
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
        Parent root = FXMLLoader.load(getClass().getResource("/telas/FXMLUsuarioRelatorio.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/consultarVenda.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Relatório de Usuário");
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

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

    public ObservableList<UsuarioRelatorio> atualizaTabela() {
        UsuarioRelatorioDAO dao = new UsuarioRelatorioDAO();
        return FXCollections.observableArrayList(dao.listaUsuarioRelatorio(
                filtroPesquisa,
                campoPesquisa
        ));
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
            TableView<UsuarioRelatorio> tabelaUsuario,
            Button imprimir,
            Button voltarMenu
    ) {
        nomeUsuario.setText(tabelaUsuario.getSelectionModel().getSelectedItem().getNomeUsuario());
        telefoneUsuario.setText(tabelaUsuario.getSelectionModel().getSelectedItem().getTelefoneUsuario());
        emailUsusario.setText(tabelaUsuario.getSelectionModel().getSelectedItem().getEmailUsuario());
        loginUsuario.setText(tabelaUsuario.getSelectionModel().getSelectedItem().getLoginUsuario());
        senhaUsuario.setText(tabelaUsuario.getSelectionModel().getSelectedItem().getSenhaUsuario());
    }
    //FIM DOS MÉTODO PARA MANIPULAÇÃO DA TABELA.

//    public void gerarRelatorio() {
//        Utilitario util = new Utilitario(conn);
//        String relatorio = "../src/relatorio/UsuarioRelatório.jasper";
//        util.relatorio(relatorio);
//    }
    public void preencherComboBoxFiltroPesquisa(ComboBox<UsuarioRelatorio> filtroPesquisaCB) {

        List<UsuarioRelatorio> filtroPesquisa = new ArrayList<>();

        ObservableList<UsuarioRelatorio> observableListUsuarioRelatorio;

        UsuarioRelatorio filtroPesquisa1 = new UsuarioRelatorio(1, "Selecione um filtro");
        UsuarioRelatorio filtroPesquisa2 = new UsuarioRelatorio(2, "Nome");
        UsuarioRelatorio filtroPesquisa3 = new UsuarioRelatorio(3, "Telefone");
        UsuarioRelatorio filtroPesquisa4 = new UsuarioRelatorio(4, "E-mail");
        UsuarioRelatorio filtroPesquisa5 = new UsuarioRelatorio(5, "Todos");
//        UsuarioRelatorio filtroPesquisa6 = new UsuarioRelatorio(6, "Restituição IRPF");
//        UsuarioRelatorio filtroPesquisa7 = new UsuarioRelatorio(7, "Semanal");

        filtroPesquisa.add(filtroPesquisa1);
        filtroPesquisa.add(filtroPesquisa2);
        filtroPesquisa.add(filtroPesquisa3);
        filtroPesquisa.add(filtroPesquisa4);
        filtroPesquisa.add(filtroPesquisa5);
//        filtroPesquisa.add(filtroPesquisa6);
//        filtroPesquisa.add(filtroPesquisa7);

        observableListUsuarioRelatorio = FXCollections.observableArrayList(filtroPesquisa);

        filtroPesquisaCB.setItems(observableListUsuarioRelatorio);

    }

    public void Relatorios(
            String relatorio,
            String nomeUsuario,
            String telefoneUsuario,
            String emailUsuario
    //              String empresa,
    //              String dataInicial,
    //              String dataFinal,
    //              String mensagemPesquisa
    ) {
        Conexao conn = new Conexao();

        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("nomeUsuario", nomeUsuario);
        filtro.put("telefoneUsuario", telefoneUsuario);
        filtro.put("emailUsuario", emailUsuario);
//                filtro.put("empresa", empresa);
//                filtro.put("dataInicial", dataInicial);
//                filtro.put("dataFinal", dataFinal);
//                filtro.put("mensagemPesquisa", mensagemPesquisa);
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn.abrirConexao());
        } catch (JRException ex) {
            System.out.println("ERRO\n" + ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);

//                JasperReport jasper = JasperCompileManager.compileReport(relatorio);
//                JasperPrint print = JasperFillManager.fillReport(jasper, filtro);
//                JRViewer jRViewer = new JRViewer(print);
//                jRViewer.setVisible(true);
//                
//                JasperPrint print;
//                print = JasperFillManager.fillReport(relatorio, filtro, conn);
//                JasperViewer.viewReport(print, false);
    }

    public void imprimir(
            ComboBox filtro,
            TextField nome,
            TextField telefone,
            TextField email
    ) {

        String relatorio = null;
        String filtropesquisa = filtro.getSelectionModel().getSelectedItem().toString();
        String campoNome = nome.getText();
        String campoTelefone = telefone.getText();
        String campoEmail = email.getText();

        System.out.println("" + filtropesquisa + campoNome);

        switch (filtropesquisa) {
            case "Todos":
                relatorio = "../src/relatorio/UsuarioRelatorioListarTodos.jasper";
                break;
            case "Nome":
                relatorio = "../src/relatorio/UsuarioRelatorioListarNome.jasper";
                break;
            case "Telefone":
                relatorio = "../src/relatorio/UsuarioRelatorioListarTelefone.jasper";
                break;
            case "E-mail":
                relatorio = "../src/relatorio/UsuarioRelatorioListarEmail.jasper";
                break;
            default:
                break;
        }

        Relatorios(
                relatorio,
                campoNome,
                campoTelefone,
                campoEmail
        );

    }

}
