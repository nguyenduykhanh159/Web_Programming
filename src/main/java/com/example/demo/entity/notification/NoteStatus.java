package com.example.demo.entity.notification;

import java.util.HashMap;
import java.util.Map;

public enum NoteStatus {
   
   READ("READ"),
   UNREAD("UNREAD");

   public final String label;

   private NoteStatus(String label) {
      this.label = label;
   }

   private static final Map<String,NoteStatus> BY_LABEL = new HashMap<>();
   static {
      for (NoteStatus e : values()) {
         BY_LABEL.put(e.label, e);
      }
   }

   public static NoteStatus valueOfLabel(String label) {
      return BY_LABEL.get(label);
   }

   @Override
   public String toString() {
      return this.label;
   } 
}
