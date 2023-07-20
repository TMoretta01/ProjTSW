package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class ProductDAO {

    public List<Product> getAllProducts() {
        
        List<Product> products = new ArrayList<>();
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM products WHERE (quantity>0)";
	        statement = connection.prepareStatement(query);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble("price");
	            String seller = resultSet.getString("seller");
	            String imgSrc = resultSet.getString("imgSrc");
	            Category category = Category.valueOf(resultSet.getString("category"));
	            int quantity = resultSet.getInt("quantity");
	            int favorites = resultSet.getInt("favorites");
	            Date listingDate = resultSet.getDate("listingDate");
	            String description = resultSet.getString("description");

	            Product product = new Product();
	            product.setId(id);
	            product.setName(name);
	            product.setPrice(price);
	            product.setSeller(seller);
	            product.setImgSrc(imgSrc);
	            product.setCategory(category);
	            product.setQuantity(quantity);
	            product.setFavorites(favorites);
	            product.setListingDate(listingDate);
	            product.setDescription(description);

	            products.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return products;
    }

    public List<Product> getFavoritesProducts() {
        
        List<Product> products = new ArrayList<>();
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM products WHERE (quantity>0) ORDER BY favorites DESC";
	        statement = connection.prepareStatement(query);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble("price");
	            String seller = resultSet.getString("seller");
	            String imgSrc = resultSet.getString("imgSrc");
	            Category category = Category.valueOf(resultSet.getString("category"));
	            int quantity = resultSet.getInt("quantity");
	            int favorites = resultSet.getInt("favorites");
	            Date listingDate = resultSet.getDate("listingDate");
	            String description = resultSet.getString("description");

	            Product product = new Product();
	            product.setId(id);
	            product.setName(name);
	            product.setPrice(price);
	            product.setSeller(seller);
	            product.setImgSrc(imgSrc);
	            product.setCategory(category);
	            product.setQuantity(quantity);
	            product.setFavorites(favorites);
	            product.setListingDate(listingDate);
	            product.setDescription(description);

	            products.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return products;
    }

    public List<Product> getProductsByCategory(String chosenCategory) { 

        List<Product> products = new ArrayList<>();
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT id, name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM products WHERE (quantity>0) AND (category=? OR category=? OR category=? OR category=?)";
	        statement = connection.prepareStatement(query);
	        
	        if (chosenCategory.equals("arte")) {
	            statement.setString(1, "fotografia");
	            statement.setString(2, "pittura");
	            statement.setString(3, "scultura");
	            statement.setString(4, "vetro");
	        } else if (chosenCategory.equals("abbigliamento")) {
	            statement.setString(1, "abbigliamento_uomo");
	            statement.setString(2, "abbigliamento_donna");
	            statement.setString(3, "abbigliamento_bambino");
	            statement.setString(4, "borsa");
	        } else if (chosenCategory.equals("gioiello")) {
	            statement.setString(1, "anello");
	            statement.setString(2, "bracciale");
	            statement.setString(3, "collana");
	            statement.setString(4, "orecchino");
	        } else if (chosenCategory.equals("intrattenimento")) {
	            statement.setString(1, "cinema");
	            statement.setString(2, "libro");
	            statement.setString(3, "musica");
	            statement.setString(4, "gioco");
	        } else {
	            statement.setString(1, chosenCategory);
	            statement.setString(2, "0");
	            statement.setString(3, "0");
	            statement.setString(4, "0");
	        }
	        
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	        	int id = resultSet.getInt("id");
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble("price");
	            String seller = resultSet.getString("seller");
	            String imgSrc = resultSet.getString("imgSrc");
	            Category category = Category.valueOf(resultSet.getString("category"));
	            int quantity = resultSet.getInt("quantity");
	            int favorites = resultSet.getInt("favorites");
	            Date listingDate = resultSet.getDate("listingDate");
	            String description = resultSet.getString("description");

	            Product product = new Product();
	            product.setId(id);
	            product.setName(name);
	            product.setPrice(price);
	            product.setSeller(seller);
	            product.setImgSrc(imgSrc);
	            product.setCategory(category);
	            product.setQuantity(quantity);
	            product.setFavorites(favorites);
	            product.setListingDate(listingDate);
	            product.setDescription(description);

	            products.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return products;
    }
    
    public Product getProductById(int productId) {
        
        Product product = new Product();
        
        Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

        try {
	        connection = DriverManagerConnectionPool.getConnection();
	        String query = "SELECT name, price, seller, imgSrc, category, quantity, favorites, listingDate, description FROM products WHERE id = ?";
	        statement = connection.prepareStatement(query);
	        
	        statement.setInt(1, productId);
	        
	        resultSet = statement.executeQuery();

	        if(resultSet.next()) {
	        	String name = resultSet.getString("name");
	            double price = resultSet.getDouble("price");
	            String seller = resultSet.getString("seller");
	            String imgSrc = resultSet.getString("imgSrc");
	            Category category = Category.valueOf(resultSet.getString("category"));
	            int quantity = resultSet.getInt("quantity");
	            int favorites = resultSet.getInt("favorites");
	            Date listingDate = resultSet.getDate("listingDate");
	            String description = resultSet.getString("description");

	            product.setName(name);
	            product.setPrice(price);
	            product.setSeller(seller);
	            product.setImgSrc(imgSrc);
	            product.setCategory(category);
	            product.setQuantity(quantity);
	            product.setFavorites(favorites);
	            product.setListingDate(listingDate);
	            product.setDescription(description);

	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return product;
    }
       
}