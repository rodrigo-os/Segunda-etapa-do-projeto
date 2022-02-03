public class SingleEditora implements MyEditora {
    private final String nome;

    public SingleEditora(String nome) {
        this.nome = nome;
    }

    @Override
    public String getEditora() {
        return nome;
    }
}