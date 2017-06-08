package cs230.dz13;

import cs230.dz13.Departments;
import cs230.dz13.DeptEmpPK;
import cs230.dz13.Employees;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-08T20:16:14")
@StaticMetamodel(DeptEmp.class)
public class DeptEmp_ { 

    public static volatile SingularAttribute<DeptEmp, Date> fromDate;
    public static volatile SingularAttribute<DeptEmp, DeptEmpPK> deptEmpPK;
    public static volatile SingularAttribute<DeptEmp, Date> toDate;
    public static volatile SingularAttribute<DeptEmp, Departments> departments;
    public static volatile SingularAttribute<DeptEmp, Employees> employees;

}