package controladorFXML;

import bancoConexaoDAO.BoletoDAO;
import classes.BoletoRelatorio;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import util.Relogio;
import util.Utilitario;

/**
 * @author douglas borges egidio
 */
public class FXMLBoletoRelatorioController implements Initializable {

    BoletoRelatorio boletoRelatorio = new BoletoRelatorio();

    public FXMLBoletoRelatorioController() {

    }

    private String filtroPesquisa;
    private String filtroEmpresa;
    private String dataAtual;
    private String data1;
    private String data2;

    @FXML
    private Label dataLB;

    @FXML
    private Label horasLB;

    @FXML
    private TableView<BoletoRelatorio> tabelaBoletoRelatorioTV;

    @FXML
    private TableColumn<BoletoRelatorio, String> colunaEmpresa;

    @FXML
    private TableColumn<BoletoRelatorio, String> colunaProduto;

    @FXML
    private TableColumn<BoletoRelatorio, String> colunaValorBoleto;

    @FXML
    private TableColumn<BoletoRelatorio, String> colunaVencimento;

    @FXML
    private TableColumn<BoletoRelatorio, String> colunaParcela;

    @FXML
    private TableColumn<BoletoRelatorio, String> colunaFormaPagto;

    @FXML
    private TableColumn<BoletoRelatorio, String> colunaDataPagto;

    @FXML
    private TableColumn<BoletoRelatorio, String> colunaValorPago;

    @FXML
    private TableColumn<BoletoRelatorio, String> colunaLocalPagto;

    @FXML
    private TableColumn<BoletoRelatorio, String> colunaPagador;

    @FXML
    private ComboBox filtroPesquisaCB;

    @FXML
    private TextField campoTodosBoletoPesquisaTF;

    @FXML
    private Button listarTodosBT;

    @FXML
    private DatePicker dataFinalDP;

    @FXML
    private DatePicker dataInicialDP;

    @FXML
    private ComboBox filtroEmpresaCB;

    @FXML
    private Button BuscarBT;

    @FXML
    private Button imprimirBT;

    @FXML
    private TextField valorBoletoPagoTF;

    @FXML
    private TextField valorBoletoPagarTF;

    @FXML
    private Button voltarMenuBT;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        BoletoRelatorio boletoRelatorio = new BoletoRelatorio();
        Relogio relogio = new Relogio(horasLB);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");

        Date date = new Date();
        dataLB.setTextFill(Color.GRAY);
        dataLB.setText("Hoje é " + sdf.format(date));
        try {
            relogio.relogio();
        } catch (Exception ex) {
        }

        valorBoletoPagarTF.setEditable(false);
        valorBoletoPagoTF.setEditable(false);

        Platform.runLater(filtroPesquisaCB::requestFocus);//fim do run.

        boletoRelatorio.preencherComboBoxFiltroPesquisa(filtroPesquisaCB);

