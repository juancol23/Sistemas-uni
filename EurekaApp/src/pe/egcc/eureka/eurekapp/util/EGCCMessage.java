package pe.egcc.eureka.eurekapp.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Coronel
 */
public final class EGCCMessage {

  private EGCCMessage() {
  }

  public static void error(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA ERROR", JOptionPane.ERROR_MESSAGE);
  }

  public static void info(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
            "EUREKA INFO", JOptionPane.INFORMATION_MESSAGE);
  }

}
