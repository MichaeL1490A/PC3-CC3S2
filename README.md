# PC3 DESARROLO DE SOFTWARE

## Principio de responsabilidad única
### Pregunta 1
![img.png](images/img.png)

Se ejecuta el método main el cual imprime "Desmotración sin SRP", luego
se crea un objeto Empleado (Jessica) y se utiliza el método privado de Cliente
(showEmpDetail) el cual recibe como parámetro al objeto Empleado (Jessica).
Este método showEmpDetail imprime una serie de datos sobre el objeto
empleado utilizando sus métodos para esto, como displayEmpDetail, generateEmpId.
y checkSeniority. Sin embargo, estos 2 últimos métodos generateEmpId y 
checkSeniority se encuentran en la clase Empleado. Esta clase Empleado vemos
entonces que cumple con más de una función, ya que además de otorgar la 
información básica del empleado, a través de estos 2 métodos también se encarga
de generar los IDs y de catalogar a los empleados en base a la experiencia,
teniendo más de una responsabilidad como clase.

Lo mismo se repite para el siguiente empleado Chalito.

### Pregunta 2

El problema de diseño se centra en la clase Empleado, ya que esta como hemos
especificado en la pregunta anterior tiene más de una responsabilidad. No solo
se encarga de almacenar y devolver la información básica del empleado, sino
además también tiene la responsabilidad de generar las IDs aleatorias con el
método generateEmpID y de especificar el nivel de un empleado en base a su
experiencia con el método checkSeniority. La razón más probable es que juntar
todos los métodos en una sola clase aparenta dar más cohesión al código, sin
tomar en cuenta que el código puede tener cambios.

### Pregunta 3

Client.java
~~~
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
~~~

Empleado.java

~~~
public class Empleado {
    public String firstName, lastName;
    public double experienceInYears;
    public Empleado(String firstName, String lastName, double experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceInYears = experience;
    }
    public void displayEmpDetail(){
        System.out.println("Nombre del empleado: "+lastName+","+firstName);
        System.out.println("Este empleado tiene "+ experienceInYears+" años de experiencia.");
    }
}
~~~

SeniorityChecker.java

~~~
public class SeniorityChecker {
    public double experienceInYears;
    public String checkSeniority(double experienceInYears){
        return experienceInYears > 5 ?"senior":"junior";
    }
}
~~~

GeneradorIDEmpleado.java

~~~
public class SeniorityChecker {
    public double experienceInYears;
    public String checkSeniority(double experienceInYears){
        return experienceInYears > 5 ?"senior":"junior";
    }
}
~~~

### Pregunta 4

![img.png](images/img2.png)

En el metodo main de Cliente crea los objetos jessica y chalo los cuales contienen información de
los empleados, luego para cada objeto llama el metodo privado de Cliente showEmpDetails en el que imprime
los datos de cada empleado con el metodo del objeto Empleado displayEmpDetail.

Después creamos una variable que almacenara el ID del empleado y la inicializaremos con el metodo
generateEmpId de la clase GeneradorIDEmpleado para esto le damos como parametro el valor firstName
del objeto Empleado e imprimimos la variable empId

Para finalizar creamos una variable rank que almacenara el nivel de estudio del Empleado y los inicializaremos
con el metodo checkSeniority de la clase GeneradorIDEmpleado para esto le pasamos como parametro la experiencia
en años del empleado (experienceInYears) e imprimimos la variable rank.

### Pregunta 5

Como hemos revisado en la anterior sección, no es correcto proceder de esta forma ya que
estaríamos violando el principio de responsabilidad única al asignarle 2 tareas totalmente
distintas a la misma clase. displayResult corresponde a otorgar la información básica del
estudiante mientras que evaluateDistinction se dedica a evaluar si es elegible para un
certificado en base a su desempeño, por lo que estos métodos son totalmente
distintos y deberían declararse en 2 clases distintas.

### Pregunta 6

![img.png](images/img3.png)

Se ejecuta el metodo main de la clase Cliente en donde se declara
una lista de objetos de tipo Estudiante y se inicializa con el metodo
privado enrollStudents de la clase Cliente. Luego se itera entre todos
los estudiantes y se imprime sus datos con detalle. Al final se crea
un objeto de tipo DistinctionDecider, el cual evalua si un estudiante
recibe una distincion, se itera en la lista y para cada objeto de la lista
se evalua si el Estudiante recibe una distincion y se imprimen los que
recibieron el certificado.