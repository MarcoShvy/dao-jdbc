package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

import java.sql.SQLException;
import java.util.Date;

public class Program {
    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}
