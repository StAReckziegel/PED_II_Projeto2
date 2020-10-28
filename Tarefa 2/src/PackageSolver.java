
import java.time.temporal.TemporalQueries;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author StAR
 */
public class PackageSolver {

    // contador de estados gerados
    public static int count = 0;
    public int precision = 3;
    private static Map<Integer, String> C = new TreeMap<>();
    private static Map<String, Item> N = new TreeMap<>();

    // registra o melhor estado encontrado até agora
    public static PackageState best = new PackageState("");

    public static void solve(double V, PackageState state) {
        double v = state.evaluate(N);

//        if (state.equals("aef"))
        // System.out.println(state + ":" + v);
        if (v > V || state.isValid() == false)
            // como estado não é válido, retorna imediatamente
            return;

        if (v == V) {
            // apenas serão gerados estados com 'level' caracteres

            alocate(state);

            System.out.println(state + "=" + state.evaluate(N));

            if (best.toString().equals(""))
                // 'best' deve ser inicializado com o primeiro estado criado
                best = state;
            if (state.evaluate(N) > best.evaluate(N))
                // se o estado atual é melhor, atualiza
                best = state;
            count++;
        } else
            // baseado no estado parcial atual, gera e testa diferentes variações
            for (String item : N.keySet())
                if (!N.get(item).alocated)
                    solve(V, new PackageState(state.toString() + item)); //            solve(V - 1, new PackageState(state.toString() + "a"));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // procura a melhor sequência com exatos 6 caracteres
        //double C[] = {200};
        //double N[] = {100, 100, 150, 50};
        N.put("a", new Item(100.0));
        N.put("b", new Item(100.0));
        N.put("c", new Item(180.0));
        N.put("d", new Item(50.0));
        N.put("e", new Item(25.0));
        N.put("f", new Item(175.0));
        N.put("g", new Item(24.900));
        

        // ab, ce, d
        long start = System.currentTimeMillis();
        PackageState pack = new PackageState("");

        double V = 200.00;
        for (double d = V; d > 0; d = decrement(d, .001)) {
//            System.out.println(d);
            solve(d, pack);
        }

        System.out.println();
        System.out.println("count: " + count);
        System.out.println("time : " + (System.currentTimeMillis() - start) / 1000.0 + " s");
        System.out.println("best : " + best + " [" + best.evaluate(N) + "]");
    }

    private static double decrement(double d, double p) {
        String s = String.valueOf(d - p);
//        System.out.print(String.valueOf(p).length()+"|"+s + " = ");
        int i = Math.min(s.indexOf(".") + String.valueOf(p).length()-1, s.length());
        d = Double.parseDouble(s.substring(0, i));

        return d;
    }

    private static void alocate(PackageState state) {
        String s = state.toString();
        for (int i = 0; i < s.length(); i++)
            N.get(String.valueOf(s.charAt(i))).alocated = true;
    }

}
