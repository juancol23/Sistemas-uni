package pe.egcc.eureka.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.eureka.app.dao.espec.IDaoCuenta;

/**
 *
 * @author Gustavo Coronel
 */
public class DaoCuentaImpl implements IDaoCuenta {

  @Override
  public void registrarDeposito(String cuenta, double importe, String empleado) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false);
      // cn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
      // Paso 1: Leer datos de cuneta
      String sql = "select dec_cuensaldo, int_cuencontmov "
              + "from cuenta "
              + "where chr_cuencodigo = ? "
              + "for update ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) {
        throw new SQLException("Cuenta no existe.");
      }
      double saldo = rs.getDouble("dec_cuensaldo");
      int cont = rs.getInt("int_cuencontmov");
      rs.close();
      pstm.close();
      // Paso 2: Actualizar cuenta
      saldo += importe;
      cont++;
      sql = "update cuenta "
              + "set dec_cuensaldo = ?, "
              + "int_cuencontmov = ? "
              + "where chr_cuencodigo = ?";
      pstm = cn.prepareStatement(sql);
      pstm.setDouble(1, saldo);
      pstm.setInt(2, cont);
      pstm.setString(3, cuenta);
      pstm.executeUpdate();
      pstm.close();
      // Paso 3: Registrar movimiento
      sql = "insert into movimiento(chr_cuencodigo,int_movinumero,"
              + "dtt_movifecha,chr_emplcodigo,chr_tipocodigo,"
              + "dec_moviimporte, chr_cuenreferencia) "
              + "values(?,?,sysdate,?,'003',?,null)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, cont);
      pstm.setString(3, empleado);
      pstm.setDouble(4, importe);
      pstm.executeUpdate();
      pstm.close();
      // Confirmar
      cn.commit();
    } catch (SQLException e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException("ERROR, no se puede ejecutar el proceso.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
}
