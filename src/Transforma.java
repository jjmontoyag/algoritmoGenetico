public interface Transforma<G,T> {
  G codificar(T fenotipo);
  T crecer(G genotipo);
}
