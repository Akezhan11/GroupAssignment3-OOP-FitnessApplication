import com.sun.tools.javac.Main;import edu.aitu.oop3.db.DataBaseCreation;

public class FitnessApplication {
    public void run(){

    }
    void main(){
        DataBaseCreation.init();
        new FitnessApplication().run();
    }
}