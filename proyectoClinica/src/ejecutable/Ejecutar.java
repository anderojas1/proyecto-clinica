package ejecutable;

import Vista.VentanaLogin;

public class Ejecutar {
    
    public static void main (String [] args) {
        
        VentanaLogin iniciarSesion = new VentanaLogin();
        iniciarSesion.setVisible(true);
        iniciarSesion.setLocationRelativeTo(null);
        
    }
}