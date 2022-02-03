public class ProdutoDigital extends Produto {
    private double custoAssinatura;

    public ProdutoDigital(double preco, double custoAssinatura) {
        super(preco);
        this.custoAssinatura = custoAssinatura;
    }

    @Override
    public void addPropriedades(Carrinho carrinho) {
        super.addPropriedades(carrinho);
        carrinho.addPropriedade(PropriedadesCarrinho.CUSTO_ASSINATURA, custoAssinatura);
    }
}