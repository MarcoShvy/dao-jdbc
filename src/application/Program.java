package application;

import model.entites.Department;
import model.entites.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args){

        Department obj = new Department(1, "TI");

        Seller seller = new Seller(11, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);

    }
}
