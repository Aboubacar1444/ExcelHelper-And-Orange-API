package spring.training.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany()
    @JoinTable(
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name="roleId")
    )
    private List <Role> roles;

    @OneToOne(mappedBy = "user")
    private Userprofile userprofile;
}
