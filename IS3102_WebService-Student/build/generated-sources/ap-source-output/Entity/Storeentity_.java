package Entity;

import Entity.Countryentity;
import Entity.Regionalofficeentity;
import Entity.Warehouseentity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T10:15:01")
@StaticMetamodel(Storeentity.class)
public class Storeentity_ { 

    public static volatile SingularAttribute<Storeentity, String> address;
    public static volatile SingularAttribute<Storeentity, Warehouseentity> warehouseId;
    public static volatile SingularAttribute<Storeentity, String> postalcode;
    public static volatile SingularAttribute<Storeentity, Regionalofficeentity> regionalofficeId;
    public static volatile SingularAttribute<Storeentity, String> name;
    public static volatile SingularAttribute<Storeentity, String> telephone;
    public static volatile SingularAttribute<Storeentity, Long> id;
    public static volatile SingularAttribute<Storeentity, Boolean> isdeleted;
    public static volatile SingularAttribute<Storeentity, String> email;
    public static volatile SingularAttribute<Storeentity, Countryentity> countryId;

}