/*1. Fișierul judete_in.txt, conține lista neordonată a județelor din țară. Să se încarce
datele din fișier într-un tablou de String-uri și să se ordoneze acest tablou cu ajutorul metodei
sort() din clasa Arrays. Să se returneze pe ce poziție se află în vectorul ordonat un județ
introdus de la tastatură. Se va utiliza metoda de căutare binară din clasa Arrays.*/

package Pb1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Pb1_Main {
    public static void main(String[] args) throws IOException {
        //Scanner citire de la tastatura
        Scanner sc = new Scanner(System.in);

        //Citirea din fisierul "judete_in.txt"
        String nume_fisier = "judete_in.txt";
        BufferedReader br = new BufferedReader(new FileReader(nume_fisier));
        String line;

        //Declaratii
        String[] judete;
        String judetCaut;
        int pozitieJudCaut = 0;

        if ((line = br.readLine()) == null) {
            System.out.println("\nFisierul este gol!\n");
            return;
        }

        judete = line.split(",");

        System.out.println("Judete:");
        for (String s : judete)
            System.out.println(s);

        Arrays.sort(judete);

        System.out.println("\nJudete ordonate:");
        for (String s : judete)
            System.out.println(s);

        System.out.print("\nJudetul cautat: ");
        judetCaut = sc.nextLine();

        pozitieJudCaut = Arrays.binarySearch(judete, judetCaut);
        if (pozitieJudCaut >= 0)
            System.out.println("\nPozitie judet cautat: " + pozitieJudCaut);
        else
            System.out.println("\nJudetul cautat nu se afla in lista");
    }
}
