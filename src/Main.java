import Controllers.CheckConvert;
import Models.CashModel;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        CheckConvert checkConvert = new CheckConvert();  // Instancia da classe que consulta a API

        System.out.println("\nDiga a PRIMEIRA moeda vc quer COMPARAR (ex: USD, EUR, BRL): ");
        String moeda = leitura.nextLine();

        System.out.println();

        try {
            CashModel cashModel = checkConvert.consultationChange(); // Faz a consulta das taxas de câmbio na API

            double tempTaxa = cashModel.findCoin(moeda); // Busca a taxa de cambio da moeda inserida
            double tempconvertII = 1 / tempTaxa;
            String convertII = Double.toString(tempconvertII).substring(0,5);
            String taxa = Double.toString(tempTaxa).substring(0,5);


            System.out.println("\n========================= CONVERSÃO =========================");
            System.out.println("                 1" + " = " + taxa + " " + moeda.toUpperCase() + " | " + convertII +" " + "= 1 " + moeda.toUpperCase());
            System.out.println("=============================================================");

            System.out.println("============== CONVERSÃO REALIZADA COM SUCESSO ==============");

        } catch (NoSuchElementException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("\nFinalizando a aplicação");
        }

    }
}
