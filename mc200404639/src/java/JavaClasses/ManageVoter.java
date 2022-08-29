

package JavaClasses;


public class ManageVoter {
    public static MyDBHelper dbHelper = new MyDBHelper();

    public ManageVoter() {
    }
    
    public static boolean insertVoterData(String id, String vote)
    {
        boolean count = dbHelper.inserVoterRecord(id, vote);
        return count;
    }
    
    public static boolean getVotingDetails(String id)
    {
        boolean isSubmitted = dbHelper.retriveVoterRecord(id);
        return isSubmitted;
    }
}
