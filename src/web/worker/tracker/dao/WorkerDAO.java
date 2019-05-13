package web.worker.tracker.dao;

import web.worker.tracker.entity.Worker;

import java.util.List;

public interface WorkerDAO {

    public List<Worker> getWorkers();

    public void saveWorker(Worker theWorker);

    public Worker getWorker(int theId);

}
