package fr.inria.diverse.utils;

public class SwhUtils {
    
    /**
     * get the snapshot id from a swh id
     * @param swhId the swh id
     * @return the snapshot id
     */
    public static String getSnapShotIdFromSwhId(String swhId){
        return swhId.split(":")[3];
    }

    public static String getSwhIdFromRevId(String snapShotId){
        return "swh:1:rev:" + snapShotId;
    }
}
