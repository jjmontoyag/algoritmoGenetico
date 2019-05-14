public class FuncionGlovito implements Funcion<Glovito> {
  private boolean[] entrada;

  public FuncionGlovito(int[] entrada){
    this.entrada = new boolean[entrada.length];

    for (int i=0; i<entrada.length;i++){
      this.entrada[i] = entrada[i] > 0;
    }
  }

  @Override
  public float aplicar(Glovito individuo) {
    boolean[] resultado = individuo.simular(this.entrada);

    int cuenta = 0;

    for(int i=0; i<entrada.length-1;i++){
      if(entrada[i+1] == resultado[i]){
        cuenta++;
      }
    }

    return cuenta;
  }
}
