package OnlainShop.Service.lmpl;

import OnlainShop.DAO.ProductsDAO;
import OnlainShop.Models.Products;
import OnlainShop.Service.ProductsService;
import OnlainShop.enums.Category;
import OnlainShop.enums.Size;

import java.util.Arrays;
import java.util.Scanner;

public class Productslmpl implements ProductsService {

    private ProductsDAO productsDAO;
    Products products = new Products();
    Scanner scanner = new Scanner(System.in);
    Scanner scannerForInt = new Scanner(System.in);
    public void ProductsImpl(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    public Productslmpl(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @Override
    public Products saveProducts() {
        boolean isTrue = false;
        System.out.println("Category: \n1.M\n2.W\n3.Child) ");
        do {
            try {
                Scanner scanner1 = new Scanner(System.in);
                int category = scanner1.nextInt();
                isTrue = false;
                switch (category) {
                    case 1 -> {
                        products.setCategory(Category.MAN);
                    }
                    case 2 -> {
                        products.setCategory(Category.WOMAN);
                    }
                    case 3 -> {
                        products.setCategory(Category.CHILDREN);
                    }
                    default -> {
                        System.out.print("Invalid command!\nNumber: ");
                        isTrue = true;
                    }
                }
            } catch (RuntimeException r) {
                System.out.println("Invalid command!");
                isTrue = true;
            }
        } while (isTrue);
        System.out.print("name: ");
        String name = "";
        boolean forName = false;
        do {
            Scanner scanner1 = new Scanner(System.in);
            name = scanner1.nextLine();
            forName = false;
            if (name.isEmpty()) {
                System.out.print("Invalid name!\nName: ");
                forName = true;
            }
        } while (forName);
        System.out.print("Price: ");
        int price = 0;
        boolean forPrice = false;
        do {
            try {
                Scanner scanner1 = new Scanner(System.in);
                price = scanner1.nextInt();
                forPrice = false;
                if (price <= 0) {
                    System.out.print("Invalid price!\nPrice: ");
                    forPrice = true;
                }
            } catch (RuntimeException r) {
                System.out.print("Invalid price!\nPrice: ");
                forPrice = true;
            }
        } while (forPrice);
        System.out.println("Sizes!");
        Size[] array = Size.values();
        Size[] array2 = new Size[0];
        int number = 0;
        for (Size size : array) {
            number++;
            System.out.println(number + "." + size);
        }
        System.out.println((number + 1) + ".Log out!");
        while (true) {
            System.out.print("Введите номер размера (от 0 до " + (array.length - 1) + "), или 8 для выхода: ");
            try {
                int sizeNumber = scannerForInt.nextInt();
                if (sizeNumber == 8) {
                    System.out.println("До свидания!");
                    break;
                } else if (sizeNumber >= 0 && sizeNumber < array.length) {
                    array2 = Arrays.copyOf(array2, array2.length + 1);
                    array2[array2.length - 1] = array[sizeNumber - 1];
                } else {
                    System.out.println("Некорректный номер размера. Попробуйте снова.");
                }
                System.out.println("Выбранные размеры: " + Arrays.toString(array2));
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Введите число!");
                scannerForInt.next();
            }
        }
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Image Url: ");
        String url = scanner.nextLine();
        System.out.print("Quantity: ");
        int qua = scannerForInt.nextInt();
        productsDAO.addProduct(new Products(products.getCategory(), name, price, array2, color, url, qua));
        return products;
    }
    @Override
    public void deleteProductById() {
        boolean is = false;
        do {
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.print("Write the id: ");
                int id = scanner1.nextInt();
                productsDAO.deleteProductById(id);
                is = false;
            } catch (RuntimeException e) {
                is = true;
                System.out.println("Invalid command!");
            }
        } while (is);
    }
    @Override
    public void updateById() {
        boolean is = false;
        do {
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.print("Write the id: ");
                int id = scanner1.nextInt();
                productsDAO.updateById(id, saveProducts());
                is = false;
            } catch (RuntimeException e) {
                is = true;
                System.out.println("Invalid command!");
            }
        } while (is);
    }
    @Override
    public void getAll() {
        productsDAO.getAll();
    }
    @Override
    public void getSizesWithCategory() {
        Category[] category = Category.values();
        int number = 0;
        for (int i = 0; i < category.length; i++) {
            number++;
            System.out.println(number + "." + category[i]);
        }
        boolean is = false;
        do {
            try {
                System.out.print("Which category: ");
                int categoryForUser = scanner.nextInt();
                switch (categoryForUser) {
                    case 1 -> {
                        productsDAO.getSizesWithCategory(Category.MAN);
                        is = false;
                    }
                    case 2 -> {
                        productsDAO.getSizesWithCategory(Category.WOMAN);
                        is = false;
                    }
                    case 3 -> {
                        productsDAO.getSizesWithCategory(Category.CHILDREN);
                        is = false;
                    }
                    default -> {
                        System.out.println("Invalid number!");
                    }
                }
            } catch (RuntimeException r) {
                System.out.println("Invalid command!");
                is = true;
            }
        } while (is);
    }
    @Override
    public void izbraanyi() {
        System.out.println("id: ");
        int id = scannerForInt.nextInt();
        productsDAO.izbraanyi(id);
    }
    @Override
    public void deleteById() {
        System.out.print("id:");
        int id = scannerForInt.nextInt();
        productsDAO.deleteById(id);
    }

    @Override
    public void getAIIIz() {

    }

    @Override
    public void getAllIz() {
        productsDAO.getAllIz();
    }
    @Override
    public void getById() {
        System.out.print("id: ");
        int id = scannerForInt.nextInt();
        productsDAO.getById(id);
    }
}
