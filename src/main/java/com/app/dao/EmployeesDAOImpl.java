package com.app.dao;

import com.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeesDAOImpl implements EmployeeDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public EmployeesDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String jpql = "FROM Employee";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);

        return query.getResultList();

        //return session.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        entityManager.merge(employee);
        //entityManager.persist(employee);
        //sessionFactory.getCurrentSession().saveOrUpdate(employee);

    }

    @Override
    public Employee getEmpFromId(int id) {
        return entityManager.find(Employee.class, id);
        //return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);

        /*sessionFactory.getCurrentSession()
                .createQuery("delete from Employee where id =: employeeId")
                .setParameter("employeeId", id)
                .executeUpdate();*/
    }
}
