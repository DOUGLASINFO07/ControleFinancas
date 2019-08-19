package bancoConexaoDAO;

import classes.UsuarioRelatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author douglas Borges Egidio
 */
public class UsuarioRelatorioDAO {

    //CLASSE DE CONEXÃO.
    private final Connection conn;

    private String caminhoFoto;

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    //CONTRUTOR
    public UsuarioRelatorioDAO() {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<UsuarioRelatorio> listaUsuarioRelatorio(String filtroPesquisa, String campoPesquisa) {
        List<UsuarioRelatorio> usuarioLista = new ArrayList<>();
        System.out.println(""+campoPesquisa + filtroPesquisa);
        String sqlListar = "";
        
        if(filtroPesquisa == "Nome"){
        sqlListar = "SELECT * "
                + "FROM usuario "
                + "WHERE nomeUsuario LIKE '" + campoPesquisa + "%' "
                + "ORDER BY nomeUsuario";
        }else if(filtroPesquisa == "Telefone"){
            sqlListar = "SELECT * "
                + "FROM usuario "
                + "WHERE telefoneUsuario LIKE '" + campoPesquisa + "%' "
                + "ORDER BY nomeUsuario";
        }else if(filtroPesquisa == "E-mail"){
            sqlListar = "SELECT * "
                + "FROM usuario "
                + "WHERE emailUsuario LIKE '" + campoPesquisa + "%' "
                + "ORDER BY nomeUsuario";
        }else if(filtroPesquisa == "Todos"){
            sqlListar = "SELECT * "
                + "FROM usuario "
                + "ORDER BY nomeUsuario";
        }
        
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioRelatorio u = new UsuarioRelatorio();
                u.setNomeUsuario(rs.getString("nomeUsuario"));
                u.setTelefoneUsuario(rs.getString("telefoneUsuario"));
                u.setEmailUsuario(rs.getString("emailUsuario"));
                u.setLoginUsuario(rs.getString("loginUsuario"));
                u.setSenhaUsuario(rs.getString("senhaUsuario"));
                usuarioLista.add(u);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return usuarioLista;
    }//FIM DO MÉTODO.
}
