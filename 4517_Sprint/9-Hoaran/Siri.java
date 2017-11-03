/*
Demo for OCA chapter 4
1. this chapter is about the method design: Access modifier, optional specifier, return type, name, exceptions, body
2. private, default, protected, public
3. overload methods with different parameters, overload of constructors
4. encapsulation: private instance; is for boolean getter, get for getter, set for setter
5. Lambdas
*/

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Siri {
  public static void main(String[] args) {
    Random randomizer = new Random();

    Vocabulary words = new Vocabulary();
    words.initialize();
    List<String> verbs = words.getSubjects().stream().filter(x -> x.endsWith("s")).collect(Collectors.toList());
    List<String> objects = words.getObjects();
    List<String> subjects = words.getSubjects();

    Scanner sc = new Scanner(System.in);
    String input = "";
    String output = "";

      while(!input.equals("exit")) {
        input = sc.nextLine().trim().toLowerCase();
        if (input.length() != 0) {
          output = objects.get(randomizer.nextInt(objects.size()))
                          .concat(" ").concat(verbs.get(randomizer.nextInt(verbs.size())))
                          .concat(" ").concat(subjects.get(randomizer.nextInt(subjects.size())));
        }
        System.out.println(output + ".");
      }
  }
}
