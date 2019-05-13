package web.worker.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.worker.tracker.entity.Worker;
import web.worker.tracker.service.WorkerService;

import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    // need to inject our customer service
    @Autowired
    private WorkerService workerService;

    @GetMapping("/list")
    public String listWorkers(Model theModel) {

        // get customers from service
        List<Worker> theWorkers = workerService.getWorkers();

        // add the customers to the model
        theModel.addAttribute("workers", theWorkers);

        return "list-workers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Worker theWorker = new Worker();
        theModel.addAttribute("worker", theWorker);
        return "worker-form";

    }

    @PostMapping("/saveWorker")
    public String saveWorker(@ModelAttribute("worker") Worker theWorker) {

        // save customer using service
        workerService.saveWorker(theWorker);

        return "redirect:/worker/list";
    }

   @GetMapping("/showFormForUpdate")
   public String showFormForUpdate(@RequestParam("workerId") int theId, Model theModel) {

       // get the worker from service
       Worker theWorker = workerService.getWorker(theId);

       // set worker as a model attribute to pre-populate the form
       theModel.addAttribute("worker", theWorker);

       // send over to our form
       return "worker-form";
   }

    @GetMapping("/delete")
    public String deleteWorker(@RequestParam("workerId") int theId) {

        // delete the worker
        workerService.deleteWorker(theId);

        return "redirect:/worker/list";
    }
}