package app.clases;

import java.util.HashMap;
import java.util.Map;

public class ModeloFuenteFinita {
public Map<String, Double> calcular(double lam, double mu, int N, double C_W, double C_S) {
        double sumatoria = 0;
        for (int n = 0; n <= N; n++) {
            sumatoria += factorial(N) / factorial(N - n) * Math.pow(lam / mu, n);
        }
        double P0 = 1 / sumatoria;
        double rho = 1 - P0;
        double L = N - (mu / lam) * (1 - P0);
        double Lq = N - ((lam + mu) / lam) * (1 - P0);
        double W = L / (lam * (N - L));
        double Wq = Lq / (lam * (N - L));
        double Costo_Espera_Diario = L * C_S * 8;
        double Costo_Servicio_Diario = rho * C_W * 8;
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
