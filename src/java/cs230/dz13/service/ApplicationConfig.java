/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230.dz13.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Filip
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cs230.dz13.service.DepartmentsFacadeREST.class);
        resources.add(cs230.dz13.service.DeptEmpFacadeREST.class);
        resources.add(cs230.dz13.service.DeptManagerFacadeREST.class);
        resources.add(cs230.dz13.service.EmployeesFacadeREST.class);
        resources.add(cs230.dz13.service.SalariesFacadeREST.class);
        resources.add(cs230.dz13.service.TitlesFacadeREST.class);
    }
    
}
