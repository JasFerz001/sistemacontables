package Controladores;

import java.sql.SQLException;
import modelos.AjusteIVA;
import modelos.CierreContable;

/**
 *
 * @author kevin
 */
public class ControladorContable {

    private AjusteIVA ajusteIVA;
    private CierreContable cierreContable;

    // Constructor
    public ControladorContable() {
        this.ajusteIVA = new AjusteIVA();
        this.cierreContable = new CierreContable();
    }

    // Métodos para invocar las funcionalidades de AjusteIVA
    public double obtenerIvaCredito() {
        try {
            return ajusteIVA.obtenerIvaCredito();
        } catch (SQLException e) {
            System.err.println("Error al obtener IVA Crédito Fiscal: " + e.getMessage());
        }
        return 0.0;
    }

    public double obtenerIvaDebito() {
        try {
            return ajusteIVA.obtenerIvaDebito();
        } catch (SQLException e) {
            System.err.println("Error al obtener IVA Débito Fiscal: " + e.getMessage());
        }
        return 0.0;
    }

    public void ajustarIva() {
        try {
            ajusteIVA.ajustarIva();
            System.out.println("Ajuste de IVA realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al realizar el ajuste de IVA: " + e.getMessage());
        }
    }

    // Métodos para invocar las funcionalidades de CierreContable
    public void calcularVentasNetas() {
        try {
            cierreContable.ventasNetas();
            System.out.println("Cálculo de Ventas Netas realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al calcular Ventas Netas: " + e.getMessage());
        }
    }

    public void calcularComprasTotales() {
        try {
            cierreContable.comprasTotales();
            System.out.println("Cálculo de Compras Totales realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al calcular Compras Totales: " + e.getMessage());
        }
    }

    public void calcularComprasNetas() {
        try {
            cierreContable.comprasNetas();
            System.out.println("Cálculo de Compras Netas realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al calcular Compras Netas: " + e.getMessage());
        }
    }

    // Método para cerrar las conexiones de ambas clases
    public void cerrarConexiones() {
        cierreContable.cerrarConexion();
        System.out.println("Conexión a la base de datos cerrada.");
    }
}
