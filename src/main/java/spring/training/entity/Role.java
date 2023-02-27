package spring.training.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    //@ManyToMany(mappedBy = "roles")
    @ManyToMany()
    @JoinTable(
            joinColumns = @JoinColumn(name="roleId"),
            inverseJoinColumns = @JoinColumn(name="userId")
    )
    private List<User> users;
}
