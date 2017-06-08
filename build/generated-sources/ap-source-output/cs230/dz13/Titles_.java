package cs230.dz13;

import cs230.dz13.Employees;
import cs230.dz13.TitlesPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-08T20:16:14")
@StaticMetamodel(Titles.class)
public class Titles_ { 

    public static volatile SingularAttribute<Titles, Date> toDate;
    public static volatile SingularAttribute<Titles, TitlesPK> titlesPK;
    public static volatile SingularAttribute<Titles, Employees> employees;

}