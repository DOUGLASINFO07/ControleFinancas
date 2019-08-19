//Classe de implemento da Interface UsuarioInterface.
package classes;

import bancoConexaoDAO.SalarioDAO;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import util.Utilitario;

/**
 *
 * @author douglas borges egidio
 * @since 25/09/2018
 */
public class Salario extends Application {

    Connection conn;

    //VARIÁVEIS DA CLASSE.
    private String nomeEmpresa;
    private String salario;
    private String dataRecebimento;
    private String tipoPagamento;
    private String caminhoFoto;
    private ImageView fotoEmpresa;
    //FIM DAS VARIÁVEIS.

    public Salario(
            String nomeEmpresa,
            String salario,
            String dataRecebimento,
            String tipoPagamento,
            String caminhoFoto,
            ImageView fotoEmpresa
    ) {
        this.nomeEmpresa = nomeEmpresa;
        this.salario = salario;
        this.dataRecebimento = dataRecebimento;
        this.tipoPagamento = tipoPagamento;
        this.fotoEmpresa = fotoEmpresa;
    }

    public Salario(
            String nomeEmpresa,
            String salario,
            String dataRecebimento,
            String tipoPagamento,
            String caminhoFoto
    ) {
        this.nomeEmpresa = nomeEmpresa;
        this.salario = salario;
        this.dataRecebimento = dataRecebimento;
        this.tipoPagamento = tipoPagamento;
        this.fotoEmpresa = fotoEmpresa;
        this.caminhoFoto = caminhoFoto;
    }

    public Salario(
            String caminhoFoto,
            ImageView fotoEmpresa
    ) {
        this.caminhoFoto = caminhoFoto;
        this.fotoEmpresa = fotoEmpresa;
    }

    public Salario(
            int posicao,
            String tipoPagamento
    ) {
        this.tipoPagamento = tipoPagamento;
    }

    public Salario(
            String tipoPagamento
    ) {
        this.tipoPagamento = tipoPagamento;
    }

    public Salario(
            String nomeEmpresa,
            String salario,
            String dataRecebimento,
            String tipoPagamento
    ) {
        this.nomeEmpresa = nomeEmpresa;
        this.salario = salario;
        this.dataRecebimento = dataRecebimento;
        this.tipoPagamento = tipoPagamento;
        this.fotoEmpresa = fotoEmpresa;
    }

    //CONSTRUTOR VAZIO 
    public Salario() {

    }//FIM DO CONSTRUTOR VAZIO.

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
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

    @Override
    public String toString() {
        return getTipoPagamento();
    }

    //MÉTODO FECHAR USUARIO.
    public void fecharSalario() {
        getStage().close();
    }//FIM DO MÉTODO FECHAR USUARIO.

