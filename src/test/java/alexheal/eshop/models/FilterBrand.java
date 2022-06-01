package alexheal.eshop.models;

public enum FilterBrand {
    All("null"),
    Azure("1"),
    NET("2"),
    Visual_Studio("3"),
    SQL_Server("4"),
    Other("5");

    public final String value;

    FilterBrand(String value) {
        this.value = value;
    }
}
