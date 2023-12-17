import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        PreencherAleatorio preencherAleatorio = new PreencherAleatorio();
        Cronometro cronometro = new Cronometro();
        AlgoritmosOdenacao algoritmosOdenacao = new AlgoritmosOdenacao(); 

        List<Integer> lista = preencherAleatorio.criarLista(30000);
        List<Integer> listaAux = lista;


        System.out.println("\n***** Lista de " + lista.size() + " elementos *****");

        cronometro.iniciar();
        algoritmosOdenacao.bubbleSort(lista);
        long tempoDuracao = cronometro.parar();
        System.out.println("\n--> Ordenada em " + cronometro.obterTempo(tempoDuracao) + " usando o Bubble Sort");
        lista = listaAux;

        cronometro.iniciar();
        algoritmosOdenacao.selectionSort(lista);
        tempoDuracao = cronometro.parar();
        System.out.println("\n--> Ordenada em " + cronometro.obterTempo(tempoDuracao) + " usando o Selection Sort");
        lista = listaAux;

        cronometro.iniciar();
        algoritmosOdenacao.insertionSort(lista);
        tempoDuracao = cronometro.parar();
        System.out.println("\n--> Ordenada em " + cronometro.obterTempo(tempoDuracao) + " usando o Insertion Sort");
        lista = listaAux;

        cronometro.iniciar();
        algoritmosOdenacao.mergeSort(lista);
        tempoDuracao = cronometro.parar();
        System.out.println("\n--> Ordenada em " + cronometro.obterTempo(tempoDuracao) + " usando o Merge Sort");
        lista = listaAux;

        cronometro.iniciar();
        algoritmosOdenacao.quickSort(lista);
        tempoDuracao = cronometro.parar();
        System.out.println("\n--> Ordenada em " + cronometro.obterTempo(tempoDuracao) + " usando o Quick Sort");
        lista = listaAux;

        cronometro.iniciar();
        algoritmosOdenacao.countingSort(lista);
        tempoDuracao = cronometro.parar();
        System.out.println("\n--> Ordenada em " + cronometro.obterTempo(tempoDuracao) + " usando o Counting Sort");
        lista = listaAux;
    }
}