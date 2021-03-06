package app.entities;

public class Product {

    private int idproducts;

    private String name;

    private int price;

    private String image;

    public Product() {
    }
    public Product(String name, int price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }
    public Product(int idproducts, String name, int price, String image) {
        this.idproducts = idproducts;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getIdproducts() {
        return idproducts;
    }

    public void setIdproducts(int idproducts) {
        this.idproducts = idproducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idproducts=" + idproducts +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}

