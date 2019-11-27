package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigBanco {

    
    public static String[] Ler(){
        BufferedReader reader = null;
        String[] dados = new String[3];
        try {
            reader = new BufferedReader(new FileReader("ConfigBanco.txt"));
            for (int i = 0; i < 3; i++) {
                dados[i] = reader.readLine();
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(ConfigBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }
    public static void Escrever(String[] dados){
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter("ConfigBanco.txt"));
            for (int i = 0; i < 3; i++) {
                write.write(dados[i] + "\n");
            }
            write.close();
        } catch (IOException ex) {
            Logger.getLogger(ConfigBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
