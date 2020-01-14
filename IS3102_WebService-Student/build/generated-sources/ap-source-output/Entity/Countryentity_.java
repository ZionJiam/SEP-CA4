package Entity;

import Entity.ItemCountryentity;
import Entity.Memberentity;
import Entity.Storeentity;
import Entity.Warehouseentity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T10:15:01")
@StaticMetamodel(Countryentity.class)
public class Countryentity_ { 

    public static volatile ListAttribute<Countryentity, Memberentity> memberentityList;
    public static volatile SingularAttribute<Countryentity, Double> exchangerate;
    public static volatile SingularAttribute<Countryentity, Integer> countrycode;
    public static volatile SingularAttribute<Countryentity, String> name;
    public static volatile SingularAttribute<Countryentity, String> currency;
    public static volatile SingularAttribute<Countryentity, Long> id;
    public static volatile ListAttribute<Countryentity, ItemCountryentity> itemCountryentityList;
    public static volatile ListAttribute<Countryentity, Warehouseentity> warehouseentityList;
    public static volatile ListAttribute<Countryentity, Storeentity> storeentityList;

}