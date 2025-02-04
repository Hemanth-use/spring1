package hero.entity.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Products_Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    public Products_Admin() {
    }

    @Override
    public String toString() {
        return "Products_Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subcategory=" + subcategory +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", size='" + size + '\'' +
                ", rating=" + rating +
                ", imageUrl='" + imageUrl + '\'' +
                ", images=" + images +
                '}';
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category_Admin category;

    public Products_Admin(Long id, String name, Subcategory subcategory, Category_Admin category, String description, BigDecimal price, Integer stock, String brand, String model, String size, Integer rating, String imageUrl, Set<ProductImage_Admin> images) {
        this.id = id;
        this.name = name;
        this.subcategory = subcategory;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.images = images;
    }

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private Integer rating;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<ProductImage_Admin> images;

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Category_Admin getCategory() {
        return category;
    }

    public void setCategory(Category_Admin category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<ProductImage_Admin> getImages() {
        return images;
    }

    public void setImages(Set<ProductImage_Admin> images) {
        this.images = images;
    }
}
