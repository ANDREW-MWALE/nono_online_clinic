package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.PayrollEntry;
import com.example.nono.s_online_clinic.repo.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository repository;

    public List<PayrollEntry> getAll() {
        return repository.findAll();
    }

    public PayrollEntry getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public PayrollEntry save(PayrollEntry entry) {
        double gross = entry.getGrossPay();

        // NHIMA is 10% of the basic salary
        double nhima = entry.getBasicSalary() * 0.01;
        entry.setNhima(nhima);

        double napsa = gross * 0.05;
        entry.setNapsa(napsa);

        double zra = calculatePayee(gross);
        entry.setZra(zra);

        double totalDeduction = nhima + napsa + zra;
        double net = gross - totalDeduction;
        entry.setNet(net);

        return repository.save(entry);
    }

    private double calculatePayee(double grossPay) {
        double zra = 0.0;

        if (grossPay <= 5100) {
            zra = 0.0;
        } else if (grossPay <= 7100) {
            zra = (grossPay - 5100) * 0.20;
        } else if (grossPay <= 9200) {
            zra = (2000 * 0.20) + (grossPay - 7100) * 0.30;
        } else {
            zra = (2000 * 0.20) + (2100 * 0.30) + (grossPay - 9200) * 0.37;
        }

        return zra;
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}