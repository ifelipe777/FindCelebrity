package data;

import data.util.PartyFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

   public void loadParty(final Integer partyAttendants){

      partyParticipants = PartyFileReader.getInstance().loadParticipants();

      party = new Integer[partyAttendants][partyAttendants];
      for(int i = 0; i < partyAttendants; i++){
         for(int j = 0; j < partyAttendants; j++)
            party[i][j] = 0;
      }

      fillParty(party);
   }

   private void fillParty(Integer[][] party){
      List<String> dataList = PartyFileReader.getInstance().loadPartyFile();
      for(String data : dataList){
         String[] partyMember = data.split(",");
         party[Integer.parseInt(partyMember[0])- 1][Integer.parseInt(partyMember[1]) - 1] = 1;
      }
   }
}
