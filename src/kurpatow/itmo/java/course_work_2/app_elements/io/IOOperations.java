package kurpatow.itmo.java.course_work_2.app_elements.io;

import java.io.*;

public class IOOperations<T> {

    private File file;

    public IOOperations() { setFile(); }

    public void setFile() {
        file = new File("game_progress.txt");
    }

    public T readFromFile() throws FileNotFoundException {
        Object result = null;

        try(FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ){
            result = objectInputStream.readObject();
        }catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return (T) result;
    }

    public void writeToFile(T object) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ){
            objectOutputStream.writeObject(object);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
