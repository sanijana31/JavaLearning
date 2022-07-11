package training.java;

import java.util.*;
import java.lang.*;

public class CreateListWithoutNewKey {
    public static void main(String args[]) {
        try {
            Class c = Class.forName("java.util.ArrayList");
            ArrayList<Integer> list = (ArrayList<Integer>) c.newInstance();
            list.add(45);
            list.add(4455);
            list.add(5);
            list.add(4);
            for (Integer e: list){
                System.out.println(e);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
