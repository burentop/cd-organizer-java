import org.junit.*;
import static org.junit.Assert.*;

public class CDTest {

  @Test
  public void CD_instantiatesCorrectly_true() {
    CD myCD = new CD("Floodplain", "Sara Groves", 2015, "CCM");
    assertEquals(true, myCD instanceof CD);
  }
}
