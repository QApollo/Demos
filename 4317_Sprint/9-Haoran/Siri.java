/*
the demo for oca chp 1
get the input from keyboard and return accordingly responses
*/

//package statement
//import statements
import java.util.Random;

public class Siri{

  public static String responses[] = {"I don't understand the question.", "I like paperclips.", "Calling Mom...", "How do you mean 'can U be my girlfriend'?", "You seems sad.", "You know, I won't talk to you if had the option."};
  //some variable
  public static void main(String[] args){
    if (args.length > 0){
      Random randint = new Random();
      System.out.println(responses[randint.nextInt(responses.length)]);
  
      }
    }
  }
