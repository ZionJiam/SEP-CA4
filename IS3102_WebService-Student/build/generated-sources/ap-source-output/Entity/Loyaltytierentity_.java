package Entity;

import Entity.Memberentity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T10:15:01")
@StaticMetamodel(Loyaltytierentity.class)
public class Loyaltytierentity_ { 

    public static volatile ListAttribute<Loyaltytierentity, Memberentity> memberentityList;
    public static volatile SingularAttribute<Loyaltytierentity, String> tier;
    public static volatile SingularAttribute<Loyaltytierentity, Long> id;
    public static volatile SingularAttribute<Loyaltytierentity, Boolean> isdeleted;
    public static volatile SingularAttribute<Loyaltytierentity, Double> amtofspendingrequired;

}