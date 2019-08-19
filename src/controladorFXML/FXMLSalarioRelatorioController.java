package controladorFXML;

import bancoConexaoDAO.SalarioDAO;
import classes.Salario;
import classes.SalarioRelatorio;
import classes.SalarioRelatorio;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import util.Relogio;
import util.Utilitario;

/**
 * @author douglas borges egidio
 */
public class FXMLSalarioRelatorioController implements Initializable {

    SalarioRelatorio salarioRelatorio = new SalarioRelatorio();

    public FXMLSalarioRelatorioController() {

    }

    private String filtroPesquisa;
    private String filtroEmpresa;
    private String data1 = "null";
    private String data2 = "null";

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private TableView<SalarioRelatorio> tabelaSalarioRelatorioTV;

    @FXML
    private TableColumn<SalarioRelatorio, String> colunaNomeEmpresa;

    @FXML
    private TableColumn<SalarioRelatorio, String> colunaSalario;

    @FXML
    private TableColumn<SalarioRelatorio, String> colunaDataRecebimento;

    @FXML
    private TableColumn<SalarioRelatorio, String> colunaTipoPagamento;

    @FXML
    private ComboBox filtroPesquisaCB;

    @FXML
    private TextField campoTodosSalarioPesquisaTF;

    @FXML
    private Button listarTodosBT;

    @FXML
    private DatePicker dataFinalDP;

    @FXML
    private DatePicker dataInicialDP;

    @FXML
    private ComboBox filtroEmpresaPagadoraCB;

    @FXML
    private Button BuscarBT;

    @FXML
    private Button imprimirBT;

    @FXML
    private TextField totalSalarioTF;

    @FXML
    private Button voltarMenuBT;

    public String getFiltroPesquisa() {
        return filtroPesquisa;
    }

    public void setFiltroPesquisa(String filtroPesquisa) {
        this.filtroPesquisa = filtroPesquisa;
    }

    public String getFiltroEmpresa() {
        return filtroEmpresa;
    }

