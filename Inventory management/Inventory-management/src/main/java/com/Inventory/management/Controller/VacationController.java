package com.Inventory.management.Controller;

import com.Inventory.management.Entity.Vacation;
import com.Inventory.management.Service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VacationController {
    @Autowired
    private VacationService vacationService;
    @PostMapping("/api/vacation/{admin_company}/{employee_name}")
    private Vacation saveVacation(@PathVariable("admin_company") String admin_company,
                                 @PathVariable("employee_name") String employee_name,@RequestBody Vacation vacation){
        return vacationService.saveVacation(admin_company,employee_name,vacation);
    }
    @GetMapping("/vacations/{admin_id}")
    public List<Vacation> fetchData(@PathVariable("admin_id") String admin_id){
        System.out.println(vacationService.fetchdata(admin_id));
        return vacationService.fetchdata(admin_id);
    }
    @PutMapping("/vacation/{id}")
    public Vacation updateVacation(@PathVariable("id") Long id, @RequestBody Vacation vacation){
        return vacationService.updateHolidayStatus(id, vacation);
    }
    @DeleteMapping("/DeleteVacation/{id}")
    public void deleteVacation(@PathVariable("id") Long id){
        vacationService.deletVacation(id);
    }
}
