/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.sql.Connection;

/**
 *
 * @author guill
 */
public class DaoEstadoResultado {

    Conexion conexion;
    private Connection conection;

    private static final String ventas_totales = "SELECT \n"
            + "    (ventas - devoluciones - rebajas) AS total_ventas\n"
            + "FROM (\n"
            + "    SELECT \n"
            + "        (SELECT COALESCE(SUM(monto), 0) \n"
            + "         FROM libro_diario \n"
            + "         JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "         JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor\n"
            + "         WHERE cuentas_mayor.cod_mayor = '5101'"
            + "         AND fecha BETWEEN ? AND ?) AS ventas,\n"
            + "        (SELECT COALESCE(SUM(monto), 0) \n"
            + "         FROM libro_diario \n"
            + "         JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "         JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor\n"
            + "         WHERE cuentas_mayor.cod_mayor = '4103'"
            + "         AND fecha BETWEEN ? AND ?) AS devoluciones,\n"
            + "        (SELECT COALESCE(SUM(monto), 0) \n"
            + "         FROM libro_diario \n"
            + "         JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "         JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor\n"
            + "         WHERE cuentas_mayor.cod_mayor = '4104'"
            + "         AND fecha BETWEEN ? AND ?) AS rebajas\n"
            + ") AS ventas_totales;";

    private static final String costo_de_venta = "SELECT (inventario_inicial - inventario_final + compras + gastos_compras - devoluciones - rebajas) AS costo_ventas\n"
            + "FROM (SELECT (SELECT COALESCE(SUM(monto), 0) FROM libro_diario  \n"
            + "WHERE cod_subcuenta = '110601' AND fecha BETWEEN ? AND ?) AS inventario_inicial,\n"
            + "(SELECT COALESCE(SUM(monto), 0) FROM libro_diario\n"
            + " WHERE cod_subcuenta = '110602' AND fecha BETWEEN ? AND ?) AS inventario_final, \n"
            + "(SELECT COALESCE(SUM(monto), 0) FROM libro_diario \n"
            + "JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor \n"
            + "WHERE cuentas_mayor.cod_mayor = '4101' AND fecha BETWEEN ? AND ?) AS compras,\n"
            + "(SELECT COALESCE(SUM(monto), 0) FROM libro_diario \n"
            + "JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor \n"
            + "WHERE cuentas_mayor.cod_mayor = '4102' AND fecha BETWEEN ? AND ?) AS gastos_compras, \n"
            + "(SELECT COALESCE(SUM(monto), 0) FROM libro_diario \n"
            + "JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor\n"
            + "WHERE cuentas_mayor.cod_mayor = '5102' AND fecha BETWEEN ? AND ?) AS devoluciones,\n"
            + "(SELECT COALESCE(SUM(monto), 0) FROM libro_diario\n"
            + "JOIN subcuentas ON subcuentas.cod_subcuenta = libro_diario.cod_subcuenta\n"
            + "JOIN cuentas_mayor ON cuentas_mayor.cod_mayor = subcuentas.cod_mayor\n"
            + "WHERE cuentas_mayor.cod_mayor = '5103' AND fecha BETWEEN ? AND ?) AS rebajas) AS costo_venta;";

    private static final String gastos_administrativos = "SELECT COALESCE(SUM(CASE WHEN ld.transaccion = 'Debe' THEN ld.monto WHEN ld.transaccion = 'Haber' THEN -ld.monto ELSE 0 END), 0) AS gastos_administrativos\n"
            + "FROM libro_diario ld\n"
            + "JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta \n"
            + "JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor \n"
            + "WHERE cm.cod_mayor = '4302' AND ld.fecha BETWEEN ? AND ?;";

    private static final String gastos_venta = "SELECT COALESCE(SUM(CASE WHEN ld.transaccion = 'Debe' THEN ld.monto WHEN ld.transaccion = 'Haber' THEN -ld.monto ELSE 0 END), 0) AS gastos_ventas\n"
            + "FROM libro_diario ld\n"
            + "JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta \n"
            + "JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor \n"
            + "WHERE cm.cod_mayor = '4301' AND ld.fecha BETWEEN ? AND ?;";

    private static final String ingresos_financieros = "SELECT COALESCE(SUM(CASE WHEN ld.transaccion = 'Debe' THEN ld.monto WHEN ld.transaccion = 'Haber' THEN -ld.monto ELSE 0 END), 0) AS ingresos_financieros\n"
            + "FROM libro_diario ld\n"
            + "JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta \n"
            + "JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor \n"
            + "WHERE cm.cod_mayor = '5201' AND ld.fecha BETWEEN ? AND ?;";

    private static final String gastos_financieros = "SELECT COALESCE(SUM(CASE WHEN ld.transaccion = 'Debe' THEN ld.monto WHEN ld.transaccion = 'Haber' THEN -ld.monto ELSE 0 END), 0) AS gastos_financieros\n"
            + "FROM libro_diario ld\n"
            + "JOIN subcuentas sc ON ld.cod_subcuenta = sc.cod_subcuenta \n"
            + "JOIN cuentas_mayor cm ON sc.cod_mayor = cm.cod_mayor \n"
            + "WHERE cm.cod_mayor = '4303' AND ld.fecha BETWEEN ? AND ?;";

}
