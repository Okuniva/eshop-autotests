package alexheal.eshop.models;

public enum FilterType {
    All("null"),
    T_Shirt("1"),
    Pin("2"),
    USB_Memory_Stick("3");

    public final String value;

    FilterType(String value) {
        this.value = value;
    }
}
