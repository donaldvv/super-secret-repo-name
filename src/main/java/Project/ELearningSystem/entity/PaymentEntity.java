package Project.ELearningSystem.entity;

import Project.ELearningSystem.entity.embbedable.PaymentId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
@Entity
public class PaymentEntity extends BaseEntity{

    @EmbeddedId
    private PaymentId paymentId;
    @Column(name = "paymentDate",nullable = false)
    private LocalDate paymentDate;
    @Column(name = "amount",nullable = false)
    private Integer amount;
    @MapsId("stdID")
    @ManyToOne
    @JoinColumn(name = "stdID",referencedColumnName = "stdID",nullable = false)
    private StudentEntity student;

}
