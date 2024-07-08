package hero.entity.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category_Admin {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String name;

        private String description;
        private String imageUrl;

        @Override
        public String toString() {
                return "Category_Admin{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", description='" + description + '\'' +
                        ", imageUrl='" + imageUrl + '\'' +
                        ", parentCategory=" + parentCategory +
                        ", subCategories=" + subCategories +
                        '}';
        }

        public Category_Admin getParentCategory() {
                return parentCategory;
        }

        public Category_Admin(Long id, String name, String description,
                              String imageUrl, Category_Admin parentCategory, List<Category_Admin> subCategories) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.imageUrl = imageUrl;
                this.parentCategory = parentCategory;
                this.subCategories = subCategories;
        }

        public void setParentCategory(Category_Admin parentCategory) {
                this.parentCategory = parentCategory;
        }

        public List<Category_Admin> getSubCategories() {
                return subCategories;
        }

        public void setSubCategories(List<Category_Admin> subCategories) {
                this.subCategories = subCategories;
        }

        @ManyToOne(fetch = FetchType.LAZY)
        @JsonIgnore
        private Category_Admin parentCategory;

//        @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
//        private List<Category_Admin> subCategories;
        public Category_Admin(String name) {
                this.name = name;
        }

        public Category_Admin(Long id, String name, String description, String imageUrl,
                              List<Products_Admin> products,
                              Date createdAt, Date updatedAt) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.imageUrl = imageUrl;

        }
        @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<Category_Admin> subCategories;

        public Category_Admin(Long id, String name, String description, String imageUrl,
                              List<Products_Admin> products, CurrentDateTimeProvider createdAt,
                              CurrentDateTimeProvider updatedAt) {
                this.id = id;
                this.name = name;
                this.description = description;

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

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }




        public Category_Admin() {
        }


}
