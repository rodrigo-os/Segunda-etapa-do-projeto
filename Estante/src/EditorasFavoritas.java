import java.util.ArrayList;
import java.util.List;

public class EditorasFavoritas implements MyEditora {
    private List<MyEditora> myEditoras;

    public EditorasFavoritas() {
        this.myEditoras = new ArrayList<MyEditora>();
    }

    public void add(MyEditora editora) {
        myEditoras.add(editora);
    }

    @Override
    public String getEditora() {
        String lista = new String();
        for (MyEditora editoraInput : myEditoras) {
            lista = lista.concat(editoraInput.getEditora());
        }
        return lista;
    }
}