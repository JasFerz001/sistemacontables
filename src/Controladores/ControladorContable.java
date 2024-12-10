package Controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import modelos.AjusteIVA;
import modelos.CierreContable;
import modelos.PartidaCierre;
import utilidades.BackupDatabase;
import utilidades.RestoreBackupDatabase;

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
    
     public void calcularUtilidadBruta() {
        try {
            cierreContable.utilidadBruta();
            System.out.println("Cálculo de Utilidad Bruta realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al calcular Utilidad Bruta: " + e.getMessage());
        }
    }
     
     public void calcularLiquidarVentas() {
        try {
            CierreContable c = new CierreContable();
            double a = c.obtener_Ventas();
            cierreContable.liquidarVentas(a);
            System.out.println("Cálculo de Liquidacion de Ventas realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al calcular Las Liquidaciones de Ventas: " + e.getMessage());
        }
    }
     
          public void calcularLiquidarGastos() {
        try {
            
            cierreContable.liquidarGastos();
            System.out.println("Cálculo de Liquidacion de Gastos realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al Calcular Las Liquidaciones de Gastos: " + e.getMessage());
        }
    }
          
          public void calcularLiquidarOtrosGastos() {
        try {
          
            cierreContable.liquidarOtrosGastos();
            System.out.println("Cálculo de Liquidacion de Otros Gastos realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al Calcular Las Liquidaciones de Otros Gastos: " + e.getMessage());
        }
    }
     
          public void calcularUtilidadEjercicio() {
        try {
          
            cierreContable.utilidadEjercicio();
            System.out.println("Cálculo de Utilidad del Ejercicio realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al Calcular Utilidad del Ejercicio: " + e.getMessage());
        }
    }
          
           public void calcularMercaderiaDisponible() {
        try {
          
            cierreContable.mercaderiaDisponible();
            System.out.println("Cálculo de Mercaderia Disponible realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al Calcular Utilidad del Ejercicio: " + e.getMessage());
        }
    }
           
             public void calcularPartidaCierre() {
        try {
          
            cierreContable.partidaCierre();
            System.out.println("Cálculo de Partida de Cierre realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al Calcular Partida de Cierre: " + e.getMessage());
        }
    }
             
                public void calcularCostoVentas(Double a) {
        try {
          
            cierreContable.costoVenta(a);
            System.out.println("Cálculo de Costo de Ventas realizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al Calcular Costo de Ventas: " + e.getMessage());
        }
    }
     
                  public void AlmacenarNuevoCiclo() throws SQLException {
                      BackupDatabase backupDatabase = new BackupDatabase();
                      backupDatabase.createBackup();
                      CierreContable c = new CierreContable();
                       int numeroPartida = c.obtenerNumeroPartida();
        ArrayList<PartidaCierre> lista1 = c.obtenerSaldoActivoCierre(numeroPartida);
        ArrayList<PartidaCierre> lista2 = c.obtenerSaldoPasivoCierre(numeroPartida);
        ArrayList<PartidaCierre> lista3 = c.obtenerSaldoPatrimonioCierre(numeroPartida);
        //hacer drop de la base
        //restaurar la base nueva, que seria la vacia
        RestoreBackupDatabase restoreBackup = new RestoreBackupDatabase();
        restoreBackup.restoreBackup();
        
        //hacer este insert.
        for (PartidaCierre x : lista1) {
            c.insertarTransaccion(1, String.valueOf(x.getCodigo()), x.getMonto(), "PARTIDA DE APERTURA", "Debe");
        }
        for (PartidaCierre x : lista2) {
            c.insertarTransaccion(1, String.valueOf(x.getCodigo()), x.getMonto(), "PARTIDA DE APERTURA", "Debe");
        }
        for (PartidaCierre x : lista3) {
            c.insertarTransaccion(1, String.valueOf(x.getCodigo()), x.getMonto(), "PARTIDA DE APERTURA", "Haber");
        }
        
    }

    // Método para cerrar las conexiones de ambas clases
    public void cerrarConexiones() {
        cierreContable.cerrarConexion();
        System.out.println("Conexión a la base de datos cerrada.");
    }
}
