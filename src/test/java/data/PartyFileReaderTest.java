package data;

import data.util.PartyFileReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class PartyFileReaderTest {

   @Test
   public void participantsFileLoaderTest(){
      Map<Integer, String> participants = PartyFileReader.getInstance().loadParticipants();
      Assert.assertNotNull(participants);
   }

   @Test
   public void partyFileLoaderTest(){
      List<String> party = PartyFileReader.getInstance().loadPartyFile();
      Assert.assertNotNull(party);
   }
}
