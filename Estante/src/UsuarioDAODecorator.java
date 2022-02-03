public class UsuarioDAODecorator implements UsuarioDAOInterface {
    private static UsuarioDAOInterface usuarioDAO;

    private UsuarioDAOInterface getDAO() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAOProxy();
        }
        return usuarioDAO;
    }

    @Override
    public void addUsuario(String nome, String senha) throws UsuarioException {
        if (nome.isBlank()) {
            throw new UsuarioException("Não é possível deixar o nome de usuário em branco!");
        } else if (nome.length() > 10 || nome.length() < 3) {
            throw new UsuarioException("O nome de usuário precisa conter de 3 a 10 caracteres!");
        }
        if (senha.isBlank()) {
            throw new UsuarioException("Não é possível deixar a senha em branco!");
        } else if (senha.length() != 4) {
            throw new UsuarioException("A senha inserida precisa conter exatamente 4 caracteres!");
        }
        getDAO().addUsuario(nome, senha);
    }

    @Override
    public Usuario getUsuario(String nome) throws UsuarioException {
        if (nome.isBlank()) {
            throw new UsuarioException("Digite um nome de usuário válido!");
        }
        Usuario user = getDAO().getUsuario(nome);
        if (user == null) {
            throw new UsuarioException("Usuário " + nome + " não cadastrado!");
        }
        return user;
    }
}
