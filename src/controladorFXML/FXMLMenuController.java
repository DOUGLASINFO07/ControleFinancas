package controladorFXML;

import bancoConexaoDAO.UsuarioDAO;
import classes.Menu;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import util.Relogio;

public class FXMLMenuController implements Initializable {

    //IDENTIFICAÇÃO DOS COMPONENTES GRÁFICOS DA TELA MENU.
    @FXML
    private Button botaoCadastrar;
    @FXML
    private Button botaoReceber;
    @FXML
    private Button boatoBoleto;
    @FXML
    private Button botaoRelatorio;
    @FXML
    private Button botaoUtilitario;
    @FXML
    private Button botaoSobre;
    @FXML
    private Button botaoSair;
    @FXML
    private Pane PaneCadastrar;
    @FXML
    private Button botaoCadastrarEmpresa;
    @FXML
    private Button botaoCadastrarUsuario;
    @FXML
    private Pane PaneBoleto;
    @FXML
    private Pane PaneRelatorio;
    @FXML
    private Pane PaneUtilitario;
    @FXML
    private Pane PaneSair;
    @FXML
    private Button botaoSairSairLogin;
    @FXML
    private Button botaoSairFechar;
    @FXML
    private Label dataLB;
    @FXML
    private Label horasLB;
    //FIM DA IDENTIFICAÇÃO DO COMPONENTES.

    //MÉTODOS PARA ATIVAR OU DESATIVAS AS PANES COM OS BOTOÕES QUE FICAM INVISÍVEIS
    //ATÉ QUE SEJA ACIONADO ALGUM BOTÃO, E ESTE POR SUA VEZ TORNA VISÍVEL AS PANES COM OS 
    //BOTÕES RELACIONADO COM O BOTÃO ACIONADO.
    
    @FXML
    void abrirPaneCadastrarMouse(MouseEvent mouseEvent) {
        Menu menu = new Menu();
        if (mouseEvent.getClickCount() == 1) {
            menu.abrirPaneCadastrar(
                    PaneCadastrar,
                    PaneBoleto,
                    PaneRelatorio,
                    PaneSair,
                    PaneUtilitario
            );
        }
    }

