package DTO;

import DTO.Deals;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-23T20:04:04")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> image;
    public static volatile SingularAttribute<Products, Date> createdAt;
    public static volatile SingularAttribute<Products, Integer> price;
    public static volatile SingularAttribute<Products, Deals> dealId;
    public static volatile ListAttribute<Products, Deals> dealsList;
    public static volatile SingularAttribute<Products, String> name;
    public static volatile SingularAttribute<Products, String> description;
    public static volatile SingularAttribute<Products, Boolean> active;
    public static volatile SingularAttribute<Products, Integer> id;
    public static volatile SingularAttribute<Products, Integer> likes;

}