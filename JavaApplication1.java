package javaapplication1;




public class JavaApplication1 {

    
    public static void main(String[] args) {
     
      //Calculando VShale  
      double grClean = 30.00;
      double grShale = 120.00;
      double grLog = 38.333333333; //input del usuario
      double vShale;
      vShale =(double) ((grLog - grClean)/(grShale - grClean)); //(double para poder tener el resultado con decimales y no solo guarde 0.0)
            
        System.out.println("grLog = " + grLog);
        System.out.println("vShale = " + vShale);
     
     //Calculando Porosidad
     double pMat = 2.65;
     double pfl = 1.0;
     double RHOB = 2.191666667; //Input del usuario
     double NPHI = 0.25;//input
     double porosity = (double) ((pMat-RHOB)/(pMat-pfl));
     double totalPoro = (double)(porosity + NPHI)/2;
     double effPoro = (double) totalPoro*(1-vShale);
        
        System.out.println("RHOB = " + RHOB);
        System.out.println("Porosity = " + porosity);
        System.out.println("Total Porosity = " + totalPoro);
        System.out.println("Effective Porosity = " + effPoro);
        
    //Calculando Saturacion
    
    double res1 = 0.5, SW, R2, a = 1, m = 2, RT = 90, //RT entrada del usuario
           n = 2, t1Sup = 15, t2Inf = 90, c = 21.5;
   
    
    //R2 = (double) res1*((t1Sup+c)/(t2Inf+c));
    R2 = (double) res1*(0.6/90);
    SW = (double) (a*R2)/(RT*Math.pow(effPoro, m));
    double SWSQT   =   Math.pow(SW,res1);
    System.out.println("SW = " + SWSQT);
        
    //Calculando Hidrocarburos
    int A = 376, h = 60, h1=40, h2=20;
    double vol = A*h*effPoro*(1-SW);
    double volOil = 7758*A*h1*effPoro*(1-SW);
    double volGas = 43560*A*h2*effPoro*(1-SW);
    System.out.println("Volumen = " + vol);
    System.out.println("Volumen Oil ="+volOil);
    System.out.println("Volumen Gas= "+volGas);

    }
    
}
