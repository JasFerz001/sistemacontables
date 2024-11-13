package modelos;

/**
 *
 * @author kevin
 */
public class LibroDiario {
    private int numeroPartida;
    private String fecha;
    private int codigo;
    private double monto;
    private double parcial;
    private int tipoTransaccion;
    private String comentario;

    public LibroDiario() {
    }

    public LibroDiario(int numeroPartida, String fecha, int codigo, double monto, double parcial, int tipoTransaccion, String comentario) {
        this.numeroPartida = numeroPartida;
        this.fecha = fecha;
        this.codigo = codigo;
        this.monto = monto;
        this.parcial = parcial;
        this.tipoTransaccion = tipoTransaccion;
        this.comentario = comentario;
    }

    public int getNumeroPartida() {
        return numeroPartida;
    }

    public void setNumeroPartida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getParcial() {
        return parcial;
    }

    public void setParcial(double parcial) {
        this.parcial = parcial;
    }

    public int getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}