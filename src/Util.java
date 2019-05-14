public class Util {
  public static String mostrar(boolean[] x){
    StringBuilder sb = new StringBuilder();

    for (int i=0; i<x.length;i++){
      sb.append(x[i]?1:0);
    }

    return sb.toString();
  }
}