        filtroPesquisaCB.getSelectionModel().selectFirst();
    }//FIM DOS CONSTRUTOR.

    @FXML

    void BuscarBTMouse(MouseEvent event) {
        preencherTabela();
    }

    @FXML
    void BuscarBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            preencherTabela();
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
    void filtroEmpresaCBMouse(MouseEvent event) {

    }

    @FXML
    void filtroEmpresaCBTeclado(KeyEvent event) {

    }

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO TECLADO(TECLA ENTER)
    void voltarMenuBTTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            boletoRelatorio.abrirMenu();
        }
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(filtroPesquisaCB::requestFocus);//fim do run.
            filtroPesquisaCB.getSelectionModel().selectFirst();
        }
    }//FIM DO MÉTODO kEYEVENT.

    @FXML//MÉTODO PARA ABRIR MENU A PARTIR DO CLIC DO MOUSE.
    void voltarMenuBTMouse(MouseEvent event) {
        BoletoRelatorio boletoRelatorio = new BoletoRelatorio();
        boletoRelatorio.abrirMenu();
        boletoRelatorio.fecharBoletoRelatorio();
    }//FIM DO MÉTODO

    @FXML
    void tabelaBoletoRelatorioTVMouse(MouseEvent event) {
        tabelaBoletoRelatorioTV.getSelectionModel().selectFirst();
        Platform.runLater(imprimirBT::requestFocus);//fim do run.
    }

    @FXML
    void tabelaBoletoRelatorioTVTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(imprimirBT::requestFocus);//fim do run.
        }
    }

    @FXML
    void imprimirBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            imprimir();
        }
    }

    @FXML
    void imprimirBTMouse(MouseEvent event) {
        imprimir();
    }

    @FXML
    void campoTodosBoletosPesquisaTFMouse(MouseEvent event) {

    }

    @FXML
    void campoTodosBoletosPesquisaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaBoletoRelatorioTV::requestFocus);//fim do run.
            tabelaBoletoRelatorioTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void campoNomePesquisaTFTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.TAB) {
            Platform.runLater(tabelaBoletoRelatorioTV::requestFocus);//fim do run.
            tabelaBoletoRelatorioTV.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void filtroPesquisaCBMouse(MouseEvent event) {
        liberarCamposPesquisa();
    }

    @FXML
    void filtroPesquisaCBTeclado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            liberarCamposPesquisa();
        }
    }

    @FXML
    void listarTodosBTTeclado(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            preencherTabela();
        }
    }

    @FXML
    void listarTodosBTMouse(MouseEvent event) {
        preencherTabela();

    }

    private void preencherTabela() {
        Utilitario util = new Utilitario();

        imprimirBT.setDisable(false);

        if (filtroPesquisaCB.getSelectionModel().getSelectedItem() == null) {
            filtroPesquisa = "Null";
        } else {
            filtroPesquisa = filtroPesquisaCB.getSelectionModel().getSelectedItem().toString();
        }

        if (filtroEmpresaCB.getSelectionModel().getSelectedItem() == null) {
            filtroEmpresa = "Null";
        } else {
            filtroEmpresa = filtroEmpresaCB.getSelectionModel().getSelectedItem().toString();
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

        Date date = new Date(System.currentTimeMillis());
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(date);
        dataAtual = formatoData.format(cal.getTime());

        BoletoRelatorio boletoRelatorio = new BoletoRelatorio(
                filtroPesquisa,
                filtroEmpresa,
                dataAtual,
                data1,
                data2
        );

        boletoRelatorio.iniciarTabela(
                colunaEmpresa,
                colunaProduto,
                colunaValorBoleto,
                colunaVencimento,
                colunaParcela,
                colunaFormaPagto,
                colunaDataPagto,
                colunaValorPago,
                colunaLocalPagto,
                colunaPagador,
                tabelaBoletoRelatorioTV
        );

//        double boletosPagar = Double.parseDouble(boletoRelatorio1.somaBoletosPagar()) - Double.parseDouble(boletoRelatorio1.somaBoletosPago());
        valorBoletoPagarTF.setText(util.converterCifraoAmericanoBrasil(Double.parseDouble(boletoRelatorio.somaBoletosPagar())));

        valorBoletoPagoTF.setText(util.converterCifraoAmericanoBrasil(Double.parseDouble(boletoRelatorio.somaBoletosPago())));
       
        Platform.runLater(tabelaBoletoRelatorioTV::requestFocus);//fim do run.
    }

    private void liberarCamposPesquisa() {
        BoletoDAO dao = new BoletoDAO();
        filtroPesquisaCB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                imprimirBT.setDisable(true);
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Selecione um filtro")) {
                    campoTodosBoletoPesquisaTF.setVisible(true);
                    campoTodosBoletoPesquisaTF.setText("Escolheu um filtro de pesquisa?... não?!... Então, escolha um e depois CLIC AQUI!!");
                    campoTodosBoletoPesquisaTF.setDisable(true);
                    filtroEmpresaCB.setVisible(false);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(false);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Empresa")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Data")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(false);
                    dataInicialDP.setVisible(true);
                    dataInicialDP.setPromptText("Data");
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Período")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(false);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(true);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Vencidos")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(false);
//                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();

                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Pagos")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(false);
//                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Vencidos por Data")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(false);
//                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Vencidos por Período")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(false);
                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(true);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Vencidos por Empresa")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Pagos por Data")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(false);
//                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Pagos por Período")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(false);
//                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(true);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Pagos por Empresa")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Empresas por Data")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Empresas por Período")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(true);
                    dao.listaEmpresa(filtroEmpresaCB);
                    dataInicialDP.setVisible(true);
                    dataFinalDP.setVisible(true);
                    listarTodosBT.setVisible(false);
                    BuscarBT.setVisible(true);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
                if (filtroPesquisaCB.getSelectionModel().getSelectedItem().toString().equals("Todos")) {
                    campoTodosBoletoPesquisaTF.setVisible(false);
                    filtroEmpresaCB.setVisible(false);
                    dataInicialDP.setVisible(false);
                    dataFinalDP.setVisible(false);
                    listarTodosBT.setVisible(true);
                    BuscarBT.setVisible(false);
                    dataInicialDP.setValue(null);
                    dataFinalDP.setValue(null);
                    filtroEmpresaCB.getSelectionModel().clearSelection();
                    tabelaBoletoRelatorioTV.getItems().clear();
                    valorBoletoPagarTF.clear();
                    valorBoletoPagoTF.clear();
                }
            }
        });
    }

    private void imprimir() {
        BoletoRelatorio boletoRelatorio = new BoletoRelatorio();

         if (filtroPesquisaCB.getSelectionModel().getSelectedItem() == null) {
            filtroPesquisa = "Null";
        } else {
            filtroPesquisa = filtroPesquisaCB.getSelectionModel().getSelectedItem().toString();
        }

        if (filtroEmpresaCB.getSelectionModel().getSelectedItem() == null) {
            filtroEmpresa = "Null";
        } else {
            filtroEmpresa = filtroEmpresaCB.getSelectionModel().getSelectedItem().toString();
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
        
        Utilitario util = new Utilitario();
        
        Date date = new Date(System.currentTimeMillis());
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(date);
        dataAtual = formatoData.format(cal.getTime());

        System.out.println("" + dataAtual);
        
        boletoRelatorio.imprimir(
                filtroPesquisa,
                filtroEmpresa,
                dataAtual,
                data1,
                data2
        );
    }

}
