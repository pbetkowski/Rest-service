package mainPackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@Table(name = "dealer_user", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "login")

    String login;
    @Column(name = "password")
    String password;

    @Column(name = "pesel")
    String pesel;

}
