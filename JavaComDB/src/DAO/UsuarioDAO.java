package JavaComDB.src.DAO;

import java.sql.*;
import JavaComDB.src.conexao.Conexao;
import JavaComDB.src.entidade.Usuario;

public class UsuarioDAO { // DAO = DATA ACESS OBJECT 
    
    public void cadastrarUsuario(Usuario usuario){

        String sql = "INSERT INTO USUARIO(NOME,LOGIN,SENHA,EMAIL) VALUES(?,?,?,?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString( 1, usuario.getNome());
            ps.setString( 2, usuario.getLogin());
            ps.setString( 3, usuario.getSenha());
            ps.setString( 4, usuario.getEmail());

            ps.execute();
            ps.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
