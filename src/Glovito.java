public class Glovito {
  protected boolean[][] salidas;
  protected int[][] estados;

  public Glovito(){
    this.salidas = new boolean[4][2];
    this.estados = new int[4][2];

    for (int i=0; i<4; i++){
      for (int j=0; j<2; j++){
        this.salidas[i][j] = Math.random() < 0.5;
        this.estados[i][j] = (int) (Math.random() * 4.0);
      }
    }
  }

//  Usar variables frescas
  public Glovito(boolean[][] salidas, int[][] estados){
    this.salidas = salidas;
    this.estados = estados;
  }


  public boolean[] simular(boolean[] entrada){
    boolean[] salida = new boolean[entrada.length];

    int estado = 0;

    for (int i=0; i<entrada.length;i++){
      salida[i] = salidas[estado][entrada[i]?1:0];
      estado = estados[estado][entrada[i]?1:0];
    }

    return salida;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();

    for (int i=0; i<4; i++){
      sb.append('|');
      for (int j=0; j<2; j++){
        sb.append((char)('A'+ estados[i][j]));
        sb.append(' ');
        sb.append(salidas[i][j]?1:0);
        sb.append('|');
      }
      sb.append("\n");
    }

    return sb.toString();
  }
}
