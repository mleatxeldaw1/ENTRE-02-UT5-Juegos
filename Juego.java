/**
 * Un objeto de esta clase guarda información relativa a un juego
 * 
 * @author -
 */
public class Juego {
    private static final String SEPARADOR = ":";
    private String titulo;
    private Genero genero;
    private int year;
    private int[] valoraciones = new int[10];

    /**
     *  Inicializa los atributos a partir de la información recibida
     *  Esta información se encuentra en linea
     */
    public Juego(String linea) {
        String[] lineaSeparada = linea.replaceAll(" ","").split(SEPARADOR);
        this.titulo = lineaSeparada[0];
        this.genero = Genero.valueOf(lineaSeparada[1].toUpperCase());
        year = Integer.parseInt(lineaSeparada[2]);
        int j = 3;
        for(int i = 0; i < valoraciones.length; i++){

            valoraciones[i] = Integer.parseInt(lineaSeparada[j]);
            j++;
        }

    }

    
    public  Juego()
    {
        String linea = "For the King:estrategia:2018:0:0:0:7:12:0:33:13:2:0";
        String[] lineaSeparada = linea.replaceAll(" ","").split(SEPARADOR);
        this.titulo = lineaSeparada[0];
        this.genero = Genero.valueOf(lineaSeparada[1].toUpperCase());
        year = Integer.parseInt(lineaSeparada[2]);
        int j = 3;
        for(int i = 0; i < valoraciones.length; i++){

            valoraciones[i] = Integer.parseInt(lineaSeparada[j]);
            j++;
        }
        
        
    }

    /**
     * accesor título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * accesor género
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * accesor year
     */
    public int getYear() {
        return year;
    }

    /**
     * accesor valoraciones
     */
    public int[] getValoraciones() {
        return valoraciones;
    }

    /**
     * total votos emitidos
     */
    public int getVotos() {
        int total =0;
        for(int i = 0; i < valoraciones.length; i++){
            total += valoraciones[i];
        }
        return total;
    }

    /**
     *  obtener valoración media
     */
    public double getValoracionMedia() {
        //Me apetecia hacerlo en while aunque ya se que en este caso es mas eficiente con for.
        int recuento = 0;
        int media = 0;
        int[] valores = {1,2,3,4,5,6,7,8,9,10};
        while(recuento != valoraciones.length){
            media += valoraciones[recuento]* valores[recuento];
            recuento++;
            if(recuento == valoraciones.length){
                return media/getVotos();
            }

        }
        return recuento;
    }

    /**
     *  Un usuario puntúa el juego con un valor entre 1 y 10 
     */
    public void puntuar(int puntuacion) {
        valoraciones[puntuacion-1]++;
    }

    /**
     * Representación textual del juego 
     * (Ver enunciado)
     */
    public String toString() {
        return titulo + "\nGénero: " + this.genero +
        "| Lanzamiento: " + this.year +
        "\nValoración (" + getVotos() + " votos): "
        + String.format("%.2f", this.getValoracionMedia());

    }

    public static void main(String[] args) {
        Juego juego1 = new Juego(
                "Steep: deporte: 2016  : 0:0:0:0: 0: 0:0:0:12:  10");
        System.out.println(juego1.toString());

        Juego juego2 = new Juego(
                "For the King: estrategia: 2018  : 0:0:0:7: 12: 0:33:13:2: 0");
        System.out.println(juego2.toString());

    }
}
