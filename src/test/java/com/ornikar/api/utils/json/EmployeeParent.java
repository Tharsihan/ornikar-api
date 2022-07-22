package com.ornikar.api.utils.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;


public class EmployeeParent {
    private List<Employee> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public void setData(List<Employee> users) {
        this.data = data;
    }

    public List<Employee> getData() {
        return data;
    }
}
