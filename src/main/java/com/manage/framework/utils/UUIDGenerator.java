package com.manage.framework.utils;



import java.util.UUID;

public class UUIDGenerator {
	 public UUIDGenerator()
	    {
	    }

	    public static String getUUID()
	    {
	        String s = UUID.randomUUID().toString();
	        return (new StringBuilder(String.valueOf(s.substring(0, 8)))).append(s.substring(9, 13)).append(s.substring(14, 18)).append(s.substring(19, 23)).append(s.substring(24)).toString();
	    }

	    public static String[] getUUID(int number)
	    {
	        if(number < 1)
	            return null;
	        String ss[] = new String[number];
	        for(int i = 0; i < number; i++)
	            ss[i] = getUUID();

	        return ss;
	    }

	    public static void main(String args[])
	    {
	        String vars[] = UUID.randomUUID().toString().split("-");
	        for(int i = 0; i < vars.length; i++)
	        {
	            System.out.println((new StringBuilder("ok:")).append(vars[i]).toString());
	            long var = Long.valueOf(vars[i], 16).longValue();
	            System.out.println((new StringBuilder("ok:===")).append(var).toString());
	        }

	    }
}
