package web.worker.tracker.service;

import web.worker.tracker.entity.Worker;
import java.util.List;

public interface WorkerService {

    public List<Worker> getWorkers();

    public void saveWorker(Worker theWorker);

    public Worker getWorker(int theId);

    public void deleteWorker(int theId);

    public List<Worker> searchWorkers(String theSearchName);
}
