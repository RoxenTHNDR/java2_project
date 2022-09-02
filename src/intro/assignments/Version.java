package intro.assignments;

public class Version {

    private int majorNum;
    private int minorNum;
    private int patchNum;


    public Version() {
        majorNum = 0;
        minorNum = 0;
        patchNum = 1;
    }


    public Version(String oldPatch){
        String[] versionArr = oldPatch.split(".");
        if (versionArr.length == 1 && versionArr[0].equals("")){
            patchNum = 1;
            return;
        }
        try {
            switch (versionArr.length){
                case 0: patchNum = 1;
                        break;
                case 1: majorNum = Integer.parseInt(versionArr[0]);
                        break;
                case 2: majorNum = Integer.parseInt(versionArr[0]);
                        minorNum = Integer.parseInt(versionArr[1]);
                default: majorNum = Integer.parseInt(versionArr[0]);
                         minorNum = Integer.parseInt(versionArr[1]);
                         patchNum = Integer.parseInt(versionArr[2]);
            }
        }
        catch (Exception e){
            throw new NumberFormatException("Error occurred while parsing version!");
        }

    }

    public Version(int major, int minor, int path){

        try {
            if(major < 0 || minor < 0 || path < 0 ){
                throw new NumberFormatException("Negative Numbers not allowed");
            }
            majorNum = major;
            minorNum = minor;
            patchNum = path;
        }
        catch (Exception e){
            throw new NumberFormatException("Error occurred while parsing version!");
        }
    }

    public int getMajor() {
        return majorNum;
    }

    public int getMinor() {
        return minorNum;
    }

    public int getPatch() {
        return patchNum;
    }

    @Override
    public String toString() {
        return majorNum + "." + minorNum + "." + patchNum;
    }
}
