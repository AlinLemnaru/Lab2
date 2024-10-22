/*3. Să se insereze într-o anumită poziție a unui șir de caractere, un alt șir. Datele vor fi
preluate de la tastatură sau din fișier. Să se șteargă o porțiune a unui șir de caractere care
începe dintr-o anumită poziție și are un anumit număr de caractere. Se recomandă utilizarea
clasei StringBuilder.*/

package Pb3;

import java.util.Scanner;

public class Pb3_Main {
    public static void main(String[] args) {
        //Scanner citire tastatura
        Scanner sc = new Scanner(System.in);

        //Declaratii
        String sir1, sir2;
        int pozitieInserare, pozitieStergere, nrCaractereStergere;

        System.out.print("sir1: ");
        sir1 = sc.nextLine();

        System.out.print("sir2: ");
        sir2 = sc.nextLine();

        System.out.print("pozitieInserare: ");
        pozitieInserare = sc.nextInt();

        StringBuilder sb = new StringBuilder(sir1);
        sb.insert(pozitieInserare, sir2);
        sir1 = sb.toString();

        System.out.println("\nsir1: " + sir1);

        System.out.print("PozitieStergere: ");
        pozitieStergere = sc.nextInt();

        System.out.print("NrCaractereStergere: ");
        nrCaractereStergere = sc.nextInt();

        sb.delete(pozitieStergere, pozitieStergere + nrCaractereStergere);
        sir1 = sb.toString();
        System.out.println("\nsir1: " + sir1);
    }
}
