//Classe de implemento da Interface EmpresaInterface.
package classes;

import bancoConexaoDAO.Conexao;
import bancoConexaoDAO.EmpresaRelatorioDAO;
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
public class EmpresaRelatorio extends Application {

    Connection conn;

    Utilitario util = new Utilitario(conn);

    //VARIÁVEIS DA CLASSE.
    private String nomeEmpresa;
    private String produtoEmpresa;
    private String telefoneEmpresa;
    private String siteEmpresa;
    private String emailEmpresa;
    private String loginEmpresa;
    private String senhaEmpresa;
    private ComboBox<EmpresaRelatorio> filtroPesquisaCB;
    private TextField campoPesquisaTF;
    private String campoPesquisa;
    private String filtroPesquisa;
    //FIM DAS VARIÁVEIS.

    public EmpresaRelatorio(
            int posicao,
            String filtroPesquisa
    ) {
        this.filtroPesquisa = filtroPesquisa;
    }

    public EmpresaRelatorio(String filtroPesquisa, String campoPesquisa) {
        this.filtroPesquisa = filtroPesquisa;
        this.campoPesquisa = campoPesquisa;
    }

    //CONSTRUTOR VAZIO 
    public EmpresaRelatorio() {

    }//FIM DO CONSTRUTOR VAZIO.

    //MÉTODOS GETTER E SETTER.
    //NOME

    public String getProdutoEmpresa() {
        return produtoEmpresa;
    }

    public void setProdutoEmpresa(String produtoEmpresa) {
        this.produtoEmpresa = produtoEmpresa;
    }

    public String getSiteEmpresa() {
        return siteEmpresa;
    }

    public void setSiteEmpresa(String siteEmpresa) {
        this.siteEmpresa = siteEmpresa;
    }
    
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

    public ComboBox<EmpresaRelatorio> getFiltroPesquisaCB() {
        return filtroPesquisaCB;
    }

    public void setFiltroPesquisaCB(ComboBox<EmpresaRelatorio> filtroPesquisaCB) {
        this.filtroPesquisaCB = filtroPesquisaCB;
    }

    public TextField getCampoPesquisaTF() {
        return campoPesquisaTF;
    }

    public void setCampoPesquisaTF(TextField campoPesquisaTF) {
        this.campoPesquisaTF = campoPesquisaTF;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    //TELEFONE
    public String getTelefoneEmpresa() {
        return telefoneEmpresa;
    }

    public void setTelefoneEmpresa(String telefoneEmpresa) {
        this.telefoneEmpresa = telefoneEmpresa;
    }

    //EMAIL
    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    //LOGIN
    public String getLoginEmpresa() {
        return loginEmpresa;
    }

    public void setLoginEmpresa(String loginEmpresa) {
        this.loginEmpresa = loginEmpresa;
    }

    //SENHA
    public String getSenhaEmpresa() {
        return senhaEmpresa;
    }

    public void setSenhaEmpresa(String senhaEmpresa) {
        this.senhaEmpresa = senhaEmpresa;
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
            Logger.getLogger(EmpresaRelatorio.class.getName()).log(Level.SEVERE, null, ex);
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
        Parent root = FXMLLoader.load(getClass().getResource("/telas/FXMLEmpresaRelatorio.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/consultarVenda.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Relatório de Empresas");
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

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

    public ObservableList<EmpresaRelatorio> atualizaTabela() {
        EmpresaRelatorioDAO dao = new EmpresaRelatorioDAO();
        return FXCollections.observableArrayList(dao.listaEmpresaRelatorio(
                filtroPesquisa,
                campoPesquisa
        ));
    }

    public void pegarDadoTabela(
            Button BuscarImagem,
            Button NovoCadastro,
            TextField nomeEmpresa,
            TextField produtoEmpresa,
            TextField telefoneEmpresa,
            TextField siteEmpresa,
            TextField emailUsusario,
            TextField loginEmpresa,
            TextField senhaEmpresa,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<EmpresaRelatorio> tabelaEmpresa,
            Button imprimir,
            Button voltarMenu
    ) {
        nomeEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getNomeEmpresa());
        produtoEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getProdutoEmpresa());
        telefoneEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getTelefoneEmpresa());
        siteEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getSiteEmpresa());
        emailUsusario.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getEmailEmpresa());
        loginEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getLoginEmpresa());
        senhaEmpresa.setText(tabelaEmpresa.getSelectionModel().getSelectedItem().getSenhaEmpresa());
    }
    //FIM DOS MÉTODO PARA MANIPULAÇÃO DA TABELA.

    public void preencherComboBoxFiltroPesquisa(ComboBox<EmpresaRelatorio> filtroPesquisaCB) {

        List<EmpresaRelatorio> filtroPesquisa = new ArrayList<>();

        ObservableList<EmpresaRelatorio> observableListEmpresaRelatorio;

        EmpresaRelatorio filtroPesquisa1 = new EmpresaRelatorio(1, "Selecione um filtro");
        EmpresaRelatorio filtroPesquisa2 = new EmpresaRelatorio(2, "Nome da Empresa");
        EmpresaRelatorio filtroPesquisa3 = new EmpresaRelatorio(3, "Telefone");
        EmpresaRelatorio filtroPesquisa4 = new EmpresaRelatorio(4, "E-mail");
        EmpresaRelatorio filtroPesquisa5 = new EmpresaRelatorio(5, "Todos");

        filtroPesquisa.add(filtroPesquisa1);
        filtroPesquisa.add(filtroPesquisa2);
        filtroPesquisa.add(filtroPesquisa3);
        filtroPesquisa.add(filtroPesquisa4);
        filtroPesquisa.add(filtroPesquisa5);

        observableListEmpresaRelatorio = FXCollections.observableArrayList(filtroPesquisa);

        filtroPesquisaCB.setItems(observableListEmpresaRelatorio);

    }

    public void Relatorios(
            String relatorio,
            String nomeEmpresa,
            String telefoneEmpresa,
            String emailEmpresa
    ) {
        Conexao conn = new Conexao();

        HashMap<String, Object> filtro = new HashMap<>();
        filtro.put("nomeEmpresa", nomeEmpresa);
        filtro.put("telefoneEmpresa", telefoneEmpresa);
        filtro.put("emailEmpresa", emailEmpresa);
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(relatorio, filtro, conn.abrirConexao());
        } catch (JRException ex) {
            System.out.println("ERRO\n" + ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(true);
        view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
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
                relatorio = "../src/relatorio/EmpresaRelatorioListarTodos.jasper";
                break;
            case "Nome da Empresa":
                relatorio = "../src/relatorio/EmpresaRelatorioListarNomeEmpresa.jasper";
                break;
            case "Telefone":
                relatorio = "../src/relatorio/EmpresaRelatorioListarTelefone.jasper";
                break;
            case "E-mail":
                relatorio = "../src/relatorio/EmpresaRelatorioListarEmail.jasper";
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
