package HW_13.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger implements ILogger {
    Logger logger;
    FileHandler fh;
    
    public FileLogger(String _filename){
        logger = Logger.getLogger(FileLogger.class.getName());
        try { 
            fh = new FileHandler(_filename); 
        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter); 
    }

    public void log(String message){
        logger.info(message);
    }
}
