package Entity;

import Entity.Furnitureentity;
import Entity.ItemCountryentity;
import Entity.Lineitementity;
import Entity.Retailproductentity;
import Entity.Warehouseentity;
import Entity.Wishlistentity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T10:15:01")
@StaticMetamodel(Itementity.class)
public class Itementity_ { 

    public static volatile SingularAttribute<Itementity, Retailproductentity> retailproductentity;
    public static volatile SingularAttribute<Itementity, Warehouseentity> warehousesId;
    public static volatile SingularAttribute<Itementity, Integer> length;
    public static volatile SingularAttribute<Itementity, String> dtype;
    public static volatile SingularAttribute<Itementity, String> description;
    public static volatile SingularAttribute<Itementity, String> type;
    public static volatile SingularAttribute<Itementity, Boolean> isdeleted;
    public static volatile SingularAttribute<Itementity, Integer> volume;
    public static volatile ListAttribute<Itementity, Lineitementity> lineitementityList;
    public static volatile SingularAttribute<Itementity, String> name;
    public static volatile SingularAttribute<Itementity, Integer> width;
    public static volatile SingularAttribute<Itementity, Long> id;
    public static volatile SingularAttribute<Itementity, String> sku;
    public static volatile SingularAttribute<Itementity, String> category;
    public static volatile ListAttribute<Itementity, Wishlistentity> wishlistentityList;
    public static volatile SingularAttribute<Itementity, Furnitureentity> furnitureentity;
    public static volatile ListAttribute<Itementity, ItemCountryentity> itemCountryentityList;
    public static volatile SingularAttribute<Itementity, Integer> height;

}