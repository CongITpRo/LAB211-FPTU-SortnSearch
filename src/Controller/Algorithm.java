/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Element;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Algorithm {

    Scanner sc = new Scanner(System.in);
    static Element e = new Element();
// Bubble Sort

    public void sortArrayByBubbleSort() {
        inputArray();
        System.out.println("Random Unsorted array: ");
        int a[] = e.getArr();
        displayArr(e, a);
        System.out.println("\nRandom Sorted array: ");
        for (int i = 0; i < e.getArraySize(); i++) {
            for (int j = 0; j < e.getArraySize() - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        displayArr(e, a);
        System.out.println();
    }

// Quick Sort
    public int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int mid = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < mid) {
                i++;
            }
            while (arr[j] > mid) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };
        return i;
    }

    public void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }

    }
    //Binary Search 
    public int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, value, left, middle - 1);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }
    //Linear Search
    public int linerSearch(int key) {
        int[] arr = e.getArr();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

//Function    
    public void displayArr(Element e, int a[]) {
        for (int i = 0; i < e.getArraySize(); i++) {
            System.out.print(a[i] + " ");
        }
    }

    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    public int getIntFromInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(msg);
            try {
                number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Only enter the integer number > 0 ");
                sc.next();
            }
        }
    }

    public void inputArray() {
//        Element e = new Element();
        Scanner sc = new Scanner(System.in);
        e.setArraySize(getIntFromInput("Enter array size: "));
        int[] arr = new int[e.getArraySize()];
        for (int i = 0; i < e.getArraySize(); i++) {
            arr[i] = getIntFromInput("Enter a[" + i + "]");
        }
        e.setArr(arr);
    }

}
