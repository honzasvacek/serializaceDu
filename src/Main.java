import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException{

        File file = new File("data.dat");

        ArrayList<Auto> arr;

        if(file.exists()) {
            //soubor existuje
            FileInputStream fos = new FileInputStream(file);
            ObjectInputStream oos = new ObjectInputStream(fos);
            //prectu soubor(predchozi arralist) pomoci 'readObject'
            //nasledne ho vlozim do arraylistu, se kterým budu pracovat dále
            arr = (ArrayList<Auto>)oos.readObject();

            oos.close();
            System.out.println(arr);
        } else {
            arr = new ArrayList<Auto>();
        }
        //vytvoreni noveho auta
        Auto auto = new Auto();

        arr.add(auto);

        //deklarace outputu
        FileOutputStream fus = new FileOutputStream(file);
        ObjectOutputStream ous = new ObjectOutputStream(fus);

        //zapisu finalni arraylist do souboru(predchozi arraylist)
        ous.writeObject(arr);

        //zavru writer
        ous.close();
    }
}