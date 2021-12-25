package com.example.demo.entity.job;

import java.util.HashMap;
import java.util.Map;

public enum JobStatus {

   FINDING("FINDING"),
   PENDING("PENDING"),
   COMPLETED("COMPLETED");

   public final String label;

   private JobStatus(String label) {
      this.label = label;
   }

   private static final Map<String, JobStatus> BY_LABEL = new HashMap<>();
   static {
      for (JobStatus e : values()) {
         BY_LABEL.put(e.label, e);
      }
   }

   public static JobStatus valueOfLabel(String label) {
      return BY_LABEL.get(label);
   }

   @Override
   public String toString() {
      return this.label;
   }
}
