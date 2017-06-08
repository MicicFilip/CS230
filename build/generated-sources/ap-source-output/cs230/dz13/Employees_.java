package cs230.dz13;

import cs230.dz13.DeptEmp;
import cs230.dz13.DeptManager;
import cs230.dz13.Salaries;
import cs230.dz13.Titles;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-08T20:16:14")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile SingularAttribute<Employees, String> firstName;
    public static volatile SingularAttribute<Employees, String> lastName;
    public static volatile SingularAttribute<Employees, Date> hireDate;
    public static volatile SingularAttribute<Employees, String> gender;
    public static volatile CollectionAttribute<Employees, Salaries> salariesCollection;
    public static volatile SingularAttribute<Employees, Integer> empNo;
    public static volatile SingularAttribute<Employees, Date> birthDate;
    public static volatile CollectionAttribute<Employees, DeptEmp> deptEmpCollection;
    public static volatile CollectionAttribute<Employees, Titles> titlesCollection;
    public static volatile CollectionAttribute<Employees, DeptManager> deptManagerCollection;

}