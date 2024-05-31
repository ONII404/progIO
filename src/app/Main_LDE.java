package app;

import app.clases.ModeloFuenteFinita;
import app.clases.ModeloMultipleServidores;
import app.clases.ModeloUnServidor;
import java.util.Map;
import java.util.Scanner;

public class Main_LDE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona el modelo:");
        System.out.println("1. Modelo con un servidor");
        System.out.println("2. Modelo con multiples servidores");
        System.out.println("3. Modelo con fuente finita");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Introduce lambda (tasa de llegada):");
                double lam1 = scanner.nextDouble();
                System.out.println("Introduce mu (tasa de servicio):");
                double mu1 = scanner.nextDouble();
                System.out.println("Introduce el costo de espera (C_W):");
                double C_W1 = scanner.nextDouble();
                System.out.println("Introduce el costo de servicio (C_S):");
                double C_S1 = scanner.nextDouble();

                ModeloUnServidor modeloUnServidor = new ModeloUnServidor();

                System.out.println("Resultados:");
                for (Map.Entry<String, Double> entry : modeloUnServidor.calcular(lam1, mu1, C_W1, C_S1).entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }

                break;
            case 2:
                System.out.println("Introduce lambda (tasa de llegada):");
                double lam2 = scanner.nextDouble();
                System.out.println("Introduce mu (tasa de servicio):");
                double mu2 = scanner.nextDouble();
                System.out.println("Introduce el numero de servidores (s):");
                int s = scanner.nextInt();
                System.out.println("Introduce el costo de espera (C_W):");
                double C_W2 = scanner.nextDouble();
                System.out.println("Introduce el costo de servicio (C_S):");
                double C_S2 = scanner.nextDouble();

                ModeloMultipleServidores modeloMultipleServidores = new ModeloMultipleServidores();

                System.out.println("Resultados:");
                for (Map.Entry<String, Double> entry : modeloMultipleServidores.calcular(lam2, mu2, s, C_W2, C_S2).entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }

                break;
            case 3:
                System.out.println("Introduce lambda (tasa de llegada):");
                double lam3 = scanner.nextDouble();
                System.out.println("Introduce mu (tasa de servicio):");
                double mu3 = scanner.nextDouble();
                System.out.println("Introduce el numero de clientes en la fuente finita (N):");
                int N = scanner.nextInt();
                System.out.println("Introduce el costo de espera (C_W):");
                double C_W3 = scanner.nextDouble();
                System.out.println("Introduce el costo de servicio (C_S):");
                double C_S3 = scanner.nextDouble();

                ModeloFuenteFinita modeloFuenteFinita = new ModeloFuenteFinita();
                System.out.println();
                
                System.out.println("Resultados:");
                for (Map.Entry<String, Double> entry : modeloFuenteFinita.calcular(lam3, mu3, N, C_W3, C_S3).entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                
                
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

        scanner.close();
    }
}
