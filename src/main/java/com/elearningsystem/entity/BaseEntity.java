package com.elearningsystem.entity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
}