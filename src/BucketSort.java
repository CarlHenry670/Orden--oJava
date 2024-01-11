import java.util.ArrayList;
import java.util.List;

public class BucketSort {
    public static List<Integer> bucketSort(List<Integer> lista, String metodoInterno) {
        int numeroDeBaldes = 10;
        List<List<Integer>> baldes = new ArrayList<>();

        // Inicializa os baldes
        for (int i = 0; i < numeroDeBaldes; i++) {
            baldes.add(new ArrayList<>());
        }

        // Distribui os elementos nos baldes
        for (Integer num : lista) {
            int indice = num * numeroDeBaldes / 500; // Ajuste conforme a faixa de valores
            baldes.get(indice).add(num);
        }

        // Ordena cada balde usando o método interno
        for (List<Integer> balde : baldes) {
            switch (metodoInterno) {
                case "bubblesor":
                    Dados.bubbleSort(balde);
                    break;
                case "Selection Sort":
                    Dados.selectionSort(balde);
                    break;
                case "Insertion Sort":
                    Dados.insertionSort(balde);
                    break;
                case "Merge Sort":
                    Dados.mergeSort(balde);
                    break;
                case "Quick Sort":
                    Dados.quickSort(balde);
                    break;
                    case "Counting Sort":
                    Dados.countingSort(balde);
            }
        }

        // Concatena os baldes ordenados
        List<Integer> listaOrdenada = new ArrayList<>();
        for (List<Integer> balde : baldes) {
            listaOrdenada.addAll(balde);
        }

        return listaOrdenada;
    }

    public static void main(String[] args) {
        int tamanhoLista = 200000;
        List<Integer> numerosNaoOrdenados = PreencherAleatorio.criarLista(tamanhoLista);

        testarOrdenacaoBucketSort("Bubble Sort", new ArrayList<>(numerosNaoOrdenados), "bubblesor");
        testarOrdenacaoBucketSort("Selection Sort", new ArrayList<>(numerosNaoOrdenados), "Selection Sort");
        testarOrdenacaoBucketSort("Insertion Sort", new ArrayList<>(numerosNaoOrdenados), "Insertion Sort");
        testarOrdenacaoBucketSort("Merge Sort", new ArrayList<>(numerosNaoOrdenados), "Merge Sort");
        testarOrdenacaoBucketSort("Quick Sort", new ArrayList<>(numerosNaoOrdenados), "Quick Sort");
        testarOrdenacaoBucketSort("Counting Sort", new ArrayList<>(numerosNaoOrdenados), "Counting Sort");
    }

    private static void testarOrdenacaoBucketSort(String metodo, List<Integer> numeros, String metodoInterno) {
        Cronometro cronometro = new Cronometro();
        cronometro.iniciar();

        List<Integer> listaOrdenada = BucketSort.bucketSort(numeros, metodoInterno);

        long tempoDecorrido = cronometro.parar();
        System.out.println("Método de ordenação: Bucket Sort (" + metodo + ")");
        System.out.println("Tempo decorrido: " + cronometro.obterTempo(tempoDecorrido));
        System.out.println("******************************************************");
    }
}
