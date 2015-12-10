package Shop.product;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 14/11/2015.
 */
@Component
public class ProductDao {

    private final Connection connection;

    @Inject
    public ProductDao(Connection connection) {
        this.connection = connection;
    }


    public List<Product> getProduct(String productId) {

        List<Product> list = new ArrayList<>();

        try {

            String query = "select * from shop.product where product_name like ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {

                Product product = new Product(result.getString("product_name"), result.getInt("stock"), result.getInt("price"));
                list.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public void addProduct(Product product) {

        String query = "insert into product(product_name, stock, price) values(?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getStock());
            preparedStatement.setDouble(3, product.getPrice());

            preparedStatement.execute();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}