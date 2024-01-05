/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Algorithm;
import Model.Element;
import sortlab1.Main;

/**
 *
 * @author hoang
 */
public class SortMenu extends Menu {

    public SortMenu(String msg, String[] mc) {
        super(msg, mc);
    }

    Algorithm al = new Algorithm();
    Element e = new Element();

    @Override
    public void execute(int n) {
        int arr[];
        switch (n) {
            case 1:
                al.sortArrayByBubbleSort();
                break;
            case 2:
                al.inputArray();
                System.out.println("Random Unsorted array: ");
                arr = e.getArr();
                al.displayArr(e, arr);
                al.quickSort(arr, 0, arr.length - 1);
                System.out.println("\nRandom Sorted array: ");
                al.displayArr(e, arr);
                System.out.println();
                break;
            case 3:
                new Main().run();
                break;
            default:
                System.out.println("Invalid input");
        }
    }

}
