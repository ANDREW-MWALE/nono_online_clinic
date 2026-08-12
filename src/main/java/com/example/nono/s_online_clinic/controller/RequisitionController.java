package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.RequisitionModel;
import com.example.nono.s_online_clinic.service.RequisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/requisition")
public class RequisitionController {

    @Autowired
    public RequisitionService requisitionService;
    @PostMapping
    public ResponseEntity<RequisitionModel> createRequisition(@RequestBody RequisitionModel requisitionModel){
        return  ResponseEntity.ok(requisitionService.createRequisition(requisitionModel));
    }

    @GetMapping
    public ResponseEntity <List<RequisitionModel>> retrieveRequisition(){
        List<RequisitionModel> requisition = requisitionService.retrieveRequisition();
        return ResponseEntity.ok(requisition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<?>> updateRequisition(@RequestBody RequisitionModel update, @PathVariable Long id){
        return ResponseEntity.ok(requisitionService.updateRequisition(update, id));
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteRequistion(@PathVariable Long id){
//        return ResponseEntity.ok(requisitionService.deleteRequisition(id));
//    }

}
