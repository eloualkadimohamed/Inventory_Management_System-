package com.Inventory.management.Service;

import com.Inventory.management.Entity.Vacation;
import com.Inventory.management.Repository.AdminRepository;
import com.Inventory.management.Repository.EmployeeRepository;
import com.Inventory.management.Repository.VacationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VacationService {
     @Autowired
     private VacationRepository vacationRepository;
     @Autowired
     private EmployeeRepository employeeRepository;
     @Autowired
     private AdminRepository adminRepository;
    public Vacation saveVacation(String admin_company,String employee_name,Vacation vacation) {
        vacation.setAdmin_id(adminRepository.getAdminByCompany(admin_company));
        vacation.setEmployeeId(employeeRepository.getEmployeeByName(employee_name));
        return vacationRepository.save(vacation);
    }

//    public List<Vacation> getVacations(String admin_id) {
//        System.out.println(admin_id);
//        return vacationRepository.getVacationWithAdminIdNativeNamedParam(admin_id);
//    }
    @Modifying
    @Transactional
    public Vacation updateHolidayStatus(Long id, Vacation vacation) {
        Vacation DB= vacationRepository.findById(id).get();
        if (Objects.nonNull(vacation.getStatus()) &&
                !"".equalsIgnoreCase(vacation.getStatus())){
            DB.setStatus(vacation.getStatus());
        }
        return vacationRepository.save(DB);
    }

    public List<Vacation> fetchdata(String adminId) {
        return vacationRepository.getVacationWithAdminIdNativeNamedParam(adminId);
    }

    public void deletVacation(Long id) {
        vacationRepository.deleteById(id);
    }
}