    @FXML
    void abrirPaneCadastrarEnter(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirPaneCadastrar(
                    PaneCadastrar,
                    PaneBoleto,
                    PaneRelatorio,
                    PaneSair,
                    PaneUtilitario
            );
        }
    }

    @FXML
    void abrirPaneBoletoMouse(MouseEvent mouseEvent) {
        Menu menu = new Menu();
        if (mouseEvent.getClickCount() == 1) {
            menu.abrirPaneBoleto(
                    PaneCadastrar,
                    PaneBoleto,
                    PaneRelatorio,
                    PaneSair,
                    PaneUtilitario
            );
        }
    }

    @FXML
    void abrirPaneBoletoEnter(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirPaneBoleto(
                    PaneCadastrar,
                    PaneBoleto,
                    PaneRelatorio,
                    PaneSair,
                    PaneUtilitario
            );
        }
    }

    @FXML
    void abrirPaneRelatorioMouse(MouseEvent mouseEvent) {
        Menu menu = new Menu();
        if (mouseEvent.getClickCount() == 1) {
            menu.abrirPaneRelatorio(
                    PaneCadastrar,
                    PaneBoleto,
                    PaneRelatorio,
                    PaneSair,
                    PaneUtilitario
            );
        }
    }

    @FXML
    void abrirPaneRelatorioEnter(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirPaneRelatorio(
                    PaneCadastrar,
                    PaneBoleto,
                    PaneRelatorio,
                    PaneSair,
                    PaneUtilitario
            );
        }
    }

    @FXML
    void abrirPaneUtilitarioMouse(MouseEvent mouseEvent) {
        Menu menu = new Menu();
        if (mouseEvent.getClickCount() == 1) {
            menu.abrirPaneUtilitario(
                    PaneCadastrar,
                    PaneBoleto,
                    PaneRelatorio,
                    PaneSair,
                    PaneUtilitario
            );
        }
    }

    @FXML
    void abrirPaneUtilitarioEnter(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirPaneUtilitario(
                    PaneCadastrar,
                    PaneBoleto,
                    PaneRelatorio,
                    PaneSair,
                    PaneUtilitario
            );
        }
    }

    @FXML
    void abrirPaneSairMouse(MouseEvent mouseEvent) {
        Menu menu = new Menu();
        if (mouseEvent.getClickCount() == 1) {
            menu.abrirPaneSair(
                    PaneCadastrar,
                    PaneBoleto,
                    PaneRelatorio,
                    PaneSair,
                    PaneUtilitario
            );
        }
    }

    @FXML
    void abrirPaneSairEnter(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirPaneSair(
                    PaneCadastrar,
                    PaneBoleto,
                    PaneRelatorio,
                    PaneSair,
                    PaneUtilitario
            );
        }
    }

    @FXML
    void fecharSistemaEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            Menu menu = new Menu();
            menu.fecharMenu();
        }
    }

    @FXML
    void fecharSistemaMouse(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 1) {
            Menu menu = new Menu();
            menu.fecharMenu();
        }
    }

    @FXML
    void abrirUsuarioEnter(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirUsuario();
            menu.fecharMenu();
        }
    }

    @FXML
    void abrirUsuarioMouse(MouseEvent event) {
        Menu menu = new Menu();
        menu.abrirUsuario();
        menu.fecharMenu();
    }

    @FXML
    void abrirEmpresaEnter(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirEmpresa();
            menu.fecharMenu();
        }
    }

    @FXML
    void abrirEmpresaMouse(MouseEvent event) {
        Menu menu = new Menu();
        menu.abrirEmpresa();
        menu.fecharMenu();
    }

    @FXML
    void abrirSalarioMouse(MouseEvent event) {
        Menu menu = new Menu();
        menu.abrirSalario();
        menu.fecharMenu();
    }

    @FXML
    void abrirSalarioTeclado(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirSalario();
            menu.fecharMenu();
        }
    }

    @FXML
    void abrirBoletoMouse(MouseEvent event) {
        Menu menu = new Menu();
        menu.abrirBoleto();
        menu.fecharMenu();
    }

    @FXML
    void abrirBoletoTeclado(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirBoleto();
            menu.fecharMenu();
        }
    }

    @FXML
    void abrirPagarBoletoMouse(MouseEvent event) {
        Menu menu = new Menu();
        menu.abrirPagarBoleto();
        menu.fecharMenu();
    }

    @FXML
    void abrirPagarBoletoTeclado(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirPagarBoleto();
            menu.fecharMenu();
        }
    }
    
    @FXML
    void abrirUsuarioRelatorioBTMouse(MouseEvent event) {
        Menu menu = new Menu();
        menu.abrirUsuarioRelatorio();
        menu.fecharMenu();
    }

    @FXML
    void abrirUsuarioRelatorioBTTeclado(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirUsuarioRelatorio();
            menu.fecharMenu();
        }
    }
    @FXML
    void abrirEmpresaRelatorioBTMouse(MouseEvent event) {
        Menu menu = new Menu();
        menu.abrirEmpresaRelatorio();
        menu.fecharMenu();
    }
    @FXML
    void abrirEmpresaRelatorioBTTeclado(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
        menu.abrirEmpresaRelatorio();
        menu.fecharMenu();
        }
    }

    @FXML
    void abrirSalarioRelatorioBTTeclado(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirSalarioRelatorio();
            menu.fecharMenu();
        }
    }
    
    @FXML
    void abrirSalarioRelatorioBTMouse(MouseEvent event) {
        Menu menu = new Menu();
            menu.abrirSalarioRelatorio();
            menu.fecharMenu();
    }
    
    @FXML
    void abrirBoletoRelatorioBTTeclado(KeyEvent event) {
        Menu menu = new Menu();
        if (event.getCode() == KeyCode.ENTER) {
            menu.abrirBoletoRelatorio();
            menu.fecharMenu();
        }
    }
    
    @FXML
    void abrirBoletoRelatorioBTMouse(MouseEvent event) {
        Menu menu = new Menu();
            menu.abrirBoletoRelatorio();
            menu.fecharMenu();
    }
    
    

    //MÉTODO CONSTRUTOR QUE INICIALIZA OS MÉTODOS PERTINENTES.
    void initialize() {

        assert botaoCadastrar != null : "fx:id=\"botaoCadastrar\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert botaoReceber != null : "fx:id=\"botaoReceber\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert boatoBoleto != null : "fx:id=\"boatoBoleto\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert botaoRelatorio != null : "fx:id=\"botaoRelatorio\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert botaoUtilitario != null : "fx:id=\"botaoUtilitario\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert botaoSobre != null : "fx:id=\"botaoSobre\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert botaoSair != null : "fx:id=\"botaoSair\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert PaneCadastrar != null : "fx:id=\"PaneCadastrar\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert botaoCadastrarEmpresa != null : "fx:id=\"botaoCadastrarEmpresa\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert botaoCadastrarUsuario != null : "fx:id=\"botaoCadastrarUsuario\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert PaneBoleto != null : "fx:id=\"PaneBoleto\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert PaneRelatorio != null : "fx:id=\"PaneRelatorio\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert PaneUtilitario != null : "fx:id=\"PaneUtilitario\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert PaneSair != null : "fx:id=\"PaneSair\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert botaoSairSairLogin != null : "fx:id=\"botaoSairSairLogin\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert botaoSairFechar != null : "fx:id=\"botaoSairFechar\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
    }//FIM DO CONSTRUTOR.

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Relogio relogio = new Relogio(horasLB);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date date = new Date();
        dataLB.setTextFill(Color.GRAY);
        dataLB.setText("Hoje é " + sdf.format(date) + " - Seja Bem Vindo!");
        try {
            relogio.relogio();
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

}
