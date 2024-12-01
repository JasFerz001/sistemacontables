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

//MOSTRAR TODAS LA VENTAS.
/*select c.cod_mayor, SUM(l.monto) AS monto
from libro_diario AS l
INNER JOIN subcuentas AS s ON s.cod_subcuenta = l.cod_subcuenta
INNER JOIN cuentas_mayor AS c ON c.cod_mayor = s.cod_mayor
WHERE c.cod_mayor = 5101 AND l.fecha BETWEEN '2024-11-29' AND '2024-11-29'
ORDER BY c.cod_mayor;*/
    Conexion conexion;
    private Connection conection;

    private static final String ventas  = "select c.cod_mayor, SUM(l.monto) AS monto\n"
            + "from libro_diario AS l\n"
            + "INNER JOIN subcuentas AS s ON s.cod_subcuenta = l.cod_subcuenta\n"
            + "INNER JOIN cuentas_mayor AS c ON c.cod_mayor = s.cod_mayor\n"
            + "WHERE c.cod_mayor = 5101 AND l.fecha BETWEEN '2024-11-29' AND '2024-11-29'\n"
            + "ORDER BY c.cod_mayor;";

    private static final String costo_de_venta = "";
    
    /*
    SELECT 
    (inventario_inicial - inventario_final + compras + gastos_compras - devoluciones - rebajas) AS costo_ventas
FROM (
    SELECT 
        (SELECT COALESCE(SUM(monto), 0) 
         FROM libro_diario 
         WHERE cod_subcuenta = '110601') AS inventario_inicial,
        (SELECT COALESCE(SUM(monto), 0) 
         FROM libro_diario 
         WHERE cod_subcuenta = '110602') AS inventario_final,
        (SELECT COALESCE(SUM(monto), 0) 
         FROM libro_diario 
         WHERE cod_subcuenta = '4101') AS compras,
        (SELECT COALESCE(SUM(monto), 0) 
         FROM libro_diario 
         WHERE cod_subcuenta = '4102') AS gastos_compras,
        (SELECT COALESCE(SUM(monto), 0) 
         FROM libro_diario 
         WHERE cod_subcuenta = '5102') AS devoluciones,
        (SELECT COALESCE(SUM(monto), 0) 
         FROM libro_diario 
         WHERE cod_subcuenta = '5103') AS rebajas
) AS calculos;
    */
}
