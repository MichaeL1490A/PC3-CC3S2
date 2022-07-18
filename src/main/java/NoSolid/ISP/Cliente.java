//package NoSolid.ISP;

 import java.util.ArrayList;
 import java.util.List;

class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion sin ISP");
        Impresora impresora = new ImpresoraAvanzada();
        impresora.printDocument();
        impresora.sendFax();

        impresora = new ImpresoraBasica();
        impresora.printDocument();
        //impresora.sendFax();// Lanza un error

        List<Impresora> impresoras = new ArrayList<Impresora>();
        impresoras.add(new ImpresoraAvanzada());
        impresoras.add(new ImpresoraBasica());
        for(Impresora dispositivo:impresoras) {
            dispositivo.printDocument();
            //dispositivo.sendFax(); //Lanza un error
        }
        impresoras.forEach( (dispositivo) -> {dispositivo.printDocument();} );
    }
}
