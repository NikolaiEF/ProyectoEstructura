package archivos;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import model.Reproductor;

public class Persistencia {

    public static final String RUTA_ARCHIVO_MODELO_REPRO_XML = "src/archivos/modelo.xml";


    public static Reproductor cargarRecursoXML() {
    	Reproductor repro = null;
            try {
                repro = (Reproductor) cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_REPRO_XML);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return repro;
     }

    public static void guardarRecursoXML(Reproductor repro) {
            try {
                 salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_REPRO_XML, repro);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
     }

    public static Object cargarRecursoSerializadoXML(String rutaArchivo) throws IOException {

        XMLDecoder decodificadorXML;
        Object objetoXML;

        decodificadorXML = new XMLDecoder(new FileInputStream(rutaArchivo));
        objetoXML = decodificadorXML.readObject();
        decodificadorXML.close();
        return objetoXML;

    }

    public static void salvarRecursoSerializadoXML(String rutaArchivo, Object objeto) throws IOException {

        XMLEncoder codificadorXML;

        codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
        codificadorXML.writeObject(objeto);
        codificadorXML.close();

    }
}