    //MÉTODO QUE ABRE A TELA MENU.
    public void abrirMenu() {
        Menu menu = new Menu();
        try {
            menu.start(new Stage());
            fecharSalario();
        } catch (Exception ex) {
            Logger.getLogger(Salario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //CONJUNTO DE MÉTODOS PARA ABRIR A TELA CADASTRO DE USUÁRIO.
    private static Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        Salario.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/FXMLSalario.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/consultarVenda.png")));
        Scene scene = new Scene(root);
        stage.setTitle("Cadastrar Salario");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    //FIM DO CONJUNTO DE MÉTODOS PARA ABRIR A TELA DE CADASTRO DE USUÁRIO.

    public void limparFormulario(
            ImageView fotoEmpresa,
            Button novoSalario,
            ComboBox empresaSalario,
            TextField valorSalario,
            DatePicker dataRecebimentoSalario,
            ComboBox tipoPagamentoSalario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Salario> tabelaSalario,
            Button imprimir,
            Button voltarMenu
    ) {
        empresaSalario.setValue("Selecione");
        valorSalario.setText("");
        dataRecebimentoSalario.setValue(null);
        tipoPagamentoSalario.setValue("Selecione");
        fotoEmpresa.setImage(new Image("/imagens/semFoto.jpg"));
    }

    public void liberarCamposFormulario(
            ImageView fotoEmpresa,
            Button novoSalario,
            ComboBox empresaSalario,
            TextField valorSalario,
            DatePicker dataRecebimentoSalario,
            ComboBox tipoPagamentoSalario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Salario> tabelaSalario,
            Button imprimir,
            Button voltarMenu
    ) {
        empresaSalario.setDisable(false);
        valorSalario.setEditable(true);
        dataRecebimentoSalario.setEditable(true);
        tipoPagamentoSalario.setDisable(false);
        valorSalario.setDisable(false);
        dataRecebimentoSalario.setDisable(false);
        tipoPagamentoSalario.setDisable(false);
        atualizar.setDisable(false);
        excluir.setDisable(false);
       

//        Platform.runLater(empresaSalario::requestFocus);
    }

    public void bloquearCamposFormulario(
            ImageView fotoEmpresa,
            Button novoSalario,
            ComboBox empresaSalario,
            TextField valorSalario,
            DatePicker dataRecebimentoSalario,
            ComboBox tipoPagamentoSalario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Salario> tabelaSalario,
            Button imprimir,
            Button voltarMenu
    ) {
        empresaSalario.setDisable(true);
        valorSalario.setDisable(true);
        dataRecebimentoSalario.setDisable(true);
        tipoPagamentoSalario.setDisable(true);
        salvar.setDisable(true);
        atualizar.setDisable(true);
        excluir.setDisable(true);
        imprimir.setDisable(true);
    }

    //MÉTODOS PARA MANIPULAÇÃO DA TABELA.
    public void iniciarTabela(
            TableColumn nome,
            TableColumn salario,
            TableColumn dataRecebimento,
            TableColumn tipoPagamento,
            TableView<Salario> tabelaSalario
    ) {
        Utilitario util = new Utilitario();
        nome.setCellValueFactory(new PropertyValueFactory("nomeEmpresa"));
        salario.setCellValueFactory(new PropertyValueFactory("salario"));
        dataRecebimento.setCellValueFactory(new PropertyValueFactory("dataRecebimento"));
        tipoPagamento.setCellValueFactory(new PropertyValueFactory("tipoPagamento"));
        tabelaSalario.setItems(atualizaTabela());
    }

    public ObservableList<Salario> atualizaTabela() {
        SalarioDAO dao = new SalarioDAO();
        return FXCollections.observableArrayList(dao.listaSalario());
    }

    public void pegarDadoTabela(
            ImageView fotoEmpresa,
            Button novoSalario,
            ComboBox empresaSalario,
            TextField valorSalario,
            DatePicker dataRecebimentoSalario,
            ComboBox tipoPagamentoSalario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Salario> tabelaSalario,
            Button imprimir,
            Button voltarMenu
    ) {
        empresaSalario.setValue(tabelaSalario.getSelectionModel().getSelectedItem().getNomeEmpresa());
        valorSalario.setText("" + tabelaSalario.getSelectionModel().getSelectedItem().getSalario());

        String data = tabelaSalario.getSelectionModel().getSelectedItem().getDataRecebimento();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataRecebimentoSalario.setValue(LocalDate.parse(data, formatter));

        tipoPagamentoSalario.setValue(tabelaSalario.getSelectionModel().getSelectedItem().getTipoPagamento());

        String nome = tabelaSalario.getSelectionModel().getSelectedItem().getNomeEmpresa();

        setCaminhoFoto("");
        SalarioDAO dao = new SalarioDAO();

        dao.buscarFoto(nome);
        fotoEmpresa.getClass().getResource(dao.getCaminhoFoto());
        fotoEmpresa.setImage(new Image("file:../src/" + dao.getCaminhoFoto()));

        caminhoFoto = dao.getCaminhoFoto();

        System.out.println("" + dao.getCaminhoFoto());

    }
    //FIM DOS MÉTODO PARA MANIPULAÇÃO DA TABELA.

    public void cadastrarSalario(
            String caminhoFoto,
            ImageView fotoEmpresa,
            Button novoSalario,
            ComboBox empresaSalario,
            TextField valorSalario,
            DatePicker dataRecebimentoSalario,
            ComboBox tipoPagamentoSalario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Salario> tabelaSalario,
            Button imprimir,
            Button voltarMenu
    ) {
        Utilitario util = new Utilitario();

        String nome = empresaSalario.getSelectionModel().getSelectedItem().toString();

        String salario1;
        if ("".equals(valorSalario.getText())) {
            salario1 = "0";
        } else {
            salario1 = util.converterCifraoBrasiloAmericano(valorSalario.getText());
        }

        LocalDate dataRecebimento1 = dataRecebimentoSalario.getValue();
        String data = "" + dataRecebimento1;

        String tipoPagamento1 = tipoPagamentoSalario.getSelectionModel().getSelectedItem().toString();

        //confere se todos os campos estão preenchidos
        if (empresaSalario.getValue().equals("Selecione")
                || salario1.equals("0")
                || dataRecebimentoSalario.getValue() == null
                || tipoPagamentoSalario.getValue().equals("Selecione")) {

            util.alertConfiraFormulario();

            Platform.runLater(empresaSalario::requestFocus);

        } else {
            //Confere se está tudo ok com o banco de dados
            SalarioDAO salarioDAO = new SalarioDAO();
            Salario s = new Salario(nome, salario1, data, tipoPagamento1);
            if (salarioDAO.Inserir(s)) {
//                            Platform.runLater(NovoCadastro::requestFocus);//fim do run.
                limparFormulario(
                        fotoEmpresa,
                        novoSalario,
                        empresaSalario,
                        valorSalario,
                        dataRecebimentoSalario,
                        tipoPagamentoSalario,
                        salvar,
                        atualizar,
                        excluir,
                        listarTabela,
                        tabelaSalario,
                        imprimir,
                        voltarMenu
                );

                bloquearCamposFormulario(
                        fotoEmpresa,
                        novoSalario,
                        empresaSalario,
                        valorSalario,
                        dataRecebimentoSalario,
                        tipoPagamentoSalario,
                        salvar,
                        atualizar,
                        excluir,
                        listarTabela,
                        tabelaSalario,
                        imprimir,
                        voltarMenu
                );

                //exibe mensagem de cadastrado com sucesso.
                util.alertCadastrado("Salario " + nome);//Fim do if.

                Platform.runLater(() -> {
                    Platform.runLater(novoSalario::requestFocus);
                });
//                           if (event.getCode() == KeyCode.TAB) {
                salvar.setDisable(true);

            } else {
                util.alertNaoCadastrado("Salario " + nome);
            }
        }
    }

    public void atualizarSalario(
            ImageView fotoEmpresa,
            Button novoSalario,
            ComboBox empresaSalario,
            TextField valorSalario,
            DatePicker dataRecebimentoSalario,
            ComboBox tipoPagamentoSalario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Salario> tabelaSalario,
            Button imprimir,
            Button voltarMenu
    ) {
        Utilitario util = new Utilitario();

        String nome = empresaSalario.getSelectionModel().getSelectedItem().toString();

        String salario1;
        if ("".equals(valorSalario.getText())) {
            salario1 = "0";
        } else {
            salario1 = util.converterCifraoBrasiloAmericano(valorSalario.getText());
        }

        String dataRecebimento1 = dataRecebimentoSalario.getValue().toString();
        String tipoPagamento1 = tipoPagamentoSalario.getSelectionModel().getSelectedItem().toString();

        //confere se todos os campos estão preenchidos
        if (empresaSalario.getValue().equals("Selecione")
                || salario1.equals("0")
                || dataRecebimentoSalario.getValue() == null
                || tipoPagamentoSalario.getValue().equals("Selecione")) {

            util.alertConfiraFormulario();

            Platform.runLater(empresaSalario::requestFocus);
            
        } else {
            SalarioDAO salarioDAO = new SalarioDAO();
            Salario s = new Salario(nome, salario1, dataRecebimento1, tipoPagamento1);
            if (salarioDAO.atualizar(s)) {
                limparFormulario(
                        fotoEmpresa,
                        novoSalario,
                        empresaSalario,
                        valorSalario,
                        dataRecebimentoSalario,
                        tipoPagamentoSalario,
                        salvar,
                        atualizar,
                        excluir,
                        listarTabela,
                        tabelaSalario,
                        imprimir,
                        voltarMenu
                );
                bloquearCamposFormulario(
                        fotoEmpresa,
                        novoSalario,
                        empresaSalario,
                        valorSalario,
                        dataRecebimentoSalario,
                        tipoPagamentoSalario,
                        salvar,
                        atualizar,
                        excluir,
                        listarTabela,
                        tabelaSalario,
                        imprimir,
                        voltarMenu
                );
                tabelaSalario.getItems().clear();
                util.alertAtualizacao("Salario " + nome);//Fim do if.
            } else {
                util.alertNaoAtualizado("Salario " + nome);
            }
        }
    }

    public void excluirSalario(
            ImageView fotoEmpresa,
            Button novoSalario,
            ComboBox empresaSalario,
            TextField valorSalario,
            DatePicker dataRecebimentoSalario,
            ComboBox tipoPagamentoSalario,
            Button salvar,
            Button atualizar,
            Button excluir,
            Button listarTabela,
            TableView<Salario> tabelaSalario,
            Button imprimir,
            Button voltarMenu
    ) {
        Utilitario util = new Utilitario();

        String nome = (String) empresaSalario.getValue();
        String salario1 = valorSalario.getText();
        String dataRecebimento1= dataRecebimentoSalario.getValue().toString();
        String tipoPagamento1 = (String) tipoPagamentoSalario.getValue();

        //Confere se está tudo ok com o banco de dados
        SalarioDAO salarioDAO = new SalarioDAO();
        Salario e = new Salario(nome, salario1, dataRecebimento1, tipoPagamento1);
        if (salarioDAO.apagar(e)) {

            limparFormulario(
                    fotoEmpresa,
                    novoSalario,
                    empresaSalario,
                    valorSalario,
                    dataRecebimentoSalario,
                    tipoPagamentoSalario,
                    salvar,
                    atualizar,
                    excluir,
                    listarTabela,
                    tabelaSalario,
                    imprimir,
                    voltarMenu
            );

            bloquearCamposFormulario(
                    fotoEmpresa,
                    novoSalario,
                    empresaSalario,
                    valorSalario,
                    dataRecebimentoSalario,
                    tipoPagamentoSalario,
                    salvar,
                    atualizar,
                    excluir,
                    listarTabela,
                    tabelaSalario,
                    imprimir,
                    voltarMenu
            );
            tabelaSalario.getItems().clear();
            //exibe mensagem de cadastrado com sucesso.
            util.alertExcluido("Salario " + nome);//Fim do if.

            //Inicio run que encapsula o requestFocus().
            Platform.runLater(novoSalario::requestFocus);//fim do run.

        } else {
            util.alertNaoExcluído("Salario " + nome);
        }
    }

    public void gerarRelatorio() {
        Utilitario util = new Utilitario(conn);
        String relatorio = "../src/relatorio/Salario.jasper";
        util.relatorio(relatorio);
    }

    public void preencherComboBoxTipoPagamento(ComboBox<Salario> tipoPagamento) {

        List<Salario> tipoPagamentoCB = new ArrayList<>();

        ObservableList<Salario> observableListSalario;

        Salario tipoPagamento1 = new Salario(1, "Mensal");
        Salario tipoPagamento2 = new Salario(2, "Quinzenal");
        Salario tipoPagamento3 = new Salario(3, "Semestral");
        Salario tipoPagamento4 = new Salario(4, "13º Salario");
        Salario tipoPagamento5 = new Salario(5, "Free Lance");
        Salario tipoPagamento6 = new Salario(6, "Restituição IRPF");
        Salario tipoPagamento7 = new Salario(7, "Semanal");

        tipoPagamentoCB.add(tipoPagamento1);
        tipoPagamentoCB.add(tipoPagamento2);
        tipoPagamentoCB.add(tipoPagamento3);
        tipoPagamentoCB.add(tipoPagamento4);
        tipoPagamentoCB.add(tipoPagamento5);
        tipoPagamentoCB.add(tipoPagamento6);
        tipoPagamentoCB.add(tipoPagamento7);

        observableListSalario = FXCollections.observableArrayList(tipoPagamentoCB);

        tipoPagamento.setItems(observableListSalario);

    }

////    MÉTODOS PARA MANIPULAÇÃO DA TABELA.
//    public void preencherComboBoxEmpresa(
//            ComboBox<Salario> empresa
//    ) {
//        SalarioDAO dao = new SalarioDAO();
//
//        empresa.setItems(dao.listaEmpresa());
//
//    }
}
