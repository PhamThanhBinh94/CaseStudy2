package CaseStudyModule2;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteFile {
    ArrayList<Product> readObjectFile(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Product> products = new ArrayList<>();
        Product product;
        try {
            while ((product = (Product) objectInputStream.readObject()) != null){
                products.add(product);
            }
        } catch (EOFException ex){
        }
        return products;
    }
    void writeObjectFile(String path, ArrayList<Product> products) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Product product: products){
            objectOutputStream.writeObject(product);
        }
    }
}
