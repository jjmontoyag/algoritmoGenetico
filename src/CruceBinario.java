public class CruceBinario implements Cruce<boolean[]> {
  @Override
  public boolean[][] aplicar(boolean[] individuo1, boolean[] individuo2) {
    boolean[][] hijos = new boolean[2][];

    hijos[0] = individuo1.clone();
    hijos[1] = individuo2.clone();

    int k = 1 + (int) (Math.random() * (individuo1.length - 1));

    System.arraycopy(individuo1,k,hijos[1],k,individuo1.length-k);
    System.arraycopy(individuo2,k,hijos[0],k,individuo2.length-k);

    return hijos;
  }
}
