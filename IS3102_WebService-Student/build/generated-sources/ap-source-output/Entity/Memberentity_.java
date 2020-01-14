package Entity;

import Entity.Countryentity;
import Entity.Lineitementity;
import Entity.Loyaltytierentity;
import Entity.Wishlistentity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-26T10:15:01")
@StaticMetamodel(Memberentity.class)
public class Memberentity_ { 

    public static volatile SingularAttribute<Memberentity, Integer> income;
    public static volatile SingularAttribute<Memberentity, String> occupation;
    public static volatile SingularAttribute<Memberentity, String> city;
    public static volatile SingularAttribute<Memberentity, String> securityanswer;
    public static volatile SingularAttribute<Memberentity, Boolean> accountactivationstatus;
    public static volatile SingularAttribute<Memberentity, Boolean> isdeleted;
    public static volatile SingularAttribute<Memberentity, Countryentity> countryId;
    public static volatile SingularAttribute<Memberentity, Long> id;
    public static volatile SingularAttribute<Memberentity, String> email;
    public static volatile SingularAttribute<Memberentity, String> loyaltycardid;
    public static volatile SingularAttribute<Memberentity, Date> joindate;
    public static volatile SingularAttribute<Memberentity, String> address;
    public static volatile SingularAttribute<Memberentity, String> activationcode;
    public static volatile SingularAttribute<Memberentity, String> passwordsalt;
    public static volatile SingularAttribute<Memberentity, Boolean> servicelevelagreement;
    public static volatile SingularAttribute<Memberentity, Boolean> accountlockstatus;
    public static volatile SingularAttribute<Memberentity, Wishlistentity> wishlistId;
    public static volatile SingularAttribute<Memberentity, Integer> securityquestion;
    public static volatile SingularAttribute<Memberentity, String> zipcode;
    public static volatile ListAttribute<Memberentity, Lineitementity> lineitementityList;
    public static volatile SingularAttribute<Memberentity, Double> cumulativespending;
    public static volatile SingularAttribute<Memberentity, String> phone;
    public static volatile SingularAttribute<Memberentity, Date> dob;
    public static volatile SingularAttribute<Memberentity, Integer> loyaltypoints;
    public static volatile SingularAttribute<Memberentity, String> name;
    public static volatile SingularAttribute<Memberentity, String> passwordreset;
    public static volatile SingularAttribute<Memberentity, String> passwordhash;
    public static volatile SingularAttribute<Memberentity, String> unlockcode;
    public static volatile SingularAttribute<Memberentity, Integer> age;
    public static volatile SingularAttribute<Memberentity, Loyaltytierentity> loyaltytierId;

}