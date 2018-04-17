package mainPackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "klienci", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @javax.persistence.Id
    @Column(name = "id_klient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "imie")
    String imie;
    @Column(name = "nazwisko")
    String nazwisko;

}