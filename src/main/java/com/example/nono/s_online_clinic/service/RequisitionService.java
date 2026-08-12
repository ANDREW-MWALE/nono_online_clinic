package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.RequisitionModel;
import com.example.nono.s_online_clinic.repo.RequisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RequisitionService {

    @Autowired
    public RequisitionRepository requisitionRepository;
    public RequisitionModel createRequisition(RequisitionModel requisitionModel) {
       return requisitionRepository.save(requisitionModel);

    }

    public List<RequisitionModel> retrieveRequisition() {
        return requisitionRepository.findAll();
    }


    public List<?> updateRequisition(RequisitionModel update, Long id) {
        return updateRequisition(update, id);
    }
}

