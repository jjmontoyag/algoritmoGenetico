public class Main {
  public static void main(String[] args){
    genetico();
  }

  public static void ascenso(){
//    Función
    FuncionGlovito f = new FuncionGlovito(new int[] {0,0,1,1,1,0,0,1,0,1,0});

//  Punto inicial : aleatorio
    Glovito aleatorio = new Glovito();
    float fa = f.aplicar(aleatorio);

    TransformaGlovito transformador = new TransformaGlovito();
    MutacionBinaria mutacion = new MutacionBinaria();

    for(int i=0; i<10000; i++){
      System.out.println(aleatorio.toString() + fa);

//      Método de Selección

      boolean[] codigoAleatorio = transformador.codificar(aleatorio);
//      System.out.println(Util.mostrar(codigoAleatorio));

      boolean[] codigoMutado = mutacion.aplicar(codigoAleatorio);
//      System.out.println(Util.mostrar(codigoMutado));

      Glovito mutado = transformador.crecer(codigoMutado);
      float fm = f.aplicar(mutado);

      if(fm > fa){
        fa = fm;
        aleatorio = mutado;
      }
    }
  }

  public static void genetico(){
//    Función
    FuncionGlovito f = new FuncionGlovito(new int[] {0,0,1,1,1,0,0,1,0,1,0});

    TransformaGlovito transformador = new TransformaGlovito();
    MutacionBinaria mutacion = new MutacionBinaria();

    CruceBinario cruce = new CruceBinario();

    Seleccion seleccion = new Torneo();

    //  Punto inicial : población

    int tamano = 100;
    Glovito[] poblacion = new Glovito[tamano];
    float[] funciones = new float[tamano];


    for(int i =0; i<tamano; i++){
      poblacion[i] = new Glovito();
      funciones[i] = f.aplicar(poblacion[i]);
    }

    for(int i=0; i<10000; i++){
      System.out.println(estadisticas(funciones));

      int[] seleccionados = seleccion.aplicar(funciones,tamano);


      Glovito[] nuevaPoblacion = new Glovito[tamano];

      for(int k=0; k<tamano; k+=2){
        boolean[] codigo1 = transformador.codificar(poblacion[seleccionados[k]]);
        boolean[] codigo2 = transformador.codificar(poblacion[seleccionados[k+1]]);

        boolean[][] hijos = cruce.aplicar(codigo1,codigo2);

        hijos[0] = mutacion.aplicar(hijos[0]);
        hijos[1] = mutacion.aplicar(hijos[1]);

        nuevaPoblacion[k] = transformador.crecer(hijos[0]);
        nuevaPoblacion[k+1] = transformador.crecer(hijos[1]);

        funciones[k] = f.aplicar(nuevaPoblacion[k]);
        funciones[k+1] = f.aplicar(nuevaPoblacion[k+1]);
      }

      poblacion = nuevaPoblacion;
    }
  }

  public static String estadisticas(float[] x){
    int min = 0, max = 0;
    float promedio = x[0];

    for(int i=1;i<x.length;i++){
      promedio += x[i];
      if(x[i] < x[min]){
        min = i;
      }else if(x[max] < x[i]){
        max = i;
      }
    }

    return "" + x[min] + " " + x[max] + " " + (promedio/x.length);
  }
}
