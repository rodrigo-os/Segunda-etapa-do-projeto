import java.util.Random;

public class Quadrinho {

    private String nome;
    private int id;
    private String estado;
    private float preco;
    private String dataAquisicao;
    private String status;
    private String nota;
    private String descricao;
    static Random randomID = new Random();

    private Quadrinho(String nome, float preco, String status) {
        this.nome = nome;
        this.preco = preco;
        this.status = status;
        this.estado = "";
        this.dataAquisicao = "";
        this.nota = "";
        this.descricao = "";
        IDQuadrinho idQuadrinho = IDQuadrinho.getInstance(randomID.nextInt(100));
        id = idQuadrinho.getId();
    }

    private Quadrinho(String nome, String estado, float preco, String dataAquisicao, String status, String nota) {
        this.nome = nome;
        this.estado = estado;
        this.preco = preco;
        this.dataAquisicao = dataAquisicao;
        this.status = status;
        this.nota = nota;
        this.descricao = "";

        IDQuadrinho idQuadrinho = IDQuadrinho.getInstance(randomID.nextInt(100));
        id = idQuadrinho.getId();
    }

    private Quadrinho(String nome, String estado, float preco, String dataAquisicao, String status) {
        this.nome = nome;
        this.estado = estado;
        this.preco = preco;
        this.dataAquisicao = dataAquisicao;
        this.status = status;
        this.nota = "";

        IDQuadrinho idQuadrinho = IDQuadrinho.getInstance(randomID.nextInt(100));
        id = idQuadrinho.getId();
    }

    public static Quadrinho criaSimples(String nome, float preco, String status) {
        return new Quadrinho(nome, preco, status);
    }

    public static Quadrinho criaNota(String nome, String estado, float preco, String dataAquisicao, String status, String nota) {
        if (validaNota(nota) == true) {
            return new Quadrinho(nome, estado, preco, dataAquisicao, status, nota);
        } else {
            System.out.println("A nota inserida não corresponde com o padrão desejado, foi substituída por uma nota em branco!");
            return new Quadrinho(nome, estado, preco, dataAquisicao, status, "");
        }
    }

    public static Quadrinho criaDescricao(String nome, String estado, float preco, String dataAquisicao, String status, String descricao) {

        if (validaDescricao(descricao) == true) {
            Quadrinho quadrinhoDescricao = new Quadrinho(nome, estado, preco, dataAquisicao, status);
            quadrinhoDescricao.setDescricao(descricao);
            return quadrinhoDescricao;
        } else {
            System.out.println("A descrição inserida não corresponde com o padrão desejado, foi substituída por uma descrição em branco!");
            Quadrinho quadrinhoDescricao = new Quadrinho(nome, estado, preco, dataAquisicao, status);
            quadrinhoDescricao.setDescricao("");
            return quadrinhoDescricao;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public float getPreco() {
        return preco;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public String getStatus() {
        return status;
    }

    public String getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private static boolean validaNota(String nota) {
        if (nota.length() > 3 && nota.length() < 30) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean validaDescricao(String descricao) {
        if (descricao.length() > 30 && descricao.length() < 300) {
            return true;
        } else {
            return false;
        }
    }

    public int getId() {
        return id;
    }
}