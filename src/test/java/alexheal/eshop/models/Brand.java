package alexheal.eshop.models;

public enum Brand {
    All("null"),
    Azure("1"),
    NET("2"),
    Visual_Studio("3"),
    SQL_Server("4"),
    Other("5");

    public final String value;

    Brand(String value) {
        this.value = value;
    }
}
