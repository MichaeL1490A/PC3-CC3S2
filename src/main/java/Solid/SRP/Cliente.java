//package Solid.SRP;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion de SRP");

        Empleado jessica = new Empleado("Jessica", "Abejita", 7.5);
        showEmpDetail(jessica);

        System.out.println("\n*******\n");

        Empleado chalo = new Empleado ("Chalito", "Smart", 3.2);
        showEmpDetail(chalo);
    }

    private static void showEmpDetail(Empleado emp) {

        emp.displayEmpDetail();

        String empId = new GeneradorIDEmpleado().generateEmpId(emp.firstName);
        System.out.println("El ID de empleado es" + empId);

        String rank = new SeniorityChecker().checkSeniority(emp.experienceInYears);
        System.out.println("Este empleado es un" + " empleado " + rank);
    }
}
