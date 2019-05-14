public class Torneo implements Seleccion {
  public int aplicar(float[] adaptabilidades){
//    Enfoque aleatorio-elitista
    int k = (int) (Math.random() * adaptabilidades.length);

    for(int i=0; i<3; i++){
      int j = (int) (Math.random() * adaptabilidades.length);

      if(adaptabilidades[j] >= adaptabilidades[k]){
        k = j;
      }

    }
    return k;
  }

  @Override
  public int[] aplicar(float[] adaptabilidades, int sujetos) {
    int[] seleccionados = new int[sujetos];

    for(int i=0; i<sujetos; i++){
      seleccionados[i] = aplicar(adaptabilidades);
    }

    return seleccionados;
  }
}
