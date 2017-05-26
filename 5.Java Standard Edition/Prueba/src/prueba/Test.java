package prueba;

abstract class primera {
    int x;
    public primera() {
        x = 8;
    }
    public abstract void imprimir();
    public abstract void incrementar();
}
class segunda extends primera {
    public void imprimir() {
        x = 10;
            System.out.println(x +"-");
    }
    public void incrementar() {
        x++;
    }
}
