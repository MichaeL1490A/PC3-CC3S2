//package NoSolid.DIP;

public class InterfazUsuario {
    private OracleDatabase oracleDatabase;

    public InterfazUsuario() {
        oracleDatabase = new OracleDatabase();
    }

    public void saveEmployeeId(String empId) {
        oracleDatabase.saveEmpIdInDatabase(empId);
    }
}
