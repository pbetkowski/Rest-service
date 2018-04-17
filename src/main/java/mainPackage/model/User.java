package mainPackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@Table(name = "user", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")

    String name;
    @Column(name = "surname")
    String surname;

    @Column(name = "pesel")
    String pesel;


    public User(Object o, String name, String surname, String pesel) {
    }
}
