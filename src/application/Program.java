package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        System.out.print("Qual departamento deseja encontrar");
        int departmentId = sc.nextInt();
        Department department = new Department(departmentId, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        if (list == null) {
            System.out.println("Não existe departamento com este ID");
        } else {
            for (Seller seller1 : list) {
                System.out.println(seller1);
            }
        }
    }
}
