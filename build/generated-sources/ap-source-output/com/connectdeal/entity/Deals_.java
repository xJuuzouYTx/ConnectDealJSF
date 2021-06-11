package com.connectdeal.entity;

import com.connectdeal.entity.Products;
import com.connectdeal.entity.Usurs;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T01:24:16")
@StaticMetamodel(Deals.class)
public class Deals_ { 

    public static volatile SingularAttribute<Deals, String> whatsapp;
    public static volatile SingularAttribute<Deals, String> image;
    public static volatile SingularAttribute<Deals, String> website;
    public static volatile ListAttribute<Deals, Products> productsList;
    public static volatile SingularAttribute<Deals, BigDecimal> lng;
    public static volatile SingularAttribute<Deals, String> facebook;
    public static volatile SingularAttribute<Deals, String> description;
    public static volatile SingularAttribute<Deals, String> instagram;
    public static volatile SingularAttribute<Deals, Usurs> userId;
    public static volatile SingularAttribute<Deals, BigDecimal> qualification;
    public static volatile SingularAttribute<Deals, String> twitter;
    public static volatile SingularAttribute<Deals, String> phone;
    public static volatile SingularAttribute<Deals, String> name;
    public static volatile SingularAttribute<Deals, Integer> id;
    public static volatile SingularAttribute<Deals, BigDecimal> lat;

}