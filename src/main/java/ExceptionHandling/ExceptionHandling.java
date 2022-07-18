package ExceptionHandling;

public class ExceptionHandling {

  public static void main(String[] args) {
    // example for custom exception
    try {
      int i = customExceptionHandling();
    } catch (MyException e) {
      System.out.println(e.getMessage());
    }

    // example for finally block
    try {
      int i = 1 / 0;
    } catch (ArithmeticException e) {
      System.out.println("ArithmeticException");
    } finally {
      System.out.println("finally");
    }
  }

  public static int customExceptionHandling() throws MyException {
    try {
      return 1 / 0;
    } catch (ArithmeticException e) {
      throw new MyException("This is an ArithmeticException");
    }
  }
}

// creating custom exception
class MyException extends Exception {
  public MyException(String message) {
    super(message);
  }
}
