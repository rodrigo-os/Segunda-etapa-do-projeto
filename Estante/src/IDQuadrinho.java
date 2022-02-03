public class IDQuadrinho {
    private int id;
    private static IDQuadrinho instance;

    private IDQuadrinho(int id) {
        this.id = id;
    }

    public static IDQuadrinho getInstance(int id) {
        if (instance == null) {
            instance = new IDQuadrinho(id);
            return instance;
        } else {
            instance.setId(instance.getId());
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