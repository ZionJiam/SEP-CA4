package Entity;

import Entity.Countryentity;
import Entity.Itementity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T10:15:01")
@StaticMetamodel(ItemCountryentity.class)
public class ItemCountryentity_ { 

    public static volatile SingularAttribute<ItemCountryentity, Itementity> itemId;
    public static volatile SingularAttribute<ItemCountryentity, Double> retailprice;
    public static volatile SingularAttribute<ItemCountryentity, Long> id;
    public static volatile SingularAttribute<ItemCountryentity, Boolean> isdeleted;
    public static volatile SingularAttribute<ItemCountryentity, Countryentity> countryId;

}