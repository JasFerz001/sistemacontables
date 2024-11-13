package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoBalanzaComprobacion {
    private Connection con;
    private Statement st;

    
    public DaoBalanzaComprobacion() {
        Conexion conexion = new Conexion();
        this.con = conexion.getConexion();
    }

    
    public int cuentaTipo(String codigo) {
        int tipo = 0;
        String sql = "SELECT catalogo.cuentatipo FROM catalogo WHERE catalogo.codigo='" + codigo + "'";

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                tipo = rs.getInt("cuentatipo");
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error en cuentaTipo: " + e);
        }
        
        return tipo;
    }

    // Método para obtener el libro mayor con código y nombre de cuenta
    /*public ArrayList<ModeloLibroMayor> mostrarLibroMayor() {
           ArrayList<ModeloLibroMayor> mayor = new ArrayList<>();
        String sql = "SELECT DISTINCT catalogo.codigo, catalogo.nombrecuenta, "
                   + "(SELECT CAST(SUM(librodiario.monto) AS NUMERIC) as debe FROM librodiario WHERE catalogo.codigo = librodiario.codigo AND librodiario.tipo = 0), "
                   + "(SELECT CAST(SUM(librodiario.monto) AS NUMERIC) as haber FROM librodiario WHERE catalogo.codigo = librodiario.codigo AND librodiario.tipo = 1) "
                   + "FROM catalogo, librodiario "
                   + "WHERE catalogo.codigo = librodiario.codigo "
                   + "ORDER BY catalogo.codigo";
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                ModeloLibroMayor mm = new ModeloLibroMayor();
                mm.setCodigo(rs.getString("codigo"));
                mm.setNombreCTA(rs.getString("nombrecuenta"));
                mm.setDescripcion(" ");

                double debe = rs.getDouble("debe");
                double haber = rs.getDouble("haber");

                // Asignar valores a debe y haber según el resultado de la consulta
                if (debe == 0 && haber != 0) {
                    mm.setHaber(haber);
                    mm.setDebe(0);
                } else if (debe != 0 && haber == 0) {
                    mm.setHaber(0);
                    mm.setDebe(debe);
                } else {
                    mm.setHaber(haber);
                    mm.setDebe(debe);
                }

                mayor.add(mm);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error en mostrarLibroMayor: " + e);
        }
        
        return mayor;
    }*/
   
   
}
