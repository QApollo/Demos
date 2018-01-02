
import java.util.*;
import java.io.*;

 public class Vocabulary {

   private List<String> subjects = new ArrayList<>();
   private List<String> verbs = new ArrayList<>();
   private List<String> objects = new ArrayList<>();
   private File fileVerb = new File("verbs.txt");
   private File fileNouns = new File("nouns.txt");

   public List<String> getSubjects(){
     return this.subjects;
   }

   public List<String> getVerbs(){
     return this.verbs;
   }

   public List<String> getObjects(){
     return this.objects;
   }


   public void initialize() {
        String line = null;
       try(BufferedReader readerVerb = new BufferedReader(new FileReader(fileVerb)); BufferedReader readerNouns = new BufferedReader(new FileReader(fileNouns))) {
         while ((line = readerVerb.readLine()) != null) {
          verbs.add(line);
          }
        while ((line = readerNouns.readLine()) != null) {
         subjects.add(line);
         objects.add(line);
         }
        } catch (IOException x) {
          System.err.format("IOException: %s%n", x);
        }
      }




   public Vocabulary (){
   }



 }
