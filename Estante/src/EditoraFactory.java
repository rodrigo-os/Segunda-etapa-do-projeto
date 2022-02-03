import java.util.HashMap;
import java.util.Map;

public class EditoraFactory {
    private static Map<String, SingleEditora> editoras;

    private static void init() {
        editoras = new HashMap<String, SingleEditora>();
        editoras.put("darkside", new SingleEditora("DarkSide Books "));
        editoras.put("eaglemoss", new SingleEditora("Eaglemoss "));
        editoras.put("panini", new SingleEditora("Panini "));
        editoras.put("pipocaENanquim", new SingleEditora("Pipoca & Nanquim "));
        editoras.put("darkHorseComics", new SingleEditora("Dark Horse Comics "));
    }

    public static SingleEditora get(String nome) {
        if (editoras == null)
            init();
        return editoras.get(nome);
    }
}