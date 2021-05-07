public class argsSum {
  public static void main(String[] args) {
    int sum = 0;
    for (int i = 0; i < args.length; i += 1) {
      sum += Integer.parseInt(args[i]);
    }
    System.out.println(sum);
  }
}
