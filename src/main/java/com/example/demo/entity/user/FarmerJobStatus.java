package com.example.demo.entity.user;

import java.util.HashMap;
import java.util.Map;

public enum FarmerJobStatus {
    REQUESTING("REQUESTING"),
    ACCEPTED("ACCEPTED"),
    COMPLETED("COMPLETED"),
    REJECTED("REJECTED");

    public final String label;

    private FarmerJobStatus(String label) {
        this.label = label;
    }

    public static final Map<String, FarmerJobStatus> BY_LABEL = new HashMap<>();

   static
   {
       for(FarmerJobStatus status:values())
       {
           BY_LABEL.put(status.label, status);
       }
    }

    @Override 
    public String toString()
    {
        return this.label;
    }
}
