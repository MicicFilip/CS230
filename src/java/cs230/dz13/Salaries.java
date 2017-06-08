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
@Table(name = "salaries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salaries.findAll", query = "SELECT s FROM Salaries s")
    , @NamedQuery(name = "Salaries.findByEmpNo", query = "SELECT s FROM Salaries s WHERE s.salariesPK.empNo = :empNo")
    , @NamedQuery(name = "Salaries.findBySalary", query = "SELECT s FROM Salaries s WHERE s.salary = :salary")
    , @NamedQuery(name = "Salaries.findByFromDate", query = "SELECT s FROM Salaries s WHERE s.salariesPK.fromDate = :fromDate")
    , @NamedQuery(name = "Salaries.findByToDate", query = "SELECT s FROM Salaries s WHERE s.toDate = :toDate")})
public class Salaries implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalariesPK salariesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private int salary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employees employees;

    public Salaries() {
    }

    public Salaries(SalariesPK salariesPK) {
        this.salariesPK = salariesPK;
    }

    public Salaries(SalariesPK salariesPK, int salary, Date toDate) {
        this.salariesPK = salariesPK;
        this.salary = salary;
        this.toDate = toDate;
    }

    public Salaries(int empNo, Date fromDate) {
        this.salariesPK = new SalariesPK(empNo, fromDate);
    }

    public SalariesPK getSalariesPK() {
        return salariesPK;
    }

    public void setSalariesPK(SalariesPK salariesPK) {
        this.salariesPK = salariesPK;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salariesPK != null ? salariesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salaries)) {
            return false;
        }
        Salaries other = (Salaries) object;
        if ((this.salariesPK == null && other.salariesPK != null) || (this.salariesPK != null && !this.salariesPK.equals(other.salariesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cs230.dz13.Salaries[ salariesPK=" + salariesPK + " ]";
    }
    
}
