public class InserirQuadrinho implements Comando {
    private Wishlist wishlist;
    private QuadrinhoWishlist quadrinho;

    public InserirQuadrinho(Wishlist wishlist, QuadrinhoWishlist quadrinho) {
        this.wishlist = wishlist;
        this.quadrinho = quadrinho;
    }

    @Override
    public Wishlist adicionar() {
        wishlist.getQuadrinhosWishlist().add(quadrinho);
        return wishlist;
    }

    @Override
    public Wishlist remover() {
        wishlist.getQuadrinhosWishlist().remove(wishlist.getQuadrinhosWishlist().size() - 1);
        return wishlist;
    }
}