package hr.tvz.nasamalakuharica.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Ingredient() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Recipe getRecepy() {
        return recipe;
    }

    public void setRecepy(Recipe recipe) {
        this.recipe = recipe;
    }
}