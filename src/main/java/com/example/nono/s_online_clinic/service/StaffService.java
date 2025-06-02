package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.StaffModel;
import com.example.nono.s_online_clinic.repo.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffService {
    private StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<StaffModel> getAllClinicStaff() {
        return  staffRepository.findAll();
    }
    
    public StaffModel addStaff(StaffModel staffModel) {
//        staffModel.setStaffName("staffName");
//        staffModel.setPosition("Position");
//        staffModel.setLocation("Location");
//        staffModel.setDepartment("Department");
        return staffRepository.save(staffModel);
    }

    public StaffModel updateStaff(Long id, StaffModel staffModel) {
       StaffModel staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" staff not present"));
       staff.setStaffName(staffModel.getStaffName());
       staff.setPosition(staffModel.getPosition());
       staff.setLocation(staffModel.getLocation());
       staff.setDepartment(staffModel.getDepartment());
       return staffRepository.save(staffModel);
    }

    public void deleteStaff(Long id) {
//      staffService.deleteById(id);
        staffRepository.deleteById(id);
    }
}
