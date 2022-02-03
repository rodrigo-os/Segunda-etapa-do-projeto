public class IDUsuario {
    private int id;
    private static IDUsuario instance;

    private IDUsuario(int id) {
        this.id = id;
    }

    public static IDUsuario getInstance(int id) {
        if (instance == null) {
            instance = new IDUsuario(id);
            return instance;
        } else {
            instance.setId(id);
            return instance;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}