package data;

import data.util.PartyFileReader;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartyLoader {

   private Map<Integer, String> partyParticipants;
   private Integer[][] party;

   private static PartyLoader instance;

   public static PartyLoader getInstance() {
      if(instance == null ){
         instance = new PartyLoader();
      }
      return instance;
   }

   private PartyLoader(){ }

   public Map<Integer, String> getPartyParticipants(){
      return partyParticipants;
   }

   public Integer[][] getParty(){
      return party;
   }

   public void loadParty(){

      partyParticipants = PartyFileReader.getInstance().loadParticipants();

      if(partyParticipants != null) {
         party = new Integer[partyParticipants.size()][partyParticipants.size()];
         for (int i = 0; i < partyParticipants.size(); i++) {
            for (int j = 0; j < partyParticipants.size(); j++)
               party[i][j] = 0;
         }

         fillParty(party);
      } else {
         Logger.getGlobal().log(Level.WARNING, "Error on party loading");
      }
   }

   private void fillParty(Integer[][] party){
      List<String> dataList = PartyFileReader.getInstance().loadPartyFile();
      for(String data : dataList){
         String[] partyMember = data.split(",");
         if(partyMember[0].equals(partyMember[1])){
            party[Integer.parseInt(partyMember[0]) - 1][Integer.parseInt(partyMember[1]) - 1] = 0;
         } else {
            party[Integer.parseInt(partyMember[0]) - 1][Integer.parseInt(partyMember[1]) - 1] = 1;
         }
      }
   }
}
