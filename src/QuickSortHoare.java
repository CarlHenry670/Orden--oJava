import java.util.List;

public class QuickSortHoare {

    public static int quickSort(List<Integer> lista, int inicio, int fim) {
        if (inicio < fim) {
            int[] resultado = particionarHoare(lista, inicio, fim);

            int indiceParticao = resultado[0];
            int trocas = resultado[1];

            trocas += quickSort(lista, inicio, indiceParticao);
            trocas += quickSort(lista, indiceParticao + 1, fim);

            return trocas;
        }
        return 0;
    }

    private static int[] particionarHoare(List<Integer> lista, int inicio, int fim) {
        int pivo = lista.get(inicio);
        int i = inicio - 1;
        int j = fim + 1;
        int trocas = 0;

        while (true) {
            do {
                i++;
            } while (lista.get(i) < pivo);

            do {
                j--;
            } while (lista.get(j) > pivo);

            if (i >= j) {
                int[] resultado = { j, trocas };
                return resultado;
            }

            trocarElementos(lista, i, j);
            trocas++;
        }
    }

    private static void trocarElementos(List<Integer> lista, int indice1, int indice2) {
        int temp = lista.get(indice1);
        lista.set(indice1, lista.get(indice2));
        lista.set(indice2, temp);
    }
}
