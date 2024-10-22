/*4. Să se realizeze un program care citește numele si CNP-ul pe care îl au n persoane.
Valoarea lui n se citește de la tastatură. Programul va afișa informațiile introduse și în plus
pentru fiecare persoana va afișa vârsta. Cât timp un CNP-ul este introdus greșit programul va
cere reintroducerea acestuia. Pentru simplitate se consideră că CNP-ul este valid dacă
îndeplinește următoarele condiții:
        - Are 13 caractere
        - Toate caracterele sunt cifre
        - Prima cifră are una din valorile 1, 2, 5, 6
        - Cifra de control a CNP-ului are o valoare validă. */

package Pb4;

import java.util.Scanner;

public class Pb4_Main {
    public static int getControl(String cnp) {
        int sum = 0, control = 0;
        int[] num = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9}; //cifrele folosite in calculul cifrei de control
        int[] afterM = new int[12]; //rezultatele inmultirii

        for (int i = 0; i < 12; i++) {
            afterM[i] = num[i] * (cnp.charAt(i) - '0');
        }

        for (int elem : afterM)
            sum += elem;

        control = sum % 11;
        return control;
    }

    public static boolean isCnpValid(String cnp) {
        //Are 13 caractere
        if (cnp.length() != 13) return false;

        //Toate caracterele sunt cifre
        for (char c : cnp.toCharArray())
            if (!Character.isDigit(c)) return false;

        //Prima cifra: 1, 2, 5, 6
        if (cnp.charAt(0) != '1' && cnp.charAt(0) != '2' && cnp.charAt(0) != '5' && cnp.charAt(0) != '6') return false;

        //Cifra de control
        if (cnp.charAt(12) - '0' != getControl(cnp)) return false;

        return true;
    }

    public static void main(String[] args) {
        //Scanner pentru citirea de la tastatura
        Scanner sc = new Scanner(System.in);

        int n = 0; // numarul de persoane

        System.out.print("Numarul de persoane: ");
        n = sc.nextInt();

        Persoana []arrayPersoane = new Persoana[n]; //declaram un array de persoane cu n elemente

        for (int i = 0; i < n; i++) {
            arrayPersoane[i] = new Persoana();
            System.out.println("\nnPersoana " + (i + 1) + ": ");
            System.out.print("NUME: ");
            arrayPersoane[i].setNume(sc.next());
            do {
                System.out.print("CNP: ");
                arrayPersoane[i].setCnp(sc.next());
            } while (!isCnpValid(arrayPersoane[i].getCnp()));
        }

        System.out.println("Persoane introduse: ");
        for(Persoana p : arrayPersoane) {
            System.out.println(p.toString());
        }
    }
}
