package OnlainShop.DAO.lmpl;

import OnlainShop.DAO.ProductsDAO;
import OnlainShop.DataBase.DataBase;
import OnlainShop.Models.Products;
import OnlainShop.enums.Category;

import java.util.Arrays;

public class Productslmpl implements ProductsDAO {

    Products products = new Products();
    private int size;
    private int sizeForIz;
    @Override
    public void addProduct(Products products) {
        DataBase.products = Arrays.copyOf(DataBase.products,DataBase.products.length+1);
        DataBase.products[DataBase.products.length-1]=products;
        size++;
    }
    @Override
    public void deleteProductById(long id) {
        for (int i = 0; i < size; i++) {
            if (DataBase.products[i].getId()==id){
                for (int i1 = i; i1 < size-1; i1++) {
                    DataBase.products[i]=DataBase.products[i+1];
                }
                size--;
                System.out.println("Deleted!");
            }
            DataBase.products =Arrays.copyOf(DataBase.products,DataBase.products.length-1);
        }
    }
    @Override
    public void updateById(long id ,Products products) {
        for (int i = 0; i < DataBase.products.length; i++) {
            if (DataBase.products[i].getId()==id){
                DataBase.products[i]=products;
            }
            else {
                System.out.println(id+" not found!");
            }
        }
    }
    @Override
    public void getSizesWithCategory(Category category) {
        for (int i = 0; i < DataBase.products.length; i++) {
            if (category.equals(DataBase.products[i].getCategory())){
                System.out.println(DataBase.products[i]);
            }
        }
    }
    @Override
    public void izbraanyi(long id) {
        for (int i = 0; i < DataBase.products.length; i++) {
            if (DataBase.products[i].getId()==id){
                DataBase.uzbrannyi=Arrays.copyOf(DataBase.products,DataBase.uzbrannyi.length+1);
                DataBase.uzbrannyi[DataBase.uzbrannyi.length-1]=DataBase.products[i];
                sizeForIz++;
            }
        }
    }
    @Override
    public void deleteById(long id) {
        for (int i = 0; i < sizeForIz; i++) {
            if (DataBase.uzbrannyi[i].getId()==id){
                for (int i1 = i; i1 < sizeForIz-1; i1++) {
                    DataBase.uzbrannyi[i]=DataBase.uzbrannyi[1+i];
                }
                sizeForIz--;
                System.out.println("Deleted!");
            }
            DataBase.uzbrannyi=Arrays.copyOf(DataBase.uzbrannyi,DataBase.uzbrannyi.length-1);
        }
    }
    @Override
    public void getAllIz() {
        for (Products products1 : DataBase.uzbrannyi) {
            System.out.println(products1);
        }
    }
    @Override
    public void getById(long id) {
        for (int i = 0; i < DataBase.uzbrannyi.length; i++) {
            if (DataBase.uzbrannyi[i].getId()==id){
                System.out.println(DataBase.uzbrannyi[i]);
            }
        }
    }
    @Override
    public void getAll() {
        for (Products product : DataBase.products) {
            System.out.println(product);
        }
    }
}
