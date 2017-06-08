package cs230.dz13;

import cs230.dz13.Departments;
import cs230.dz13.DeptManagerPK;
import cs230.dz13.Employees;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-08T20:16:14")
@StaticMetamodel(DeptManager.class)
public class DeptManager_ { 

    public static volatile SingularAttribute<DeptManager, Date> fromDate;
    public static volatile SingularAttribute<DeptManager, DeptManagerPK> deptManagerPK;
    public static volatile SingularAttribute<DeptManager, Date> toDate;
    public static volatile SingularAttribute<DeptManager, Departments> departments;
    public static volatile SingularAttribute<DeptManager, Employees> employees;

}