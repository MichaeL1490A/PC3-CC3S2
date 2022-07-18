//package Solid.DIP;


public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion con DIP");

        // Usando Oracle
        BaseDatos oracle = new OracleDatabase();

        // Usando Mysql
        BaseDatos mysql = new MySQLDatabase();

        // Cambiando la base de datos objetivo
        InterfazUsuario usuario = new InterfazUsuario(oracle);
        usuario.saveEmployeeId("E001");
        usuario = new InterfazUsuario(mysql);
        usuario.saveEmployeeId("E001");
    }
}
