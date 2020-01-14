package Entity;

import Entity.Itementity;
import Entity.Memberentity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T10:15:01")
@StaticMetamodel(Lineitementity.class)
public class Lineitementity_ { 

    public static volatile SingularAttribute<Lineitementity, Itementity> itemId;
    public static volatile ListAttribute<Lineitementity, Memberentity> memberentityList;
    public static volatile SingularAttribute<Lineitementity, Integer> quantity;
    public static volatile SingularAttribute<Lineitementity, String> packtype;
    public static volatile SingularAttribute<Lineitementity, Long> id;

}