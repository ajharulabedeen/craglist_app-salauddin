package salahuddin_ayubi.configs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
    {
        public static String getDate()
        {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm a");//23/10/2017 12:20 PM
            Date date = new Date();
            return dateFormat.format(date);
        }
        public static String getDateForDirectory()
        {
            DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_a");
            Date date = new Date();
            return dateFormat.format(date);
        }
    }
