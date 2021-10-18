package konwerter_stopnie;

/**'
 * Klasa konwertujaca stopnie celsjusza na fahrenheita i odwrotnie.
 * @author swmar
 */
public abstract class KonwerterStopnie {
  /**przelicznik potrzebny do dzialan*/
  private static final double PRZELICZNIK = 1.8;
  
  /**
   * Metoda przeliczajaca stopnie celsjusza na fahrenheita.
   * @param celsjusz stopnie celsjusza
   * @return stopnie fahrenheita
   */
  public static double celnafahr(final double celsjusz) {
    return celsjusz * PRZELICZNIK+ 32;
  }
  
  /**
   * Metoda przeliczajaca stopnie celsjusza na fahrenheita.
   * @param fahrenheit stopnie fahrenheita
   * @return stopnie celsjusza
   */
  public static double fahrnacel(final double fahrenheit) {
    return (fahrenheit - 32) / PRZELICZNIK;
  }
}
