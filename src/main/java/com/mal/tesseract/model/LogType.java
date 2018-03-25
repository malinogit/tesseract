package com.mal.tesseract.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Table
@Entity
public class LogType implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "logType")
    private List<AccountLog> accountLogs;

    @Column
    private String name;

    @Override
    public String toString() {
        return "LogType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
