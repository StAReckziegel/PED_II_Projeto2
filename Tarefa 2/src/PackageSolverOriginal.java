public class PackageSolverOriginal
{
    // contador de estados gerados
    public static int count = 0;
    
    // registra o melhor estado encontrado até agora
    public static PackageState best = new PackageState("");

    public static void solve(int level, PackageState state)
    {
        if (level == 0) {
            // apenas serão gerados estados com 'level' caracteres
            if (state.isValid() == false) {
                // como estado não é válido, retorna imediatamente
                return; 
            }
            System.out.println(state + "=" + state.evaluate());
            
            if (best.toString().equals("")) {
                // 'best' deve ser inicializado com o primeiro estado criado
                best = state;
            }
            if (state.evaluate() > best.evaluate()) {
                // se o estado atual é melhor, atualiza
                best = state;
            }
            count++; 
        }
        else {
            // baseado no estado parcial atual, gera e testa diferentes variações
            solve(level - 1, new PackageState(state.toString() + "a"));
            solve(level - 1, new PackageState(state.toString() + "b"));
            solve(level - 1, new PackageState(state.toString() + "c")); 
        }
    }
    
    public static void main(String[] args)
    {
        // procura a melhor sequência com exatos 6 caracteres
        long start = System.currentTimeMillis();
        solve(6, new PackageState(""));
        
        System.out.println();
        System.out.println("count: " + count);
        System.out.println("time : " + (System.currentTimeMillis() - start) / 1000.0 + " s");        
        System.out.println("best : " + best + " [" + best.evaluate() + "]");
    }
}

