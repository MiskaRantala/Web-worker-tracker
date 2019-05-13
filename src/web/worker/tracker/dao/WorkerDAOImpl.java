package web.worker.tracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

        // save the worker
        currentSession.save(theWorker);
    }
}
