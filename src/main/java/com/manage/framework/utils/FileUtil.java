package com.manage.framework.utils;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class FileUtil {
	
	private static final Logger logger = Logger.getLogger(FileUtil.class);
	
	public FileUtil()
    {
    }

    public static String generateFilename(String originalFilename)
    {
        SimpleDateFormat dirSdf = new SimpleDateFormat("yyyyMM");
        String filePre = dirSdf.format(new Date());
        String fileExt = "";
        int lastIndex = originalFilename.lastIndexOf('.');
        if(lastIndex != -1)
            fileExt = originalFilename.substring(lastIndex);
        String filename = (new StringBuilder(String.valueOf(filePre))).append("/").append(UUIDGenerator.getUUID()).append(fileExt).toString();
        return filename;
    }

    public static void writeFile(String filePath, String data)
    {
        FileOutputStream fos;
        OutputStreamWriter writer;
        fos = null;
        writer = null;
        try
        {
            fos = new FileOutputStream(new File(filePath));
            writer = new OutputStreamWriter(fos, "UTF-8");
            writer.write(data);
        }
        catch(Exception ex)
        {
            logger.error(ex.getMessage());
        }
        try
        {
            if(writer != null)
                writer.close();
            if(fos != null)
                fos.close();
        }
        catch(Exception exception1) { }
        try
        {
            if(writer != null)
                writer.close();
            if(fos != null)
                fos.close();
        }
        catch(Exception exception2) { }

        try
        {
            if(writer != null)
                writer.close();
            if(fos != null)
                fos.close();
        }
        catch(Exception exception3) { }
    }

    public static String readFile(String filePath)
    {
        StringBuffer buffer = new StringBuffer();
        try
        {
            File file = new File(filePath);
            FileInputStream fis = null;
            BufferedReader breader = null;
            try
            {
                fis = new FileInputStream(file);
                InputStreamReader isReader = new InputStreamReader(fis, "UTF-8");
                breader = new BufferedReader(isReader);
                String line;
                while((line = breader.readLine()) != null) 
                {
                    buffer.append(line);
                    buffer.append("\r\n");
                }
                breader.close();
                isReader.close();
                fis.close();
            }
            catch(FileNotFoundException e)
            {
                logger.error(e.getMessage());
            }
            catch(IOException e)
            {
                logger.error(e.getMessage());
            }
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
        }
        return buffer.toString();
    }
}
