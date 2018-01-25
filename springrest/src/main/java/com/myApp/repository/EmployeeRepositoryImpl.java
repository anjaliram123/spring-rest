package com.myApp.repository;

import com.myApp.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("SELECT emp from Employee emp ORDER BY emp.email DESC",
                Employee.class);
          return query.getResultList();
          }

    public Employee findOne(String id) {
        return em.find(Employee.class,id);

    }

    public Employee findByEmail(String email)
    {
        TypedQuery<Employee> query = em.createQuery("SELECT emp from Employee emp WHERE emp.email=:paramEmail",
                Employee.class);
        query.setParameter("paramEmail",email);
        List<Employee> list = query.getResultList();
        if(list!=null && list.size()==1)
        {
            return list.get(0);
        }
        else{
            return null;
        }
    }

    public Employee create(Employee emp) {
        em.persist(emp);
        return emp;
    }

    public Employee update(String id, Employee emp) {

        em.merge(emp);
        return emp;
    }

    public void delete(Employee emp) {
        em.remove(emp);
        }
}

