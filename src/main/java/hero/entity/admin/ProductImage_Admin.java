// ProductImage_Admin.java
package hero.entity.admin;

import jakarta.persistence.*;



@Entity
@Table(name = "product_images")
public class ProductImage_Admin {

        public Long getId() {
                return id;
        }

        public ProductImage_Admin() {
        }

        @Override
        public String toString() {
                return "ProductImage_Admin{" +
                        "id=" + id +
                        ", product=" + product +
                        ", imageUrl='" + imageUrl + '\'' +
                        '}';
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Products_Admin getProduct() {
                return product;
        }

        public void setProduct(Products_Admin product) {
                this.product = product;
        }

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        public ProductImage_Admin(Long id, Products_Admin product, String imageUrl) {
                this.id = id;
                this.product = product;
                this.imageUrl = imageUrl;
        }

        @ManyToOne
        @JoinColumn(name = "product_id", nullable = false)
        private Products_Admin product;

        @Column(nullable = false)
        private String imageUrl;

}
