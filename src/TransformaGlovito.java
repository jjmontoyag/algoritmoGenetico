public class TransformaGlovito implements Transforma<boolean[],Glovito> {
  @Override
  public boolean[] codificar(Glovito fenotipo) {
    boolean[] codigo = new boolean[24];

    //    k: bit que estamos construyendo
    int k = 0;

    for (int i=0; i<4; i++){
      for (int j=0; j<2; j++){
        codigo[k] = fenotipo.estados[i][j] > 1;
        k++;
        codigo[k] = (fenotipo.estados[i][j] % 2) == 1;
        k++;
        codigo[k] = fenotipo.salidas[i][j];
        k++;
      }
    }


    return codigo;
  }

  @Override
  public Glovito crecer(boolean[] genotipo) {
    int[][] estados = new int[4][2];
    boolean[][] salidas = new boolean[4][2];

    int k = 0;

    for (int i=0; i<4; i++){
      for (int j=0; j<2; j++){
        estados[i][j] = genotipo[k] ? 2 : 0;
        k++;
        estados[i][j] += genotipo[k] ? 1 : 0;
        k++;
        salidas[i][j] = genotipo[k];
        k++;
      }
    }

    return new Glovito(salidas, estados);
  }
}
