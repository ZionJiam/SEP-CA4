package Entity;

import Entity.Storeentity;
import Entity.Warehouseentity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T10:15:01")
@StaticMetamodel(Regionalofficeentity.class)
public class Regionalofficeentity_ { 

    public static volatile SingularAttribute<Regionalofficeentity, String> address;
    public static volatile SingularAttribute<Regionalofficeentity, String> name;
    public static volatile SingularAttribute<Regionalofficeentity, String> telephone;
    public static volatile SingularAttribute<Regionalofficeentity, Long> id;
    public static volatile SingularAttribute<Regionalofficeentity, Boolean> isdeleted;
    public static volatile SingularAttribute<Regionalofficeentity, String> email;
    public static volatile ListAttribute<Regionalofficeentity, Warehouseentity> warehouseentityList;
    public static volatile ListAttribute<Regionalofficeentity, Storeentity> storeentityList;

}