package lr2;

public class Work2 {
    public static void main(String[] args) {
        int n = 9; // Размер массива 9x9
        int[][] array = new int[n][n];
        int count = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { // Если строка четная, то заполняем слева направо
                for (int j = 0; j < n; j++) {
                    array[i][j] = count++;
                }
            } else { // Если строка нечетная, то заполняем справа налево
                for (int j = n - 1; j >= 0; j--) {
                    array[i][j] = count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
