package trabengIII.Interface;


public interface Sujeito {
    
    public void adicionar(Observador ob);
    public void remover(Observador ob);
    public int notificar();
}
