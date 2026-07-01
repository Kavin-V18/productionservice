package com.example.production.entity;
import com.example.production.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Table(name="productionorders",schema = "public")
@Data
@Entity
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "deleted")
public class ProductionOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_number")
    private String orderNumber;
    //foreignkey--manufacturing plant
    @Column(name="plant_id")
    private Long manufacturingPlant;
    //foreignkey--carModel
    private Long carModel;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false,name="target_quantity")
    private int targetQuantity;
    @Column(name ="completed_quantity")
    private int completedQuantity;
    @Column(name ="expected_end_date")
    private LocalDate expectedEndDate;
    @Column(name ="actual_end_date")
    private LocalDateTime actualEndDate;
    @CreationTimestamp
    @Column(name ="created_at")
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(name ="created_by")
    private Long createdBy;
    @UpdateTimestamp
    @Column(name ="last_modified_at")
    private LocalDateTime lastModifiedAt;
    @LastModifiedBy
    @Column(name ="last_modified_by")
    private Long lastModifiedBy;
    @Column(insertable=false, updatable=false)
    private boolean deleted;

    @PrePersist
    @PreUpdate
    private void validateAndUpdateEndDate() {
        if (this.status == Status.COMPLETED) {
            if (this.actualEndDate == null) {
                this.actualEndDate = LocalDateTime.now(Clock.systemDefaultZone());
            }
        } else {
            this.actualEndDate = null;
        }
    }
}
