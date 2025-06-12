import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GUI extends JFrame {

    private int index;
    private JTextArea textArea1;
    private JCheckBox checkBox1;
    private JTable table1;

    PracovnikTable model = new PracovnikTable();

    public GUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Pracovní Týmy");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Nastavení layoutu
        frame.setLayout(new BorderLayout());

// Inicializace menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Tým");
        JMenuItem nacti = new JMenuItem("Načti");
        JMenuItem prepni = new JMenuItem("Přepni aktivitu");
        JMenuItem souhrn = new JMenuItem("Souhrn");

// Přidání položek do menu
        menuBar.add(menu);
        menu.add(nacti);
        menu.add(prepni);
        menu.add(souhrn);
        frame.setJMenuBar(menuBar);

// Inicializace ostatních komponent
        textArea1 = new JTextArea();
        checkBox1 = new JCheckBox("Je aktivní?");
        table1 = new JTable(model);;
        JScrollPane scrollPane = new JScrollPane(table1);

// Přidání komponent do frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(textArea1, BorderLayout.SOUTH);
        frame.add(checkBox1, BorderLayout.NORTH);

        frame.setVisible(true);


        //nastaveni acton listeners pro menu
        nacti.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();

            try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(selectedFile)))) {
    StringBuilder content = new StringBuilder();
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(";");
        if (parts.length == 5) {
            String osobniCislo = parts[0];
            String jmeno = parts[1];
            String nastupniBonus = parts[2];
            String datumNarozeni = parts[3];
            String externista = parts[4].equals("x") ? "true" : "false";

            // Zde můžete přidat logiku pro zpracování dat
            content.append(String.format("Osobní číslo: %s, Jméno: %s, Nástupní bonus: %s, Datum narození: %s, Externista: %s%n",
                    osobniCislo, jmeno, nastupniBonus, datumNarozeni, externista));
                    }
                }
            }catch (IOException ex) {
                System.out.println("Chyba při čtení souboru: " + ex.getMessage());
            }
                }


            });

        prepni.addActionListener(e -> {
            if (checkBox1.isSelected()) {
                checkBox1.setSelected(false);
                JOptionPane.showMessageDialog(frame, "Tým je nyní neaktivní.");
            } else {
                checkBox1.setSelected(true);
                JOptionPane.showMessageDialog(frame, "Tým je nyní aktivní.");
            }
            });
        souhrn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "1. Nazev: "+ PracovniTym.getNazev() + "\n" +
                    "2. Bonusy Celkem: " + PracovniTym.nastupniBonusCelkem() + "\n" +
                    "3. Počet externistů: " + PracovniTym.pocetExternistu());
                });





    }


}
