package web.worker.tracker.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.worker.tracker.dao.WorkerDAO;
import web.worker.tracker.entity.Worker;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    // need to inject worker dao
    @Autowired
    private WorkerDAO workerDAO;

    @Override
    @Transactional
    public List<Worker> getWorkers() {
        return workerDAO.getWorkers();
    }

    @Override
    @Transactional
    public void saveWorker(Worker theWorker) {

        workerDAO.saveWorker(theWorker);
    }


}
