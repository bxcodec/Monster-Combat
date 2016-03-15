/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author VeniNababan
 */
public class Timer {

    protected long second = 0;
    private boolean isRun = false;

    public Timer(boolean _isRun, long _second) {
        this.isRun = _isRun;
        this.second = _second;
    }

    public long getSecond() {
        return second;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    public boolean isIsRun() {
        return isRun;
    }

    public void setIsRun(boolean isRun) {
        this.isRun = isRun;
    }

    
    @Override
    public String toString() {
        long h = second/3600;
        long m = (second%3600)/60;
        long s = (second%3600)%60;
        String jam =  (h<10)?"0"+h :""+ h ;
        String menit = (m<10)?"0"+m: ""+m;
        String detik = (s<10)?"0"+s:""+s;
        return (menit+ " : "+detik);
    }
    
    public void decreement() {
    this.second--;
    }
    

    
    
}
