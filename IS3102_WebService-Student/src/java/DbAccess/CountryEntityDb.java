/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author futur
 */
public class CountryEntityDb {
    public int getQuantity(String sku) {
        int qty = 0;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/islandfurniture-it07?zeroDateTimeBehavior=convertToNull&user=root&password=12345");
            String stmt = "SELECT li.QUANTITY as sum from country_ecommerce c, warehouseentity w, storagebinentity sb, storagebinentity_lineitementity sbli, lineitementity li, "
                    + "itementity i WHERE li.ITEM_ID=i.ID and sbli.lineItems_ID=li.ID and sb.ID=sbli.StorageBinEntity_ID and w.id=sb.WAREHOUSE_ID and c.warehouseentity_id=w.id "
                    + "and sb.type<>'Outbound' and i.SKU=?";
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setString(1, sku);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                qty = rs.getInt("sum");
                System.out.println("Quantity: " + qty);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return qty;
    }
}
