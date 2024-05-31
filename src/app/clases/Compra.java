package app.clases;

import java.text.DecimalFormat;

public class Compra {
    
    // Atributos Globales

    public double CT, Q, S, PR, L, n, Z, B, Sigma, SigmaL, d, h, H, D, N, t;


    // Constructor Compra con demanda constante
    public Compra(double D, int tD, double S, double H, int tH, double L) {

        this.S = S;
        this.L = L;

        // Seteo de D y d
        switch (tD) {
            case 1: // Diario
                this.d = D;
                this.D = D * 365;
                break;
            case 2: // Anual
                this.D = D;
                this.d = D / 365;
                break;
        }

        // Seteo de H y h
        switch (tH) {
            case 1: // Diario
                this.h = H;
                this.H = H * 365;
                break;
            case 2: // Anual
                this.H = H;
                this.h = H / 365;
                break;
        }

        // Calcular Q, t, N, R y C
        calcularQ();
        calcularT();
        calcularN();
        calcularPR();
        calcularCT();

        mostrarResultados();

    }


    // Constructor Compra con demanda variable
    public Compra(double Q, double L, double Z, double Sigma, double t) {
        this.Q = Q;
        this.L = L;
        this.Z = Z;
        this.t = t;
        this.Sigma = Sigma;

        calcularn();
        calcularSigmaL();
        calcularB();
        calculard();
        calcularPR();
        calcularN();
        calcularCT();

        this.Q += B;
        mostrarResultadosDemandaVariable();
    }


    /**
     * 
     * 
     *  --- METODOS DE LA CLASE ---
     * 
     * 
     */

    // Calcular la cantidad óptima de pedido Q
    void calcularQ() {
        this.Q = Math.sqrt((2 * S * D) / H);
    }

    // Calcular el número de pedidos al año N
    void calcularN() {
        this.N = D / Q;
    }

    // Calcular el tiempo de ciclo de pedidos t
    void calcularT() {
        this.t = Q / d;
    }

    // Calcular el punto de reorden
    void calcularPR() {
        if (L > t) {
            calcularn();
            this.PR = d * (L - (n * t));
        } else {
            this.PR = d * L;
        }
    }

    // Calcular el coste total anual
    void calcularCT() {
        this.CT = (S * D / Q) + (H * Q / 2);
    }

    // Calcular n
    void calcularn() {
        this.n = Math.floor(L / t);
    }

    // Calcular SigmaL
    void calcularSigmaL() {
        if (L > t) {
            this.SigmaL = Math.sqrt((L - (n * t)) * Math.pow(Sigma, 2));
        } else {
            this.SigmaL = Math.sqrt(L * Math.pow(Sigma, 2));
        }
    }

    // Calcular el stock de seguridad (B)
    void calcularB() {
        this.B = Z * SigmaL;
    }

    // Calcular demanda diaria
    void calculard() {
        this.d = Q / t;
        this.D = d * 365;
    }


    DecimalFormat df = new DecimalFormat("#.##");

    // Mostrar resultados para demanda constante
    void mostrarResultados() {
        System.out.println("\nCantidad Optima de Pedido (Q): " + df.format(Q));
        System.out.println("Tiempo de Ciclo (t): " + df.format(t));
        System.out.println("Número de Pedidos al Año (N): " + df.format(N));
        System.out.println("Punto de Reorden (PR): " + df.format(PR));
        System.out.println("Costo Total Anual (CT): " + df.format(CT));
    }

    // Mostrar resultados para demanda variable
    void mostrarResultadosDemandaVariable() {
        System.out.println("\nCantidad Optima de Pedido (Q): " + df.format(Q));
        System.out.println("Stock de Seguridad (B): " + df.format(B));
        System.out.println("Punto de Reorden (PR): " + df.format(PR));
        System.out.println("Tiempo de Ciclo (t): " + df.format(t));
        System.out.println("Número de Pedidos al Año (N): " + df.format(N));
        // System.out.println("Costo Total Anual (CT): " + df.format(CT));
        System.out.println("SigmaL: " + df.format(SigmaL));
        System.out.println("n: " + df.format(n));

    }


}
