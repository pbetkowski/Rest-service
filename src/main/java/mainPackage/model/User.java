package mainPackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "userdata")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @javax.persistence.Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @Column(name = "Name")
    String Name;
    @Column(name = "Surname")
    String Surname;

}