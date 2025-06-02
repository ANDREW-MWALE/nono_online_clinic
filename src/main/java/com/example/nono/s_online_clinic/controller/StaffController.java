package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.StaffModel;
import com.example.nono.s_online_clinic.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController()
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public ResponseEntity<List<StaffModel>> getAllClinicStaff(){
        List<StaffModel> staffList = staffService.getAllClinicStaff();
        return ResponseEntity.ok(staffList);
    }
    @PostMapping
    public ResponseEntity<StaffModel> postStaffData(@RequestBody StaffModel staffModel){
        return ResponseEntity.ok(staffService.addStaff(staffModel));
    }
  @PutMapping("/{id}")
 public ResponseEntity<StaffModel> updateStaff(@PathVariable Long id, @RequestBody StaffModel staffModel){

   return ResponseEntity.ok(staffService.updateStaff(id, staffModel));
   }
@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id){
    staffService.deleteStaff(id);
        return ResponseEntity.ok("Product deleted successfully");
}


}
