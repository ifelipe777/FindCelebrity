package data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

public class PartyLoaderTest {

   @Test
   public void loadPartyTest(){
      PartyLoader.getInstance().loadParty(4);
      Assert.assertTrue(PartyLoader.getInstance().getParty().length > 0);
      Assert.assertTrue(!PartyLoader.getInstance().getPartyParticipants().isEmpty());
   }
}
