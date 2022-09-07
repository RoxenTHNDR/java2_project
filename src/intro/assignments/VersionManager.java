package intro.assignments;

// A continuation of the Version class assignment

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class VersionManager {
    Version currentVersion;
    List<Version> previousVersions = new ArrayList<>();

    public VersionManager() {
        currentVersion = new Version();
    }

    public VersionManager(String newVersion) {
        currentVersion = new Version(newVersion);
    }

    public VersionManager major(){

        previousVersions.add(currentVersion);
        int major = currentVersion.getMajor();
        major++;
        currentVersion = new Version(major,0,0);
        return this;

    }

    public VersionManager minor(){

        previousVersions.add(currentVersion);
        int major = currentVersion.getMajor();
        int minor = currentVersion.getMinor();
        minor++;
        currentVersion = new Version(major,minor,0);
        return this;

    }

    public VersionManager patch(){

        previousVersions.add(currentVersion);
        int major = currentVersion.getMajor();
        int minor = currentVersion.getMinor();
        int patch = currentVersion.getPatch();
        patch++;
        currentVersion = new Version(major,minor,patch);
        return this;

    }

    public VersionManager rollback(){

        try {
            currentVersion = previousVersions.get(previousVersions.size()-1);
            previousVersions.remove(previousVersions.size()-1);
        }
        catch (Exception e){
            throw new NoSuchElementException("Cannot rollback!");
        }

        return this;
    }

    public String release(){
        return currentVersion.toString();
    }

}
