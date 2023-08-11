package hr.tvz.nasamalakuharica.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Recepy> recepies;

    public void setId(Long id) {
        this.id = id;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Recepy> getRecepies() {
        return recepies;
    }

    public void setRecepies(List<Recepy> recepies) {
        this.recepies = recepies;
    }

}
