/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbAccess;

import Entity.LineItem;
import Entity.SalesRecord;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author futur
 */
public class EcommerceEntityDb {

    public EcommerceEntityDb() {

    }

    public SalesRecord createSalesRecord(Long memberId, double amountPaid) {
        System.out.println("Member Id: " + memberId);
        SalesRecord salesRecord = new SalesRecord();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/islandfurniture-it07?zeroDateTimeBehavior=convertToNull&user=root&password=12345");
            String stmt = "INSERT into salesrecordentity (member_Id,amountDue, amountPaid) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(stmt,Statement.RETURN_GENERATED_KEYS);

            ps.setLong(1, memberId);
            ps.setDouble(2, amountPaid);
            ps.setDouble(3, amountPaid);

            int count = ps.executeUpdate();

            if (count == 0) {
                throw new SQLException("Fail to create Ecommerce transaction record");
            } else {
                long salesRecordId = 0;
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    salesRecordId = rs.getLong(1);

                    salesRecord.setSalesRecordId(salesRecordId);
                    salesRecord.setAmountPaid(amountPaid);
                    salesRecord.setAmountDue(amountPaid);
                    salesRecord.setMemberId(memberId);

                    System.out.println("Sales record id:createSalesRecord():" + salesRecordId);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return salesRecord;
    }

    public LineItem createLineItemRecord(long itemEntityId, int quantity) {
        System.out.println("createLineItemRecord: " + itemEntityId);
        LineItem lineItem = new LineItem();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/islandfurniture-it07?zeroDateTimeBehavior=convertToNull&user=root&password=12345");
            String stmt = "INSERT into lineitementity (ITEM_ID, QUANTITY) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(stmt, Statement.RETURN_GENERATED_KEYS);

            ps.setLong(1, itemEntityId);
            ps.setInt(2, quantity);

            int count = ps.executeUpdate();

            if (count == 0) {
                throw new SQLException("Fail to create Line item record");
            } else {
                long lineitemId = 0;
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    lineitemId = rs.getLong(1);
                    lineItem.setItemEntityId(itemEntityId);
                    lineItem.setQuantity(quantity);
                    lineItem.setLineItemId(lineitemId);

                    System.out.println("line item id: " + lineitemId);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lineItem;
    }

    public int createSalesRecordLineItem(long salesRecordId, long lineItemId) {
        System.out.println("createSalesRecordLineItem: " + salesRecordId);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/islandfurniture-it07?zeroDateTimeBehavior=convertToNull&user=root&password=12345");
            String stmt = "INSERT into salesrecordentity_lineitementity (SalesRecordEntity_ID, itemsPurchased_ID) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(stmt);

            ps = conn.prepareStatement(stmt);
            ps.setLong(1, salesRecordId);
            ps.setLong(2, lineItemId);

            int count = ps.executeUpdate();

            if (count == 0) {
                throw new SQLException("Create SalesRecord_LineItem failed");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 1;
    }

    public void updateItemQuantity(int quantity, long itemEntityId) {
        System.out.println("updateItemQuantity: " + quantity);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/islandfurniture-it07?zeroDateTimeBehavior=convertToNull&user=root&password=12345");
            String stmt = "UPDATE country_ecommerce c, warehouseentity w, storagebinentity sb, storagebinentity_lineitementity sbli, lineitementity li, itementity i "
                            + "SET li.QUANTITY = li.QUANTITY - ? WHERE li.ITEM_ID=i.ID and sbli.lineItems_ID=li.ID and sb.ID=sbli.StorageBinEntity_ID and " 
                            + "w.id=sb.WAREHOUSE_ID and c.warehouseentity_id=w.id and sb.type<>'Outbound' and i.ID=?;";
            
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, quantity);
            ps.setLong(2, itemEntityId);
            
            int count = ps.executeUpdate();
            if(count ==0){
                throw new SQLException("updateItemQuantity fail");
            }    
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void updateFreeVolume(int quantity, long itemEntityId){
        System.out.println("updateFreeVolume: " + quantity);
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/islandfurniture-it07?zeroDateTimeBehavior=convertToNull&user=root&password=12345");
            String stmt = "UPDATE country_ecommerce c, warehouseentity w, storagebinentity sb, storagebinentity_lineitementity sbli, lineitementity li, itementity i         "
                            + "SET sb.FREEVOLUME = sb.FREEVOLUME + ?*i.VOLUME WHERE li.ITEM_ID=i.ID and sbli.lineItems_ID=li.ID and sb.ID=sbli.StorageBinEntity_ID and " 
                            + "w.id=sb.WAREHOUSE_ID and c.warehouseentity_id=w.id and sb.type<>'Outbound' and i.ID=?;";
            
            PreparedStatement ps = conn.prepareStatement(stmt);
            ps.setInt(1, quantity);
            ps.setLong(2, itemEntityId);
            
            int count = ps.executeUpdate();
            if(count ==0){
                throw new SQLException("updateItemQuantity fail");
            }    
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
