/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230.dz13;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Filip
 */
@Entity
@Table(name = "dept_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeptManager.findAll", query = "SELECT d FROM DeptManager d")
    , @NamedQuery(name = "DeptManager.findByDeptNo", query = "SELECT d FROM DeptManager d WHERE d.deptManagerPK.deptNo = :deptNo")
    , @NamedQuery(name = "DeptManager.findByEmpNo", query = "SELECT d FROM DeptManager d WHERE d.deptManagerPK.empNo = :empNo")
    , @NamedQuery(name = "DeptManager.findByFromDate", query = "SELECT d FROM DeptManager d WHERE d.fromDate = :fromDate")
    , @NamedQuery(name = "DeptManager.findByToDate", query = "SELECT d FROM DeptManager d WHERE d.toDate = :toDate")})
public class DeptManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeptManagerPK deptManagerPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employees employees;
    @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departments departments;

    public DeptManager() {
    }

    public DeptManager(DeptManagerPK deptManagerPK) {
        this.deptManagerPK = deptManagerPK;
    }

    public DeptManager(DeptManagerPK deptManagerPK, Date fromDate, Date toDate) {
        this.deptManagerPK = deptManagerPK;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public DeptManager(String deptNo, int empNo) {
        this.deptManagerPK = new DeptManagerPK(deptNo, empNo);
    }

    public DeptManagerPK getDeptManagerPK() {
        return deptManagerPK;
    }

    public void setDeptManagerPK(DeptManagerPK deptManagerPK) {
        this.deptManagerPK = deptManagerPK;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptManagerPK != null ? deptManagerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptManager)) {
            return false;
        }
        DeptManager other = (DeptManager) object;
        if ((this.deptManagerPK == null && other.deptManagerPK != null) || (this.deptManagerPK != null && !this.deptManagerPK.equals(other.deptManagerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cs230.dz13.DeptManager[ deptManagerPK=" + deptManagerPK + " ]";
    }
    
}
