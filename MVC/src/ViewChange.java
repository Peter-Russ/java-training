public class ViewChange {
    private int PointsUser = 0;
    private int PointsComp = 0;
    private ELEMENTS userSet;
    private ELEMENTS compSet;
    private STATUS statusValue;
    public ViewChange(int PointsUser, int PointsComp, ELEMENTS userSet, ELEMENTS compSet, STATUS statusValue) {
        this.PointsUser = PointsUser;
        this.PointsComp = PointsComp;
        this.userSet = userSet;
        this.compSet = compSet;
        this.statusValue = statusValue;
    }
    public int getPointsUser() {
        return PointsUser;
    }
    public int getPointsComp() {
        return PointsComp;
    }
    public ELEMENTS getUserSet() {
        return userSet;
    }
    public ELEMENTS getCompSet() {
        return compSet;
    }
    public STATUS getStatusValue() {
        return statusValue;
    }
}
