public class main {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(sum(a, b));
    }
}