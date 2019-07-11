package data.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartyFileReader {

   private static PartyFileReader instance;

   private PartyFileReader(){}

   public static PartyFileReader getInstance() {
      if(instance == null){
         instance = new PartyFileReader();
      }
      return instance;
   }

   public Map<Integer, String> loadParticipants(){
      try(Stream<String> fileStream =
                Files.lines(Paths.get(getClass().getClassLoader().getResource("participants.txt").toURI()))){
         Map<Integer, String> partyParticipants = fileStream
               .map(fs -> fs.split(","))
               .collect(Collectors.toMap(fs -> Integer.parseInt(fs[0]), fs -> fs[1]));

         return partyParticipants;
      } catch(final URISyntaxException us){

      } catch(final IOException ioe){

      }
      return null;
   }

   public List<String> loadPartyFile(){
      try(Stream<String> fileStream =
                Files.lines(Paths.get(getClass().getClassLoader().getResource("party.txt").toURI()))){
         List<String> party = fileStream
               .collect(Collectors.toList());
         return party;
      } catch(final URISyntaxException us){

      } catch(final IOException ioe){

      }
      return null;
   }
}
