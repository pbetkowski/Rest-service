package mainPackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "klienci")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @javax.persistence.Id
    @Column(name = "id_klient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @Column(name = "imie")
    String Name;
    @Column(name = "nazwisko")
    String Surname;

}