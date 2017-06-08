package cs230.dz13;

import cs230.dz13.DeptEmp;
import cs230.dz13.DeptManager;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-08T20:16:14")
@StaticMetamodel(Departments.class)
public class Departments_ { 

    public static volatile SingularAttribute<Departments, String> deptName;
    public static volatile SingularAttribute<Departments, String> deptNo;
    public static volatile CollectionAttribute<Departments, DeptEmp> deptEmpCollection;
    public static volatile CollectionAttribute<Departments, DeptManager> deptManagerCollection;

}