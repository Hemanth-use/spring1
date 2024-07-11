package hero.entity.admin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "category_id")
    private Long categoryId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category_Admin category;

    public Subcategory() {
    }

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category_Admin getCategory() {
        return category;
    }

    public void setCategory(Category_Admin category) {
        this.category = category;
    }

    @JsonCreator
    public Subcategory(@JsonProperty("id") Long id,
                       @JsonProperty("name") String name,
                       @JsonProperty("category") Category_Admin category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
