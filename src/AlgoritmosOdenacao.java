import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlgoritmosOdenacao {

    public static List<Integer> bubbleSort(List<Integer> lista) {
        int tamanho = lista.size();

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    int auxiliar = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, auxiliar);
                }
            }
        }

        return lista;
    }

    public static List<Integer> selectionSort(List<Integer> lista) {
        int tamanho = lista.size();

        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMenorValor = i;

            for (int j = i + 1; j < tamanho; j++) {
                if (lista.get(j) < lista.get(indiceMenorValor)) {
                    indiceMenorValor = j;
                }
            }

            int auxiliar = lista.get(indiceMenorValor);
            lista.set(indiceMenorValor, lista.get(i));
            lista.set(i, auxiliar);
        }

        return lista;
    }

    public static List<Integer> insertionSort(List<Integer> lista) {
        int tamanho = lista.size();

        for (int i = 1; i < tamanho; i++) {
            int valorAtual = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j) > valorAtual) {
                lista.set(j + 1, lista.get(j));
                j--;
            }

            lista.set(j + 1, valorAtual);
        }

        return lista;
    }

    public static List<Integer> mergeSort(List<Integer> lista) {
        int tamanho = lista.size();

        if (tamanho < 2) {
            return lista;
        }

        int meio = tamanho / 2;

        List<Integer> listaEsquerda = new ArrayList<>(lista.subList(0, meio));
        List<Integer> listaDireita = new ArrayList<>(lista.subList(meio, tamanho));

        mergeSort(listaEsquerda);
        mergeSort(listaDireita);

        merge(lista, listaEsquerda, listaDireita);

        return lista;
    }

    private static void merge(List<Integer> lista, List<Integer> listaEsquerda, List<Integer> listaDireita) {
        int tamanhoListaEsquerda = listaEsquerda.size();
        int tamanhoListaDireita = listaDireita.size();

        int indiceListaEsquerda = 0;
        int indiceListaDireita = 0;
        int indiceLista = 0;

        while (indiceListaEsquerda < tamanhoListaEsquerda && indiceListaDireita < tamanhoListaDireita) {
            if (listaEsquerda.get(indiceListaEsquerda) <= listaDireita.get(indiceListaDireita)) {
                lista.set(indiceLista, listaEsquerda.get(indiceListaEsquerda));
                indiceListaEsquerda++;
            } else {
                lista.set(indiceLista, listaDireita.get(indiceListaDireita));
                indiceListaDireita++;
            }

            indiceLista++;
        }

        while (indiceListaEsquerda < tamanhoListaEsquerda) {
            lista.set(indiceLista, listaEsquerda.get(indiceListaEsquerda));
            indiceListaEsquerda++;
            indiceLista++;
        }

        while (indiceListaDireita < tamanhoListaDireita) {
            lista.set(indiceLista, listaDireita.get(indiceListaDireita));
            indiceListaDireita++;
            indiceLista++;
        }
    }

    public static void quickSort(List<Integer> lista) {
        Stack<Integer> pilha = new Stack<>();
        pilha.push(0);
        pilha.push(lista.size() - 1);

        while (!pilha.isEmpty()) {
            int fim = pilha.pop();
            int inicio = pilha.pop();

            int indicePivo = particionar(lista, inicio, fim);

            if (indicePivo - 1 > inicio) {
                pilha.push(inicio);
                pilha.push(indicePivo - 1);
            }

            if (indicePivo + 1 < fim) {
                pilha.push(indicePivo + 1);
                pilha.push(fim);
            }
        }
    }

    private static int particionar(List<Integer> lista, int inicio, int fim) {
        int pivo = lista.get(fim);
        int indicePivo = inicio - 1;

        for (int indiceAtual = inicio; indiceAtual < fim; indiceAtual++) {
            if (lista.get(indiceAtual) <= pivo) {
                indicePivo++;
                trocarElementos(lista, indicePivo, indiceAtual);
            }
        }

        trocarElementos(lista, indicePivo + 1, fim);

        return indicePivo + 1;
    }

    private static void trocarElementos(List<Integer> lista, int indiceA, int indiceB) {
        int temp = lista.get(indiceA);
        lista.set(indiceA, lista.get(indiceB));
        lista.set(indiceB, temp);
    }

    public static List<Integer> countingSort(List<Integer> lista) {
        int tamanho = lista.size();
        int maiorValor = lista.get(0);

        for (int i = 1; i < tamanho; i++) {
            if (lista.get(i) > maiorValor) {
                maiorValor = lista.get(i);
            }
        }

        int[] listaAuxiliar = new int[maiorValor + 1];

        for (int i = 0; i < tamanho; i++) {
            listaAuxiliar[lista.get(i)]++;
        }

        int indiceLista = 0;

        for (int i = 0; i < listaAuxiliar.length; i++) {
            while (listaAuxiliar[i] > 0) {
                lista.set(indiceLista, i);
                indiceLista++;
                listaAuxiliar[i]--;
            }
        }

        return lista;
    }

}