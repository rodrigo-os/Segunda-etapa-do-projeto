public class Role {
    private String name;

    public Role named(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }
}
