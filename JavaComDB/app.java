package JavaComDB;

import JavaComDB.src.DAO.UsuarioDAO;
import JavaComDB.src.entidade.Usuario;

public class app {
    public static void main(String[] args) throws Exception{
        Usuario user = new Usuario();
        user.setNome("Ana");
        user.setLogin("ana");
        user.setSenha("12345");
        user.setEmail("ana@gmail");

        new UsuarioDAO().cadastrarUsuario(user);

    }
}
