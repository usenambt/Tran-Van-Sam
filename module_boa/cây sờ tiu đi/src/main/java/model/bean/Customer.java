

public class Customer {
   private int idProduct;
   private String nameProduct;
   private double price;
   private boolean status;
    private int idCategory;
    private String nameCategory;
    private Contract category;


    public Customer(String nameProduct, double price, boolean status, int idCategory) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.status = status;
        this.idCategory = idCategory;
    }

    public Customer(int idProduct, String nameProduct, double price, boolean status, int idCategory, String nameCategory) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.status = status;
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public Customer(int idProduct, String nameProduct, double price, boolean status) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.status = status;
    }

    public Customer(int idProduct, String nameProduct, double price, boolean status, int idCategory, Contract category) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.status = status;
        this.idCategory = idCategory;
        this.category = category;
    }

    public Customer() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