    public void setFiltroEmpresa(String filtroEmpresa) {
        this.filtroEmpresa = filtroEmpresa;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public DatePicker getDataInicialDP() {
        return dataInicialDP;
    }

    public void setDataInicialDP(DatePicker dataInicialDP) {
        this.dataInicialDP = dataInicialDP;
    }

    public SalarioRelatorio getSalarioRelatorio() {
        return salarioRelatorio;
    }

    public void setSalarioRelatorio(SalarioRelatorio salarioRelatorio) {
        this.salarioRelatorio = salarioRelatorio;
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

    public TableView<SalarioRelatorio> getTabelaSalarioRelatorioTV() {
        return tabelaSalarioRelatorioTV;
    }

    public void setTabelaSalarioRelatorioTV(TableView<SalarioRelatorio> tabelaSalarioRelatorioTV) {
        this.tabelaSalarioRelatorioTV = tabelaSalarioRelatorioTV;
    }

    public TableColumn<SalarioRelatorio, String> getColunaNomeEmpresa() {
        return colunaNomeEmpresa;
    }

    public void setColunaNomeEmpresa(TableColumn<SalarioRelatorio, String> colunaNomeEmpresa) {
        this.colunaNomeEmpresa = colunaNomeEmpresa;
    }

    public TableColumn<SalarioRelatorio, String> getColunaSalario() {
        return colunaSalario;
    }

    public void setColunaSalario(TableColumn<SalarioRelatorio, String> colunaSalario) {
        this.colunaSalario = colunaSalario;
    }

    public TableColumn<SalarioRelatorio, String> getColunaDataRecebimento() {
        return colunaDataRecebimento;
    }

    public void setColunaDataRecebimento(TableColumn<SalarioRelatorio, String> colunaDataRecebimento) {
        this.colunaDataRecebimento = colunaDataRecebimento;
    }

    public TableColumn<SalarioRelatorio, String> getColunaTipoPagamento() {
        return colunaTipoPagamento;
    }

    public void setColunaTipoPagamento(TableColumn<SalarioRelatorio, String> colunaTipoPagamento) {
        this.colunaTipoPagamento = colunaTipoPagamento;
    }

    public ComboBox<SalarioRelatorio> getFiltroPesquisaCB() {
        return filtroPesquisaCB;
    }

    public void setFiltroPesquisaCB(ComboBox<SalarioRelatorio> filtroPesquisaCB) {
        this.filtroPesquisaCB = filtroPesquisaCB;
    }

    public TextField getCampoTodosSalarioPesquisaTF() {
        return campoTodosSalarioPesquisaTF;
    }

    public void setCampoTodosSalarioPesquisaTF(TextField campoTodosSalarioPesquisaTF) {
        this.campoTodosSalarioPesquisaTF = campoTodosSalarioPesquisaTF;
    }

    public Button getListarTodosBT() {
        return listarTodosBT;
    }

    public void setListarTodosBT(Button listarTodosBT) {
        this.listarTodosBT = listarTodosBT;
    }

    public DatePicker getDataFinalDP() {
        return dataFinalDP;
    }

    public void setDataFinalDP(DatePicker dataFinalDP) {
        this.dataFinalDP = dataFinalDP;
    }

    public DatePicker getdataInicialDP() {
        return dataInicialDP;
    }

    public void setdataInicialDP(DatePicker dataInicialDP) {
        this.dataInicialDP = dataInicialDP;
    }

    public ComboBox<SalarioRelatorio> getFiltroEmpresaPagadoraCB() {
        return filtroEmpresaPagadoraCB;
    }

    public void setFiltroEmpresaPagadoraCB(ComboBox<SalarioRelatorio> filtroEmpresaPagadoraCB) {
        this.filtroEmpresaPagadoraCB = filtroEmpresaPagadoraCB;
    }

    public Button getBuscarBT() {
        return BuscarBT;
    }

    public void setBuscarBT(Button BuscarBT) {
        this.BuscarBT = BuscarBT;
    }

    public Button getImprimirBT() {
        return imprimirBT;
    }

    public void setImprimirBT(Button imprimirBT) {
        this.imprimirBT = imprimirBT;
    }

    public TextField getTotalSalarioTF() {
        return totalSalarioTF;
    }

    public void setTotalSalarioTF(TextField totalSalarioTF) {
        this.totalSalarioTF = totalSalarioTF;
    }

    public Button getVoltarMenuBT() {
        return voltarMenuBT;
    }

    public void setVoltarMenuBT(Button voltarMenuBT) {
        this.voltarMenuBT = voltarMenuBT;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        SalarioRelatorio salarioRelatorio = new SalarioRelatorio();
        Relogio relogio = new Relogio(horasLB);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");

        Date date = new Date();
        dataLB.setTextFill(Color.GRAY);
        dataLB.setText("Hoje é " + sdf.format(date));
        try {
            relogio.relogio();
        } catch (Exception ex) {
        }

        totalSalarioTF.setEditable(false);

        Platform.runLater(filtroPesquisaCB::requestFocus);//fim do run.

        salarioRelatorio.preencherComboBoxFiltroPesquisa(filtroPesquisaCB);

        filtroPesquisaCB.getSelectionModel().selectFirst();
    }//FIM DOS CONSTRUTOR.

    @FXML

    void BuscarBTMouse(MouseEvent event) {
        imprimirBT.setDisable(false);

        if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().isEmpty()) {
            setFiltroPesquisa("Null");
        } else {
            setFiltroPesquisa(filtroPesquisaCB.getSelectionModel().getSelectedItem().toString());
        }

        if (filtroEmpresaPagadoraCB.getSelectionModel().getSelectedItem() == null) {
            setFiltroEmpresa("Null");
        } else {
            setFiltroEmpresa(filtroEmpresaPagadoraCB.getSelectionModel().getSelectedItem().toString());
        }

        if (dataInicialDP.getValue() == null) {
            setData1("Null");
        } else {
            setData1(dataInicialDP.getValue().toString());
        }

        if (dataFinalDP.getValue() == null) {
            setData2("Null");
        } else {
            setData2(dataFinalDP.getValue().toString());
        }

        String pesquisa = getFiltroPesquisa();
        String empresa = getFiltroEmpresa();
        String data1 = getData1();
        String data2 = getData2();
        
         

        SalarioRelatorio salarioRelatorio = new SalarioRelatorio(
                pesquisa,
                empresa,
                data1,
                data2
        );

        salarioRelatorio.iniciarTabela(
                colunaNomeEmpresa,
                colunaSalario,
                colunaDataRecebimento,
                colunaTipoPagamento,
                tabelaSalarioRelatorioTV
        );

        totalSalarioTF.setText(salarioRelatorio.somaSalario());

        Platform.runLater(tabelaSalarioRelatorioTV::requestFocus);//fim do run.
    }

    @FXML
    void BuscarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            imprimirBT.setDisable(false);

            if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().isEmpty()) {
                setFiltroPesquisa("Null");
            } else {
                setFiltroPesquisa(filtroPesquisaCB.getSelectionModel().getSelectedItem().toString());
            }

