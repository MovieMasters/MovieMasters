package datastorage;

import java.util.Calendar;
import java.util.TimeZone;

public abstract class DAO {
    Calendar cal = Calendar.getInstance(TimeZone.getDefault());
}
