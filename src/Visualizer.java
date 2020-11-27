import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Visualizer extends JPanel {

    private boolean sorted = false;
    private Vector<Integer> arr;
    int xloc = 0, yloc = Main.WINDOWHEIGHT - 30, width;
    private int mannaia = 1;

    public Visualizer(Vector<Integer> arr) {
        this.setBackground(Color.BLACK);
        this.arr = arr;
        if (arr.size() > Main.WINDOWHEIGHT)
            width = 1;
        else
            width = Main.WINDOWHEIGHT / arr.size() * 2;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {

        for (int j : arr) {
            if (selected == j)
                g.setColor(Color.MAGENTA);
            else
                g.setColor(Color.YELLOW);
            if (Main.WINDOWHEIGHT / arr.size() != 0) {
                g.fillRect(xloc, yloc - j, width, j);
                    xloc += width + 1;
            } else {
                g.fillRect(xloc, yloc - j / (arr.size() / Main.WINDOWHEIGHT), width, j);
                if (mannaia%(arr.size())!=0) {
                    xloc+=1;
                }
                else {
                    xloc += width + 1;
                }
                mannaia += 1;
            }
        }
        xloc = 0;
        bubbleSort(arr);
        // non funzoina bene insertionSort(arr);
    }

    int selected = 0;

    public void bubbleSort(Vector<Integer> arr) {
        //BUBBLE SORT
       // System.out.println("entrato");
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) {
                selected = i - 1;
                int temp = arr.get(i - 1);
                arr.set(i - 1, arr.get(i));
                arr.set(i, temp);
            }
        }
       /* try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        repaint();

        if (isSorted())
            Main.arrayRandom(arr);
    }

    public void insertionSort(Vector<Integer> arr) {
        System.out.println("entrato");
        for (int i = 0; i < arr.size(); i++) {
            int current = arr.get(i);
            int j = i - 1;
            while (j >= 0 && current < arr.get(j)) {
                arr.set(j + 1, j);
                j--;
                repaint();
            }
            arr.set(j + 1, current);
            selected = j + 1;
        }
    }

    public boolean isSorted() {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1))
                return false;
        }
        return true;
    }
}
