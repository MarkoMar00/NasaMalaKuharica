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
    @JoinColumn(name = "recepy_id")
    private Recepy recepy;

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

    public Recepy getRecepy() {
        return recepy;
    }

    public void setRecepy(Recepy recepy) {
        this.recepy = recepy;
    }
}
