package dal;

import entity.Category;
import entity.Product;
import entity.Product_Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riel
 */
public class ProductDAO extends db.DBContext {

    public List<Product> getTopNewestProductsByCategoryID(int categoryID, int top) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "select top (?) p.*, c.name as cname from Product p "
                    + "join Category c on p.cid = c.cid WHERE c.cid = ? ORDER BY pid DESC";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, top);
            stm.setInt(2, categoryID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("pid"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setQuantity_stock(rs.getInt("quantity_stock"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setDisplay_resolution(rs.getString("display_resolution"));
                product.setProcessor(rs.getString("processor"));
                product.setProcessor_technology(rs.getString("processor_technology"));
                product.setGraphics(rs.getString("graphics"));
                product.setMemory(rs.getString("memory"));
                product.setHard_drive(rs.getString("hard_drive"));
                product.setWireless(rs.getString("wireless"));
                product.setPower_supply(rs.getString("power_supply"));
                product.setBattery(rs.getString("battery"));

                Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setName(rs.getString("cname"));

                product.setCategory(category);

                List<Product_Image> listImages = getListImageByPid(rs.getInt("pid"));
                product.setListImage(listImages);

                products.add(product);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return products;
    }

    public List<Product> getTopNewestProducts(int top) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "select top (?) p.*, c.name as cname from Product p "
                    + "join Category c on p.cid = c.cid ORDER BY pid DESC";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, top);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("pid"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setQuantity_stock(rs.getInt("quantity_stock"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setDisplay_resolution(rs.getString("display_resolution"));
                product.setProcessor(rs.getString("processor"));
                product.setProcessor_technology(rs.getString("processor_technology"));
                product.setGraphics(rs.getString("graphics"));
                product.setMemory(rs.getString("memory"));
                product.setHard_drive(rs.getString("hard_drive"));
                product.setWireless(rs.getString("wireless"));
                product.setPower_supply(rs.getString("power_supply"));
                product.setBattery(rs.getString("battery"));

                Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setName(rs.getString("cname"));

                product.setCategory(category);

                List<Product_Image> listImages = getListImageByPid(rs.getInt("pid"));
                product.setListImage(listImages);

                products.add(product);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return products;
    }

    public List<Product_Image> getListImageByPid(int pid) {
        List<Product_Image> listImages = new ArrayList<>();
        try {
            String sql = "select p.*, [pi].pi_id, [pi].pimage from Product p join Product_Image [pi] on p.pid = [pi].pid where p.pid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product_Image pi = new Product_Image();
                pi.setPid(rs.getInt("pid"));
                pi.setPi_id(rs.getInt("pi_id"));
                pi.setImage(rs.getString("pimage"));
                listImages.add(pi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listImages;
    }

    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "select p.*, c.name as cname from Product p "
                    + "join Category c on p.cid = c.cid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("pid"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setQuantity_stock(rs.getInt("quantity_stock"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setDisplay_resolution(rs.getString("display_resolution"));
                product.setProcessor(rs.getString("processor"));
                product.setProcessor_technology(rs.getString("processor_technology"));
                product.setGraphics(rs.getString("graphics"));
                product.setMemory(rs.getString("memory"));
                product.setHard_drive(rs.getString("hard_drive"));
                product.setWireless(rs.getString("wireless"));
                product.setPower_supply(rs.getString("power_supply"));
                product.setBattery(rs.getString("battery"));

                Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setName(rs.getString("cname"));

                product.setCategory(category);

                List<Product_Image> listImages = getListImageByPid(rs.getInt("pid"));
                product.setListImage(listImages);

                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Product getProductByID(int pid) {
        try {
            String sql = "select p.*, c.name as cname from Product p "
                    + "join Category c on p.cid = c.cid where pid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("pid"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setQuantity_stock(rs.getInt("quantity_stock"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setDisplay_resolution(rs.getString("display_resolution"));
                product.setProcessor(rs.getString("processor"));
                product.setProcessor_technology(rs.getString("processor_technology"));
                product.setGraphics(rs.getString("graphics"));
                product.setMemory(rs.getString("memory"));
                product.setHard_drive(rs.getString("hard_drive"));
                product.setWireless(rs.getString("wireless"));
                product.setPower_supply(rs.getString("power_supply"));
                product.setBattery(rs.getString("battery"));

                Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setName(rs.getString("cname"));

                product.setCategory(category);

                List<Product_Image> listImages = getListImageByPid(rs.getInt("pid"));
                product.setListImage(listImages);

                return product;

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> getProductByPageAndCategoryAndSort(int page, int cateid, int sortid, int PRODUCT_PAGE) {
        List<Product> products = new ArrayList<>();
        try {
            String presql = "with r as (\n"
                    + "SELECT p.*, c.name as cname FROM product p join Category c on p.cid = c.cid\n"
                    + ")\n"
                    + "\n"
                    + "select * from (\n"
                    + "SELECT ROW_NUMBER() OVER (ORDER BY";
            switch (sortid) {
                case 0:
                    presql += " pid ";
                    break;
                case 1:
                    presql += " name asc ";
                    break;
                case 2:
                    presql += " name desc ";
                    break;
                case 3:
                    presql += " price asc ";
                    break;
                case 4:
                    presql += " price desc ";
                    break;
            }
            String midsql = ") AS number , r.* FROM r where ";

            switch (cateid) {
                case 0:
                    midsql += " 1=1 ";
                    break;
                case 1:
                    midsql += " r.cid=1 ";
                    break;
                case 2:
                    midsql += " r.cid=2 ";
                    break;
                case 3:
                    midsql += " r.cid=3 ";
                    break;
            }

            String postsql = ") as aa where number between ? and ?";

            int from = page * PRODUCT_PAGE - (PRODUCT_PAGE - 1);
            int to = from + PRODUCT_PAGE - 1;

            String sql = presql + midsql + postsql;

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, from);
            stm.setInt(2, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("pid"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setQuantity_stock(rs.getInt("quantity_stock"));
                product.setOperating_system(rs.getString("operating_system"));
                product.setDisplay_resolution(rs.getString("display_resolution"));
                product.setProcessor(rs.getString("processor"));
                product.setProcessor_technology(rs.getString("processor_technology"));
                product.setGraphics(rs.getString("graphics"));
                product.setMemory(rs.getString("memory"));
                product.setHard_drive(rs.getString("hard_drive"));
                product.setWireless(rs.getString("wireless"));
                product.setPower_supply(rs.getString("power_supply"));
                product.setBattery(rs.getString("battery"));

                Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setName(rs.getString("cname"));

                product.setCategory(category);

                List<Product_Image> listImages = getListImageByPid(rs.getInt("pid"));
                product.setListImage(listImages);

                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public int getNumberPageByCategory(int cateid, int PRODUCT_PAGE) {
        int numberProduct = 0;
        try {
            String sql = "select count(*) from Product where";
            PreparedStatement stm = null;
            if (cateid == 0) {
                sql += " 1=1";
                stm = connection.prepareStatement(sql);
            } else {
                sql += " cid = ?";
                stm = connection.prepareStatement(sql);
                stm.setInt(1, cateid);
            }

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                numberProduct = rs.getInt(1);
            }
            return numberProduct % PRODUCT_PAGE == 0 ? numberProduct / PRODUCT_PAGE : (numberProduct / PRODUCT_PAGE) + 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void updateProduct(Product p) {
        try {
            String sql = "update [Product] set "
                    + "[name] = ?, "
                    + "[price] = ?, "
                    + "[description] = ?, "
                    + "[quantity_stock] = ?, "
                    + "[cid] = ?, "
                    + "[operating_system] = ?, "
                    + "[display_resolution] = ?, "
                    + "[processor] = ?, "
                    + "[processor_technology] = ?, "
                    + "[graphics] = ?, "
                    + "[memory] = ?, "
                    + "[hard_drive] = ?, "
                    + "[wireless] = ?, "
                    + "[power_supply] = ?, "
                    + "[battery] = ? "
                    + "where [pid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, p.getName());
            stm.setDouble(2, p.getPrice());
            stm.setString(3, p.getDescription());
            stm.setInt(4, p.getQuantity_stock());
            stm.setInt(5, p.getCategory().getCid());
            stm.setString(6, p.getOperating_system());
            stm.setString(7, p.getDisplay_resolution());
            stm.setString(8, p.getProcessor());
            stm.setString(9, p.getProcessor_technology());
            stm.setString(10, p.getGraphics());
            stm.setString(11, p.getMemory());
            stm.setString(12, p.getHard_drive());
            stm.setString(13, p.getWireless());
            stm.setString(14, p.getPower_supply());
            stm.setString(15, p.getBattery());
            stm.setInt(16, p.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertProduct(Product p) {
        String sql = "INSERT INTO Product ([name], [price], [description], [quantity_stock],"
                + "[cid], [operating_system], [display_resolution], [processor], [processor_technology],"
                + "[graphics], [memory], [hard_drive], [wireless], [power_supply], [battery])\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, p.getName());
            stm.setDouble(2, p.getPrice());
            stm.setString(3, p.getDescription());
            stm.setInt(4, p.getQuantity_stock());
            stm.setInt(5, p.getCategory().getCid());
            stm.setString(6, p.getOperating_system());
            stm.setString(7, p.getDisplay_resolution());
            stm.setString(8, p.getProcessor());
            stm.setString(9, p.getProcessor_technology());
            stm.setString(10, p.getGraphics());
            stm.setString(11, p.getMemory());
            stm.setString(12, p.getHard_drive());
            stm.setString(13, p.getWireless());
            stm.setString(14, p.getPower_supply());
            stm.setString(15, p.getBattery());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeProduct(int pid) {
        String sql = "DELETE FROM Product WHERE pid = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
