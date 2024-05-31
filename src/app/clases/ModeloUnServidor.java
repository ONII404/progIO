
package app.clases;

import java.util.HashMap;
import java.util.Map;


public class ModeloUnServidor {
     public Map<String, Double> calcular(double lam, double mu, double C_W, double C_S) {
        double rho = lam / mu;
        double P0 = 1 - rho;
        double L = lam / (mu - lam);
        double Lq = (Math.pow(lam, 2)) / (mu * (mu - lam));
        double W = 1 / (mu - lam);
        double Wq = lam / (mu * (mu - lam));
        double Costo_Total = Lq * C_W + C_S;

        Map<String, Double> resultados = new HashMap<>();
        resultados.put("rho", rho);
        resultados.put("P0", P0);
        resultados.put("L", L);
        resultados.put("Lq", Lq);
        resultados.put("W", W);
        resultados.put("Wq", Wq);
        resultados.put("Costo_Total", Costo_Total);

        return resultados;
    }
}
