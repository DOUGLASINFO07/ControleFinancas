package bancoConexaoDAO;

import classes.Empresa;
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
public class EmpresaDAO {

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
    public EmpresaDAO() {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.

    //MÉTODO PARA INSERIR DADOS NO BANCO DE DADOS.
    public boolean Inserir(Empresa e) {

        String sqlAdicionar = "INSERT INTO Empresa VALUES (null, ?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlAdicionar)) {
                stmt.setString(1, e.getNomeEmpresa());
                stmt.setString(2, e.getProdutoEmpresa());
                stmt.setString(3, e.getTelefoneEmpresa());
                stmt.setString(4, e.getSiteEmpresa());
                stmt.setString(5, e.getEmailEmpresa());
                stmt.setString(6, e.getLoginEmpresa());
                stmt.setString(7, e.getSenhaEmpresa());
                stmt.setString(8, e.getCaminhoFoto());
                stmt.execute();
//                stmt.close();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
    public boolean atualizar(Empresa e) {
        String sqlAtualizar = "UPDATE Empresa "
                + "SET produtoEmpresa = ?, "
                + "telefoneEmpresa = ?, "
                + "siteEmpresa = ?, "
                + "emailEmpresa = ?, "
                + "loginEmpresa = ?, "
                + "senhaEmpresa = ?, "
                + "fotoEmpresa = ? "
                + "WHERE nomeEmpresa = ? ";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizar)) {
                stmt.setString(1, e.getProdutoEmpresa());
                stmt.setString(2, e.getTelefoneEmpresa());
                stmt.setString(3, e.getSiteEmpresa());
                stmt.setString(4, e.getEmailEmpresa());
                stmt.setString(5, e.getLoginEmpresa());
                stmt.setString(6, e.getSenhaEmpresa());
                stmt.setString(7, e.getCaminhoFoto());
                stmt.setString(8, e.getNomeEmpresa());
                stmt.execute();
//                stmt.close();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA APAGAR DADOS DO BANCO DE DADOS.
    public boolean apagar(Empresa e) {
        String sqlApagar = "DELETE FROM Empresa "
                + "WHERE NomeEmpresa = ? AND emailEmpresa = ?";
        try {
            try (PreparedStatement stmt = conn.prepareStatement(sqlApagar)) {
                stmt.setString(1, e.getNomeEmpresa());
                stmt.setString(2, e.getEmailEmpresa());
                stmt.execute();
//                stmt.close();
            }
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO PARA ATUALIZAR DADOS DO BANCO DE DADOS.
    public void buscarFoto(
            String nomeEmpresa,
            String emailEmpresa
    ) {
        String sqlAtualizar = "SELECT * FROM Empresa "
                + "WHERE nomeEmpresa = '" + nomeEmpresa + "' AND emailEmpresa = '" + emailEmpresa + "'";

        try (PreparedStatement stmt = conn.prepareStatement(sqlAtualizar)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                caminhoFoto = (rs.getString("fotoEmpresa"));
                stmt.execute();

            }
//            stmt.close();
//            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//FIM DO MÉTODO.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<Empresa> listaEmpresa() {
        List<Empresa> EmpresaLista = new ArrayList<>();
        String sqlListar = "SELECT * FROM Empresa ORDER BY nomeEmpresa";
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Empresa e = new Empresa();
                e.setNomeEmpresa(rs.getString("NomeEmpresa"));
                e.setProdutoEmpresa(rs.getString("produtoEmpresa"));
                e.setTelefoneEmpresa(rs.getString("telefoneEmpresa"));
                e.setSiteEmpresa(rs.getString("siteEmpresa"));
                e.setEmailEmpresa(rs.getString("emailEmpresa"));
                e.setLoginEmpresa(rs.getString("loginEmpresa"));
                e.setSenhaEmpresa(rs.getString("senhaEmpresa"));
                EmpresaLista.add(e);
            }
//            stmt.close();
//            rs.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return EmpresaLista;
    }//FIM DO MÉTODO.
}
