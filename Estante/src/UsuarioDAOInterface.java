public interface UsuarioDAOInterface {
    public void addUsuario(String nome, String senha) throws UsuarioException;

    public Usuario getUsuario(String nome) throws UsuarioException;
}
