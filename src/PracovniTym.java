import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PracovniTym {
    private static String nazev;
    private boolean jeAktivni;
    private Pracovnik vedouci;
    private static List<Pracovnik> seznamPracovniku;

    public PracovniTym(String nazev, boolean jeAktivni, Pracovnik vedouci, List<Pracovnik> seznamPracovniku) {
        this.nazev = "Novy tým";
        this.jeAktivni = jeAktivni;
        this.vedouci = vedouci;
        this.seznamPracovniku = null;
    }

    public static String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean isJeAktivni() {
        return jeAktivni;
    }

    public void setJeAktivni(boolean jeAktivni) {
        this.jeAktivni = jeAktivni;
    }

    public Pracovnik getVedouci() {
        return vedouci;
    }

    public void setVedouci(Pracovnik vedouci) {
        this.vedouci = vedouci;
    }

    public List<Pracovnik> getSeznamPracovniku() {
        return seznamPracovniku;
    }

    public void setSeznamPracovniku(List<Pracovnik> seznamPracovniku) {
        this.seznamPracovniku = seznamPracovniku;
    }

    public static BigDecimal nastupniBonusCelkem() {
        BigDecimal celkovyBonus = BigDecimal.ZERO;
        for (Pracovnik prac : seznamPracovniku) {
            celkovyBonus = celkovyBonus.add(prac.getNastupniBonus());
        }
        return celkovyBonus;
    }

    public static int pocetExternistu() {
        int pocetExternistu = 0;
        for (Pracovnik prac : seznamPracovniku) {
            if (prac.isJeExternista()) {
                pocetExternistu++;
            }
        }
        return pocetExternistu;
    }

    public void add(Pracovnik pracovnik) {

        if (seznamPracovniku == null) {
            seznamPracovniku = new ArrayList<>();
        }
        seznamPracovniku.add(pracovnik);
    }
}