            if (filtroEmpresaPagadoraCB.getSelectionModel().getSelectedItem() == null) {
                setFiltroEmpresa("Null");
            } else {
                setFiltroEmpresa((String) (Object) filtroEmpresaPagadoraCB.getSelectionModel().getSelectedItem());
            }

            if (dataInicialDP.getValue() == null) {
                setData1("Null");
            } else {
                setData1(dataInicialDP.getValue().toString());
            }

            if (dataFinalDP.getValue() == null) {
                setData2("Null");
            } else {
                setData2(dataFinalDP.getValue().toString());
            }

            String pesquisa = getFiltroPesquisa();
            String empresa = getFiltroEmpresa();
            String data1 = getData1();
            String data2 = getData2();

            SalarioRelatorio salarioRelatorio = new SalarioRelatorio(
                    pesquisa,
                    empresa,
                    data1,
                    data2
            );

            salarioRelatorio.iniciarTabela(
                    colunaNomeEmpresa,
                    colunaSalario,
                    colunaDataRecebimento,
                    colunaTipoPagamento,
                    tabelaSalarioRelatorioTV
            );

            totalSalarioTF.setText(salarioRelatorio.somaSalario());

            Platform.runLater(tabelaSalarioRelatorioTV::requestFocus);//fim do run.
        }
    }

    @FXML
    void dataInicialDPMouse(MouseEvent event) {

    }

    @FXML
    void dataInicialDPTeclado(KeyEvent event) {

    }

    @FXML
    void dataFinalDPMouse(MouseEvent event) {

    }

    @FXML
    void dataFinalDPTeclado(KeyEvent event) {

    }

    @FXML
    void filtroEmpresaPagadoraCBMouse(MouseEvent event) {

    }

    @FXML
    void filtroEmpresaPagadoraCBTeclado(KeyEvent event) {

    }

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO TECLADO(TECLA ENTER)
    void voltarMenuBTTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            salarioRelatorio.abrirMenu();
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(filtroPesquisaCB::requestFocus);//fim do run.
            filtroPesquisaCB.getSelectionModel().selectFirst();
        }
    }//FIM DO MÉTODO kEYEVENT.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO CLIC DO MOUSE.
    void voltarMenuBTMouse(MouseEvent event) {
        SalarioRelatorio salarioRelatorio = new SalarioRelatorio();
        salarioRelatorio.abrirMenu();
        salarioRelatorio.fecharSalarioRelatorio();
        Platform.runLater(filtroPesquisaCB::requestFocus);//fim do run.
        filtroPesquisaCB.getSelectionModel().selectFirst();
    }//FIM DO MÉTODO

    @FXML
    void tabelaSalarioRelatorioTVMouse(MouseEvent event) {
        tabelaSalarioRelatorioTV.getSelectionModel().selectFirst();
        Platform.runLater(imprimirBT::requestFocus);//fim do run.
    }

    @FXML
    void tabelaSalarioRelatorioTVTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(imprimirBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            SalarioRelatorio salarioRelatorio = new SalarioRelatorio();

            String filtroPesquisa = filtroPesquisaCB.getSelectionModel().getSelectedItem().toString();
            String EmpresaPagadora = (String) (Object) filtroEmpresaPagadoraCB.getSelectionModel().getSelectedItem();
            LocalDate dataUm = dataInicialDP.getValue();
            String data1 = "" + dataUm;
            LocalDate dataDois = dataFinalDP.getValue();
            String data2 = "" + dataDois;
            
             System.out.println("" + filtroPesquisa);
            System.out.println("" + EmpresaPagadora);
            System.out.println("" + data1);
            System.out.println("" + data2);

          
            salarioRelatorio.imprimir(
                    filtroPesquisa,
                    EmpresaPagadora,
                    data1,
                    data2
            );
        }
    }

    @FXML
    void imprimirBTMouse(MouseEvent event) {
        SalarioRelatorio salarioRelatorio = new SalarioRelatorio();

        String filtroPesquisa = filtroPesquisaCB.getSelectionModel().getSelectedItem().toString();
        String EmpresaPagadora = (String) (Object) filtroEmpresaPagadoraCB.getSelectionModel().getSelectedItem();
        LocalDate dataUm = dataInicialDP.getValue();
        String data1 = "" + dataUm;
        LocalDate dataDois = dataFinalDP.getValue();
        String data2 = "" + dataDois;

        System.out.println("" + filtroPesquisa);
        System.out.println("" + EmpresaPagadora);
        System.out.println("" + data1);
        System.out.println("" + data2);
        
        salarioRelatorio.imprimir(
                filtroPesquisa,
                EmpresaPagadora,
                data1,
                data2
        );
    }

    @FXML
    void campoTodosSalariosPesquisaTFMouse(MouseEvent event) {

    }

    @FXML
    void campoTodosSalariosPesquisaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaSalarioRelatorioTV::requestFocus);//fim do run.
            tabelaSalarioRelatorioTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void campoNomePesquisaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaSalarioRelatorioTV::requestFocus);//fim do run.
            tabelaSalarioRelatorioTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void filtroPesquisaCBMouse(MouseEvent event) {

        SalarioDAO dao = new SalarioDAO();
        filtroPesquisaCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                imprimirBT.setDisable(true);
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Selecione um filtro")) {
                    campoTodosSalarioPesquisaTF.setVisible(true);
                    campoTodosSalarioPesquisaTF.setText("Escolheu um filtro de pesquisa?... não?!... Então, escolha um e depois CLIC AQUI!!");
                    campoTodosSalarioPesquisaTF.setDisable(true);
                    filtroEmpresaPagadoraCB.setVisible(false);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(false);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Empresa Pagadora")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaPagadoraCB);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Data")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(false);
                    dataInicialDP.setVisible(true);
                    dataInicialDP.setPromptText("Data");
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Período")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(false);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(true);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Empresa e Data")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaPagadoraCB);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();

                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Empresa e Período")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaPagadoraCB);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(true);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Todos")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(false);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(true);
                    BuscarBT.setVisible(false);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
            }
        });
    }

    @FXML
    void filtroPesquisaCBTeclado(KeyEvent event) {

        SalarioDAO dao = new SalarioDAO();
        filtroPesquisaCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                imprimirBT.setDisable(true);
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Selecione um filtro")) {
                    campoTodosSalarioPesquisaTF.setVisible(true);
                    campoTodosSalarioPesquisaTF.setText("Escolheu um filtro de pesquisa?... não?!... Então, escolha um e depois CLIC AQUI!!");
                    campoTodosSalarioPesquisaTF.setDisable(true);
                    filtroEmpresaPagadoraCB.setVisible(false);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(false);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Empresa Pagadora")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaPagadoraCB);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Data")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(false);
                    dataInicialDP.setVisible(true);
                    dataInicialDP.setPromptText("Data");
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Período")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(false);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(true);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Empresa e Data")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaPagadoraCB);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();

                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Empresa e Período")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaPagadoraCB);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(true);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Todos")) {
                    campoTodosSalarioPesquisaTF.setVisible(false);
                    filtroEmpresaPagadoraCB.setVisible(false);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(true);
                    BuscarBT.setVisible(false);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaPagadoraCB.getSelectionModel().clearSelection();
                    tabelaSalarioRelatorioTV.getItems().clear();
                    totalSalarioTF.clear();
                }
            }
        });

    }

    @FXML
    void listarTodosBTTeclado(KeyEvent event) {

        imprimirBT.setDisable(false);

        String filtroPesquisa;
        String filtroEmpresa;
        String data1 = "null";
        String data2 = "null";

        if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().isEmpty()) {
            filtroPesquisa = "Null";
        } else {
            filtroPesquisa = (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString();
        }

        if (filtroEmpresaPagadoraCB.getSelectionModel().getSelectedItem() == null) {
            filtroEmpresa = "Null";
        } else {
            filtroEmpresa = (String) (Object) filtroEmpresaPagadoraCB.getSelectionModel().getSelectedItem().toString();
        }

        if (dataInicialDP.getValue() == null) {
            data1 = "Null";
        } else {
            data1 = dataInicialDP.getValue().toString();
        }

        if (dataFinalDP.getValue() == null) {
            data2 = "Null";
        } else {
            data2 = dataFinalDP.getValue().toString();
        }

        SalarioRelatorio salarioRelatorio = new SalarioRelatorio(
                filtroPesquisa,
                filtroEmpresa,
                data1,
                data2
        );

        salarioRelatorio.iniciarTabela(
                colunaNomeEmpresa,
                colunaSalario,
                colunaDataRecebimento,
                colunaTipoPagamento,
                tabelaSalarioRelatorioTV
        );

        totalSalarioTF.setText(salarioRelatorio.somaSalario());

        Platform.runLater(tabelaSalarioRelatorioTV::requestFocus);//fim do run.

    }

    @FXML
    void listarTodosBTMouse(MouseEvent event) {
        imprimirBT.setDisable(false);

        String filtroPesquisa;
        String filtroEmpresa;
        String data1 = "null";
        String data2 = "null";

        if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().isEmpty()) {
            filtroPesquisa = "Null";
        } else {
            filtroPesquisa = (String) (Object) filtroPesquisaCB.getSelectionModel().getSelectedItem().toString();
        }

        if (filtroEmpresaPagadoraCB.getSelectionModel().getSelectedItem() == null) {
            filtroEmpresa = "Null";
        } else {
            filtroEmpresa = (String) (Object) filtroEmpresaPagadoraCB.getSelectionModel().getSelectedItem().toString();
        }

        if (dataInicialDP.getValue() == null) {
            data1 = "Null";
        } else {
            data1 = dataInicialDP.getValue().toString();
        }

        if (dataFinalDP.getValue() == null) {
            data2 = "Null";
        } else {
            data2 = dataFinalDP.getValue().toString();
        }

        SalarioRelatorio salarioRelatorio = new SalarioRelatorio(
                filtroPesquisa,
                filtroEmpresa,
                data1,
                data2
        );

        salarioRelatorio.iniciarTabela(
                colunaNomeEmpresa,
                colunaSalario,
                colunaDataRecebimento,
                colunaTipoPagamento,
                tabelaSalarioRelatorioTV
        );

        totalSalarioTF.setText(salarioRelatorio.somaSalario());

        Platform.runLater(tabelaSalarioRelatorioTV::requestFocus);//fim do run.

    }

}
