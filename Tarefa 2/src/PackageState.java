
import java.util.Map;

public class PackageState {
    
    private String state;
    private Map<Integer, String> containers;
    private Map<String, Item> items;
    
    public void setContainers(Map containers) {
        this.containers = containers;
    }
    
    public void setItems(Map items) {
        this.items = items;
    }
    
    public PackageState(String s) {
        this.state = s;
    }
    
    public boolean isValid() {
        // restricão: define qual é um estado válido
        // neste caso, é inválido se conter mais de 2 caracteres 'c'
        int c = 0;
        for (int i = 0; i < this.state.length() - 1; i++) {
            String l = String.valueOf(this.state.charAt(i));
//            if (state.equals("aef"))
//                System.out.println(i + state + "|" + l);
            if (this.state.substring(i + 1).contains(l))
                return false;
        }
        return true;
    }
    
    public double evaluate(Map<String, Item> item) {
        // avaliação: define uma função de valor para este estado, que
        // deve ser maximizada ou minimizada, dependendo do problema
        // neste caso, simplesmente adiciona pesos para cada caracter
        double r = 0;
        for (int i = 0; i < this.state.length(); i++) {
            String letra = String.valueOf(this.state.charAt(i));
            r += item.get(letra).volume;
        }
        return r;
    }
    
    public String toString() {
        return this.state;
    }
}
