public class AppointmentBook {
    private boolean[][] schedule;

    public void AppointmentBook(boolean[][] schedule){
        this.schedule = schedule;
    }
    private boolean isMinuteFree(int period, int minute){
        return schedule[period][minute];
    }
    /**
     * Marks the block of minutes that starts at startMinute in period and
     * is duration minutes long as reserved for an appointment
     * Preconditions: 1 <= period <= 8; 0 <= startMinute <= 59;
     * 1 <= duration <= 60
     */
    private void reserveBlock(int period, int startMinute, int duration){
        for(int i = startMinute; i<= duration; i++){
            schedule[period][i] = false;
        }
    }

    public int findFreeBlock(int period, int duration){
        int amount = 0;
        int time = 0;
        while (time <= schedule[period].length){
            if (schedule[period][time]){
                amount += 1;
                if (amount == duration){
                    return amount;
                }
            }
            else{
                amount = 0;
            }
            time +=1;
        }
        return -1;
    }
    /**
     * Searches periods from startPeriod to endPeriod, inclusive, for a block
     * of duration free minutes, as described in part (b). If such a block is found,
     * calls reserveBlock to reserve the block of minutes and returns true; otherwise
     * returns false.
     * Preconditions: 1 <= startPeriod <= endPeriod <= 8; 1 <= duration <= 60
     */
    public boolean makeAppointment(int startPeriod, int endPeriod, int duration){
        for(int i = startPeriod; i <= endPeriod; i++){
            int free = findFreeBlock(i, duration);
            if (free != -1){
                reserveBlock(i, free, duration);
                return true;
            }
        }
        return false;
    }
}
