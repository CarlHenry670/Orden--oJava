import java.util.List;

public class App {
    public static void main(String[] args) {
        testarQuickSortHoare();
        testarQuickSortLomuto();
    }

    private static void testarQuickSortHoare() {
        System.out.println("Testando QuickSort com Particionamento de Hoare:");

        for (int tamanho : new int[]{100, 500, 1000, 5000, 30000, 80000, 100000, 150000, 200000}) {
            List<Integer> lista = PreencherAleatorio.criarLista(tamanho);

            Cronometro cronometro = new Cronometro();
            cronometro.iniciar();

            int trocas = QuickSortHoare.quickSort(lista, 0, lista.size() - 1);

            long tempoDecorrido = cronometro.parar();

            System.out.printf("Tamanho: %d - Trocas: %03d - Tempo: %d ms%n", tamanho, trocas, tempoDecorrido);

        }
    }

    private static void testarQuickSortLomuto() {
        System.out.println("\nTestando QuickSort com Particionamento de Lomuto:");

        for (int tamanho : new int[]{100, 500, 1000, 5000, 30000, 80000, 100000, 150000, 200000}) {
            List<Integer> lista = PreencherAleatorio.criarLista(tamanho);

            Cronometro cronometro = new Cronometro();
            cronometro.iniciar();

            int trocas = QuickSortLomuto.quickSort(lista, 0, lista.size() - 1);

            long tempoDecorrido = cronometro.parar();

            System.out.printf("Tamanho: %d - Trocas: %03d - Tempo: %d ms%n", tamanho, trocas, tempoDecorrido);

        }
    }
}
