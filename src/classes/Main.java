package src.classes;

public class Main {
  public static void main(String[] args) {

    Cookie test1 = new Cookie("red");
    Cookie test2 = new Cookie("blue");

    System.out.println(test1.getColor());
    test1.setColor("Purple");

    System.out.println(test1.getColor());
  }
}
