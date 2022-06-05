package alexheal.eshop.models;

public enum FilterType {
    All("null", "All"),
    T_Shirt("1", "T-Shirt"),
    Pin("2", "Pin"),
    USB_Memory_Stick("3", "USB Memory Stick");

    public final String value;
    public final String text;

    FilterType(String value, String text) {
        this.value = value;
        this.text = text;
    }
}
