package lr4;

public class Example12 {
    public static class Main {
        public static void m(String str, double chislo) {
            try {
                if (str == null) {
                    throw new IllegalArgumentException("Строка введена неверно");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            try{
                if (chislo > 0.001) {
                    throw new IllegalArgumentException("Неверное число");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        public static void main(String[] args) {
            m(null, 0.000001);
        }
    }
}
