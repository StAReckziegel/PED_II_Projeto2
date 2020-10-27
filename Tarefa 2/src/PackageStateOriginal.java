public class PackageStateOriginal
{
    private String state;
    
    public PackageStateOriginal(String s) {
        this.state = s;
    }
    
    public boolean isValid() {
        // restricão: define qual é um estado válido
        // neste caso, é inválido se conter mais de 2 caracteres 'c'
        int c = 0;
        for (int i = 0; i < this.state.length(); i++) {
            if (this.state.charAt(i) == 'c') { 
                c++; 
            }
        }
        return c <= 2;
    }
   
    public double evaluate() {
        // avaliação: define uma função de valor para este estado, que
        // deve ser maximizada ou minimizada, dependendo do problema
        // neste caso, simplesmente adiciona pesos para cada caracter
        double r = 0;
        for (int i = 0; i < this.state.length(); i++) {
            if (this.state.charAt(i) == 'a') { r +=  2.1; }
            if (this.state.charAt(i) == 'b') { r += -1.5; }
            if (this.state.charAt(i) == 'c') { r +=  4.0; }
        }
        return r;
    }
    
    public String toString() {
        return this.state; 
    }
}

