package dailyreg.logic;

import dailyreg.DailyReg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Archivo {
    
    private File f = new File("DailyReg.txt");
    private Sistema system;

    public Sistema getSystem() {
        return system;
    }
    

    public Archivo(Sistema system) {
        this.system = system;
    }    

    public void setSystem(Sistema system) {
        this.system = system;
    }
    
    
    public void guardar() throws IOException  {
        
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(system);
        
        fos.close();
        oos.close();

    }

    public Sistema cargar() throws FileNotFoundException, IOException, ClassNotFoundException {

        if (f.exists()) {
            ObjectInputStream ois;
            try (FileInputStream fis = new FileInputStream(f)) {
                ois = new ObjectInputStream(fis);
                system = (Sistema) ois.readObject();
            }
            ois.close();
        } else {
            f.createNewFile();
        }
        return system;
    }
}
