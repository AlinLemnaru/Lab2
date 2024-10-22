package Pb4;

import java.time.LocalDate;
import java.time.Period;

public class Persoana {
    private String nume;
    private String cnp;

    //constructor
    public Persoana() {
        this.nume = "";
        this.cnp = "";
    }

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    //getter, setter - nume
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    //getter, setter - cnp
    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getVarsta() {
        LocalDate date = LocalDate.now();
        LocalDate dataNasterii;
        StringBuilder sb = new StringBuilder(cnp);
        String an, luna, zi;

        an = sb.substring(1, 3);
        luna = sb.substring(3, 5);
        zi = sb.substring(5, 7);

        if (Integer.valueOf(an) + 2000 > date.getYear())
            an = "19" + an;
        else
            an = "20" + an;

        dataNasterii = LocalDate.of(Integer.valueOf(an), Integer.valueOf(luna), Integer.valueOf(zi));

        if ((dataNasterii != null) && (date != null))
            return Period.between(dataNasterii, date).getYears();

        return 0;
    }

    public String toString() {
        return "nume=" + nume + ", cnp=" + cnp + ", varsta=" + getVarsta();
    }
}
