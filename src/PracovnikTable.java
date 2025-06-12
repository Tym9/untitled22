import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PracovnikTable extends AbstractTableModel {
    List<Pracovnik> pracovnici = new ArrayList<>();
    public PracovnikTable() {
      pracovnici.add(new Pracovnik("Jan Novak", 12345, BigDecimal.valueOf(1000), LocalDate.of(1990, 1, 1), false));
        pracovnici.add(new Pracovnik("Petr Svoboda", 67890, BigDecimal.valueOf(1500), LocalDate.of(1985, 5, 15), true));
        pracovnici.add(new Pracovnik("Eva Novakova", 11223, BigDecimal.valueOf(1200), LocalDate.of(1992, 3, 20), false));
    }

    @Override
    public int getRowCount() {
        return pracovnici.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pracovnik prac = pracovnici.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> prac.getOsobniCislo();
            case 1 -> prac.getJmeno();
            case 2 -> prac.getDatumNarozeni();
            case 3 -> prac.getNastupniBonus();
            case 4 -> prac.isJeExternista() ? "Ano" : "Ne";
            default -> null;
        };
    }


}
