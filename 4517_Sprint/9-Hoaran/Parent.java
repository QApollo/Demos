public class Parent {
  public void print(){
    System.out.println("parent");
  }

  public void racecar(){
    System.out.println("Haoran is smart");
  }

  public static void main(String[] args){
    Parent bcd = new Parent();
    Child child = new Child();
    Parent abc = new Child();
    abc.print();
    child.print();
    abc.racecar();
    bcd.print();
  }
}

class Child extends Parent{
  public void print(){
    System.out.println("child");
  }
  public void potatosalad(){
    System.out.println("Haoran is dom");
  }

}
