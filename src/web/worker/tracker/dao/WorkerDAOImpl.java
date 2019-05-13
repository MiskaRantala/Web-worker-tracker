package web.worker.tracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.worker.tracker.entity.Worker;

import java.util.List;

@Repository
public class WorkerDAOImpl implements WorkerDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Worker> getWorkers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query and sort by last name
        Query<Worker> theQuery = currentSession.createQuery("FROM Worker ORDER BY lastName", Worker.class);

        // execute query and get result list
        List<Worker> workers = theQuery.getResultList();

        // return the results
        return workers;
    }

    @Override
    public void saveWorker(Worker theWorker) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/update the worker
        currentSession.saveOrUpdate(theWorker);
    }

    @Override
    public Worker getWorker(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // retrieve/read from database using primary key
        Worker theWorker = currentSession.get(Worker.class, theId);

        return theWorker;
    }

    @Override
    public void deleteWorker(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery = currentSession.createQuery("DELETE FROM Worker WHERE id=:workerId");
        theQuery.setParameter("workerId", theId);

        // execute the update
        theQuery.executeUpdate();
    }

    @Override
    public List<Worker> searchWorker(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        // only search by name if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName, case sensitive
            theQuery = currentSession.createQuery(
                    "FROM Worker WHERE LOWER (firstName) LIKE :theName OR LOWER (lastName) LIKE :theName", Worker.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        }

        // theSearchName is empty, so just get all workers
        else {

            theQuery = currentSession.createQuery("FROM Worker", Worker.class);
        }

        // execute query and get result list
        List<Worker> workers = theQuery.getResultList();

        // return the results
        return workers;

    }
}
