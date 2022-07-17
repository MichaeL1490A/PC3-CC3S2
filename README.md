# PC3 DESARROLO DE SOFTWARE

## Principio de responsabilidad única
### Pregunta 1
![img.png](images/img.png)

Se ejecuta el método main el cual imprime "Demostración sin SRP", luego
se crea un objeto Empleado (Jessica) y se utiliza el método privado de Cliente
(showEmpDetail) el cual recibe como parámetro al objeto Empleado (Jessica).
Este método showEmpDetail imprime una serie de datos sobre el objeto
empleado usando sus métodos para esto, como displayEmpDetail, generateEmpId.
y checkSeniority. Sin embargo, estos 2 últimos métodos generateEmpId y 
checkSeniority se encuentran en la clase Empleado. Esta clase Empleado vemos
entonces que cumple con más de una función, ya que además de otorgar la 
información básica del empleado, a través de estos 2 métodos también se encarga
de generar los IDs y de catalogar a los empleados con base en la experiencia,
teniendo más de una responsabilidad como clase.

Lo mismo se repite para el siguiente empleado Chalito.

### Pregunta 2

El problema de diseño se centra en la clase Empleado, ya que esta como hemos
especificado en la pregunta anterior tiene más de una responsabilidad. No solo
se encarga de almacenar y devolver la información básica del empleado, sino
además también tiene la responsabilidad de generar las IDs aleatorias con el
método generateEmpID y de especificar el nivel de un empleado con base en su
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

En el método main de Cliente crea los objetos jessica y chalo los cuales contienen información de
los empleados, luego para cada objeto llama el método privado de Cliente showEmpDetails en el que imprime
los datos de cada empleado con el método del objeto Empleado displayEmpDetail.

Después creamos una variable que almacenara el ID del empleado y la inicializaremos con el método
generateEmpId de la clase GeneradorIDEmpleado para esto le damos como parámetro el valor firstName
del objeto Empleado e imprimimos la variable empId

Para finalizar creamos una variable rank que almacenara el nivel de estudio del Empleado y los inicializaremos
con el método checkSeniority de la clase GeneradorIDEmpleado para esto le pasamos como parámetro la experiencia
en años del empleado (experienceInYears) e imprimimos la variable rank.

### Pregunta 5

Como hemos revisado en la anterior sección, no es correcto proceder de esta forma, ya que
estaríamos violando el principio de responsabilidad única al asignarle 2 tareas totalmente
distintas a la misma clase. displayResult corresponde a otorgar la información básica del
estudiante mientras que evaluateDistinction se dedica a evaluar si es elegible para un
certificado con base en su desempeño, por lo que estos métodos son totalmente
distintos y deberían declararse en 2 clases distintas.

### Pregunta 6

![img.png](images/img3.png)

Se ejecuta el método main de la clase Cliente en donde se declara
una lista de objetos de tipo Estudiante y se inicializa con el método
privado enrollStudents de la clase Cliente. Luego se itera entre todos
los estudiantes y se imprime sus datos con detalle. Al final se crea
un objeto de tipo DistinctionDecider, el cual evalúa si un estudiante
recibe una distinción, se itera en la lista y para cada objeto de la lista
se evalúa si el Estudiante recibe una distinción y se imprimen los que
recibieron el certificado.

### Pregunta 7

El diseño del código actual es problemático para la extensión del mismo, podemos
observar que al querer extender el método evaluateDistinction de DistinctionDecider
tendremos que constantemente aumentar la cantidad de ifs dentro del mismo, así
teniendo un código demasiado grande sin necesidad de serlo. Este problema es 
producto de la baja escabilidad que posee nuestro clase DistinctionDecider.

Declarando la clase Estudiante.java como abstracta obtenemos:

~~~
abstract class Estudiante {
    String name;
    String regNumber;
    double score;
    String department;

    public Estudiante(String name, String regNumber, double score) {
        this.name = name;
        this.regNumber = regNumber;
        this.score = score;
    }

    public String toString() {
        return ("Nombre: " + name + "\nNumero Reg: " + regNumber + "\nDept:" + department + "\nMarks:"
                + score + "\n");
    }

}
~~~

ArteEstudiante.java:

~~~
public class ArteEstudiante extends Estudiante{
    public ArteEstudiante(String name, String regNumber, double score, String dept) {
        super(name,regNumber,score);
        this.department = dept;
    }
}
~~~

CienciaEstudiante.java:

~~~
public class CienciaEstudiante extends Estudiante{
    public CienciaEstudiante(String name, String regNumber, double score,String dept) {
        super(name,regNumber,score);
        this.department = dept;
    }
}
~~~

### Pregunta 8

Declarando como interface DistinctionDecider.java:

~~~
interface DistinctionDecider{
    void evaluateDistinction(Estudiante estudiante);
}
~~~

### Pregunta 9

ArtsDistinctionDecider.java

~~~
public class ArtsDistinctionDecider implements DistinctionDecider{
    public void evaluateDistinction(Estudiante estudiante){
        if(estudiante.score > 70){
            System.out.println(estudiante.regNumber + " ha recibido una distincion en artes.");
        }
    }
}
~~~

ScienceDistinctionDecider.java

~~~
public class ScienceDistinctionDecider implements DistinctionDecider {
    public void evaluateDistinction(Estudiante estudiante){
        if(estudiante.score > 80){
            System.out.println(estudiante.regNumber + " ha recibido una distincion en ciencias.");
        }
    }
}
~~~

### Pregunta 10

![img.png](images/img4.png)

Se ejecuta el método main en la clase Cliente en donde se crean dos listas, una
de tipo CienciasEstudiantes que alberga a los estudiantes del área de ciencias,
y otra de tipo ArtesEstudiantes que alberga a los estudiantes del área de artes.
Estas 2 listas se inicializan con los métodos privados enrollScienceStudents y
enrollArtsStudents de la clase Cliente. En la siguiente parte, se itera cada lista
respectivamente para poder imprimir sus datos de cada uno. Finalmente, en la
última parte se generan dos objetos, uno de tipo scienceDistinctionDecider para
los estudiantes de ciencias y el otro de tipo artsDistinctionDecider para los
estudiantes de arte, estos dos evalúan para cada tipo de estudiante si recibieron
una distinción por sus notas. Procedemos a iterar las listas para evaluar si se
han recibido afirmativamente o no las distinciones, imprimiendo los que sí
lograron recibirlas, culminando la ejecución del código.

### Pregunta 11

Los beneficios de ahora tener una clase específica para cada área en la que se
desempeñe un estudiante es que ahora podremos distinguirlos a través de las
clases, simplemente heredando la clase principal estudiante mejorando la
escalabilidad del código, ya que cuando por ejemplo necesitemos integrar otra
área más aparte de ciencias o artes simplemente será necesario heredar otra vez
la clase estudiante y definirla para esta nueva área. Así mismo, en el caso de
las distinciones, ahora podemos declarar una evaluación para cada área distinta
sin necesidad de tener que declarar tantos ifs en una misma clase, simplemente
implementaremos la interfaz DistinctionDecider para realizar una nueva evaluación
para esta nueva área.