//package Solid.DIP;

class InterfazUsuario {
    private BaseDatos database;
    public InterfazUsuario(BaseDatos DB){
        this.database = DB;
    }
    public void saveEmployeeId(String empId){
        database.saveEmpIdInDatabase(empId);
    }
}
