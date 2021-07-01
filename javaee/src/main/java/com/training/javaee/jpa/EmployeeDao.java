package com.training.javaee.jpa;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.training.javaee.employee.Employee;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class EmployeeDao {

    @PersistenceContext(unitName = "javaee")
    private EntityManager em;

    //    @PersistenceUnit(unitName = "javaee")
    //    private EntityManagerFactory emf;

    @Transactional
    public void insert(final Employee employeeParam) {
        this.em.persist(employeeParam); // Managed
    }

    public Employee getEmployeeById(final Long empId) {
        return this.em.find(Employee.class,
                            empId);
    }

    @Transactional
    public void test(final Employee employeeParam) {
        this.em.persist(employeeParam); // Managed
        this.em.detach(employeeParam); // Detached
        Employee mergeLoc = this.em.merge(employeeParam); // Managed
        this.em.refresh(mergeLoc);
        mergeLoc.setName("test"); // database en son hali test görürüz


        Employee findLoc = this.em.find(Employee.class,
                                        1);
        findLoc.setDepartment("TEST");

        if (!this.em.contains(employeeParam)) {
            Employee merge2Loc = this.em.merge(employeeParam);
            merge2Loc.setDepartment("TEST");
        } else {
            employeeParam.setDepartment("TEST");
        }

    }

    public void insertJava(final Employee employeeParam) {
        // this.em.joinTransaction();
        this.em.getTransaction()
               .begin();
        try {
            this.em.persist(employeeParam);
            this.em.getTransaction()
                   .commit();
        } catch (Exception eLoc) {
            this.em.getTransaction()
                   .rollback();
        }
    }

    public Employee get(final String usernameParam) {
        TypedQuery<Employee> createQueryLoc = this.em.createQuery("select e from Employee e where e.username=:is",
                                                                  Employee.class);
        createQueryLoc.setParameter("is",
                                    usernameParam);
        return createQueryLoc.getSingleResult();
    }

    public List<Employee> getByName(final String nameParam) {
        TypedQuery<Employee> createQueryLoc = this.em.createQuery("select e from Employee e where e.name=?1",
                                                                  Employee.class);
        createQueryLoc.setParameter(1,
                                    nameParam);
        return createQueryLoc.getResultList();
    }

    public List<Employee> getByNameNamedQuery(final String nameParam) {
        TypedQuery<Employee> createQueryLoc = this.em.createNamedQuery("employee_find_by_id",
                                                                       Employee.class);
        createQueryLoc.setParameter(1,
                                    nameParam);
        return createQueryLoc.getResultList();
    }

    public List<Employee> getByNameNative(final String nameParam) {
        Query createNativeQueryLoc = this.em.createNativeQuery("select * from emp_table e where e.isim=?1",
                                                               Employee.class);
        createNativeQueryLoc.setParameter(1,
                                          nameParam);
        return createNativeQueryLoc.getResultList();
    }

}

