package bancoConexaoDAO;

import classes.EmpresaRelatorio;
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
public class EmpresaRelatorioDAO {

    //CLASSE DE CONEXÃO.
    private final Connection conn;

    //CONTRUTOR
    public EmpresaRelatorioDAO() {
        this.conn = new Conexao().abrirConexao();
    }//FIM DO CONSTRUTUOR.

    //INICIO DO MÉTODO QUE CRIA UMA LISTA COM OS DADOS PUXADOS DA TABELA.
    public List<EmpresaRelatorio> listaEmpresaRelatorio(
            String filtroPesquisa, 
            String campoPesquisa
    ) {
        List<EmpresaRelatorio> empresaLista = new ArrayList<>();
        
        String sqlListar = "";
        
        if(filtroPesquisa == "Nome da Empresa"){
        sqlListar = "SELECT * "
                + "FROM empresa "
                + "WHERE nomeEmpresa LIKE '" + campoPesquisa + "%' "
                + "ORDER BY nomeEmpresa";
        }else if(filtroPesquisa == "Telefone"){
            sqlListar = "SELECT * "
                + "FROM empresa "
                + "WHERE telefoneEmpresa LIKE '" + campoPesquisa + "%' "
                + "ORDER BY nomeEmpresa";
        }else if(filtroPesquisa == "E-mail"){
            sqlListar = "SELECT * "
                + "FROM empresa "
                + "WHERE emailEmpresa LIKE '" + campoPesquisa + "%' "
                + "ORDER BY nomeEmpresa";
        }else if(filtroPesquisa == "Todos"){
            sqlListar = "SELECT * "
                + "FROM empresa "
                + "ORDER BY nomeEmpresa";
        }
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlListar);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                EmpresaRelatorio eR = new EmpresaRelatorio();
                eR.setNomeEmpresa(rs.getString("nomeEmpresa"));
                eR.setProdutoEmpresa(rs.getString("produtoEmpresa"));
                eR.setTelefoneEmpresa(rs.getString("telefoneEmpresa"));
                eR.setSiteEmpresa(rs.getString("siteEmpresa"));
                eR.setEmailEmpresa(rs.getString("emailEmpresa"));
                eR.setLoginEmpresa(rs.getString("loginEmpresa"));
                eR.setSenhaEmpresa(rs.getString("senhaEmpresa"));
                empresaLista.add(eR);
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaRelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lista não retornada!!");
            return null;
        }
        return empresaLista;
    }//FIM DO MÉTODO.
}
