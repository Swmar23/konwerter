package okno;

import java.awt.*;
import javax.swing.*;

/**
 * Klasa glowna programu.
 * @author swmar
 */
public class Okno extends JFrame{
  /**nr serializacji klasy*/
  private static final long serialVersionUID = -7479134393755736395L;
  /**glowny label programu*/
  private final transient JLabel tekst = new JLabel("Wybierz konwerter.", SwingConstants.CENTER);
  /**przycisk konwersji dlugosci*/
  private final transient JButton przyciskCcm = new JButton("cal/cm");
  /**przycisk konwersji stopni*/
  private final transient JButton przyciskCf = new JButton("cel/far");
  /**
   * Konstruktor klasy Okno.
   */
  public Okno() 
  {
    super("Konwerter");
    final JPanel panelegre = new JPanel();
    panelegre.setLayout(new GridLayout(1,2));
    setLayout(new GridLayout(2,1));
    
    przyciskCcm.addActionListener(new Dlugosc(this, "Konwerter dlugosci", false));
    przyciskCf.addActionListener(new Stopnie(this, "Konwerter stopni", true));
    
    panelegre.add(przyciskCcm);
    panelegre.add(przyciskCf);
    add(tekst);
    add(panelegre);
    setSize(350, 200);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);  
  }
  
  /**
   * Glowna metoda programu.
   * @param args nieuzywane
   */
  public static void main(final String[] args) {
    new Okno();
  }
}
