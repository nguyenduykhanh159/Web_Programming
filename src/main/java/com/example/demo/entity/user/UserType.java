package com.example.demo.entity.user;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
   FARMER("FARMER"),
   SOCIETY("SOCIETY");
   
   public final String label;
   private UserType(String label)
   {
       this.label=label;
   }

   public static final Map<String,UserType> BY_LABEL=new HashMap<>();
   static
   {
       for(UserType type:values())
       {
           BY_LABEL.put(type.label,type);
       }
   }

   @Override
   public String toString()
   {
       return this.label;
   }

}
