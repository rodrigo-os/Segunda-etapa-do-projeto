import java.util.Random;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String senha;
    private int id;
    private Role role;
    private ArrayList<Quadrinho> quadrinhos = new ArrayList<Quadrinho>();
    private int numLi;
    private int numNaoLi;
    private float valorColecao;
    static Random randomID = new Random();
    Wishlist wishlist = new Wishlist();
    Carrinho carrinho = new Carrinho();
    EditorasFavoritas editorasFavoritas = new EditorasFavoritas();

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        IDUsuario idUsuario = IDUsuario.getInstance(randomID.nextInt(10));
        id = idUsuario.getId();
    }

    public Usuario named(String nome) {
        this.nome = nome;
        return this;
    }

    public Usuario is(Role role) {
        this.role = role;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public ArrayList<Quadrinho> getQuadrinhos() {
        return quadrinhos;
    }

    public void setQuadrinhos(ArrayList<Quadrinho> quadrinhos) {
        this.quadrinhos = quadrinhos;
    }

    public int getNumLi() {
        return numLi;
    }

    public void setNumLi(int numLi) {
        this.numLi = numLi;
    }

    public int getNumNaoLi() {
        return numNaoLi;
    }

    public void setNumNaoLi(int numNaoLi) {
        this.numNaoLi = numNaoLi;
    }

    public float getValorColecao() {
        return valorColecao;
    }

    public void setValorColecao(float valorColecao) {
        this.valorColecao = valorColecao;
    }

    public int getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public EditorasFavoritas getEditorasFavoritas() {
        return editorasFavoritas;
    }
}