package bancoConexaoDAO;

import classes.Usuario;
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
 * @author dougl
 */
public class UsuarioDAO {

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
    public UsuarioDAO() {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.

    //MÉTODO PARA INSERIR DADOS NO BANCO DE DADOS.
    public boolean Inserir(Usuario u) {

        String sqlAdicionar = "INSERT INTO usuario VALUES (null, ?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlAdicionar)) {
                stmt.setString(1, u.getNomeUsuario());
                stmt.setString(2, u.getTelefoneUsuario());
                stmt.setString(3, u.getEmailUsuario());
                stmt.setString(4, u.getLoginUsuario());
                stmt.setString(5, u.getSenhaUsuario());
                stmt.setString(6, u.getCaminhoFoto());
                stmt.execute();
//                stmt.close();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
    public boolean atualizar(Usuario u) {
        String sqlAtualizar = "UPDATE usuario "
                + "SET telefoneusuario = ?, "
                + "emailUsuario = ?, "
                + "loginUsuario = ?, "
                + "senhaUsuario = ?, "
                + "fotoUsuario = ? "
                + "WHERE nomeUsuario = ? ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizar)) {
                stmt.setString(1, u.getTelefoneUsuario());
                stmt.setString(2, u.getEmailUsuario());
                stmt.setString(3, u.getLoginUsuario());
                stmt.setString(4, u.getSenhaUsuario());
                stmt.setString(5, u.getCaminhoFoto());
                stmt.setString(6, u.getNomeUsuario());
                stmt.execute();
//                stmt.close();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA APAGAR DADOS DO BANCO DE DADOS.
    public boolean apagar(Usuario u) {
        String sqlApagar = "DELETE FROM usuario "
                + "WHERE nomeUsuario = ? AND emailUsuario = ?";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlApagar)) {
                stmt.setString(1, u.getNomeUsuario());
                stmt.setString(2, u.getEmailUsuario());
                stmt.execute();
//                stmt.close();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
    public void buscarFoto(
            String nomeUsuario,
            String emailUsuario
    ) {
        String sqlAtualizar = "SELECT * FROM usuario "
                + "WHERE nomeUsuario = '" + nomeUsuario + "' AND emailUsuario = '" + emailUsuario + "'";

        try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizar)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                caminhoFoto = rs.getString("fotoUsuario");
                stmt.execute();
//                stmt.close();
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<Usuario> listaUsuario() {
        List<Usuario> usuarioLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM usuario ORDER BY nomeUsuario";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setNomeUsuario(rs.getString("nomeUsuario"));
                u.setTelefoneUsuario(rs.getString("telefoneUsuario"));
                u.setEmailUsuario(rs.getString("emailUsuario"));
                u.setLoginUsuario(rs.getString("loginUsuario"));
                u.setSenhaUsuario(rs.getString("senhaUsuario"));
                usuarioLista.add(u);
            }
//            stmt.close();
//            rs.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return usuarioLista;
    }//FIM DO MÉTODO.
}
