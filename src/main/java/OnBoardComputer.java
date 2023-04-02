public class OnBoardComputer implements BurnStream {

    @Override
    public int getNextBurn(DescentEvent status) {
        int burn = 0;

        if (status.getVelocity() == 2) {
            //Once rocket is below 100 altitude, gets it the rest of the way there
            burn = 100;
        } else if (status.getAltitude() > 6000) {
            //Step 1: Get Rocket to below 6000 altitude
            burn = 100;
        } else if (status.getVelocity() > 100){
            //Step 2: Get rocket to 100 velocity
            burn = 200;
        } else if (status.getAltitude() > 100) {
            burn = 100;
        } else {
            //Once below 100 altitude, reduces velocity to 2
            burn = 198;
        }

        System.out.println(burn); /*hack!*/
        return burn;
    }
}
