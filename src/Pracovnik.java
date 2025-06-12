import java.math.BigDecimal;
import java.time.LocalDate;

public class Pracovnik {
    private String jmeno;
    private int osobniCislo;
    private BigDecimal nastupniBonus;
    private LocalDate datumNarozeni;
    private boolean jeExternista;

    public Pracovnik(String jmeno, int osobniCislo, BigDecimal nastupniBonus, LocalDate datumNarozeni, boolean jeExternista) {
        this.jmeno = jmeno;
        this.osobniCislo = osobniCislo;
        this.nastupniBonus = nastupniBonus;
        this.datumNarozeni = datumNarozeni;
        this.jeExternista = jeExternista;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getOsobniCislo() {
        return osobniCislo;
    }

    public void setOsobniCislo(int osobniCislo) {
        this.osobniCislo = osobniCislo;
    }

    public BigDecimal getNastupniBonus() {
        return nastupniBonus;
    }

    public void setNastupniBonus(BigDecimal nastupniBonus) {
        this.nastupniBonus = nastupniBonus;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public boolean isJeExternista() {
        return jeExternista;
    }

    public void setJeExternista(boolean jeExternista) {
        this.jeExternista = jeExternista;
    }
}
