import javax.swing.*;
import java.util.Random;
import java.util.Vector;

public class Main {

    public static final int WINDOWWIDTH = 1800;
    public static final int WINDOWHEIGHT = 950;
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WINDOWWIDTH, WINDOWHEIGHT);
        Vector <Integer> array = arrayMaker(); // CREO ARRAY

        arrayRandom(array); // MIXO L'ARRAY
        Visualizer visualizer = new Visualizer(array);
        frame.add(visualizer);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void arrayRandom(Vector <Integer> arr) {
        Random random = new Random();
        Vector<Integer> temp = new Vector<>();
        temp.setSize(arr.size());
        for (Integer integer : arr) {
            temp.set(integer, integer);
        }

        for (int i = 0; i < arr.size(); i++) {
            int temporaneo = random.nextInt(temp.size());
            arr.set(i, temp.get(temporaneo));
            temp.remove(temporaneo);
        }
    }

    public static Vector <Integer> arrayMaker() {
        Vector <Integer> arr = new Vector <>(100);
        arr.setSize(50000);
        for (int i = 0; i < arr.size(); i++)
            arr.set(i,i);
        return arr;
    }


}




