package com.example.purchasingbackend.entity.manufacturing;

import jakarta.persistence.*;


/**
 * Entity representing a Work Order Operation.
 */
@Entity
@Table(name = "work_order_operations")
public class WorkOrderOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operation_name")
    private String operationName;

    @ManyToOne
    @JoinColumn(name = "work_order_id")
    private WorkOrder workOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    @Override
    public String toString() {
        return "WorkOrderOperation{" +
                "id=" + id +
                ", operationName='" + operationName + '\'' +
                ", workOrder=" + workOrder +
                '}';
    }
}
