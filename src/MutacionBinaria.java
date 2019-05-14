public class MutacionBinaria implements Mutacion<boolean[]> {
  @Override
  public boolean[] aplicar(boolean[] genoma) {
    int k = (int) (Math.random() * genoma.length);

    boolean[] copia = genoma.clone();

    copia[k] = !copia[k];

    return copia;
  }
}
