import java.util.HashMap;
import java.util.Map;

public class UsuarioDAOProxy implements UsuarioDAOInterface {
    private Map<String, Usuario> usuarios;

    public UsuarioDAOProxy() {
        super();
        this.usuarios = new HashMap<>();
    }

    public void addUsuario(String nome, String senha) {
        this.usuarios.put(nome, new Usuario(nome, senha));
    }

    public Usuario getUsuario(String nome) {
        return usuarios.get(nome);
    }

}