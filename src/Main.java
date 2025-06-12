import java.math.BigDecimal;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GUI gui = new GUI();
        PracovniTym tym = new PracovniTym("Nový tým", true, null, null);

        Pracovnik pracovnik = new Pracovnik("Jan Novak", 12345, BigDecimal.valueOf(1000), LocalDate.of(1990, 1, 1), false);
        Pracovnik pracovnik2 = new Pracovnik("Petr Svoboda", 67890, BigDecimal.valueOf(1500), LocalDate.of(1985, 5, 15), true);
        Pracovnik pracovnik3 = new Pracovnik("Eva Novakova", 11223, BigDecimal.valueOf(1200), LocalDate.of(1992, 3, 20), false);

        tym.add(pracovnik);
        tym.add(pracovnik2);
        tym.add(pracovnik3);

    }
}