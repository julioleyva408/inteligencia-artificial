import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class Main {
    public static void main(String[] args) {
        // Cargar archivo de definición de reglas difusas
        String archivo = "cerveza.fcl";
        FIS fis = FIS.load(archivo, true);

        // Verificar si el archivo de definición de reglas difusas fue cargado correctamente
        if (fis == null) {
            System.err.println("No se pudo cargar el archivo: '" + archivo + "'");
            return;
        }

        FunctionBlock functionBlock = fis.getFunctionBlock(null);


        // Evaluar las entradas del sistema y obtener la salida correspondiente
        functionBlock.setVariable("temperaturaActual", 25);
        functionBlock.setVariable("temperaturaDeseada", 10);
        functionBlock.evaluate();

        // Definir la salida y mostrarla en una gráfica de resultados
        double enfriamiento =
                functionBlock.getVariable("enfriamientoRequerido") . defuzzify();

        System.out.println("El enfriamiento requerido es: " + enfriamiento );
    }
}