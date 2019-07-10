package party;

import data.PartyLoader;

public class FindCelebrity {

   public static void main(String args[]){
      PartyLoader loader = new PartyLoader();
      loader.loadParty(4);

      Integer celebrity = findTheCelebrity(loader.getParty());
   }

   private static Integer findTheCelebrity(final Integer[][] party){

      return 0;
   }
}
