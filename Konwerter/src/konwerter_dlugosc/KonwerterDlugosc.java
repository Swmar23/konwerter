package konwerter_dlugosc;

/**
 * Klasa konwertujaca centymetry na cale i odwrotnie.
 * @author swmar
 */
public abstract class KonwerterDlugosc {
  /**przelicznik potrzebny do dzialan*/
  private static final double PRZELICZNIK = 2.54;
  
  /**
   * Metoda przeliczajaca cale na centymetry.
   * @param cal dlugosc w calach
   * @return dlugosc w centymetrach
   */
  public static double calnacm(final double cal) {
    return cal * PRZELICZNIK;
  }
  /**
   * Metoda przeliczajaca centymetry na cale.
   * @param cm dlugosc w centymetrach
   * @return dlugosc w calach
   */
  public static double cmnacal(final double centymetr) {
    return centymetr / PRZELICZNIK;
  }
}
