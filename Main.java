import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Item{

public String name;
public String sNumber;
public int value;

  public Item(){

  }
  
public Item(String name, String sNumber, int value){
  this.name = name;
  this.sNumber = sNumber;
  this.value = value;
}

public void setName(String name){
  this.name = name;
}

public void setSNumber(String sNumber){
      this.sNumber = sNumber;
    }

public void setvalue(int value){
      this.value = value;
    }

public String getName(){
      return name;
    }

 public String getSNumber(){
      return sNumber;
    }

  public int getValue(){
      return value;
    }
  

}

public class Main {

  
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Item> inventory = new ArrayList<Item>();
    public static void main(String [] args) throws InputMismatchException{
    int option = 0;

  boolean run = true;
    while (run){
        System.out.println("Press 1 to add an item.\nPress 2 to delete an item." + 
         "\nPress 3 to update an item.\nPress 4 to show all the items." + 
         "\nPress 5 to quit the program.");
         option = input.nextInt();
         input.nextLine();
        switch(option){
            case 1: addItem(); break;
            case 2: deleteItem(); break;
            case 3: updateItem(); break;
            case 4: print(); break;
            case 5: run = false; break;
            default: break;
            }
    }
  }

public static void addItem(){
    Item newItem = new Item();

  System.out.println("Enter the name:");
  String name = input.nextLine();
  newItem.setName(name);

  System.out.println("Enter the serial number:");
  String sNumber = input.nextLine();
  newItem.setSNumber(sNumber);

  System.out.println("Enter the value in dollars (whole number):");
  int value = input.nextInt();
    input.nextLine();
    newItem.setvalue(value);


    inventory.add(newItem);
  
}

  public static void deleteItem(){
    System.out.println("Enter the serial number of the item to delete:");
    String sNumber = input.nextLine();

  for(int i = 0; i < inventory.size(); i++){
      
    if(inventory.get(i).getSNumber().equals(sNumber)){
        inventory.remove(i);
      }
    }
  
  }

  public static void updateItem(){
    System.out.println("Enter the serial number of the item to change:");
    String sNumber = input.nextLine();

  System.out.println("Enter the new name:");
    String name = input.nextLine();

  System.out.println("Enter the new value in dollars (whole number):");
    int value = input.nextInt();
    input.nextLine();

  Item updatedElement = new Item(name, sNumber, value);

  for(int i = 0; i < inventory.size(); i++){

    if(inventory.get(i).getSNumber().equals(sNumber)){
      inventory.set(i, updatedElement);
    }
  }

  }
  
public static void print(){

    for(int i = 0; i < inventory.size(); i++){
      Item temp = inventory.get(i);
      System.out.println(temp.getName() + "," + temp.getSNumber() + "," + temp.getValue());
    }
  }
  
}