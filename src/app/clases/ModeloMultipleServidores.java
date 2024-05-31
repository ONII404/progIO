package app.clases;

import java.util.HashMap;
import java.util.Map;

public class ModeloMultipleServidores {

   public Map<String, Double> calcular(double lam, double mu, int s, double C_W, double C_S) {
        double rho = lam / (s * mu);

        double sumatoria = 0;
        for (int n = 0; n < s; n++) {
            sumatoria += Math.pow(lam / mu, n) / factorial(n);
        }
        double P0 = 1 / (sumatoria + Math.pow(lam / mu, s) / (factorial(s) * (1 - rho)));
        double Lq = (Math.pow(lam / mu, s) * rho * P0) / (factorial(s) * Math.pow(1 - rho, 2));
        double L = Lq + lam / mu;
        double Wq = Lq / lam;
        double W = Wq + (mu == 1 ? 0 : 1 / mu);
        double Costo_Espera_Diario = L * C_W;
        double Costo_Servicio_Diario = s * C_S;
        double Costo_Total = Costo_Espera_Diario + Costo_Servicio_Diario;

        Map<String, Double> resultados = new HashMap<>();
        resultados.put("rho", rho);
        resultados.put("P0", P0);
        resultados.put("L", L);
        resultados.put("Lq", Lq);
        resultados.put("W", W);
        resultados.put("Wq", Wq);
        resultados.put("Costo_Espera_Diario", Costo_Espera_Diario);
        resultados.put("Costo_Servicio_Diario", Costo_Servicio_Diario);
        resultados.put("Costo_Total", Costo_Total);

        return resultados;
    }

    private int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
