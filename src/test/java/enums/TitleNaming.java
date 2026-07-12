package enums;

public enum TitleNaming {
    PRODUCTS("Products"),
    BASKET("Your Cart"),
    CHECKOUT("Checkout: Your Information");

    private final String displayName;

    TitleNaming(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
