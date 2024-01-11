import java.util.List;

public class QuickSortLomuto {

    public static int quickSort(List<Integer> lista, int inicio, int fim) {
        if (inicio < fim) {
            int indiceParticao = particionarLomuto(lista, inicio, fim);

            quickSort(lista, inicio, indiceParticao - 1);
            quickSort(lista, indiceParticao + 1, fim);
        }
        return fim;
    }

    private static int particionarLomuto(List<Integer> lista, int inicio, int fim) {
        int pivo = lista.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j <= fim - 1; j++) {
            if (lista.get(j) < pivo) {
                i++;
                trocarElementos(lista, i, j);
            }
        }

        trocarElementos(lista, i + 1, fim);
        return i + 1;
    }

    private static void trocarElementos(List<Integer> lista, int indice1, int indice2) {
        int temp = lista.get(indice1);
        lista.set(indice1, lista.get(indice2));
        lista.set(indice2, temp);
    }
}
