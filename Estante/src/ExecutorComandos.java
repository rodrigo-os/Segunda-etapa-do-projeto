import java.util.Stack;

public class ExecutorComandos {
    private Stack<Comando> feitos;
    private Stack<Comando> desfeitos;

    public ExecutorComandos() {
        this.feitos = new Stack<Comando>();
        this.desfeitos = new Stack<Comando>();
    }

    public Wishlist fazer(Comando comando) {
        feitos.push(comando);
        return comando.adicionar();
    }

    public Wishlist desfazer() {
        if (feitos.empty() == true) {
            return new Wishlist();
        } else {
            Comando comando = feitos.pop();
            desfeitos.push(comando);
            return comando.remover();
        }
    }
}