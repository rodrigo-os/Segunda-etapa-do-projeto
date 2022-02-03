public class EditoraLancamento {
    private Editora eaglemoss;
    private Editora panini;
    private Editora pipocaENanquim;

    public EditoraLancamento() {
        eaglemoss = new Eaglemoss();
        panini = new Panini();
        pipocaENanquim = new PipocaENanquim();
    }

    public void publicarEaglemoss() {
        eaglemoss.publicar();
    }

    public void publicarPanini() {
        panini.publicar();
    }

    public void publicarPipocaENanquim() {
        pipocaENanquim.publicar();
    }
}