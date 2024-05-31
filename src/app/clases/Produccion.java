package app.clases;

import java.text.DecimalFormat;

public class Produccion {
  
    // Variables a utilizar en el cálculo del ELS
  double Q, S, a, Sm, t, t1, t2, CT, D, H, d, h;

  // Constructor ELS con demanda constante
  public Produccion(double D, int tD, double S, double H, int tH, double a) {

    this.S = S;
    this.a = a;

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

    // Realizar cálculos
    calcularQ();
    calcularT();
    calcularT1();
    calcularT2();
    calcularSm();
    calcularCT();
    
    // Mostrar resultados
    mostrarResultados();
  }


  /**
   * 
   *  --- METODOS DE CALCULO ---
   * 
   * 
   */

  // Calculo de la cantidad optima de pedido
  void calcularQ() {
    this.Q = Math.sqrt((2 * S * D) / (H * (1 - (d / a))));
  }

  // Calculo del costo total anual
  void calcularCT() {
    this.CT = ((D / Q) * S) + ((Q / 2) * (1 - (d / a)) * H);
  }

  // Calculo del stock maximo
  void calcularSm() {
    this.Sm = Q - (t1 * d);
  }

    // Calculo del tiempo de produccion
  void calcularT() {
    this.t = Q / d;
  }

    // Calculo del tiempo de produccion y demanda
  void calcularT1() {
    this.t1 = Q / a;
  }

    // Calculo del tiempo de demanda
  void calcularT2() {
    this.t2 = (Q / d) - t1;
  }

  DecimalFormat df = new DecimalFormat("#.##");

  // Método para mostrar resultados
  void mostrarResultados() {
    System.out.println("Cantidad Optima de Pedido: " + df.format(Q));
    System.out.println("Tiempo de Produccion: " + df.format(t));
    System.out.println("Tiempo de Produccion y Demanda: " + df.format(t1));
    System.out.println("Tiempo de Demanda: " + df.format(t2));
    System.out.println("Stock Maximo: " + df.format(Sm));
    System.out.println("Costo Total Anual: " + df.format(CT));
  }


}
