package edu.jpa.service;

import edu.jpa.entity.Company;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CompanyService {

    @PersistenceContext
    private EntityManager em;

    @Transactional(propagation = Propagation.REQUIRED)
    public void init() {
        String[] companies = {"Microsoft", "IBM"};
        for (String name : companies) {
            Company company = new Company();
            company.setName(name);
            em.persist(company);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Company getCompany(int id) {
        return em.find(Company.class, id);
    }
}
