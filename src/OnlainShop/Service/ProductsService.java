package OnlainShop.Service;

import OnlainShop.Models.Products;

public interface ProductsService {

    Products saveProducts();

    void deleteProductById();

    void updateById();

    void getAll();

    void getSizesWithCategory();

    void izbraanyi();

    void deleteById();

    void getAIIIz();

    void getAllIz();

    void getById();
}
