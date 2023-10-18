package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        System.out.print("Qual departamento deseja encontrar: ");
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

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller seller1 : list) {
            System.out.println(seller1);
        }

//        System.out.println("\n=== TEST 4: seller insert ===");
//        Seller newSeller = new Seller();
//        sc.nextLine();
//        System.out.print("Name: ");
//        newSeller.setName(sc.nextLine());
//        System.out.print("Email: ");
//        newSeller.setEmail(sc.nextLine());
//        System.out.print("Data nascimento(dd/MM/yyyy): ");
//        newSeller.setBirthDate(sdt.parse(sc.nextLine()));
//        System.out.print("Base Salary: ");
//        newSeller.setBaseSalary(sc.nextDouble());
//        System.out.print("Department (1-4): ");
//        newSeller.setDepartment(new Department(sc.nextInt(), null));
//        sellerDao.insert(newSeller);
//        System.out.println("Inserted! new Id = "+ newSeller.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        System.out.printf("Qual id deseja mudar: ");
        seller = sellerDao.findById(sc.nextInt());
        System.out.print("Oque deseja mudar 1-Nome, 2-Email, 3-BirthDate, 4-BaseSalary, 5-Department: ");
        int choose = sc.nextInt();
        sc.nextLine();
        switch (choose) {
            case 1:
                System.out.printf("Digite o nome: ");
                seller.setName(sc.nextLine());
                break;
            case 2:
                System.out.printf("Digite o email: ");
                seller.setEmail(sc.nextLine());
                break;
            case 3:
                System.out.printf("Digite a data nascimento");
                seller.setBirthDate(sdt.parse(sc.nextLine()));
                break;
            case 4:
                System.out.printf("digite o salário");
                seller.setBaseSalary(sc.nextDouble());
                break;
            case 5:
                System.out.printf("Digite o departamento");
                seller.setDepartment(new Department(sc.nextInt(), null));
                break;
        }
        sellerDao.update(seller);
        System.out.println("Update completed");
    }
}
