package Enum;
public enum Constant {
    PET_FILE("Pet.data"),
    CUSTOMER_FILE("Customer.data"),
    TRANSACTION_FILE("Transaction.data");

    private final String fileName;

    Constant(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}