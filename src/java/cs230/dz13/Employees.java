/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230.dz13;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Filip
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmpNo", query = "SELECT e FROM Employees e WHERE e.empNo = :empNo")
    , @NamedQuery(name = "Employees.findByBirthDate", query = "SELECT e FROM Employees e WHERE e.birthDate = :birthDate")
    , @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employees.findByGender", query = "SELECT e FROM Employees e WHERE e.gender = :gender")
    , @NamedQuery(name = "Employees.findByHireDate", query = "SELECT e FROM Employees e WHERE e.hireDate = :hireDate")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "emp_no")
    private Integer empNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private Collection<Salaries> salariesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private Collection<DeptEmp> deptEmpCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private Collection<DeptManager> deptManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
    private Collection<Titles> titlesCollection;

    public Employees() {
    }

    public Employees(Integer empNo) {
        this.empNo = empNo;
    }

    public Employees(Integer empNo, Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
        this.empNo = empNo;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @XmlTransient
    public Collection<Salaries> getSalariesCollection() {
        return salariesCollection;
    }

    public void setSalariesCollection(Collection<Salaries> salariesCollection) {
        this.salariesCollection = salariesCollection;
    }

    @XmlTransient
    public Collection<DeptEmp> getDeptEmpCollection() {
        return deptEmpCollection;
    }

    public void setDeptEmpCollection(Collection<DeptEmp> deptEmpCollection) {
        this.deptEmpCollection = deptEmpCollection;
    }

    @XmlTransient
    public Collection<DeptManager> getDeptManagerCollection() {
        return deptManagerCollection;
    }

    public void setDeptManagerCollection(Collection<DeptManager> deptManagerCollection) {
        this.deptManagerCollection = deptManagerCollection;
    }

    @XmlTransient
    public Collection<Titles> getTitlesCollection() {
        return titlesCollection;
    }

    public void setTitlesCollection(Collection<Titles> titlesCollection) {
        this.titlesCollection = titlesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empNo != null ? empNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.empNo == null && other.empNo != null) || (this.empNo != null && !this.empNo.equals(other.empNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cs230.dz13.Employees[ empNo=" + empNo + " ]";
    }
    
}
