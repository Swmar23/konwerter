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
import konwerter_dlugosc.KonwerterDlugosc;

class Dlugosc extends JDialog implements ActionListener {
  
  private static final long serialVersionUID = -6584193364799386263L;
  private final transient JLabel cal = new JLabel("Cale", SwingConstants.CENTER);
  private final transient JLabel cm = new JLabel("Centymetry", SwingConstants.CENTER);
  
  private final transient JButton przycisk = new JButton("Wyczysc pola");
  private final transient JTextField textCal = new JTextField();
  private final transient JTextField textCm = new JTextField();
  
  public Dlugosc(final JFrame okno, final String tytul, final boolean a) {
    super(okno, tytul, a);
  }
  
  public void actionPerformed(final ActionEvent e) {    
    final JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2));
    
    textCal.addActionListener(new TextCal());
    textCm.addActionListener(new TextCm());
    przycisk.addActionListener(new Wyczysc());
    
    przycisk.setBackground(new java.awt.Color(0, 204, 204));
    
    panel.add(cal);
    panel.add(textCal);
    panel.add(cm);
    panel.add(textCm);
    panel.add(przycisk);
    
    add(panel);
    setSize(350, 150);
    setResizable(false);
    setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    setVisible(true);  
  }
  
  class TextCal extends KonwerterDlugosc implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      try {
        double cal = Double.parseDouble(textCal.getText());
        String s = Double.toString(calnacm(cal));
        textCm.setText(s);  
      } catch (NumberFormatException n) {
        JOptionPane.showMessageDialog(null, "Nieprawidlowy format liczby", "", JOptionPane.ERROR_MESSAGE);
      }  
    }
  }
  
  class TextCm extends KonwerterDlugosc implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      try {
        final double cm = Double.parseDouble(textCm.getText());
        String s = Double.toString(cmnacal(cm));
        textCal.setText(s);  
      } catch (NumberFormatException n) {
        JOptionPane.showMessageDialog(null, "Nieprawidlowy format liczby", "", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
  
  class Wyczysc implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      textCal.setText(null);
      textCm.setText(null);
    }
  }
}
