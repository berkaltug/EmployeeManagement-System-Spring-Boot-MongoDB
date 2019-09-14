package com.berkaltug.employeemanagement.Listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.berkaltug.employeemanagement.domain.Employee;
import com.berkaltug.employeemanagement.service.SequenceGeneratorService;

@Component
public class EmployeeModelListener extends AbstractMongoEventListener<Employee>{

    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public EmployeeModelListener(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Employee> event) {
        if (event.getSource().getEmployeeId() < 1) {
            event.getSource().setEmployeeId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        }
    }
}
