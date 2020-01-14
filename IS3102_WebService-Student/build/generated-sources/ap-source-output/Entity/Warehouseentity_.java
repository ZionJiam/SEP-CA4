package Entity;

import Entity.Countryentity;
import Entity.Itementity;
import Entity.Regionalofficeentity;
import Entity.Storeentity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T10:15:01")
@StaticMetamodel(Warehouseentity.class)
public class Warehouseentity_ { 

    public static volatile ListAttribute<Warehouseentity, Itementity> itementityList;
    public static volatile SingularAttribute<Warehouseentity, String> address;
    public static volatile SingularAttribute<Warehouseentity, Regionalofficeentity> regionalofficeId;
    public static volatile SingularAttribute<Warehouseentity, String> telephone;
    public static volatile SingularAttribute<Warehouseentity, Long> id;
    public static volatile SingularAttribute<Warehouseentity, Boolean> isdeleted;
    public static volatile SingularAttribute<Warehouseentity, String> email;
    public static volatile SingularAttribute<Warehouseentity, Countryentity> countryId;
    public static volatile SingularAttribute<Warehouseentity, String> warehousename;
    public static volatile ListAttribute<Warehouseentity, Storeentity> storeentityList;

}