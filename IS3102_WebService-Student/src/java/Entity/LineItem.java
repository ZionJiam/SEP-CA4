/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author futur
 */
public class LineItem {
    
    private Long lineItemId;
    private Long itemEntityId;
    private int  quantity;
    
    public LineItem(){
        
    }
    
    public LineItem(Long lineItemId, Long itemEntityId, int quantity) {
        this.lineItemId = lineItemId;
        this.itemEntityId = itemEntityId;
        this.quantity = quantity;
    }

    public Long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
    }

    public Long getItemEntityId() {
        return itemEntityId;
    }

    public void setItemEntityId(Long itemEntityId) {
        this.itemEntityId = itemEntityId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
