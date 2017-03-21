import org.junit.*;
import static org.junit.Assert.*;

public class CDTest {

  @Test
  public void CD_instantiatesCorrectly_true() {
    CD myCD = new CD("Floodplain", "Sara Groves", 2015, "CCM");
    assertEquals(true, myCD instanceof CD);
  }

  @Test
  public void CD_instantiatesWithInfoDetail_true() {
    CD myCD = new CD("Floodplain", "Sara Groves", 2015, "CCM");
    String cdDetail = "Floodplain, by Sara Groves\nGenre: CCM, 2015\n";
    assertEquals(cdDetail, myCD.getInfo());
  }
}
