package WebApp.entity;

import java.util.function.BiFunction;

public class Calculator {

  private int toInt(String orig) {
    return Integer.parseInt(orig);
  }

  public String doOperation(String xs, String ys, String ops) {
    String res;
    try {
      int x = toInt(xs);
      int y = toInt(ys);
      int r = doParse(x, y, ops);
      res = String.valueOf(r);
    } catch (NumberFormatException x) {
      res = "The number is in wrong format";
    } catch (IllegalArgumentException x) {
      res = x.getMessage();
    } catch (ArithmeticException x) {
      res = "Division by zero caught!";
    } catch (Exception x) {
      res = String.format("Something went wrong %s", x.getMessage());
    }
    return res;
  }

  private int doCore(int x, int y, BiFunction<Integer, Integer, Integer> f) {
    return f.apply(x, y);
  }

  private int doParse(int x, int y, String ops) {
    switch (ops) {
      case "add": return doCore(x, y, (a, b) -> a + b);
      case "sub": return doCore(x, y, (a, b) -> a - b);
      case "mul": return doCore(x, y, (a, b) -> a * b);
      case "div": return doCore(x, y, (a, b) -> a / b);
      default: throw new IllegalArgumentException("Wrong operation");
    }
  }

}
