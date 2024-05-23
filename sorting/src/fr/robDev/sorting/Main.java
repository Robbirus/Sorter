package fr.robDev.sorting;

import java.util.Random;

public class Main {

    static void bubbleSort(int[] tab){
        //tri a bulle
        int taille = tab.length;
        int save = 0;
        for(int i = 0; i<taille; i++){
            for(int j = 1; j<taille; j++){
                if(tab[j-1] > tab[j]){
                    //echange des elements
                    save = tab[j-1];
                    tab[j-1] = tab[j];
                    tab[j] = save;
                }
            }
        }
    }

    static void optiBubble(int[] tab){
        //tri a bulle optimiser
        int taille = tab.length;
        int save = 0;

        for(int i = 0; i<taille; i++){
            boolean tabSorted = true;

            for(int j = 1; j<taille; j++){

                if(tab[j-1] > tab[j]){
                    //echange des elements
                    save = tab[j-1];
                    tab[j-1] = tab[j];
                    tab[j] = save;
                    tabSorted = false;
                }
            }

            if(tabSorted){
                break;
            }
        }
    }

    static void insertSort(int[] tab){

        int taille = tab.length;
        int x;
        int j;

        for(int i = 0; i<taille; i++){
            //mémoire de tab[i] dans x
            x = tab[i];

            //Décaler les éléments tab[0]...tab[i-1] qui sont plus grands que x, en partant de tab[i-1]
            j = i;
            while(j > 0 && tab[j-1] > x){
                tab[j] = tab[j-1];
                j -= 1;
            }

            //Placer x dans le "trou" laissé par le décalage
            tab[j] = x;
        }
    }

    static void selectSort(int[] tab){
        int n = tab.length;
        int min;

        for(int i = 0; i<n-2; i++){
            min = i;

            for(int j = i+1; j<n-1;j++){
                if(tab[j]<tab[min]){
                    min=j;
                }
            }

            if(min != i){
                int save = tab[i];
                tab[i] = tab[min];
                tab[min] = save;
            }
        }
    }

    static int findMe(int[] tab, int target, int start, int end){

        if(end < start){
            return -1;
        }

        int middle = end + ((start - end)/2);

        if(tab[middle] == target){
            return middle;
        }
        else if(tab[middle] > target){
            return findMe(tab, target, start, middle-1);
        }
        else{
            return findMe(tab, target, middle+1, end);
        }
    }

    static void displayTab(int[] tab){

        System.out.println("==========================================================");
        for(int i = 0; i< tab.length; i++){
            System.out.println("La valeur a l'indice: " + i + " est égale à: " + tab[i]);
        }
    }

    public static void main(String[] args) {

        int[] tab = new int[10];

        for(int i = 0; i < 10; i++){

            Random random = new Random();
            int nb = random.nextInt(10);

            tab[i] = nb;
        }

        long before = System.currentTimeMillis();

        /*
        System.out.println("Tri à bulle optimisé");
        optiBubble(tab);

        displayTab(tab);

        System.out.println("Tri à bulle");
        bubbleSort(tab);

        displayTab(tab);

        System.out.println("Tri à Sélection");
        selectSort(tab);

        displayTab(tab);

        System.out.println("Tri par insertion");
        insertSort(tab);

        displayTab(tab);
        */

        int n = findMe(tab, 3, 0, 9);

        long after = System.currentTimeMillis();

        if(n < 0){
            System.out.println("Cible non trouvé");
        }else{
            System.out.println("Cible trouvé à l'index: " + n);
        }

        System.out.println("Ce tri a mis: " + (after - before) + " ms");

    }
}