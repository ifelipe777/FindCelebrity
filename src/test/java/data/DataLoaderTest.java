package data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

@RunWith(JUnit4ClassRunner.class)
public class DataLoaderTest {

   @Test
   public void loadPartyTest(){
      PartyLoader loader = new PartyLoader();
      loader.loadParty(4);
      Assert.assertTrue(loader.getParty().length > 0);
   }
}
