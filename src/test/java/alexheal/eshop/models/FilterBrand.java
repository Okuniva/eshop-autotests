package alexheal.eshop.models;

public enum FilterBrand {
    All("null", "All"),
    Azure("1", "Azure"),
    NET("2", ".NET"),
    Visual_Studio("3", "Visual Studio"),
    SQL_Server("4", "SQL Server"),
    Other("5", "Other");

    public final String value;
    public final String text;

    FilterBrand(String value, String text) {
        this.value = value;
        this.text = text;
    }
}
