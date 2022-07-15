//package Solid.OCP;

public class ArtsDistinctionDecider implements DistinctionDecider{
    public void evaluateDistinction(Estudiante estudiante){
        if(estudiante.score > 70){
            System.out.println(estudiante.regNumber + " ha recibido una distincion en artes.");
        }
    }
}
