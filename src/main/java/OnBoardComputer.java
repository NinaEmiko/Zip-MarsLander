public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) {
        int burn = 0;

        //Once rocket is below 100 altitude, gets it the rest of the way there
        if (status.getVelocity() == 1) {
            burn = 100;
        //Step 1: Get Altitude to below 5000
        } else if (status.getAltitude() > 5000) {
            burn = 200;
        //Step 2: Lower velocity to 100
        } else if (status.getVelocity() > 100 && status.getAltitude() > 100) {
            burn = 200;
        //Step 3: Until altitude is 100 or below, steadily reduces altitude
        } else if (status.getAltitude() > 100){
            burn = 100;
        //Once below 100 altitude, reduces velocity to 1
        } else if (status.getVelocity() > 50) {
            burn = 199;
        }
        
        System.out.println(burn); /*hack!*/
        return burn;
    }

}
