package types;

import controller.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static  void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        menu.menu();

    }


}
