import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class seirCalculator {
    private Map<String, ArrayList<ArrayList<Double>>> integrators = new HashMap<String, ArrayList<ArrayList<Double>>>();
    public seirCalculator(){
        ArrayList<ArrayList<Double>> ArrayList1 = new ArrayList<ArrayList<Double>>();
        ArrayList1.add();

    }

    public void calculate(double dt, double N, double I0, double R0, double D_incbation, double D_infectious, double D_recovery_mild, double D_hospital_lag, double D_recovery_severe, double D_death, double P_severe, double CFR, double interventionTime, double interventionAmt, double duration){
        double interpolation_steps = 40.0;
        double steps = 110 * interpolation_steps;
        double new_dt = dt/interpolation_steps;
        double sampleStep = interpolation_steps;



    }
}
