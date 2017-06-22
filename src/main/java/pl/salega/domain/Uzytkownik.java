package pl.salega.domain;


import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by kamilsalega on 22.06.2017.
 */
@Entity
public class Uzytkownik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false) //auto update kolumn
    private Long id;
    private String nazwaUzytkownika;
    private String haslo;
    private String pierwszeImie;
    private String nazwisko;


    @Column(name = "email", nullable = false, updatable = false)
    private String email;
    private String nrTelfonu;
    private boolean wlaczone = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaUzytkownika() {
        return nazwaUzytkownika;
    }

    public void setNazwaUzytkownika(String nazwaUzytkownika) {
        this.nazwaUzytkownika = nazwaUzytkownika;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getPierwszeImie() {
        return pierwszeImie;
    }

    public void setPierwszeImie(String pierwszeImie) {
        this.pierwszeImie = pierwszeImie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTelfonu() {
        return nrTelfonu;
    }

    public void setNrTelfonu(String nrTelfonu) {
        this.nrTelfonu = nrTelfonu;
    }

    public boolean isWlaczone() {
        return wlaczone;
    }

    public void setWlaczone(boolean wlaczone) {
        this.wlaczone = wlaczone;
    }
}
