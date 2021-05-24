package DTO;

import DTO.Deals;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-23T20:04:04")
@StaticMetamodel(Usurs.class)
public class Usurs_ { 

    public static volatile SingularAttribute<Usurs, String> password;
    public static volatile SingularAttribute<Usurs, String> salt;
    public static volatile ListAttribute<Usurs, Deals> dealsList;
    public static volatile SingularAttribute<Usurs, String> name;
    public static volatile SingularAttribute<Usurs, Integer> id;
    public static volatile SingularAttribute<Usurs, String> email;
    public static volatile SingularAttribute<Usurs, String> lastname;

}