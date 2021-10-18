package okno;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import konwerter_stopnie.KonwerterStopnie;

/**
 * Klasa tworzaca gui do konwersji stopni.
 * @author swmar
 */
class Stopnie extends JDialog implements ActionListener {
  
  /**nr serializacji klasy*/
  private static final long serialVersionUID = 4018219737697651596L;
  /**opis pola tekstowego*/
  private final transient JLabel cel = new JLabel("Celsjusz", SwingConstants.CENTER);
  /**opis pola tekstowego*/
  private final transient JLabel fah = new JLabel("Fahrenheit", SwingConstants.CENTER);
  /**przycisk do czyszczenia pol*/
  private final transient JButton przycisk = new JButton("Wyczysc pola");
  /**pole tekstowe dla stopni celsjusza*/
  private final transient JTextField textCel = new JTextField();
  /**pole tekstowe dla stopni fahrenheita*/
  private final transient JTextField textFah = new JTextField();
  
  /**
   * Konstruktor klasy Stopnie.
   * @param okno okno glowne programu
   * @param tytul tytul okna
   * @param alleluja modal
   */
  public Stopnie(final JFrame okno, final String tytul, final boolean alleluja) {
	  super(okno, tytul, alleluja);
  }
  
  /**
   * Metoda wywolywana przy kliknieciu opcji konwersji stopni.
   */
  @Override
  public void actionPerformed(final ActionEvent event) {
    final JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2));
    
    textCel.addActionListener(new TextCelsjusz());
    textFah.addActionListener(new TextFahrenheit());
    przycisk.addActionListener(new Wyczysc());
    
    przycisk.setBackground(new java.awt.Color(0, 204, 204));
    
    panel.add(cel);
    panel.add(textCel);
    panel.add(fah);
    panel.add(textFah);
    panel.add(przycisk);
    
    add(panel);
    setSize(350, 150);
    setResizable(false);
    setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    setVisible(true);  
  }
  
  class TextCelsjusz extends KonwerterStopnie implements ActionListener {
    @Override
    public void actionPerformed(final ActionEvent event) {
      try {
        final double cel = Double.parseDouble(textCel.getText());
        final String s = Double.toString(celnafahr(cel));
        textFah.setText(s);  
      } catch (NumberFormatException n) {
        JOptionPane.showMessageDialog(null, "Nieprawidlowy format liczby", "", JOptionPane.ERROR_MESSAGE);
      }  
    }
  }
  
  class TextFahrenheit extends KonwerterStopnie implements ActionListener {
    @Override
    public void actionPerformed(final ActionEvent event) {
      try {
        final double cel = Double.parseDouble(textFah.getText());
        final String s = Double.toString(fahrnacel(cel));
        textCel.setText(s);  
      } catch (NumberFormatException n) {
        JOptionPane.showMessageDialog(null, "Nieprawidlowy format liczby", "", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
  
  class Wyczysc implements ActionListener {
	@Override
    public void actionPerformed(final ActionEvent event) {
      textCel.setText(null);
      textFah.setText(null);
    }
  }
}
